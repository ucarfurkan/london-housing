package com.ucarfurkan.londonhousing.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "london_housing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class House{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String propertyName;
    private Long price;
    private String houseType;
    private Long area;
    private int bedrooms;
    private int bathrooms;
    private int receptions;
    private String location;
    private String city;
    private String postalCode;

}