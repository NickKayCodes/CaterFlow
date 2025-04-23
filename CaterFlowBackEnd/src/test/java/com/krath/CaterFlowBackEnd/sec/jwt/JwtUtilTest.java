//package com.krath.CaterFlowBackEnd.sec.jwt;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@ExtendWith({SpringExtension.class})
//@ActiveProfiles("default")
//public class JwtUtilTest {
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    private String token;
//
//    @BeforeEach
//    public void setup() {
//        assertNotNull(jwtUtil, "JwtUtil should be autowired properly by Spring");
//        token = jwtUtil.generateToken("testUser");
//    }
//
//    @Test
//    public void testGenerateToken() {
//        assertNotNull(token, "Token should not be null");
//    }
//
//    @Test
//    public void testExtractUsername() {
//        String username = jwtUtil.extractUsername(token);
//        assertEquals("testUser", username, "Extracted username should match");
//    }
//
//    @Test
//    public void testTokenExpiration() {
//        Date expiryDate = jwtUtil.extractExpiration(token);
//        assertNotNull(expiryDate, "Expiration date should not be null");
//        assertTrue(expiryDate.after(new Date()), "Token should not be expired");
//    }
//
//    @Test
//    public void testValidateToken() {
//        assertTrue(jwtUtil.validateToken(token, "testUser"), "Token should be valid");
//    }
//
//    @Test
//    public void testTokenExpired() {
//        assertFalse(jwtUtil.isTokenExpired(token), "Token should not be expired");
//    }
//}
