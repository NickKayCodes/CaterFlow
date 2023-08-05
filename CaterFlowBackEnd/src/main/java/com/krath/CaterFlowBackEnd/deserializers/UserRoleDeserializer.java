package com.krath.CaterFlowBackEnd.deserializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.krath.CaterFlowBackEnd.user.enums.UserRole;

import java.io.IOException;

/**
 * Due to the nature of the whitespace coming in from the UI,
 * this class will handle putting in the underscore to match the enum values of UserRole
 */
public class UserRoleDeserializer extends JsonDeserializer<UserRole> {

    @Override
    public UserRole deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String roleValue = jsonParser.getText().replaceAll(" ", "_");
        try {
            return UserRole.valueOf(roleValue);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UserRole: " + roleValue);
        }
    }
}
