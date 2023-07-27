package com.krath.CaterFlowBackEnd.user.service.roles;

import com.krath.CaterFlowBackEnd.user.enitity.Roles;
import com.krath.CaterFlowBackEnd.user.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Roles saveRole(Roles role) {
        Roles existingRole = rolesRepository.findByName(role.getRoleName());
        if (existingRole == null) {
            return rolesRepository.save(role);
        } else {
            return existingRole;
        }
    }

    @Override
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles getRolesById(Long id) {
        return rolesRepository.findById(id).orElse(null);
    }

    @Override
    public Roles findByName(String roleName) {
        return rolesRepository.findByName(roleName);
    }
}
