package com.example.rentacar.business.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UptadeBrandRequest {
    private int id;
    private String name;

}
