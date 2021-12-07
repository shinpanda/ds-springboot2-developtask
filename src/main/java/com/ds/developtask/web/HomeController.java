package com.ds.developtask.web;

import com.ds.developtask.service.member.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HomeController {

    private final LoginService loginService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password){
        return loginService.login(name, password);
    }

}
