package ru.mail.zinovevdv.beautifulcode_sber.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class CheckRoundBracketsServiceTest {
    @InjectMocks
    CheckRoundBracketsService checkRoundBracketsService;
    @Test
    @DisplayName("CheckRoundBracketsService Test NULL String")
    void checkNullString() {
        // given
        String input = null;
        //when
        boolean result = checkRoundBracketsService.check(input);
        // then
        assert !result;
    }

    @Test
    @DisplayName("CheckRoundBracketsService Test Empty String")
    void checkEmptyString() {
        // given
        String input = "";
        //when
        boolean result = checkRoundBracketsService.check(input);
        // then
        assert !result;
    }

    @Test
    @DisplayName("CheckRoundBracketsService Test empty brackets")
    void checkEmptyBrackets() {
        // given
        String input = "Hello, World()!";
        //when
        boolean result = checkRoundBracketsService.check(input);
        // then
        assert !result;
    }

    @Test
    @DisplayName("CheckRoundBracketsService Test no brackets")
    void checkNoBrackets() {
        // given
        String input = "Hello, World!";
        //when
        boolean result = checkRoundBracketsService.check(input);
        // then
        assert result;
    }

    @Test
    @DisplayName("CheckRoundBracketsService Test too much )")
    void checkTooMuchCloseBrackets() {
        // given
        String input = "(Hello), World)!";
        //when
        boolean result = checkRoundBracketsService.check(input);
        // then
        assert !result;
    }

    @Test
    @DisplayName("CheckRoundBracketsService Test too much (")
    void checkTooMuchOpenBrackets() {
        // given
        String input = "(Hello, (World)!";
        //when
        boolean result = checkRoundBracketsService.check(input);
        // then
        assert !result;
    }

    @Test
    @DisplayName("CheckRoundBracketsService Test good string")
    void checkBrackets() {
        // given
        String input = "Hello, (World)!";
        //when
        boolean result = checkRoundBracketsService.check(input);
        // then
        assert result;
    }
}