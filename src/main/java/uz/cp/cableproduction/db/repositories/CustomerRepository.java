package uz.cp.cableproduction.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.cp.cableproduction.db.entities.Customer;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAll();

    Customer findById(int id);

    Customer findByName(String name);

}
