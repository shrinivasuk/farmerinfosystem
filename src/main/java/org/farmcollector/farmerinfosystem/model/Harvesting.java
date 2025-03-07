package org.farmcollector.farmerinfosystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Harvesting")
@Getter
@Setter
public class Harvesting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;

    @Column(name = "season")
    private String season;

    @Column(name = "crop_type")
    private String cropType;

    @Column(name = "amount")
    private double amtOfActualProduct;

}