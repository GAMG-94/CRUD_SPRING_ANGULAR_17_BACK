package com.crud.blockchain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Usuario {

    @Id
    @SequenceGenerator(name = "crud", allocationSize = 1, sequenceName = "crud")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "crud")
    private Long id;
    private String nombre;
    private Double cant;
    private Double fees;
    private String block;
}
