package com.greendookan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cart_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

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
    @PreUpdate
    protected void updatePrice() {
        if (product != null) {
            this.price = product.getPrice();
        }
    }
}
