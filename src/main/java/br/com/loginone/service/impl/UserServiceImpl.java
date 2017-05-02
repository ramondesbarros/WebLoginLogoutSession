package br.com.loginone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loginone.domain.User;
import br.com.loginone.integration.UserRepository;
import br.com.loginone.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        
        return userRepository.getUserByLoginAndPassword(login, password);
    }

    @Override
    public User saveUser(User user) {
        
        return userRepository.save(user);
    }

}
