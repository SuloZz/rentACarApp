package com.example.rentacar.webApi.controllers;

import com.example.rentacar.business.abstracts.BrandService;
import com.example.rentacar.business.request.CreateBrandRequest;
import com.example.rentacar.business.request.UptadeBrandRequest;
import com.example.rentacar.business.responses.GetAllBrandsResponse;
import com.example.rentacar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }
    @PutMapping
     public void uptade(@RequestBody  UptadeBrandRequest uptadeBrandRequest){
        this.brandService.uptade(uptadeBrandRequest);
    }
    @DeleteMapping("/{id}")
    public int delete(@PathVariable int id ){
        this.brandService.delete(id);
    return id;
    }
}

