package com.ucarfurkan.londonhousing.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
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

    @NotNull(message = "propertyName can not be null.")
    @NotBlank(message = "propertyName can not be blank.")
    private String propertyName;

    @NotNull(message = "price can not be null.")
    @PositiveOrZero(message = "price can not be less than zero.")
    private Long price;

    @NotNull(message = "houseType can not be null.")
    @NotBlank(message = "houseType can not be blank.")
    private String houseType;

    @NotNull(message = "area can not be null.")
    @PositiveOrZero(message = "area can not be less than zero.")
    private Long area;

    @PositiveOrZero(message = "bedrooms can not be less than zero.")
    private Integer bedrooms;

    @PositiveOrZero(message = "bathrooms can not be less than zero.")
    private Integer bathrooms;

    @PositiveOrZero(message = "receptions can not be less than zero.")
    private Integer receptions;

    private String location;
    private String city;
    private String postalCode;

    public House(String propertyName, Long price, String houseType, Long area, Integer bedrooms, Integer bathrooms, Integer receptions, String location, String city, String postalCode) {
        this.propertyName = propertyName;
        this.price = price;
        this.houseType = houseType;
        this.area = area;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.receptions = receptions;
        this.location = location;
        this.city = city;
        this.postalCode = postalCode;
    }

    public House(Long l, String london, Integer v, Integer i) {
    }
}