//package com.krath.CaterFlowBackEnd.kitchen.cookbook.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//
//@Entity
//public class Measurement {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private String measurementUnit; //cups, teaspoons, tablespoons, etc..
//
//    public Measurement() {
//    }
//
//    public Measurement(long id, String measurementUnit) {
//        this.id = id;
//        this.measurementUnit = measurementUnit;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setMeasurementUnit(String measurementUnit) {
//        this.measurementUnit = measurementUnit;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getMeasurementUnit() {
//        return measurementUnit;
//    }
//}
