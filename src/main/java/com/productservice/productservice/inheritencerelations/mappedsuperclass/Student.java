package com.productservice.productservice.inheritencerelations.mappedsuperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="ms_student")
public class Student extends User {
    private double psp;
}
