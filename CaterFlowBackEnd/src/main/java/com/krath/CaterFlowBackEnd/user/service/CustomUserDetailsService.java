package com.krath.CaterFlowBackEnd.user.service;

import com.krath.CaterFlowBackEnd.user.entity.User;
import com.krath.CaterFlowBackEnd.user.enums.UserRole;
import com.krath.CaterFlowBackEnd.user.map.RolePrivilegeMapping;
import com.krath.CaterFlowBackEnd.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);

        if (user==null){
            throw new UsernameNotFoundException("Username not found: "+username);
        }
        // Convert your User entity to Spring Security's UserDetails
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities(user.getRoles())); // User roles converted to GrantedAuthorities
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<UserRole> roles) {
        return roles.stream()
                .flatMap(role -> RolePrivilegeMapping.getPrivilegesForRole(role).stream())
                .map(privilege -> new SimpleGrantedAuthority(privilege.name()))
                .collect(Collectors.toSet());
    }
}
