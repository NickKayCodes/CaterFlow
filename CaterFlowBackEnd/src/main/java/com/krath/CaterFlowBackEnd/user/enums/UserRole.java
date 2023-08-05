package com.krath.CaterFlowBackEnd.user.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.krath.CaterFlowBackEnd.deserializers.UserRoleDeserializer;

@JsonDeserialize(using = UserRoleDeserializer.class)
public enum UserRole {
    EVENT_CHEF,
    KITCHEN_CHEF,
    SERVER,
    CAPTAIN,
    SALES_PLANNER,
    ADMIN,
    MANAGER
}
