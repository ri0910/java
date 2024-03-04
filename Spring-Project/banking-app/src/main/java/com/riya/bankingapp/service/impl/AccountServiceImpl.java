package com.riya.bankingapp.service.impl;

import com.riya.bankingapp.dto.AccountDto;
import com.riya.bankingapp.entity.Account;
import com.riya.bankingapp.mapper.AccountMapper;
import com.riya.bankingapp.repository.AccountRepo;
import com.riya.bankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;


    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<Account> getAll() {
        return accountRepo.findAll();
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("No Account Found !"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("No Account Found !"));
        account.setBalance(account.getBalance() + amount);
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) throws RuntimeException {
        Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("No Account Found !"));
        if(account.getBalance() - amount >= 0){
            account.setBalance(account.getBalance() - amount);
            Account savedAccount = accountRepo.save(account);
            return AccountMapper.mapToAccountDto(account);
        }
        else{
            throw new RuntimeException("Account don't have much balance");
        }
    }


}
