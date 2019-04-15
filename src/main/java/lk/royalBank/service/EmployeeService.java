package lk.royalBank.service;

import lk.royalBank.dto.EmployeeDTO;

public interface EmployeeService {

    void addEmployee(String empID ,EmployeeDTO employeeDTO);

    EmployeeDTO findById(String empID);

}
