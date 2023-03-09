package com.example.rentacar.webApi.controllers;

import com.example.rentacar.business.abstracts.ModelService;
import com.example.rentacar.business.request.CreateBrandRequest;
import com.example.rentacar.business.request.CreateModelRequest;
import com.example.rentacar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;
@GetMapping()
    public List<GetAllModelsResponse> getAll(){
    return modelService.getAll();

}
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid    CreateModelRequest createModelRequest) {
        this.modelService.add(createModelRequest);
    }
}
