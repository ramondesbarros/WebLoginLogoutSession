package br.com.loginone.web;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.loginone.domain.User;
import br.com.loginone.service.UserService;

@Controller
public class LoginController {
    
    private static final Logger logger = Logger.getLogger(LoginController.class);
    
    //https://spring.io/guides/tutorials/spring-boot-oauth2/
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/login")
    public String loginForm() {
      return "login-form";
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(User user, HttpSession session) {
        
        logger.info("User -> " + user);
        
        if(userService.getUserByLoginAndPassword(user.getLoginUser(), user.getPasswordUser()) == null) {
            session.setAttribute("usuarioLogado", user);
            return "login-form";
        }
        
        return "index";
    }
}
