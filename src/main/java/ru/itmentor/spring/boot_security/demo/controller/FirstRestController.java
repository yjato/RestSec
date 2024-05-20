package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmentor.spring.boot_security.demo.exception.AppError;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class FirstRestController {

    public final UserService userService;

    @Autowired
    public FirstRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String testRest() {
        return "TESTOVOE SMS NA REST CONTROLLER";
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/getByDepartment/{department}")
    public ResponseEntity<List<User>> getListByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(userService.getUsersByDepartment(department));
    }

    @GetMapping("/getUsersWithSalary/{salary}")
    public ResponseEntity<List<User>> getUsersWithSalary(@PathVariable int salary) {
        return ResponseEntity.ok(userService.getUsersWithSalaryGreaterThan(salary));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), "User with id:" + id + " not found"), HttpStatus.NOT_FOUND);
        }
    }
}
