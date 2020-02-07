package uz.cp.cableproduction.db.dao;

import uz.cp.cableproduction.collections.ProductionAndMessage;
import uz.cp.cableproduction.db.entities.documents.Production;

import java.util.List;

public interface ProductionDAO {
    List<Production> getAll();

    Production getById(int id);

    List<Production> getAllByAgentId(int id);

    List<Production> getAllByEngineerId(int id);

    Long differenceOfErrorHours(Production production);

    ProductionAndMessage saveAndEditProduction(Production production);

    String deleteProduction(int id);


}
