package com.ucarfurkan.londonhousing.Controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.ucarfurkan.londonhousing.Entities.House;
import com.ucarfurkan.londonhousing.Services.HouseService;

@RestController
public class HouseController {
    HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/houses")
    public List<House> getAllHouses() {
        return houseService.getAllHouses();
    }

    @GetMapping("/houses/{id}")
    public Optional<House> getHouseById(@PathVariable Long id) {
        return houseService.findHouseById(id);
    }

    @PostMapping("/houses/add")
    public House addNewHouse(@Valid @RequestBody House house) {
        house.setId(null);
        return houseService.addNewHouse(house);
    }

    @DeleteMapping("/houses/delete")
    public void deleteHouse(@RequestBody House house) {
        houseService.deleteHouse(house);
    }

    @DeleteMapping("/houses/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        houseService.deleteHouseById(id);
    }

    @PutMapping("/houses/update")
    public House updateHouse(
                             @RequestParam(name = "id") Long id,
                             @RequestParam(name = "propertyName", required = false) String propertyName,
                             @RequestParam(name = "price", required = false) Long price,
                             @RequestParam(name = "houseType", required = false) String houseType,
                             @RequestParam(name = "area", required = false) Long area,
                             @RequestParam(name = "bedrooms", required = false) Integer bedrooms,
                             @RequestParam(name = "bathrooms", required = false) Integer bathrooms,
                             @RequestParam(name = "receptions", required = false) Integer receptions,
                             @RequestParam(name = "location", required = false) String location,
                             @RequestParam(name = "city", required = false) String city,
                             @RequestParam(name = "postalCode", required = false) String postalCode) {
        Optional<House> houseOptional = houseService.findHouseById(id);

        House house = houseOptional.get();

        if (StringUtils.isNotBlank(propertyName)) {
            house.setPropertyName(propertyName);
        }
        if (price != null){
            house.setPrice(price);
        }
        if (StringUtils.isNotBlank(houseType)) {
            house.setHouseType(houseType);
        }
        if (area != null){
            house.setArea(area);
        }
        if (bedrooms != null){
            house.setBedrooms(bedrooms);
        }
        if (bathrooms != null){
            house.setBathrooms(bathrooms);
        }
        if (receptions != null){
            house.setReceptions(receptions);
        }
        if (StringUtils.isNotBlank(location)) {
            house.setLocation(location);
        }
        if (StringUtils.isNotBlank(city)) {
            house.setCity(city);
        }
        if (StringUtils.isNotBlank(postalCode)) {
            house.setPostalCode(postalCode);
        }

        return houseService.updateHouse(house);
    }

    @GetMapping("/houses/search")
    public List<House> search(
            @RequestParam(name = "propertyName", required = false) String propertyName,
            @RequestParam(name = "price", required = false) Long price,
            @RequestParam(name = "houseType", required = false) String houseType,
            @RequestParam(name = "area", required = false) Long area,
            @RequestParam(name = "bedrooms", required = false) Integer bedrooms,
            @RequestParam(name = "bathrooms", required = false) Integer bathrooms,
            @RequestParam(name = "receptions", required = false) Integer receptions,
            @RequestParam(name = "location", required = false) String location,
            @RequestParam(name = "city", required = false) String city,
            @RequestParam(name = "postalCode", required = false) String postalCode,
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size) {


        if(page!=null && size!=null){
            Pageable pageable = PageRequest.of(page, size);
            Page<House> houses = houseService.searchWithPagination(propertyName, price, houseType, area, bedrooms, bathrooms, receptions, location, city, postalCode,pageable);
            return houses.getContent();
        }

        return houseService.searchWithoutPagination(propertyName, price, houseType, area, bedrooms, bathrooms, receptions, location, city, postalCode);
    }

    @GetMapping("/houses/search/interval")
    public List<House> searchWithInterval(
            @RequestParam(name = "propertyName", required = false) String propertyName,
            @RequestParam(name = "price", required = false) String priceInterval,
            @RequestParam(name = "houseType", required = false) String houseType,
            @RequestParam(name = "area", required = false) String areaInterval,
            @RequestParam(name = "bedrooms", required = false) String bedroomsInterval,
            @RequestParam(name = "bathrooms", required = false) String bathroomsInterval,
            @RequestParam(name = "receptions", required = false) String receptionsInterval,
            @RequestParam(name = "location", required = false) String location,
            @RequestParam(name = "city", required = false) String city,
            @RequestParam(name = "postalCode", required = false) String postalCode,
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size) {

        Long minPrice = null;
        Long maxPrice = null;
        if (priceInterval != null) {
            String[] priceValues = priceInterval.split("-");
            if (priceValues.length == 2) {
                minPrice = Long.parseLong(priceValues[0]);
                maxPrice = Long.parseLong(priceValues[1]);
            } else if (priceValues.length == 1) {
                minPrice = Long.parseLong(priceValues[0]);
            }
        }

        Long minArea = null;
        Long maxArea = null;
        if (areaInterval != null) {
            String[] areaValues = areaInterval.split("-");
            if (areaValues.length == 2) {
                minArea = Long.parseLong(areaValues[0]);
                maxArea = Long.parseLong(areaValues[1]);
            } else if (areaValues.length == 1) {
                minArea = Long.parseLong(areaValues[0]);
            }
        }

        Integer minBedrooms = null;
        Integer maxBedrooms = null;
        if (bedroomsInterval != null) {
            String[] bedroomsValues = bedroomsInterval.split("-");
            if (bedroomsValues.length == 2) {
                minBedrooms = Integer.parseInt(bedroomsValues[0]);
                maxBedrooms = Integer.parseInt(bedroomsValues[1]);
            } else if (bedroomsValues.length == 1) {
                minBedrooms = Integer.parseInt(bedroomsValues[0]);
            }
        }

        Integer minBathrooms = null;
        Integer maxBathrooms = null;
        if (bathroomsInterval != null) {
            String[] bathroomsValues = bathroomsInterval.split("-");
            if (bathroomsValues.length == 2) {
                minBathrooms = Integer.parseInt(bathroomsValues[0]);
                maxBathrooms = Integer.parseInt(bathroomsValues[1]);
            } else if (bathroomsValues.length == 1) {
                minBathrooms = Integer.parseInt(bathroomsValues[0]);
            }
        }

        Integer minReceptions = null;
        Integer maxReceptions = null;
        if (receptionsInterval != null) {
            String[] receptionsValues = receptionsInterval.split("-");
            if (receptionsValues.length == 2) {
                minReceptions = Integer.parseInt(receptionsValues[0]);
                maxReceptions = Integer.parseInt(receptionsValues[1]);
            } else if (receptionsValues.length == 1) {
                minReceptions = Integer.parseInt(receptionsValues[0]);
            }
        }

        if(page!=null && size!=null){
            Pageable pageable = PageRequest.of(page, size);
            Page<House> houses = houseService.searchWithIntervalAndPagination(propertyName,minPrice,maxPrice,houseType,minArea,maxArea,minBedrooms,maxBedrooms,minBathrooms,maxBathrooms,minReceptions,maxReceptions, location, city, postalCode, pageable);
            return houses.getContent();
        }

        return houseService.searchWithIntervalAndWithoutPagination(propertyName,minPrice,maxPrice,houseType,minArea,maxArea,minBedrooms,maxBedrooms,minBathrooms,maxBathrooms,minReceptions,maxReceptions, location, city, postalCode);
    }
}


