package uz.cp.cableproduction.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.cp.cableproduction.db.entities.Machine;
import uz.cp.cableproduction.db.enums.MachineStateStatus;

import java.util.List;


public interface MachineRepository extends JpaRepository<Machine, Integer> {
    List<Machine> findAll();

    Machine findById(int id);

    Machine findByType(String type);

    Machine findBySpeed(double speed);

    Machine findByModel(String model);

//    @Query("SELECT * FROM Machine")
}
