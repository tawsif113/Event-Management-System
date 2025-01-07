package com.tawsif.eventmanagement.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void validateWhenAllFieldsAreValid() {
        User user = new User("John Doe","abc@email.com","01533406937");
        assertTrue(user.validate());
    }

    @Test
    void validateWhenEmailIsEmpty() {
        User user = new User("John Doe","","01533406937");
    }
    @Test
    void validateWhenPhoneNumberIsEmpty() {
        User user = new User("John Doe","abc@email.com","");
    }
    @Test
    void validateWhenAllFieldsAreEmpty() {
        User user = new User("","","");
        assertFalse(user.validate());
    }
    @Test
    void validateWhenEmailIsInvalid() {
        User user = new User("John Doe","abc","01533406937");
    }
    @Test
    void validateWhenPhoneNumberIsInvalid() {
        User user = new User("John Doe","abc@email.com","0153340693");
    }
    @Test
    void validateWhenEmailAndPhoneNumberAreInvalid() {
        User user = new User("John Doe","abc","0153340693");
        assertFalse(user.validate());
    }
    @Test
    void validateWhenEmailAndPhoneNumberAreValid() {
        User user = new User("John Doe","abc@email.com","01533406937");
        assertTrue(user.validate());
    }
}