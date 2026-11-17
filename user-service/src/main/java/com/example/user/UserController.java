package com.example.user;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")
public class UserController {
 @GetMapping("/dashboard") public String dashboard() { return "USER SERVICE: Welcome to the user dashboard."; }
 @GetMapping("/profile") public String profile() { return "USER SERVICE: User profile information."; }
}
