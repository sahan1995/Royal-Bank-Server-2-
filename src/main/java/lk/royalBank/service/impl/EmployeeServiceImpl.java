package lk.royalBank.service.impl;

import lk.royalBank.dto.BranchDTO;
import lk.royalBank.dto.EmployeeDTO;
import lk.royalBank.dto.UserDTO;
import lk.royalBank.entity.Branch;
import lk.royalBank.entity.Employee;
import lk.royalBank.repository.EmployeeRepository;
import lk.royalBank.service.EmployeeService;
import lk.royalBank.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserService userService;
    @Override
    public void addEmployee(String empID,EmployeeDTO employeeDTO) {

        if(!empID.equals(employeeDTO.getEmpID())){
            throw new RuntimeException("Id's Are Note Same");
        }
        Employee employee = new Employee();
        Branch branch = new Branch();
        BeanUtils.copyProperties(employeeDTO,employee);

        RestTemplate restTemplate = new RestTemplate();
        //Using server one service for get branchDTO bt ID
        try{
            ResponseEntity<BranchDTO> responseEntity = restTemplate.getForEntity("http://192.168.1.101:8081/api/v1/branches/" + employeeDTO.getBrachid(), BranchDTO.class);
            HttpStatus statusCode = responseEntity.getStatusCode();
            System.out.println(statusCode);
            BranchDTO branchDTO = responseEntity.getBody();
            BeanUtils.copyProperties(branchDTO,branch);
            employee.setBranch(branch);
            UserDTO userDTO = new UserDTO(employeeDTO.getUserName(), employeeDTO.getPassword(), employeeDTO.getRole(), employeeDTO.getEmpID());
            employeeRepository.save(employee);
            userService.addUser(employeeDTO.getUserName(),userDTO);

        }catch(Exception e){

            ResponseEntity<BranchDTO> responseEntity = restTemplate.getForEntity("http://192.168.1.101:8083/api/v1/branches/" + employeeDTO.getBrachid(), BranchDTO.class);
            HttpStatus statusCode = responseEntity.getStatusCode();
            System.out.println(statusCode);
            BranchDTO branchDTO = responseEntity.getBody();
            BeanUtils.copyProperties(branchDTO,branch);
            employee.setBranch(branch);
            UserDTO userDTO = new UserDTO(employeeDTO.getUserName(), employeeDTO.getPassword(), employeeDTO.getRole(), employeeDTO.getEmpID());
            employeeRepository.save(employee);
            userService.addUser(employeeDTO.getUserName(),userDTO);
        }






    }

    @Override
    public EmployeeDTO findById(String empID) {

        Optional<Employee> getEmp = employeeRepository.findById(empID);
        if(getEmp.isPresent()){
            Employee employee = getEmp.get();
            EmployeeDTO employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employee,employeeDTO);
            return employeeDTO;
        }
         throw new RuntimeException("User Not Found !");


    }
}
