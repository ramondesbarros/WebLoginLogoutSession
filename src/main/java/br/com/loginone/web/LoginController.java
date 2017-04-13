package br.com.loginone.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.loginone.domain.User;
import br.com.loginone.service.UserService;

@Controller
public class LoginController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/")
    public String loginForm() {
      return "login-form";
    }
    
    @RequestMapping("/efetuaLogin")
    public String efetuaLogin(User user, HttpSession session) {
        
        if(userService.getUserByLoginAndPassword(user.getLoginUser(), user.getPasswordUser()) == null) {
            session.setAttribute("usuarioLogado", user);
            return "login-form";
        }
        
        return "index";
    }
}
