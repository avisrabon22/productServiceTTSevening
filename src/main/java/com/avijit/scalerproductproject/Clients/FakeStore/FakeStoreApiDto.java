package com.avijit.scalerproductproject.Clients.FakeStore;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreApiDto {
    private Long Id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
