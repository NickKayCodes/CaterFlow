//package com.krath.CaterFlowBackEnd.reimb.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//import com.krath.CaterFlowBackEnd.user.entity.User;
//
//@Entity
//@Table(name = "reimbursement_requests")
//@Getter
//@Setter
//@AllArgsConstructor
//@RequiredArgsConstructor
//public class ReimbursementRequest {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    //@ManyToOne
//    //@JoinColumn(name = "user_id", nullable = false)
//   // private User user;
//
//    private double amount;
//    private String reason;
//    private byte[] receiptFile;
//    private ReimbStatus status = ReimbStatus.PENDING;
//
//
//}
