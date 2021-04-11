package com.dio.livecoding.crud.SPgastronomy.repository;

import com.dio.livecoding.crud.SPgastronomy.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{


}
