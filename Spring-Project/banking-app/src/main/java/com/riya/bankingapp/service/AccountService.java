package com.riya.bankingapp.service;


import com.riya.bankingapp.dto.AccountDto;
import com.riya.bankingapp.entity.Account;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto account);

    List<Account> getAll();

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);
}
