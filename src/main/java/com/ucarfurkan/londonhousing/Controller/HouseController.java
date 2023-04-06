package com.ucarfurkan.londonhousing.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.ucarfurkan.londonhousing.Entities.House;
import com.ucarfurkan.londonhousing.Services.HouseService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController {
    HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService){
        this.houseService = houseService;
    }

    @GetMapping("/houses")
    public List<House> getAllHouses(){
        return houseService.getAllHouses();
    }
}
