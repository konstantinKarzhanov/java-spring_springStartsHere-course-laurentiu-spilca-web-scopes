package com.practice.service;

import com.practice.dto.LoginDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.HashMap;
import java.util.Map;

@Service
@RequestScope
public class LoginProcessorService {
    private final LoggedUserManagementService loggedUserManagementService;

    public LoginProcessorService(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    public boolean validateCredentials(LoginDTO loginDTO) {
        Map<String, String> registeredUsersMap = new HashMap<>();

        registeredUsersMap.put("test1", "test1");
        registeredUsersMap.put("test2", "test2");

        boolean isCredentialsValid = registeredUsersMap.containsKey(loginDTO.username()) &&
                registeredUsersMap.get(loginDTO.username()).equals(loginDTO.password());

        if (isCredentialsValid) this.loggedUserManagementService.setUsername(loginDTO.username());

        return isCredentialsValid;
    }
}
