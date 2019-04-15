package lk.royalBank.service;

import lk.royalBank.dto.UserDTO;
import lk.royalBank.util.LoginDTO;
import lk.royalBank.util.LoginUserDTO;

public interface UserService {

    void addUser(String UserName,UserDTO userDTO);

    LoginUserDTO login(LoginDTO loginDTO);
}
