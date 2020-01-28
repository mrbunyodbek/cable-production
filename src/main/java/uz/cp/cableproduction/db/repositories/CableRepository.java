package uz.cp.cableproduction.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.cp.cableproduction.db.entities.Cable;

import java.util.List;

public interface CableRepository extends JpaRepository<Cable, Integer> {
    List<Cable> findAll();

    Cable findById(int id);

    Cable findByType(String type);

    Cable findByName(String name);
}
