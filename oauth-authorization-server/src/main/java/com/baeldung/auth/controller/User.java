package com.baeldung.auth.controller;

import com.baeldung.auth.domain.Users;
import com.baeldung.auth.repository.UsersRepository;
import org.apache.james.mime4j.field.datetime.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RestController
@RequestMapping("/user")
public class User {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("")
    public String abc(){
        return "!23213";
    }
    @GetMapping("/add")
    public String a(@RequestParam(name = "user") String userName,
                    @RequestParam(name = "password") String pass,
                    @RequestParam(name = "email") String email,
                    @RequestParam(name = "firstName") String firstName,
                    @RequestParam(name = "lastName") String lastName,
                    @RequestParam(name = "birthDay") String birthDay) throws ParseException {
        Users user = new Users();
        user.setUserName(userName);
        user.setPassword(pass);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(birthDay, formatter);
        user.setBirthDay(Date.valueOf(date));
        usersRepository.save(user);
        return "123";
    }
}
