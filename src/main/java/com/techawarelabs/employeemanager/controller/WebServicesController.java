package com.techawarelabs.employeemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/orgs")
public class WebServicesController {

    @GetMapping("/")
    public String getMyNameParam(){
        return "editName";
    }

    @ResponseBody
    @GetMapping("/info")
    public String getMyNameRequestParam(@RequestParam(name = "name") String name11) {
        return "<h2> welcome at " + name11 + " HTTP get request @RequestParam";
    }
}
