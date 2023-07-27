package com.krath.CaterFlowBackEnd.user.service.roles;

import com.krath.CaterFlowBackEnd.user.enitity.Roles;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public interface RolesService {
    public Roles findByName(String name);

    public Roles getRolesById(Long id);

    public List<Roles> getAllRoles();

    public Roles saveRole(Roles role);

    public List<Roles> assignRolesToUser();
}
