package com.krath.CaterFlowBackEnd.user.enitity;

import com.krath.CaterFlowBackEnd.user.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id; // primary key for db

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles = new HashSet<>();

    // New fields
    private boolean isEnabled;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private boolean isCredentialsNonExpired;

    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;
    private LocalDateTime passwordUpdatedAt;

    private String profilePictureUrl;
    private String bio;

    private boolean twoFactorEnabled;
    private String twoFactorSecret;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_security_questions", joinColumns = @JoinColumn(name = "user_id"))
    private List<SecurityQuestion> securityQuestions;

    private String createdBy;
    private String updatedBy;

}

@Embeddable
class SecurityQuestion {
    private String question;
    private String answer;

    // Constructor, getters, setters
}
