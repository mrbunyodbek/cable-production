package uz.cp.cableproduction.db.dao;

import uz.cp.cableproduction.collections.EngineerAndMessage;
import uz.cp.cableproduction.db.entities.Engineer;

import java.util.List;

public interface EngineerDAO {
    List<Engineer> getAll();

    Engineer getByName(String name);

    Engineer getById(int id);

    EngineerAndMessage saveEngineer(Engineer engineer);

    String deleteById(int id);

}
