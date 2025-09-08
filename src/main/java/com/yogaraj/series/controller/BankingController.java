package com.yogaraj.series.BO.controller;

import com.yogaraj.series.BO.BankingBo;
import com.yogaraj.series.BO.DTO.BankingDto;
import com.yogaraj.series.BO.DTO.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BankingController {

    @Autowired
    BankingBo bankingBo;

    private static final Logger log = LoggerFactory.getLogger(BankingController.class);

    @PostMapping("/accounts")
    public ResponseDTO CreateAccount(@RequestBody BankingDto bankingDto){
        log.info("Banking create account Api initiated for account ID : "+bankingDto.getAccountId());
        return bankingBo.CreateAccount(bankingDto);
    }

    @GetMapping("/accounts")
    public Object getAllAccounts(){
        log.info("GetAll Accounts Api initiated");
        return bankingBo.getAllAccounts();
    }

    @GetMapping("accounts/{id}")
    public Object getUserbyId(@PathVariable(name = "id") String id){
        log.info("getUserbyId API initiated for id : "+id);
        return bankingBo.getUserbyId(id);
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseDTO deleteAccountbyId(@PathVariable(name = "id") String id){
        log.info("deleteAccountbyId API initiated for ID : "+id);
        return bankingBo.deleteAccountbyId(id);
    }

    @PostMapping("/accounts/{id}/deposit")
    public ResponseDTO deposit(@PathVariable(name = "id") String id, @RequestParam(name = "amount") double amount){
        log.info("Deposit API initated for ID "+id);
        return bankingBo.deposit(id,amount);
    }

    @PostMapping("/accounts/{id}/withdrawal")
    public ResponseDTO withdrawal(@PathVariable(name = "id") String id, @RequestParam(name = "amount") double amount){
        log.info("Withdrawa API initiated for Id "+id);
        return bankingBo.withdrawal(id,amount);
    }

}
