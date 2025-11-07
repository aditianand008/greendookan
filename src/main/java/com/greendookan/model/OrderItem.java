package com.greendookan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @Min(value = 1)
    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double price;

    public Double getSubtotal() {
        return price * quantity;
    }

    @PrePersist
    protected void onCreate() {
        if (product != null) {
            this.price = product.getPrice();
        }
    }
}
