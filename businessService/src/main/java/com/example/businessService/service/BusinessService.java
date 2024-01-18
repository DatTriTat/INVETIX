package com.example.businessService.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.businessService.dto.BusinessDTO;
import com.example.businessService.model.Business;
import com.example.businessService.repository.BusinessRepository;

@Service("BusinessService")
public class BusinessService {
    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Business create(String ownerName, BusinessDTO business, String authHeader) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authHeader);
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", ownerName);
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);
        Business newBusiness = new Business();
        Long ownerId = restTemplate.postForObject("http://user-service/userId", entity, Long.class);
        newBusiness.setBusinessName(business.getBusinessName());;
        newBusiness.setType(business.getType());
        newBusiness.setOwnerId(ownerId);
        businessRepository.save(newBusiness);
        return newBusiness;
    }
}