package lk.royalBank.controller;

import lk.royalBank.dto.UserDTO;
import lk.royalBank.service.UserService;
import lk.royalBank.util.LoginDTO;
import lk.royalBank.util.LoginUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/{username}")
    public void addUser(@PathVariable("username") String userName, @RequestBody UserDTO userDTO){

        System.out.println(userName);
        System.out.println(userDTO);
        userService.addUser(userName,userDTO);

    }

    @PostMapping(path = "/login")
    public LoginUserDTO login(@RequestBody LoginDTO loginDTO){
        System.out.println(loginDTO.getUserName());
        return userService.login(loginDTO);
    }



}
