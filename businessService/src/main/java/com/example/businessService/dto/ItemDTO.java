package com.example.businessService.dto;

import java.time.LocalDateTime;

import com.example.businessService.model.Category;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private String name;
    private Category category;
    private String desciption;
    private int quantity;
    private LocalDateTime expired;
    private String location;
}
