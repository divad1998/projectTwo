package com.ingryd.projects.projectTwo.controller;

import com.ingryd.projects.projectTwo.model.AccountUser;
import com.ingryd.projects.projectTwo.resource.AccountResource;
import com.ingryd.projects.projectTwo.service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources")
public class AccountResourceController {

    @Autowired
    private AccountUserService service;

    @GetMapping("/{id}")
    public ResponseEntity<AccountResource> fetchAccountResource(@PathVariable int id) throws Exception {
        AccountUser accountUser = service.fetchById(id);
        AccountResource accountResource = new AccountResource();
        accountResource.setAccountUser(accountUser);

        Link create = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountUserController.class).create(null)).withRel("create");
        Link update = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountUserController.class).update(id, null)).withRel("update");
        Link fetchAll = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountUserController.class).fetchAll()).withRel("fetchAll");
        Link fetchById = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountUserController.class).fetchById(id)).withRel("fetchById");
        Link fetchByUsername = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountUserController.class).fetchByUsername(null)).withRel("fetchByUsername");
        Link deleteById = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountUserController.class).deleteById(id)).withRel("deleteById");
        Link deleteAll = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountUserController.class).deleteAll()).withRel("deleteAll");

        accountResource.add(create, update, fetchAll, fetchById, fetchByUsername, deleteById, deleteAll);

        return new ResponseEntity<>(accountResource, HttpStatus.OK);
    }
}
