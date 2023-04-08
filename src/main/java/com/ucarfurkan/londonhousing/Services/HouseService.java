package com.ucarfurkan.londonhousing.Services;

import java.util.List;
import java.util.Optional;

import com.ucarfurkan.londonhousing.Entities.House;
import org.springframework.data.repository.query.Param;

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
    List<House> search(String propertyName,
            Long price,
            String houseType,
            Long area,
                       Integer bedrooms,
                       Integer bathrooms,
                       Integer receptions,
            String location,
            String city,
            String postalCode);
}
