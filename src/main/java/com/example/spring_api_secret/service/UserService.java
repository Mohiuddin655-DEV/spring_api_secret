package com.example.spring_api_secret.service;

import com.example.spring_api_secret.dto.Response;
import com.example.spring_api_secret.entity.User;
import com.example.spring_api_secret.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

//    @PostConstruct
//    public void initDB() {
//        List<User> users = IntStream.rangeClosed(1, 200).mapToObj(i -> new User(
//                String.valueOf(i),
//                "User " + i + "",
//                "user" + i + "@gmail.com"
//        )).toList();
//        repository.saveAll(users);
//    }

    public boolean isExists(String id) {
        return repository.existsById(id);
    }

    public Response<String> add(@NotNull User user) {
        String id = user.getId();
        if (id != null && isExists(id)) {
            return Response.withError("User already found!");
        } else {
            repository.save(user);
            return Response.withMessage("User create successfully!");
        }
    }

    public Response<String> update(User content, String id) {
        if (!repository.existsById(id)) {
            return Response.withError("User not found!");
        } else {
            repository.save(content);
            return Response.withMessage("User update successfully!");
        }
    }

    public Response<User> fetch(String id) {
        return repository.findById(id).map(Response::withData).orElseGet(() -> Response.withError("User not found!"));
    }

    public Response<String> delete(String id) {
        repository.deleteById(id);
        return Response.withMessage("User deleted!");
    }

    public Response<String> deletes() {
        repository.deleteAll();
        return Response.withMessage("Users deleted!");
    }

    public Response<User> get(String id) {
        return repository.findById(id).map(Response::withData).orElseGet(() -> Response.withError("User not found!"));
    }

    public Response<List<User>> gets() {
        if (repository != null) {
            final List<User> data = repository.findAll();
            if (!data.isEmpty()) {
                return Response.withData(data);
            } else {
                return Response.withError("Users not found!");
            }
        } else {
            return Response.withError("Bad gateway!");
        }
    }

    public List<User> sort(Sort.Direction direction, String... fields) {
        Sort sort = Sort.by(direction, fields);
        return repository.findAll(sort);
    }

    public List<User> paging(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable).getContent();
    }

    public List<User> specifics(List<String> ids) {
        return repository.findAllById(ids);
    }

    public Response<Long> count() {
        return Response.withData(repository.count());
    }

}
