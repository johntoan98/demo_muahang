package com.demomuahang.repository;

import com.demomuahang.models.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IAccountRepo extends CrudRepository<Account,Integer> {

    @Query(value = "select a from Account a where a.username=:u and a.password=:p")
    Account getAccountLogin(@Param("u") String username, @Param("p") String p);

}
