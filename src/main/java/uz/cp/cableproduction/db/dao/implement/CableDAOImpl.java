package uz.cp.cableproduction.db.dao.implement;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.model.CamelCaseAbbreviatingFieldNamingStrategy;
import org.springframework.stereotype.Service;
import uz.cp.cableproduction.collections.CableAndMessage;
import uz.cp.cableproduction.db.entities.Cable;
import uz.cp.cableproduction.db.dao.CableDAO;
import uz.cp.cableproduction.db.entities.Machine;
import uz.cp.cableproduction.db.repositories.CableRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CableDAOImpl implements CableDAO {

    CableRepository repository;

    @Autowired
    public CableDAOImpl(CableRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cable> getAll() {
        return repository.findAll();
    }

    @Override
    public Cable getByType(String type) {
        return repository.findByType(type);
    }

    @Override
    public Cable findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Cable getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public CableAndMessage saveEditCable(Cable cable) {
        Cable saved;
        List list = new ArrayList();
        Cable temp = repository.findById(cable.getId());
        if (temp != null) {
            temp.setDeleted(false);
            temp.setDescription(cable.getDescription());
            list.add(temp.getMachines());
            temp.setName(cable.getName());
            temp.setType(cable.getType());
            saved = repository.save(temp);

        } else {
            saved = repository.save(cable);
        }
        CableAndMessage cam = new CableAndMessage();
        cam.setCable(saved);
        cam.setMessage("Cable has been saved!");
        return cam;
    }

    @Override
    public String deleteCableById(int id) {
        Cable cable = repository.findById(id);
        cable.setDeleted(true);
        repository.save(cable);
        return "Cable was deleted";
    }
}
