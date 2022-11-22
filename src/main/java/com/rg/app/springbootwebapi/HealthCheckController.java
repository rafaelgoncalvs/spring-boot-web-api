package com.rg.app.springbootwebapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
@RequestMapping("healthCheck")
public class HealthCheckController {

    @GetMapping
    public String getHealthCheck() {
        return LocalDateTime.now(ZoneOffset.UTC).toString();
    }
}
