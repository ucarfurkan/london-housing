package com.ucarfurkan.londonhousing.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ucarfurkan.londonhousing.Entities.House;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House,Long> {
    @Query("SELECT h FROM House h WHERE "
            + "(:propertyName is null or h.propertyName = :propertyName) AND "
            + "(:price is null or h.price = :price) AND "
            + "(:houseType is null or h.houseType = :houseType) AND "
            + "(:area is null or h.area = :area) AND "
            + "(:bedrooms is null or h.bedrooms = :bedrooms) AND "
            + "(:bathrooms is null or h.bathrooms = :bathrooms) AND "
            + "(:receptions is null or h.receptions = :receptions) AND "
            + "(:location is null or h.location = :location) AND "
            + "(:city is null or h.city = :city) AND "
            + "(:postalCode is null or h.postalCode = :postalCode)")
    Page<House> search(
            @Param("propertyName") String propertyName,
            @Param("price") Long price,
            @Param("houseType") String houseType,
            @Param("area") Long area,
            @Param("bedrooms") Integer bedrooms,
            @Param("bathrooms") Integer bathrooms,
            @Param("receptions") Integer receptions,
            @Param("location") String location,
            @Param("city") String city,
            @Param("postalCode") String postalCode,
            Pageable pageable);

    @Query("SELECT h FROM House h WHERE "
            + "(:minPrice is null or h.price >= :minPrice) AND "
            + "(:maxPrice is null or h.price <= :maxPrice) AND "
            + "(:minArea is null or h.area >= :minArea) AND "
            + "(:maxArea is null or h.area <= :maxArea) AND "
            + "(:minBedrooms is null or h.bedrooms >= :minBedrooms) AND "
            + "(:maxBedrooms is null or h.bedrooms <= :maxBedrooms) AND "
            + "(:minBathrooms is null or h.bathrooms >= :minBathrooms) AND "
            + "(:maxBathrooms is null or h.bathrooms <= :maxBathrooms) AND "
            + "(:minReceptions is null or h.receptions >= :minReceptions) AND "
            + "(:maxReceptions is null or h.receptions <= :maxReceptions)")
    Page<House> searchWithInterval(
            @Param("minPrice") Long minPrice,
            @Param("maxPrice") Long maxPrice,
            @Param("minArea") Long minArea,
            @Param("maxArea") Long maxArea,
            @Param("minBedrooms") Integer minBedrooms,
            @Param("maxBedrooms") Integer maxBedrooms,
            @Param("minBathrooms") Integer minBathrooms,
            @Param("maxBathrooms") Integer maxBathrooms,
            @Param("minReceptions") Integer minReceptions,
            @Param("maxReceptions") Integer maxReceptions,
            Pageable pageable);
}


