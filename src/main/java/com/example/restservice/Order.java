package com.example.restservice;

public record Order(int orderNumber, int prodNumber, int quantity, float unitPrice) { }