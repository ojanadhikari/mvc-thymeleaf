package com.bo.cabmvc.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "book")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private Double price;
}
