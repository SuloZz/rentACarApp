package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.ModelService;
import com.example.rentacar.business.request.CreateModelRequest;
import com.example.rentacar.business.responses.GetAllModelsResponse;
import com.example.rentacar.core.utilites.mappers.ModelMapperService;
import com.example.rentacar.dataAccess.abstracts.ModelRepository;
import com.example.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();


        List<GetAllModelsResponse>  modelsResponse = models.stream().map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {

        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);

       this.modelRepository.save(model);
        }
    }

