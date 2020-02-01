package uz.cp.cableproduction.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.cp.cableproduction.db.entities.Engineer;

import java.util.List;

public interface EngineerRepository extends JpaRepository<Engineer, Integer> {
    List<Engineer> findAll();

    Engineer findById(int id);

    Engineer findByName(String name);
}
