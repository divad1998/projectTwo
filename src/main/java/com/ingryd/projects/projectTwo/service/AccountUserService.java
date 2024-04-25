package com.ingryd.projects.projectTwo.service;

import com.ingryd.projects.projectTwo.model.AccountUser;
import com.ingryd.projects.projectTwo.repository.AccountUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountUserService {

    @Autowired
    private AccountUserRepository repository;

    public void create(AccountUser accountUser) {
        this.repository.save(accountUser);
    }

    public void update(int id, AccountUser accountUser) throws Exception {
        this.isIdValid(id);
        accountUser.setId(id);
        this.repository.save(accountUser);
    }

    public List<AccountUser> fetchAll() {
        return this.repository.findAll();
    }

    public AccountUser fetchById(int id) throws Exception {
        this.isIdValid(id);
        return this.repository.findById(id).get();
    }

    public AccountUser fetchByUsername(String username) throws Exception {
        Optional<AccountUser> optional = this.repository.findByUsername(username);

        if (optional.isEmpty()) {
            throw new Exception("Invalid Account User");
        }

        return this.repository.findByUsername(username).get();
    }

    private void isIdValid(int id) throws Exception {
        Optional<AccountUser> optional = this.repository.findById(id);

        if (optional.isEmpty()) {
            throw new Exception("Invalid Account User");
        }
    }

    public void deleteById(int id) throws Exception {
        this.isIdValid(id);
        this.repository.deleteById(id);
    }

    public void deleteAll() throws Exception {
        //are values present? ok
        boolean empty = this.repository.findAll().isEmpty();
        if (empty) {
            throw new Exception("Error. Attempt to delete all Account Users but none was found in storage.");
        }

        this.repository.deleteAll();
    }
}
