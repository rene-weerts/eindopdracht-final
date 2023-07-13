package com.NoviHogeschool.EindopdrachtReneWeertsfinal.controller;

import com.NoviHogeschool.EindopdrachtReneWeertsfinal.dto.UserDto;
import com.NoviHogeschool.EindopdrachtReneWeertsfinal.model.Role;
import com.NoviHogeschool.EindopdrachtReneWeertsfinal.model.User;
import com.NoviHogeschool.EindopdrachtReneWeertsfinal.repository.RoleRepository;
import com.NoviHogeschool.EindopdrachtReneWeertsfinal.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepos;
    private final RoleRepository roleRepos;
    private final PasswordEncoder encoder;

    public UserController(UserRepository userRepos, RoleRepository roleRepos, PasswordEncoder encoder) {
        this.userRepos = userRepos;
        this.roleRepos = roleRepos;
        this.encoder = encoder;
    }
    @PostMapping("/users")
    public String createUser(@RequestBody UserDto userDto) { //createUser is een endpoint
        User newUser = new User();                           //er wordt een nieuw object aangemaakt
        newUser.setUsername(userDto.username);               //username wordt gecopieerd
        newUser.setPassword(encoder.encode(userDto.password)); //wachtwoord wordt door de encoder gehaald want staat in constructor

        List<Role> userRoles = new ArrayList<>();
        for (String rolename : userDto.roles) {
            Optional<Role> or = roleRepos.findById("ROLE_" + rolename);

            userRoles.add(or.get());
        }
        newUser.setRoles(userRoles);

        userRepos.save(newUser);

        return "Done";
    }
}
