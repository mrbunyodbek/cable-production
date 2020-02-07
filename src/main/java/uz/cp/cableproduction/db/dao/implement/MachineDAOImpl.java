package uz.cp.cableproduction.db.dao.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.cp.cableproduction.collections.MachineAndMessage;
import uz.cp.cableproduction.db.entities.Machine;
import uz.cp.cableproduction.db.dao.MachineDAO;
import uz.cp.cableproduction.db.repositories.MachineRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MachineDAOImpl implements MachineDAO {
    MachineRepository repository;

    @Autowired
    public MachineDAOImpl(MachineRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Machine> getAll() {
        return repository.findAll();
    }

    @Override
    public Machine getById(int id) {
        return repository.findById(id);
    }

    @Override
    public Machine getByType(String type) {
        return repository.findByType(type);
    }

    @Override
    public Machine getByModel(String model) {
        return repository.findByModel(model);
    }

    @Override
    public Machine getBySpeed(double speed) {
        return repository.findBySpeed(speed);
    }

    @Override
    public MachineAndMessage saveEdit(Machine machine) {
        Machine saved;

        Machine temp = repository.findById(machine.getId());
        if (temp != null) {
            temp.setDescription(machine.getDescription());
            temp.setModel(machine.getModel());
            temp.setSpeed(machine.getSpeed());
            temp.setType(machine.getType());

            saved = repository.save(temp);
        } else {
            saved = repository.save(machine);
        }
        MachineAndMessage mam = new MachineAndMessage();
        mam.setMachine(saved);
        mam.setMessage("Machine has been saved!");
        return mam;
    }

    @Override
    public String deleteMachineById(int id) {
        Machine machine = repository.findById(id);
        machine.setDeleted(true);
        repository.save(machine);
        return "Machine was deleted";
    }
}
