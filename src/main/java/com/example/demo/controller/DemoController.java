package com.example.demo.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//http://localhost:8080/remove?value=santhosh
@RestController
public class DemoController {

    @GetMapping("/remove")
    public ResponseEntity<String> removeFirstAndLast(@RequestParam String value) {
        if (value == null || value.length() < 2) {
            return ResponseEntity.badRequest().body("Input must be at least 2 characters long");
        }
        if (value.length() == 2) {
            return ResponseEntity.ok("");
        }
        String result = StringUtils.substring(value, 1, value.length() - 1);
        return ResponseEntity.ok(result);
    }
}
