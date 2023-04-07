package com.ucarfurkan.londonhousing.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ucarfurkan.londonhousing.Entities.House;
import com.ucarfurkan.londonhousing.Services.HouseService;

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

    @GetMapping("/houses/{id}")
    public Optional<House> getHouseById(@PathVariable Long id){
        return houseService.findHouseById(id);
    }

    @PostMapping("/houses/add")
    public House addNewHouse(@RequestBody House house){
        return houseService.addNewHouse(house);
    }

    @DeleteMapping("/houses/delete")
    public void deleteHouse(@RequestBody House house){
        houseService.deleteHouse(house);
    }

    @DeleteMapping("/houses/delete/{id]")
    public void deleteById(@PathVariable Long id){
        houseService.deleteHouseById(id);
    }
}
