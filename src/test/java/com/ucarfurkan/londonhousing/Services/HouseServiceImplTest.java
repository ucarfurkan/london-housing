package com.ucarfurkan.londonhousing.Services;

import com.ucarfurkan.londonhousing.Entities.House;
import com.ucarfurkan.londonhousing.Repository.HouseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HouseServiceImplTest {

    HouseServiceImpl houseService;

    @Mock
    private HouseRepository houseRepository;

    private List<House> houseList;
    private House house1;
    private House house2;

    @BeforeEach
    void setUp() {
        houseRepository = mock(HouseRepository.class);
        houseService = new HouseServiceImpl(houseRepository);
        houseList = new ArrayList<>();
        house1 = House.builder().id(1L)
                        .propertyName("property name")
                        .price(300L)
                        .houseType("house type")
                        .area(10L)
                        .bedrooms(1)
                        .bathrooms(2)
                        .receptions(1)
                        .location("location")
                        .city("city")
                        .postalCode("postal code")
                        .build();

        house2 = House.builder().id(2L)
                .propertyName("property name2")
                .price(301L)
                .houseType("house type2")
                .area(11L)
                .bedrooms(2)
                .bathrooms(3)
                .receptions(4)
                .location("location2")
                .city("city2")
                .postalCode("postal code2")
                .build();

        houseList.add(house1);
        houseList.add(house2);
    }

    @Test
    void getAllHouses() {
        when(houseRepository.findAll()).thenReturn(houseList);
        List<House> result = houseService.getAllHouses();
        assertEquals(2, result.size());
    }

    @Test
    void findHouseById() {
        when(houseRepository.findById(2L)).thenReturn(Optional.of(house2));
        Optional<House> result = houseService.findHouseById(2L);
        assertEquals(house2,result.orElse(null));
    }

    @Test
    void updateHouse(){
        when(houseRepository.save(house1)).thenReturn(house1);
        House result = houseService.updateHouse(house1);

        assertEquals(house1, result);
    }

    @Test
    void addNewHouse(){
        when(houseRepository.save(house1)).thenReturn(house1);
        House result = houseService.addNewHouse(house1);

        assertEquals(house1, result);
    }

    @Test
    void deleteHouse(){
        houseService.deleteHouse(house1);
        verify(houseRepository).delete(house1);
    }

    @Test
    void deleteHouseById(){
        houseService.deleteHouseById(house1.getId());
        verify(houseRepository).deleteById(house1.getId());
    }

    @Test
    void search() {
        List<House> searchList = new ArrayList<>();
        searchList.add(house2);
        Pageable pageable = PageRequest.of(0,10);
        Page<House> testHouse = new PageImpl<>(searchList,pageable,1);

        when(houseRepository.searchWithPagination("property name2", null, null,
                null, null, null, null,
                null, null, null, pageable)).thenReturn(testHouse);

        Page<House> page = houseService.searchWithPagination("property name2", null, null,
                null, null, null, null,
                null, null, null, pageable);
        assertEquals(1, page.getContent().size());
        assertEquals(house2,page.getContent().get(0));
        assertEquals("location2",page.getContent().get(0).getLocation());

        when(houseRepository.searchWithoutPagination("property name2", null, null,
                null, null, null, null,
                null, null, null)).thenReturn(searchList);

        List<House> houses = houseService.searchWithoutPagination("property name2", null, null,
                null, null, null, null,
                null, null, null);

        assertEquals(1, houses.size());
        assertEquals(house2, houses.get(0));
        assertEquals("location2",houses.get(0).getLocation());
    }

    @Test
    void searchWithIntervals(){
        Pageable pageable = PageRequest.of(0,10);
        Page<House> testHouse = new PageImpl<>(houseList,pageable,2);

        when(houseService.searchWithIntervalAndPagination(null,300L,301L,null,null,
                null,null,null,null,
                null,null,null,null,null,null,pageable)).thenReturn(testHouse);

        Page<House> page = houseService.searchWithIntervalAndPagination(null,300L,301L,null,null,
                null,null,null,null,
                null,null,null,null,null,null,pageable);

        assertEquals(2, page.getContent().size());
        assertTrue(page.getContent().contains(house1));
        assertTrue(page.getContent().contains(house2));

        when(houseService.searchWithIntervalAndPagination(null,300L,301L,null,null,
                null,3,4,null,null,
                null,null,null,null,null,pageable)).thenReturn(new PageImpl<>(new ArrayList<>(),pageable,0));

        Page<House> page1 = houseService.searchWithIntervalAndPagination(null,300L,301L,null,null,null,
                3,4,null,null,
                null,null,null,null,null,pageable);
        assertEquals(0, page1.getContent().size());
        assertFalse(page1.getContent().contains(house1));
        assertFalse(page1.getContent().contains(house2));


        when(houseRepository.searchWithIntervalAndWithoutPagination(null, 300L, 301L,
                null, null, null, null,
                null, null, null,null,null,null,null,null))
                .thenReturn(houseList);

        List<House> houses = houseService.searchWithIntervalAndWithoutPagination(null, 300L, 301L,
                null, null, null, null,
                null, null, null,null,null,null,
                null, null);

        assertEquals(2, houses.size());
        assertTrue(houses.contains(house1));
        assertTrue(houses.contains(house2));


    }


}