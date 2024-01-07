package com.pi.order;

import java.util.List;

import com.pi.order.DeliveryInfo;
import com.pi.order.Order;
import com.pi.order.OrderLineItem;


    // OrderRequest.java
public class OrderRequest {
    private Order order;
    private List<OrderLineItem> lineItem;
    private DeliveryInfo deliveryInfo;

    // Constructeur, getters, setters

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderLineItem> getLineItems() {
        return lineItem;
    }

    public void setLineItems(List<OrderLineItem> lineItems) {
        this.lineItem = lineItems;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }
}


