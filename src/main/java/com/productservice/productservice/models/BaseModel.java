package com.productservice.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(generator = "generator_name")
    @GenericGenerator(name = "generator_name" , strategy = "uuid2")
    @Column(name ="user_id" ,columnDefinition = "binary(16)",nullable = false,updatable = false)


    private UUID id;
}
