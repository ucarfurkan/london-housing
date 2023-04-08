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
@Table(name = "houses")
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
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer receptions;
    private String location;
    private String city;
    private String postalCode;

    public House(Long l, String london, Integer v, Integer i) {
    }
}