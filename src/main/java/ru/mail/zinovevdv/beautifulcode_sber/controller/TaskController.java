package ru.mail.zinovevdv.beautifulcode_sber.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.zinovevdv.beautifulcode_sber.dto.BracketTextDto;
import ru.mail.zinovevdv.beautifulcode_sber.dto.ResponseDto;
import ru.mail.zinovevdv.beautifulcode_sber.service.CheckBracketsService;

/**
 * Основной контроллер по задаче https://beautifulcode.sber.ru/task/java
 */
@RestController
@RequestMapping("api")
@AllArgsConstructor
public class TaskController {
    private final CheckBracketsService checkBracketsService;

    /**
     * Проверка текста на правильность расстановки скобок
     * @param bracketText - текст для проверки
     * @return ResponseDto - результат проверки
     */
    @Operation(summary = "Проверь свой текст на корректность расстановки скобок")
    @PostMapping("/checkBrackets")
    public ResponseEntity<ResponseDto> checkBrackets(@RequestBody BracketTextDto bracketText){
        ResponseDto result = new ResponseDto(checkBracketsService.check(bracketText.text()));

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }
}
