package com.krath.CaterFlowBackEnd.user.map;


import com.krath.CaterFlowBackEnd.user.enums.Privilege;
import com.krath.CaterFlowBackEnd.user.enums.UserRole;

import java.util.*;

public class RolePrivilegeMapping {
    private static final Map<UserRole, Set<Privilege>> rolePrivilegesMap = new HashMap<>();

    static {
        rolePrivilegesMap.put(UserRole.EVENT_CHEF, EnumSet.of(
                Privilege.VIEW_EVENT,
                Privilege.UPDATE_MENU,
                Privilege.MANAGE_STAFF
        ));

        rolePrivilegesMap.put(UserRole.KITCHEN_CHEF, EnumSet.of(
                Privilege.MANAGE_KITCHEN,
                Privilege.VIEW_INVENTORY,
                Privilege.UPDATE_MENU
        ));

//        rolePrivilegesMap.put(UserRole.SERVER, EnumSet.of(
//              // Server privileges are not defined yet
//        ));

        rolePrivilegesMap.put(UserRole.CAPTAIN, EnumSet.of(
                Privilege.VIEW_EVENT,
                Privilege.EDIT_REPORT,
                Privilege.VIEW_REPORT,
                Privilege.CREATE_REPORT
        ));

        rolePrivilegesMap.put(UserRole.SALES_PLANNER, EnumSet.of(
                Privilege.VIEW_INVOICE,
                Privilege.VIEW_EVENT,
                Privilege.VIEW_EVENT_PLAN,
                Privilege.VIEW_MENU,
                Privilege.EDIT_EVENT,
                Privilege.EDIT_EVENT_PLAN,
                Privilege.CREATE_INVOICE
        ));

        rolePrivilegesMap.put(UserRole.ADMIN, EnumSet.of(
                Privilege.FULL_ACCESS
        ));

        rolePrivilegesMap.put(UserRole.MANAGER, EnumSet.of(
                Privilege.MANAGE_STAFF,
                Privilege.FULL_ACCESS,
                Privilege.VIEW_INVENTORY,
                Privilege.VIEW_INVOICE,
                Privilege.VIEW_EVENT,
                Privilege.VIEW_EVENT_PLAN,
                Privilege.VIEW_MENU,
                Privilege.VIEW_REPORT
        ));

        rolePrivilegesMap.put(UserRole.WAREHOUSE, EnumSet.of(
                Privilege.VIEW_EVENT,
                Privilege.VIEW_INVENTORY,
                Privilege.VIEW_REPORT,
                Privilege.VIEW_EVENT_PLAN,
                Privilege.EDIT_INVENTORY,
                Privilege.MANAGE_INVENTORY
        ));
    }

    public static Set<Privilege> getPrivilegesForRole(UserRole roles) {
        return rolePrivilegesMap.getOrDefault(roles, EnumSet.noneOf(Privilege.class));
    }

    // Method to get privileges for multiple roles (combine privileges)
    public static Set<Privilege> getPrivilegesForRoles(Set<UserRole> roles) {
        Set<Privilege> combinedPrivileges = new HashSet<>();
        for (UserRole role : roles) {
            combinedPrivileges.addAll(getPrivilegesForRole(role));
        }
        return combinedPrivileges;
    }
}