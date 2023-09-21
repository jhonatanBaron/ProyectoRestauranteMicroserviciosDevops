package com.jeoldev.foodcatalogue.controller;

import com.jeoldev.foodcatalogue.dto.FoodCataloguePage;
import com.jeoldev.foodcatalogue.dto.FoodItemDTO;
import com.jeoldev.foodcatalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class FoodCatalogueController {

    @Autowired
    FoodCatalogueService foodCatalogueService;

    @PostMapping("/andFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO foodItemSaved = foodCatalogueService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
    }
    @GetMapping("/fetchRestaurantAndFoodItemById/|restaurantId")
    public ResponseEntity<FoodCataloguePage>fetchRestauDetailsWithFoodMenu(
            @PathVariable Long restarantId){
        FoodCataloguePage foodCataloguePage =
                foodCatalogueService.fetCataloguePageDetails(restaurantId);
        return new ResponseEntity<>(new FoodCataloguePage, HttpStatus.OK);
    }
}
