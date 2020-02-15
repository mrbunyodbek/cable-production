package uz.cp.cableproduction.db.dao.implement;

import org.springframework.stereotype.Service;
import uz.cp.cableproduction.collections.ProductionAndMessage;
import uz.cp.cableproduction.db.dao.ProductionDAO;
import uz.cp.cableproduction.db.entities.documents.Production;
import uz.cp.cableproduction.db.entities.dto.MachinesDTO;
import uz.cp.cableproduction.db.repositories.ProductionRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductionDAOImpl implements ProductionDAO {
    ProductionRepository repository;

    public ProductionDAOImpl(ProductionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Production> getAll() {
        return repository.findAllByJobDoneFalseAndDeletedFalse();
    }

    @Override
    public List<Production> getByOrderId(int id) {
        return repository.findAllByOrderId(id);
    }

    @Override
    public Production getByMachineId(int id) {
        return repository.findByMachineId(id);
    }

    @Override
    public List<Production> getAllByAgentId(int id) {
        return repository.findAllByAgentId(id);
    }

    @Override
    public List<Production> getAllByEngineerId(int id) {
        return repository.findByEngineerId(id);
    }

    @Override
    public ProductionAndMessage saveAndEditProduction(Production production) {
        Production saved;
        Production temp = repository.findById(production.getId());

        if (temp != null) {
            temp.setCreatedAt(production.getCreatedAt());
            temp.setCreatedBy(production.getCreatedBy());
            temp.setUpdatedAt(production.getUpdatedAt());
            temp.setUpdatedBy(production.getUpdatedBy());

            saved = repository.save(temp);
        } else {
            assert false;
            temp.setEstimated(ChronoUnit.DAYS.between(temp.getDateAccepted(), temp.getDateDone()));
            saved = repository.save(temp);
        }
        ProductionAndMessage pam = new ProductionAndMessage();
        pam.setMessage("Production has been saved!");
        pam.setProduction(saved);
        return pam;
    }

    @Override
    public Long differenceOfErrorHours(Production production) {
        return calculateErrorHours(production.getErrorEnd(), production.getErrorStarted());
    }

    private Long calculateErrorHours(LocalDateTime errorStarted, LocalDateTime errorEnded) {
        return ChronoUnit.MINUTES.between(errorEnded, errorStarted);
    }

    @Override
    public String deleteProduction(int id) {
        Production production = repository.findById(id);
        production.setDeleted(true);
        return "Production was deleted";
    }

    @Override
    public List<MachinesDTO> getOverallLoadTimeByMachine() {
        List<MachinesDTO> machinesDTO = new ArrayList<>();

        List<Object[]> machines = repository.getOverallWorkTimeForMachines();
        for (Object[] obj : machines) {
            MachinesDTO dto = new MachinesDTO();
            dto.setId((Integer) obj[0]);
            dto.setMachineName((String) obj[1]);
            dto.setOweralWorkTime((Long) obj[2]);
            machinesDTO.add(dto);
        }
        return machinesDTO;

    }

}
