package com.example.abastr.abastr.price;

public class AveragePrice {
    private String orderNumber;
    private int orderTotalQuantity;
    private float orderTotalPrice;
    private float orderAveragePrice;

    public AveragePrice() {  }

    public String getOrderNumber() { return this.orderNumber; }
    public int getOrderTotalQuantity() { return this.orderTotalQuantity; }
    public float getOrderTotalPrice() { return this.orderTotalPrice; }
    public float getOrderAveragePrice() { return this.orderAveragePrice; }

    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    public void setOrderTotalQuantity(int orderTotalQuantity) { this.orderTotalQuantity = orderTotalQuantity; }
    public void setOrderTotalPrice(float orderTotalPrice) { this.orderTotalPrice = orderTotalPrice; }
    public void setOrderAveragePrice(float orderAveragePrice) { this.orderAveragePrice = orderAveragePrice; }
}
