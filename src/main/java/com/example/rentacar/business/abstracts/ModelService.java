package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.request.CreateBrandRequest;
import com.example.rentacar.business.request.CreateModelRequest;
import com.example.rentacar.business.responses.GetAllBrandsResponse;
import com.example.rentacar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);

}
