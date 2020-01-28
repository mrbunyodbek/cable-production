package uz.cp.cableproduction.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.cp.cableproduction.db.dao.MachineDAO;
import uz.cp.cableproduction.db.entities.Machine;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/machines")
public class MachineController {

    MachineDAO machineDAO;

    public MachineController(MachineDAO machineDAO) {
        this.machineDAO = machineDAO;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<Machine>> getAllMachines() {
        machineDAO.getAll();
        return new ResponseEntity<>(machineDAO.getAll(), HttpStatus.OK);

    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Machine> getById(@PathVariable int id) {
        return new ResponseEntity<>(machineDAO.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getModel")
    public ResponseEntity<Machine> getByModel(@PathVariable String model) {
        return new ResponseEntity<>(machineDAO.getByModel(model), HttpStatus.OK);
    }

    @GetMapping(value = "/getType")
    public ResponseEntity<Machine> getBySpeed(@PathVariable double speed) {
        return new ResponseEntity<>(machineDAO.getBySpeed(speed), HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<List<Machine>> deleteById(@PathVariable int id) {
        machineDAO.deleteMachineById(id);
        return new ResponseEntity<>(machineDAO.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<Machine>> saveAndEditMachine(@Valid @RequestBody Machine machine) {
        machineDAO.saveEdit(machine);
        return new ResponseEntity<>(machineDAO.getAll(), HttpStatus.OK);
    }

}
