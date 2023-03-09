package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.BrandService;
import com.example.rentacar.business.request.CreateBrandRequest;
import com.example.rentacar.business.request.UptadeBrandRequest;
import com.example.rentacar.business.responses.GetAllBrandsResponse;
import com.example.rentacar.business.responses.GetByIdBrandResponse;
import com.example.rentacar.business.rules.BrandBusinessRules;
import com.example.rentacar.core.utilites.mappers.ModelMapperService;
import com.example.rentacar.dataAccess.abstracts.BrandRepository;
import com.example.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service //bu bir businessdir
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();


        List<GetAllBrandsResponse>  brandsResponse = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponse;
    }
    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        this.brandBusinessRules.checkIfBrandNameExsists(createBrandRequest.getName());

        this.brandRepository.save(brand);
    }

    @Override
    public void uptade(UptadeBrandRequest uptadeBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(uptadeBrandRequest,Brand.class);
        this.brandRepository.save(brand);

    }
    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand=this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response=modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);

    }

}