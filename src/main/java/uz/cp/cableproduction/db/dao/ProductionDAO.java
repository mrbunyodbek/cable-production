package uz.cp.cableproduction.db.dao;

import uz.cp.cableproduction.collections.ProductionAndMessage;
import uz.cp.cableproduction.db.entities.documents.Production;
import uz.cp.cableproduction.db.entities.dto.MachinesDTO;

import java.util.List;

public interface ProductionDAO {
    List<Production> getAll();

    Production getByMachineId(int id);

    List<Production> getByOrderId(int id);

    List<Production> getAllByAgentId(int id);

    List<Production> getAllByEngineerId(int id);

    Long differenceOfErrorHours(Production production);

    ProductionAndMessage saveAndEditProduction(Production production);

    String deleteProduction(int id);

   List<MachinesDTO> getOverallLoadTimeByMachine();


}
