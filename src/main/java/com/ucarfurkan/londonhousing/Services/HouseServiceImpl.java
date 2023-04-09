package com.ucarfurkan.londonhousing.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public House updateHouse(House house) {
        return houseRepository.save(house);
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

    @Override
    public Page<House> search(String propertyName, Long price, String houseType, Long area, Integer bedrooms, Integer bathrooms, Integer receptions, String location, String city, String postalCode, Pageable pageable) {
        return houseRepository.search(propertyName,price,houseType,area,bedrooms,bathrooms,receptions,location,city,postalCode, pageable);
    }

    @Override
    public Page<House> searchWithInterval(Long minPrice, Long maxPrice, Long minArea, Long maxArea, Integer minBedrooms, Integer maxBedrooms, Integer minBathrooms, Integer maxBathrooms, Integer minReceptions, Integer maxReceptions, Pageable pageable) {
        return houseRepository.searchWithInterval(minPrice,maxPrice,minArea,maxArea,minBedrooms,maxBedrooms,minBathrooms,maxBathrooms,minReceptions,maxReceptions,pageable);
    }

}
