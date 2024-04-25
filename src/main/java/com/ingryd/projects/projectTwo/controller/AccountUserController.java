package com.ingryd.projects.projectTwo.controller;

import com.ingryd.projects.projectTwo.Response;
import com.ingryd.projects.projectTwo.model.AccountUser;
import com.ingryd.projects.projectTwo.service.AccountUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account-users")
public class AccountUserController {

    @Autowired
    private AccountUserService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AccountUser accountUser) {
        //Test cases: validation, db server down, send a diff obj, created
        this.service.create(accountUser);
        Response response = new Response(true, "Created successfully.", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable int id, @RequestBody @Valid AccountUser accountUser) throws Exception {
        this.service.update(id, accountUser);
        Response response = new Response(true, "Updated successfully.", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Response> fetchAll() {
        List<AccountUser> accountUsers = this.service.fetchAll();
        Response response = new Response(true, "Fetched successfully.", accountUsers);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> fetchById(@PathVariable int id) throws Exception {
        AccountUser accountUser = this.service.fetchById(id);
        Response response = new Response(true, "Fetched successfully.", List.of(accountUser));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<Response> fetchByUsername(@RequestParam String username) throws Exception {
        AccountUser accountUser = this.service.fetchByUsername(username);
        Response response = new Response(true, "Fetched successfully.", List.of(accountUser));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteById(@PathVariable int id) throws Exception {
        this.service.deleteById(id);
        Response response = new Response(true, "Deleted.", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Response> deleteAll() throws Exception {
        this.service.deleteAll();
        Response response = new Response(true, "Deleted.", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
