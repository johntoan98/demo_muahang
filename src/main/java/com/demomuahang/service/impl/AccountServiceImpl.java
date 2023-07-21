package com.demomuahang.service.impl;

import com.demomuahang.models.Account;
import com.demomuahang.repository.IAccountRepo;
import com.demomuahang.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepo iAccountRepo;

    @Override
    public Account getAccountLogin(Account account) {
        return iAccountRepo.getAccountLogin(account.getUsername(), account.getPassword());
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public void save(Account account) {
        iAccountRepo.save(account);
    }

    @Override
    public void edit(Account account) {

    }

    @Override
    public void delete(Account account) {

    }
}
