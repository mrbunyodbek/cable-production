package uz.cp.cableproduction.db.dao;

import uz.cp.cableproduction.collections.CustomerAndMessage;
import uz.cp.cableproduction.db.entities.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getAll();

    Customer findById(int id);

    Customer getByName(String name);

    CustomerAndMessage saveEdit(Customer customer);

    String deleteCustomerById(int id);

}
