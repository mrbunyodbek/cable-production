package uz.cp.cableproduction.db.dao;

import uz.cp.cableproduction.collections.MachineAndMessage;
import uz.cp.cableproduction.db.entities.Machine;

import java.util.List;

public interface MachineDAO {
    List<Machine> getAll();

    Machine getById(int id);

    Machine getByType(String type);

    Machine getByModel(String model);

    Machine getBySpeed(double speed);

    MachineAndMessage saveEdit(Machine machine);

    String deleteMachineById(int id);


}
