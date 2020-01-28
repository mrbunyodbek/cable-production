package uz.cp.cableproduction.db.dao;

import uz.cp.cableproduction.collections.CableAndMessage;
import uz.cp.cableproduction.db.entities.Cable;

import java.util.List;

public interface CableDAO {
    List<Cable> getAll();

    Cable findById(int id);

    Cable getByType(String type);

    Cable getByName(String name);

    CableAndMessage saveEditCable(Cable cable);

    String deleteCableById(int id);

}