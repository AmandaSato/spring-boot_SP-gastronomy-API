package com.dio.livecoding.crud.SPgastronomy.controller;

import com.dio.livecoding.crud.SPgastronomy.exception.ResourceNotFoundException;
import com.dio.livecoding.crud.SPgastronomy.model.Restaurant;
import com.dio.livecoding.crud.SPgastronomy.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RestaurantController {
  @Autowired
  private RestaurantRepository restaurantRepository;

  @GetMapping("/restaurants")
  public List<Restaurant> getAllRestaurants() {
    return restaurantRepository.findAll();
  }

  @GetMapping("/restaurants/{id}")
  public ResponseEntity < Restaurant > getRestaurantById(@PathVariable(value = "id") Long restaurantId)
    throws ResourceNotFoundException {
    Restaurant restaurant = restaurantRepository.findById(restaurantId)
      .orElseThrow(() -> new ResourceNotFoundException("Room not found :: " + restaurantId));
    return ResponseEntity.ok().body(restaurant);
  }

  @PostMapping("/restaurants")
  public Restaurant createRestaurant(@Valid @RequestBody Restaurant restaurant) {
    return restaurantRepository.save(restaurant);
  }

  @PutMapping("/restaurants/{id}")
  public ResponseEntity < Restaurant > updateRestaurant(@PathVariable(value = "id") Long restaurantId,
                                                    @Valid @RequestBody Restaurant restaurantDetails) throws ResourceNotFoundException {
    Restaurant restaurant = restaurantRepository.findById(restaurantId)
      .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantId));

    restaurant.setName(restaurantDetails.getName());
    restaurant.setLocal(restaurantDetails.getLocal());
    restaurant.setType(restaurantDetails.getType());
    restaurant.setRating( restaurantDetails.getRating() );
    final Restaurant updateRestaurant = restaurantRepository.save(restaurant);
    return ResponseEntity.ok(updateRestaurant);
  }

  @DeleteMapping("/restaurants/{id}")
  public Map < String, Boolean > deleteRestaurant(@PathVariable(value = "id") Long restaurantId)
    throws ResourceNotFoundException {
    Restaurant restaurant = restaurantRepository.findById(restaurantId)
      .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantId));

    restaurantRepository.delete(restaurant);
    Map< String, Boolean > response = new HashMap< >();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}

