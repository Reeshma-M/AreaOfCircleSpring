package com.example.area;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HelloController {
        
    @GetMapping("/hello")
    public String sayHello(){
        return "Hey asile";
    }

    @PostMapping("/area")
    public ResponseEntity<String> calculateArea(@RequestParam double radius) {
        if (radius < 1 || radius > 100) {
            return ResponseEntity.badRequest().body("Radius must be between 1 and 100");
        }
        double area = Math.PI * Math.pow(radius, 2);
        String formattedArea = String.format("%.2f", area);
        return ResponseEntity.ok("The area is: " + formattedArea);
    }

}
