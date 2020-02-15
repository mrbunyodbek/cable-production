package uz.cp.cableproduction.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.cp.cableproduction.collections.ProductionAndMessage;
import uz.cp.cableproduction.db.dao.ProductionDAO;
import uz.cp.cableproduction.db.entities.documents.Production;

import java.util.List;

@RestController
@RequestMapping(value = "/production")
public class ProductionController {
    ProductionDAO productionDAO;

    public ProductionController(ProductionDAO productionDAO) {
        this.productionDAO = productionDAO;
    }

    @GetMapping("/get")
    public ResponseEntity<List<Production>> getAllProductions() {
        return new ResponseEntity<>(productionDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Production> getProductionById(@PathVariable int id) {
//        return new ResponseEntity<>(productionDAO.getById(id), HttpStatus.OK);
        return null;
    }

    @GetMapping("/getAgent")
    public ResponseEntity<List<Production>> getProductionByAgent(@PathVariable int id) {
        return new ResponseEntity<>(productionDAO.getAllByAgentId(id), HttpStatus.OK);
    }

    @GetMapping("/getEngineer")
    public ResponseEntity<List<Production>> getProductionByEngineer(@PathVariable int id) {
        return new ResponseEntity<>(productionDAO.getAllByEngineerId(id), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<List<Production>> deleteProductionById(@PathVariable int id) {
        productionDAO.deleteProduction(id);
        return new ResponseEntity<>(productionDAO.getAll(), HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<ProductionAndMessage> saveAndEditProduction(@RequestBody Production production) {
        return new ResponseEntity<>(productionDAO.saveAndEditProduction(production), HttpStatus.CREATED);
    }
}
