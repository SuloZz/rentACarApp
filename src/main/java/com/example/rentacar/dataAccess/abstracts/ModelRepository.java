package com.example.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentacar.entities.concretes.Model;
public interface ModelRepository extends JpaRepository<Model,Integer>{

}
