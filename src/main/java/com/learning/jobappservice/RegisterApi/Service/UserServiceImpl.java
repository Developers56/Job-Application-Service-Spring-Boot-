package com.learning.jobappservice.RegisterApi.Service;

import com.learning.jobappservice.InvalidInputException;
import com.learning.jobappservice.RegisterApi.Entity.User;
import com.learning.jobappservice.RegisterApi.Repository.UserRepository;
import com.learning.jobappservice.RegisterApi.Model.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserRegistrationRequest request) {
        if (userRepository.findByMobile(request.getMobile()).isPresent()) {
            throw new InvalidInputException("Mobile number already exists");
        }

        if (userRepository.findByCnic(request.getCnic()).isPresent()) {
            throw new InvalidInputException("CNIC number already exists");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());
        user.setCnic(request.getCnic());

        userRepository.save(user);
    }
}
