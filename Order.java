package grasp.items;

import java.util.ArrayList;
import java.util.List;

public class Order {
    /*
     * GRASP: Information Expert
     */
    private List<OrderItem> orderItems;

    public Order(List<OrderItem> orderItems) {
        this.orderItems = orderItems != null ? orderItems : new ArrayList<>();
    }

    public Order() {
        this.orderItems = new ArrayList<>();
    }

    public double countPrice() {
        double result = 0;
        for (OrderItem orderItem : orderItems) {
            result += orderItem.countPrice();
        }
        return result;
    }

    /*
     * GRASP: Creator + method polymorphism
     */
    public boolean addItem(OrderItem orderItem) {
        if (orderItem == null) return false;

        for (OrderItem existingItem : orderItems) {
            if (existingItem.getProduct().equals(orderItem.getProduct())) {
                existingItem.setQuantity(existingItem.getQuantity() + orderItem.getQuantity());
                return true;
            }
        }

        this.orderItems.add(orderItem);
        return true;
    }

    public boolean addItem(Product product, int number) {
        if (product == null || number <= 0) return false;
        for (OrderItem existingItem : orderItems) {
            if (existingItem.getProduct().equals(product)) {
                existingItem.setQuantity(existingItem.getQuantity() + number);
                return true;
            }
        }

        this.orderItems.add(new OrderItem(product, number));
        return true;
    }

    public boolean cancel() {
        this.orderItems.clear();
        return true;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderItems=" + orderItems +
                '}';
    }
}
