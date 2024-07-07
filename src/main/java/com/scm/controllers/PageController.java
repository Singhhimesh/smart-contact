package com.scm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scm.entities.User;
import com.scm.enums.MesssageEnum;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.services.servicesImplementation.UserServiceImpl;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import  com.scm.helpers.AppConstants;

@Controller
public class PageController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping
    public String home() {
        return "pages/home";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "pages/about";
    }

    @GetMapping("/service")
    public String servicePage() {
        return "pages/service";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "pages/contact";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "sessions/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();

        userForm.setAbout("Lorem ipsum dolor sit amet consectetur adipisicing elit. Enim, dolorum!");

        model.addAttribute("userForm", userForm);
        
        return "sessions/register";
    }

    @PostMapping("/register")
    public String handleRegister(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "sessions/register";   
        }

        User user = new User();

        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        user.setAbout(userForm.getAbout());
        user.setRoleList(List.of(AppConstants.ROLE_USER));
        user.setPhone(userForm.getPhone());
        user.setProfile("https://static.vecteezy.com/system/resources/previews/018/765/757/original/user-profile-icon-in-flat-style-member-avatar-illustration-on-isolated-background-human-permission-sign-business-concept-vector.jpg");

        this.userServiceImpl.saveUSer(user);

        Message message = Message.builder().message("User saved successfully").type(MesssageEnum.DANGER).build();

        httpSession.setAttribute("message", message);

        return "redirect:/register";
    }
}
