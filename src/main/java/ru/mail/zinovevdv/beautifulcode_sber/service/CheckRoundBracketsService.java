package ru.mail.zinovevdv.beautifulcode_sber.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Проверка корректности расстановки скобок
 * кол-во открывающихся скобок должно совпадать с количеством закрывающих
 * не должно быть пустых скобок по типу ()
 * проверяет круглые скобки
 */
@Slf4j
@Service
public class CheckRoundBracketsService implements CheckBracketsService {
    public boolean check(String text) {
        log.debug("CheckBracketsService check text: " + text);
        if ((text == null) || (text.isEmpty())) {
            log.debug("CheckBracketsService check result = false - input text is empty");
            return false;
        }
        char prev = 'a';
        int counter = 0;
        for (char c : text.toCharArray()){
            if(c == '('){
                counter++;
            } else if (c == ')'){
                counter--;
                if(prev == '('){
                    log.debug("CheckBracketsService check result = false - text contains ()");
                    return false;
                }
            }
            if(counter < 0){
                log.debug("CheckBracketsService check result = false - too much )");
                return false;
            }
            prev = c;
        }
        boolean result = counter == 0;
        log.debug("CheckBracketsService check result = " + result);
        return result;
    }
}
