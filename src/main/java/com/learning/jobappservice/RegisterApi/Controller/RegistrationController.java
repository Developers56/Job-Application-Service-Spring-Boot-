package com.learning.jobappservice.RegisterApi.Controller;

import com.learning.jobappservice.RegisterApi.Model.ApiResponse;
import com.learning.jobappservice.RegisterApi.Service.UserService;
import com.learning.jobappservice.RegisterApi.Model.UserRegistrationRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/register")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody UserRegistrationRequest request) {
        userService.registerUser(request);
        return new ResponseEntity<>(new ApiResponse(201, "User registered successfully"), HttpStatus.CREATED);
    }

}
