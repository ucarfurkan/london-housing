package com.ucarfurkan.londonhousing.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucarfurkan.londonhousing.Entities.House;
import com.ucarfurkan.londonhousing.Repository.HouseRepository;

@Service
public class HouseServiceImpl implements HouseService{
    HouseRepository houseRepository;

    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository){
        this.houseRepository = houseRepository;
    }

    @Override
    public List<House> getAllHouses() {
        try{
            return houseRepository.findAll();
        }
        catch(Error err){
            throw new UnsupportedOperationException("Unimplemented method 'getAllHouses'");
        }
    }
}
