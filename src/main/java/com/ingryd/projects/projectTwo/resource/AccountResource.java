package com.ingryd.projects.projectTwo.resource;

import com.ingryd.projects.projectTwo.model.AccountUser;
import org.springframework.hateoas.RepresentationModel;

public class AccountResource extends RepresentationModel<AccountResource> {
    private AccountUser accountUser;

    public AccountUser getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }
}
