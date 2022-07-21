package com.example.purchases.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Buyer buyer;
    @ManyToOne
    private Product product;
    private Integer count;
    private BigDecimal amount;
    private LocalDate date;

    // Необходимость переопределения ToString, Equals и HashCode в рамках этого задания - дискуссионная тема
    // Читал о разных подходах. Интересны принятые у вас практики по этому вопросу для Entity-классов.
}


