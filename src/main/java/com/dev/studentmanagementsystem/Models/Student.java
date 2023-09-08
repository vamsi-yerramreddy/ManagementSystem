package com.dev.studentmanagementsystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long rollNo;
     @Column(name="first_name",nullable = false)
     private String firstName;
     @Column(name="last_name")
     private String lastName;
     @Column(name="email")
     private String email;

}
