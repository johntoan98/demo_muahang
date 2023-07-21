package com.demomuahang.service;

import com.demomuahang.models.Account;

public interface IAccountService extends ICrudService<Account>{
    Account getAccountLogin(Account account);
}
