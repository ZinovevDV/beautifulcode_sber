package ru.mail.zinovevdv.beautifulcode_sber.service;

/**
 * Интерфейс сервиса проверки соотношения открывающихся и закрывающихся скобок
 */
public interface CheckBracketsService {
    boolean check(String text);
}
