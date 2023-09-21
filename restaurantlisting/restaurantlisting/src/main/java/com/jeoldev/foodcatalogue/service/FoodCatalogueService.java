package com.jeoldev.foodcatalogue.service;

import com.jeoldev.foodcatalogue.dto.FoodItemDTO;
import com.jeoldev.foodcatalogue.dto.Restaurant;
import com.jeoldev.foodcatalogue.entity.FoodItem;
import com.jeoldev.foodcatalogue.mapper.FoodItemMapper;
import com.jeoldev.foodcatalogue.repo.FoodItemRepo;
import com.jeoldev.foodcatalogue.dto.FoodCataloguePage;
import com.jeoldev.foodcatalogue.entity.FoodItem;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class FoodCatalogueService {
    FoodItemRepo foodItemRepo;
    RestTemplate restTemplate;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO){
        FoodItem foodItemSavedinDB;
        foodItemSavedinDB = foodItemRepo.save(
                FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItemSavedinDB);
    }

    public FoodCataloguePage fetCataloguePageDetails(Long restaurantId){
        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsfromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemList,restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    /**
     * @param restaurantId
     * @return
     */
    private Restaurant fetchRestaurantDetailsfromRestaurantMS(Long restaurantId) {
        return restTemplate.getForObject(
                "http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId,
                Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Long restaurantId){
        return foodItemRepo.findByRestaurantId(restaurantId);
    }




}
