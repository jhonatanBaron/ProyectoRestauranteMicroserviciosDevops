package com.jeoldev.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTOFromFE {
    private List<FoodItemDTO> foodItemDTOList;
    private Long userId;

    public List<FoodItemDTO> getFoodItemDTOList() {
        return foodItemDTOList;
    }

    public void setFoodItemDTOList(List<FoodItemDTO> foodItemDTOList) {
        this.foodItemDTOList = foodItemDTOList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    private Restaurant restaurant;
}
