package com.krath.CaterFlowBackEnd.reimb.repository;

import com.krath.CaterFlowBackEnd.reimb.entity.ReimbursementRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementRepository extends JpaRepository<ReimbursementRequest, Long>{
    @Query(value='select r from ReimbursementRequest r where r.user.user = ')
}
