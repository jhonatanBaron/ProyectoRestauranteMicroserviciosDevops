package com.jeoldev.order.service;

import com.jeoldev.order.dto.UserDTO;
import com.jeoldev.order.entity.Order;
import com.jeoldev.order.mapper.OrderMapper;
import com.jeoldev.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    SequenceGenerator sequenceGenerator;
    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrderInDB(OrderDTOFromFE orderDetails){
        Long newOrderID = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSave =
                new Order(newOrderID, orderDetails.getFoodItemDTOList(), orderDetails.getRestaurant(), UserDTO);
        orderRepo.save(orderToBeSave);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSave);

    }

    private UserDTO fetchUserDetailsFromUserId(){
    return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById" + userId, UserDTO.class);
    }

}
