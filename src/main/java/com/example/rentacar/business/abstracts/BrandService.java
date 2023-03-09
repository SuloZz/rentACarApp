package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.request.CreateBrandRequest;
import com.example.rentacar.business.request.UptadeBrandRequest;
import com.example.rentacar.business.responses.GetAllBrandsResponse;
import com.example.rentacar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {

        List<GetAllBrandsResponse> getAll();
        GetByIdBrandResponse getById(int id);
        void add(CreateBrandRequest createBrandRequest);
        void uptade(UptadeBrandRequest uptadeBrandRequest);
        void delete(int id);



}
