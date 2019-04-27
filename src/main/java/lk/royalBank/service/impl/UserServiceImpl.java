package lk.royalBank.service.impl;

import lk.royalBank.dto.ClientDTO;
import lk.royalBank.dto.EmployeeDTO;
import lk.royalBank.dto.UserDTO;
import lk.royalBank.entity.User;
import lk.royalBank.repository.UserRepository;
import lk.royalBank.service.ClientService;
import lk.royalBank.service.EmployeeService;
import lk.royalBank.service.UserService;
import lk.royalBank.util.LoginDTO;
import lk.royalBank.util.LoginUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Autowired
    private EmployeeService employeeService;


    @Autowired
    private ClientService clientService;
    @Override
    public void addUser(String UserName, UserDTO userDTO) {
        System.out.println(userDTO);
        if (!UserName.equals(userDTO.getUserName())) {
            throw new RuntimeException("ID's Are Not Same");
        }

        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userRepository.save(user);

    }

    @Override
    public LoginUserDTO login(LoginDTO loginDTO) {
        System.out.println(loginDTO.getUserName());
        System.out.println(loginDTO.getPassword());
        Optional<User> login = userRepository.findById(loginDTO.getUserName());
        System.out.println(login.isPresent());

        if (login.isPresent()) {
            User user = login.get();

            if(user.getUserName().equals(loginDTO.getUserName()) && user.getPassword().equals(loginDTO.getPassword())){
                if (user.getRole().equals("Client")) {

                    ClientDTO clientDTO = clientService.findByID(user.getID());
                    return  new LoginUserDTO(clientDTO.getClientID(),clientDTO.getFname(),clientDTO.getLname(),"Client");

                }else{

                    EmployeeDTO emp = employeeService.findById(user.getID());

                    return new LoginUserDTO(emp.getEmpID(), emp.getFname(), emp.getLname(),emp.getRole());

                }
            }else {
                System.out.println("2");
                throw new RuntimeException("User Name or Password Invalid !");
            }


        }else{
            System.out.println("3");
//            return null;
            throw new RuntimeException("User Name or Password Invalid !");
        }


    }

    @Override
    public UserDTO findByID(String userID) {
        User user = userRepository.findById(userID).get();
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }

    @Override
    public void changePassword(String uname, String password) {

        User user = userRepository.findById(uname).get();
        user.setPassword(password);
    }
}
