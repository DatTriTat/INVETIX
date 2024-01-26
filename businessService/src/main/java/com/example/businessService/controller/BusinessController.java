package com.example.businessService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import com.example.businessService.dto.BusinessDTO;
import com.example.businessService.model.Business;
import com.example.businessService.service.BusinessService;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/business")   
public class BusinessController {
    @Autowired
    private BusinessService service;

    @PostMapping("/create")
    public String CreateBusiness(@RequestHeader("LoggedInUser") String name, @RequestBody BusinessDTO business,HttpServletRequest request) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        service.create(name, business, authHeader);
        return name + " Created Sucessfully";
    } 

    @GetMapping("/information")
    public Business BusinessInformation(@RequestHeader("LoggedInUser") String name,HttpServletRequest request) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
       
        return service.getBusiness(name, authHeader);
    } 


    @PostMapping("/edit")
    public String editBusiness(@RequestHeader("LoggedInUser") String name, @RequestBody BusinessDTO business,HttpServletRequest request) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        service.edit(name, business, authHeader);
        return name + " Edited Sucessfully";
    } 
}
