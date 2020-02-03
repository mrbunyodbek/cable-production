package uz.cp.cableproduction.db.dao.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.cp.cableproduction.collections.CustomerAndMessage;
import uz.cp.cableproduction.db.entities.Customer;
import uz.cp.cableproduction.db.dao.CustomerDAO;
import uz.cp.cableproduction.db.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerDAOImpl implements CustomerDAO {

    CustomerRepository repository;

    @Autowired
    public CustomerDAOImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Customer getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public CustomerAndMessage saveEdit(Customer customer) {
        Customer saved;
        Customer temp = repository.findById(customer.getId());

        if (null != temp) {

            temp.setName(customer.getName());
            temp.setPassword(customer.getPassword());
            saved = repository.save(temp);

        } else {
            saved = repository.save(temp);
        }

        CustomerAndMessage cam = new CustomerAndMessage();
        cam.setCustomer(saved);
        cam.setMessage("Customer has been saved!");
        return cam;
    }

    @Override
    public String deleteCustomerById(int id) {
        Customer customer=repository.findById(id);
        customer.setDeleted(true);
        repository.save(customer);
        return "Customer was deleted";
    }
}
