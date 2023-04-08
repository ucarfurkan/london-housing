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

    @DeleteMapping("/houses/delete/{id}")
    public void deleteById(@PathVariable Long id){
        houseService.deleteHouseById(id);
    }

    @PutMapping("/update")
    public House updateHouse(House house){
        return houseService.updateHouse(house);
    }

    @GetMapping("/search")
    public List<House> search(
            @RequestParam(name="propertyName", required = false) String propertyName,
            @RequestParam(name="price", required = false) Long price,
            @RequestParam(name="houseType", required = false) String houseType,
            @RequestParam(name="area", required = false) Long area,
            @RequestParam(name="bedrooms", required = false) Integer bedrooms,
            @RequestParam(name="bathrooms", required = false) Integer bathrooms,
            @RequestParam(name="receptions", required = false) Integer receptions,
            @RequestParam(name="location", required = false) String location,
            @RequestParam(name="city", required = false) String city,
            @RequestParam(name="postalCode", required = false) String postalCode) {

        return houseService.search(propertyName,price,houseType,area,bedrooms,bathrooms,receptions,location,city,postalCode);
    }

}
