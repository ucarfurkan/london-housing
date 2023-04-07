package com.ucarfurkan.londonhousing.Services;

import java.util.List;
import java.util.Optional;

import com.ucarfurkan.londonhousing.Entities.House;

public interface HouseService {
    // READ
    List<House> getAllHouses();
    Optional<House> findHouseById(Long id);

    // CREATE
    House addNewHouse(House house);

    // DELETE
    void deleteHouse(House house);
    void deleteHouseById(Long id);
}
