package org.farmcollector.farmerinfosystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Planting")
@Getter
@Setter
public class Planting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "farm_name")
    private String farmName;

    @Column(name = "season")
    private String season;

    @Column(name = "planting_area")
    private double plantingArea;

    @Column(name = "crop_type")
    private String cropType;

    @Column(name = "amount")
    private double amtOfExpectedProduct;

}
