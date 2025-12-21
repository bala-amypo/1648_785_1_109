package com.example.demo.entity;

@Entity
public class creditcard{
    @Id
    @GeneratedValue(strategy=GenerationType.IDNETITY)
    private Long id;
    private String userid;
    private String fullname;
    private String email;
    private String password;
    private String role;
    private Boolean active;
    private LocalDateTime createAt; 
}