package com.bo.cabmvc.entity;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role", uniqueConstraints =@UniqueConstraint(columnNames = "name",name="unique_role_name") )
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
    private String description;
}
