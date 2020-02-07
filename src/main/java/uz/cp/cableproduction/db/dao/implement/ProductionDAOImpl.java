package uz.cp.cableproduction.db.dao.implement;

import org.springframework.stereotype.Service;
import uz.cp.cableproduction.collections.ProductionAndMessage;
import uz.cp.cableproduction.db.dao.ProductionDAO;
import uz.cp.cableproduction.db.entities.documents.Production;
import uz.cp.cableproduction.db.repositories.ProductionRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ProductionDAOImpl implements ProductionDAO {
    ProductionRepository repository;

    public ProductionDAOImpl(ProductionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Production> getAll() {
        return repository.findAll();
    }

    @Override
    public Production getById(int id) {
        return repository.findById(id);
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

}
