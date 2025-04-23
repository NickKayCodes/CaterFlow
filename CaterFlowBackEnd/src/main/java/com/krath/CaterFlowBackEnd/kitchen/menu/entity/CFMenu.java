//package com.krath.CaterFlowBackEnd.kitchen.menu.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "menu")
//public class CFMenu {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private String dishName;
//    private String description;
//    private double price;
//    private String season;
//
//    public CFMenu() {
//    }
//
//    public CFMenu(long id, String dishName, String description, double price, String season) {
//        this.id = id;
//        this.dishName = dishName;
//        this.description = description;
//        this.price = price;
//        this.season = season;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setDishName(String dishName) {
//        this.dishName = dishName;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public void setSeason(String season) {
//        this.season = season;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getDishName() {
//        return dishName;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public String getSeason() {
//        return season;
//    }
//
//    @Override
//    public String toString() {
//        return "CFMenu{" +
//                "id=" + id +
//                ", dishName='" + dishName + '\'' +
//                ", description='" + description + '\'' +
//                ", price=" + price +
//                ", season='" + season + '\'' +
//                '}';
//    }
//
//
//}
