package com.ucarfurkan.londonhousing.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucarfurkan.londonhousing.Entities.House;

@Repository
public interface HouseRepository extends JpaRepository<House,Long> {
    
}
