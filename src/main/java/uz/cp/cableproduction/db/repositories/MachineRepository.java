package uz.cp.cableproduction.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.cp.cableproduction.db.entities.Machine;

import java.util.List;


public interface MachineRepository extends JpaRepository<Machine, Integer> {
    List<Machine> findAll();

    Machine findById(int id);

    Machine findByType(String type);

    Machine findBySpeed(double speed);

    Machine findByModel(String model);
}
