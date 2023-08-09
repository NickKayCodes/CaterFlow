package com.krath.CaterFlowBackEnd.kitchen.cookbook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Measurement {
    @Id
    private long id;
    private String measurementUnit; //cups, teaspoons, tablespoons, etc..
}
