package lk.royalBank.controller;

import lk.royalBank.dto.EmployeeDTO;
import lk.royalBank.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping(value = "/{empID}")
    public void saveEmp(@PathVariable("empID") String empID, @RequestBody EmployeeDTO employeeDTO){
        employeeService.addEmployee(empID,employeeDTO);
    }

    @GetMapping(value = {"/{empID}"})
    public EmployeeDTO findbyID(@PathVariable("empID") String empID){
        return employeeService.findById(empID);
    }

}
