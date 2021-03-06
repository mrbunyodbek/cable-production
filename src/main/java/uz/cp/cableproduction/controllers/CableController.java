package uz.cp.cableproduction.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.cp.cableproduction.collections.CableAndMessage;
import uz.cp.cableproduction.db.dao.CableDAO;
import uz.cp.cableproduction.db.entities.Cable;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/cables")
public class CableController {
    private CableDAO cableDAO;

    public CableController(CableDAO cableDAO) {
        this.cableDAO = cableDAO;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<Cable>> getAllCables() {
        return new ResponseEntity<>(cableDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/getType")
    public ResponseEntity<Cable> getType(@PathVariable String type) {
        return new ResponseEntity<>(cableDAO.getByType(type), HttpStatus.OK);
    }

    @GetMapping(value = "/getName")
    public ResponseEntity<Cable> getByName(@PathVariable String name) {
        return new ResponseEntity<>(cableDAO.getByName(name), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<CableAndMessage> saveEdit(@Valid @RequestBody Cable cable) {
        CableAndMessage andMessage = cableDAO.saveEditCable(cable);
        return new ResponseEntity<>(andMessage, HttpStatus.OK);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<List<Cable>> deleteById(@PathVariable int id) {
        cableDAO.deleteCableById(id);
        return new ResponseEntity<>(cableDAO.getAll(), HttpStatus.OK);
    }

}
