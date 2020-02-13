package uz.cp.cableproduction.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.cp.cableproduction.db.entities.Machine;
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

    @Query ("SELECT m.id, m.model, count(p.estimated) FROM production p INNER JOIN machines m ON m.id = p.machineId WHERE p.status='PENDING' OR p.status='PRODUCING' OR p.status='DONE'")
    List<Object[]> getOverallWorkTimeForMachines();

}
