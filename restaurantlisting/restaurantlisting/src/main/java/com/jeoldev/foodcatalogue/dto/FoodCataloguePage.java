package com.jeoldev.foodcatalogue.dto;

import java.util.List;
import com.jeoldev.foodcatalogue.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FoodCataloguePage {
    private  List<FoodItem> FoodItemList;
    private Restaurant restaurant;

}
