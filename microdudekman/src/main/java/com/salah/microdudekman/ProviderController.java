package com.salah.microdudekman;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderController {
    @GetMapping("list")
    public ResponseEntity<?> getList(){
        return ResponseEntity.ok(List.of("Salah", "Abdulrahman"));
    }
}
