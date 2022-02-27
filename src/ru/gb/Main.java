package ru.gb;

public class Main {

    public static void main(String[] args) {
        OrderLineItemDto orderLineItem = new OrderLineItemDto.Builder(1L, 1L)
                .color("green")
                .material("gold")
                .build();
        System.out.println(orderLineItem.toString());
    }
}
