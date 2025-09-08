package com.yogaraj.series.BO;


import com.yogaraj.series.BO.DTO.LoginDTO;
import com.yogaraj.series.BO.DTO.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginBo {

    @Autowired
    LoginDTO loginDTO;

    @Autowired
    ResponseDTO responseDTO;

    public ResponseDTO LoginValidator(LoginDTO loginDTO){
        System.out.println(loginDTO.getUsername()+"Username");
        boolean validator = loginDTO.getUsername().equals("Admin")  & loginDTO.getPassword().equals("1234");
        if (validator){
            responseDTO.setStatus("Success");
            responseDTO.setMessage("Welcome admin!");
        }else {
            responseDTO.setStatus("Failure");
            responseDTO.setMessage("Invalid Credentials!");
        }
        return responseDTO;
    }
}
