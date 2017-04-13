package br.com.loginone.service;

import br.com.loginone.domain.User;

public interface UserService {
    
     User getUserByLoginAndPassword(String login, String password);
}
