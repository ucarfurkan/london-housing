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
    public Page<House> searchWithPagination(String propertyName, Long price, String houseType, Long area, Integer bedrooms, Integer bathrooms, Integer receptions, String location, String city, String postalCode, Pageable pageable) {
        try {
            return houseRepository.searchWithPagination(propertyName,price,houseType,area,bedrooms,bathrooms,receptions,location,city,postalCode, pageable);
        } catch(Exception ex){
            throw new RuntimeException("Failed to search for paginated houses", ex);
        }
    }

    @Override
    public List<House> searchWithoutPagination(String propertyName, Long price, String houseType, Long area, Integer bedrooms, Integer bathrooms, Integer receptions, String location, String city, String postalCode) {
        try {
            return houseRepository.searchWithoutPagination(propertyName,price,houseType,area,bedrooms,bathrooms,receptions,location,city,postalCode);
        } catch(Exception ex){
            throw new RuntimeException("Failed to search for houses", ex);
        }
    }

    @Override
    public Page<House> searchWithIntervalAndPagination(String propertyName, Long minPrice, Long maxPrice, String houseType, Long minArea, Long maxArea, Integer minBedrooms, Integer maxBedrooms, Integer minBathrooms, Integer maxBathrooms, Integer minReceptions, Integer maxReceptions, String location, String city, String postalCode, Pageable pageable) {
        try {
            return houseRepository.searchWithIntervalAndPagination(propertyName, minPrice,maxPrice,houseType,minArea,maxArea,minBedrooms,maxBedrooms,minBathrooms,maxBathrooms,minReceptions,maxReceptions, location, city, postalCode, pageable);
        } catch(Exception ex){
            throw new RuntimeException("Failed to search for paginated houses within interval", ex);
        }
    }

    @Override
    public List<House> searchWithIntervalAndWithoutPagination(String propertyName, Long minPrice, Long maxPrice, String houseType, Long minArea, Long maxArea, Integer minBedrooms, Integer maxBedrooms, Integer minBathrooms, Integer maxBathrooms, Integer minReceptions, Integer maxReceptions, String location, String city, String postalCode) {
        try {
            return houseRepository.searchWithIntervalAndWithoutPagination(propertyName, minPrice,maxPrice,houseType,minArea,maxArea,minBedrooms,maxBedrooms,minBathrooms,maxBathrooms,minReceptions,maxReceptions, location, city, postalCode);
        } catch(Exception ex){
            throw new RuntimeException("Failed to search for houses within interval", ex);
        }
    }

}
