package com.example.spring_api_secret.controller;

import com.example.spring_api_secret.dto.Response;
import com.example.spring_api_secret.entity.User;
import com.example.spring_api_secret.service.UserService;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response<String> add(@Valid @RequestBody @NotNull User user) {
        return service.add(user);
    }

    @PutMapping("/{id}")
    public Response<String> update(@RequestBody User user, @PathVariable String id) {
        return service.update(user, id);
    }

    @PatchMapping("/{id}")
    public Response<User> fetch(@PathVariable String id) {
        return service.fetch(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Response<String> delete(@PathVariable String id) {
        return service.delete(id);
    }

    @DeleteMapping("")
    public Response<String> clear() {
        return service.deletes();
    }

    @GetMapping("/{id}")
    public Response<User> get(@PathVariable String id) {
        return service.get(id);
    }

    @GetMapping("")
    public Response<List<User>> gets() {
        return service.gets();
    }

    @GetMapping("/size")
    public Response<Long> count() {
        return service.count();
    }

}
