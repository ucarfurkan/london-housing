package com.ucarfurkan.londonhousing.Services;

import java.util.List;
import java.util.Optional;

import com.ucarfurkan.londonhousing.Entities.House;

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
}
