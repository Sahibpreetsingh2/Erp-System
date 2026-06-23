package com.erp_ecom.Erp.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "product_sub_categories")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class ProductSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;
}