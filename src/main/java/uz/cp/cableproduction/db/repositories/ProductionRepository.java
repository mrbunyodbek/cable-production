package uz.cp.cableproduction.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.cp.cableproduction.db.entities.documents.Production;

import java.util.List;

public interface ProductionRepository extends JpaRepository<Production, Integer> {

    List<Production> findAll();

    List<Production> findAllByOrderId(int orderId);

    List<Production> findAllByAgentId(int id);

    List<Production> findAllByStatus(String status);

    List<Production> findAllByJobDoneTrue();

    Production findById(int id);

    List<Production> findByEngineerId(int id);

    Production findByMachineId(int machineId);

    int getOverallWorkTimeForMachines();

}
