package com.jeoldev.foodcatalogue.mapper;

import com.jeoldev.foodcatalogue.entity.FoodItem;
import com.jeoldev.foodcatalogue.dto.FoodItemDTO;
import org.mapstruct.Mapper;
import  org.mapstruct.factory.Mappers;


/**
 * FoodItemMapper
 */
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);
    FoodItemDTO mapFoodItemToFoodItemDto(FoodItem foodItem);
}