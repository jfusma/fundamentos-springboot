package com.platzi.springboot.fundamentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FundamentalController {

    @RequestMapping
    @ResponseBody
    public ResponseEntity<String> firstFunction(){
        return new ResponseEntity<>("Hello word front controller", HttpStatus.OK);
    }
}
