package com.example.aop.service;

import com.example.aop.domain.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {


    public void saveAccount() {
        System.out.println("saveAccount() is called");

    }

    public void updateAccount(int i) throws Exception {
        System.out.println("updateAccount() is called");

    }

    public int deleteAccount() {
        System.out.println("deleteAccount() is called");
        return 0;
    }
}
