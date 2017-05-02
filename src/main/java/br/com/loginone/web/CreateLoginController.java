package br.com.loginone.web;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.loginone.domain.User;
import br.com.loginone.service.UserService;

@Controller
public class CreateLoginController {
    
    private static final Logger logger = Logger.getLogger(CreateLoginController.class);
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/createLogin")
    private String createUser(@Valid User user, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            
            logger.info("Information wrong!");
            return "login-form";
        }
        if(userService.getUserByLoginAndPassword(user.getLoginUser(), user.getPasswordUser()) != null) {
            return "login-form";
        }
        userService.saveUser(user);
        return "index";
    }
}
