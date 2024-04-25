package com.ingryd.projects.projectTwo.repository;

import com.ingryd.projects.projectTwo.model.AccountUser;
import com.ingryd.projects.projectTwo.model.KnowYourCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KYCRepository extends JpaRepository<KnowYourCustomer, Integer> {
    KnowYourCustomer getByAccountUser(AccountUser accountUser);
}
