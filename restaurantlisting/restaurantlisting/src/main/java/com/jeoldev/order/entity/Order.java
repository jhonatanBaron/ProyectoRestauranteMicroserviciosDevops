package com.jeoldev.order.entity;

import com.jeoldev.order.dto.FoodItemDTO;
import com.jeoldev.order.dto.Restaurant;
import com.jeoldev.order.dto.UserDTO;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("com/jeoldev/order")
public class Order {
    private Long orderId;
    private List<FoodItemDTO> foodItemDTOList;
    private Restaurant restaurant;
    private UserDTO userDTO;
}
