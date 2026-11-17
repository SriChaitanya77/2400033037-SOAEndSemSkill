package com.example.admin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/admin")
public class AdminController {
 @GetMapping("/dashboard") public String dashboard() { return "ADMIN SERVICE: Welcome to the admin dashboard."; }
 @GetMapping("/reports") public String reports() { return "ADMIN SERVICE: Confidential admin reports."; }
}
