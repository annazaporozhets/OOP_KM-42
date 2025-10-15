package grasp.controller;

import grasp.items.Order;
import grasp.items.OrderItem;

import java.util.List;

public class OrderController {

    public Order createOrder(List<OrderItem> orderItems) {
        return new Order(orderItems);
    }

    public boolean cancelOrder(Order order) {
        return order.cancel();
    }

    // Метод для додавання одного айтему до ордеру
    public void addItemToOrder(Order order, OrderItem newItem) {
        if (order != null && newItem != null) {
            order.getOrderItems().add(newItem);
        }
    }
}
