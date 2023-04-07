package com.ucarfurkan.londonhousing.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucarfurkan.londonhousing.Entities.House;
import com.ucarfurkan.londonhousing.Repository.HouseRepository;

@Service
public class HouseServiceImpl implements HouseService {
    HouseRepository houseRepository;

    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public List<House> getAllHouses() {
        try {
            return houseRepository.findAll();
        } catch (Exception ex) {
            throw new RuntimeException("Failed to retrieve all houses", ex);
        }
    }

    @Override
    public Optional<House> findHouseById(Long id) {
        try {
            return houseRepository.findById(id);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to retrieve house by id", ex);
        }
    }

    @Override
    public House addNewHouse(House house) {
        try {
            return houseRepository.save(house);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to add new house", ex);
        }
    }

    @Override
    public void deleteHouse(House house) {
        try {
            houseRepository.delete(house);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to delete house", ex);
        }
    }

    @Override
    public void deleteHouseById(Long id) {
        try {
            houseRepository.deleteById(id);
        } catch (Exception ex){
            throw new RuntimeException("Failed to delete house by id",ex);
        }
    }
}
