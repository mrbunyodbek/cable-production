package uz.cp.cableproduction.db.dao.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.cp.cableproduction.collections.EngineerAndMessage;
import uz.cp.cableproduction.db.dao.EngineerDAO;
import uz.cp.cableproduction.db.entities.Engineer;
import uz.cp.cableproduction.db.repositories.EngineerRepository;

import java.util.List;

@Service
public class EngineerDAOImpl implements EngineerDAO {

    EngineerRepository repository;

    @Autowired
    public EngineerDAOImpl(EngineerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Engineer> getAll() {
        return repository.findAll();
    }

    @Override
    public Engineer getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Engineer getById(int id) {
        return repository.findById(id);
    }

    @Override
    public EngineerAndMessage saveEngineer(Engineer engineer) {
        Engineer saved;
        Engineer temp = repository.findById(engineer.getId());
        if (temp != null) {
            temp.setName(engineer.getName());
            temp.setMachines(engineer.getMachines());
            saved = repository.save(engineer);

        } else {
            saved = repository.save(engineer);
        }

        EngineerAndMessage eam = new EngineerAndMessage();
        eam.setEngineer(saved);
        eam.setMessage("Engineer has been saved");
        return eam;

    }

    @Override
    public String deleteById(int id) {
        Engineer engineer = repository.findById(id);
        engineer.setDeleted(true);
        repository.save(engineer);
        return null;
    }
}
