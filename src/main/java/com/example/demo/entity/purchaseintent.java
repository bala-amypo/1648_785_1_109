package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class purchaseintent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Double amount;
    private String category;
    private String merchant;
    private LocalDateTime intentDate;
}
