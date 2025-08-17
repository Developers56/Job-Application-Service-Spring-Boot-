package com.learning.jobappservice.RegisterApi.Service;

import com.learning.jobappservice.RegisterApi.Model.UserRegistrationRequest;

public interface UserService {

    void registerUser(UserRegistrationRequest request);
}
