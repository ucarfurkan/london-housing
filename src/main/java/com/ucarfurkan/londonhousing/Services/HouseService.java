package com.ucarfurkan.londonhousing.Services;

import java.util.List;
import java.util.Optional;

import com.ucarfurkan.londonhousing.Entities.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HouseService {
    // CREATE
    House addNewHouse(House house);

    // READ
    List<House> getAllHouses();
    Optional<House> findHouseById(Long id);

    // UPDATE
    House updateHouse(House house);

    // DELETE
    void deleteHouse(House house);
    void deleteHouseById(Long id);

    // SEARCH
    Page<House> searchWithPagination(String propertyName,
            Long price,
            String houseType,
            Long area,
                       Integer bedrooms,
                       Integer bathrooms,
                       Integer receptions,
            String location,
            String city,
            String postalCode,
                       Pageable pageable);

    List<House> searchWithoutPagination(String propertyName,
                                     Long price,
                                     String houseType,
                                     Long area,
                                     Integer bedrooms,
                                     Integer bathrooms,
                                     Integer receptions,
                                     String location,
                                     String city,
                                     String postalCode);

    Page<House> searchWithIntervalAndPagination(
            String propertyName,
            Long minPrice,
            Long maxPrice,
            String houseType,
            Long minArea,
            Long maxArea,
            Integer minBedrooms,
            Integer maxBedrooms,
            Integer minBathrooms,
            Integer maxBathrooms,
            Integer minReceptions,
            Integer maxReceptions,
            String location,
            String city,
            String postalCode,
            Pageable pageable);

    List<House> searchWithIntervalAndWithoutPagination(
            String propertyName,
            Long minPrice,
            Long maxPrice,
            String houseType,
            Long minArea,
            Long maxArea,
            Integer minBedrooms,
            Integer maxBedrooms,
            Integer minBathrooms,
            Integer maxBathrooms,
            Integer minReceptions,
            Integer maxReceptions,
            String location,
            String city,
            String postalCode);
}
