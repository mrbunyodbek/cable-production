package uz.cp.cableproduction.db.dao.implement;

import org.springframework.stereotype.Service;
import uz.cp.cableproduction.collections.ProductionAndMessage;
import uz.cp.cableproduction.collections.ProductionStats;
import uz.cp.cableproduction.db.dao.ProductionDAO;
import uz.cp.cableproduction.db.entities.Machine;
import uz.cp.cableproduction.db.entities.documents.Production;
import uz.cp.cableproduction.db.repositories.ProductionRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductionDAOImpl implements ProductionDAO {
    ProductionRepository repository;
    private EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public ProductionDAOImpl(ProductionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Production> getAll() {
        return repository.findAll();
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
            temp.setEstimated(ChronoUnit.DAYS.between(temp.getDateAccepted(),temp.getDateDone()));
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
    public List<Object[]> getOverallLoadTimeByMachine(Production production, Machine machine) {
        return repository.getOverallWorkTimeForMachines(production,machine);
    }
//    @Override
//    public List<ProductionStats> getOverallLoadTimeByMachine() {
//        List<ProductionStats> productionStatsList = new ArrayList<>();
//
//        String QUERY = "SELECT p.machineId FROM ";
//        Query query = em.createQuery(QUERY);
//
//        return null;
//    }

}
