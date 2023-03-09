package com.example.rentacar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Table(name="cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;
        @Column(name = "plate")
        private String plate;
        @Column(name = "dailyPrise")
        private double dailyPrise;
        @Column(name = "modelYear")
        private int modelYear;
        @Column(name = "state")
        private int state;

@ManyToOne
@JoinColumn(name = "model_id")
private Model model;
}
