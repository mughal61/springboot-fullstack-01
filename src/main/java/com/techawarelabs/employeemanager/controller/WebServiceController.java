package com.techawarelabs.employeemanager.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/org")
public class WebServiceController {

    @GetMapping("/info")
    public String getMyNameParam(@RequestParam(defaultValue = "skillsoft", name = "orgname") String name) {
        return "<h2> welcome at " + name + " HTTP get request @RequestParam";
    }

    @GetMapping("/info/{name}")
    public String getMyNamePath(@PathVariable(name = "name") String name11) {
        return "<h2> welcome at " + name11 + " HTTP get request @PathVariable";
    }
}
