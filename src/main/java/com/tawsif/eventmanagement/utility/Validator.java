package com.tawsif.eventmanagement.utility;

import com.tawsif.eventmanagement.models.Event;
import com.tawsif.eventmanagement.models.User;

import java.util.List;

public class Validator {
    public static boolean validateInput(String type, String value) {
        return switch (type) {
            case "email" -> value.matches("^[\\w-_.+]*[\\w-_.]\\@[\\w]+[\\w-.]+\\.[a-z]{2,4}$");
            case "phone" -> value.matches("\\d{11}");
            default -> false;
        };
    }
    public static boolean validateDuplicateUser(Event event, User user){
        return event.getRegistrations().stream().anyMatch(_user->_user == user);
    }

    public static boolean validateEvent(String type, Object value){
        return switch (type) {
            case "name", "venue", "date" -> (value instanceof String && !((String) value).isEmpty());
            case "capacity" -> value instanceof Integer && ((Integer) value) > 0;
            default -> false;
        };
    }

}
