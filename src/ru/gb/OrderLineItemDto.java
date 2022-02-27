package ru.gb;

public class OrderLineItemDto {

    private Long productId;

    private Long orderId;

    private Integer qty;

    private String color;

    private String material;

    private OrderLineItemDto(Builder builder) {
        this.productId = builder.productId;
        this.orderId = builder.orderId;
        this.qty = builder.qty;
        this.color = builder.color;
        this.material = builder.material;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Integer getQty() {
        return qty;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "OrderLineItemDto{" +
                "productId=" + productId +
                ", orderId=" + orderId +
                ", qty=" + qty +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }

    public static class Builder {

        private Long productId;

        private Long orderId;

        private Integer qty;

        private String color;

        private String material;

        public Builder(Long productId, Long orderId) {
            this.productId = productId;
            this.orderId = orderId;
        }

        public Builder qty(Integer qty) {
            this.qty = qty;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder material(String material) {
            this.material = material;
            return this;
        }

        public OrderLineItemDto build() {
            return new OrderLineItemDto(this);
        }
    }
}