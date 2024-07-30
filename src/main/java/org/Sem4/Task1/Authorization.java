package org.Sem4.Task1;
//1. Создать статический метод который принимает на вход три
//параметра: login, password и confirmPassword.
//2. Длина login должна быть меньше 20 символов. Если login не
//соответствует этим требованиям, необходимо выбросить
//WrongLoginException.
//3. Длина password должна быть меньше 20 символов. Также password
//и confirmPassword должны быть равны. Если password не
//соответствует этим требованиям, необходимо выбросить
//WrongPasswordException.
//4. WrongPasswordException и WrongLoginException - пользовательские
//классы исключения с двумя конструкторами – один по умолчанию,
//второй принимает сообщение исключения и передает его в
//конструктор класса Exception.
//5. В основном классе программы необходимо по-разному обработать
//исключения.
//6. Метод возвращает true, если значения верны или false в другом
//случае

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class Authorization {
    private String login;
    private String password;
    private String confirmPassword;

    public static boolean checkData(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        if (login == null || password == null || confirmPassword == null) {
            System.err.println("Login and password are null!");
            return false;
        }

        if (Objects.equals(login, password)) {
            System.err.println("Login and password does not match!");
            return false;
        }
        if (!Objects.equals(password, confirmPassword)) {
            System.err.println("Confirm password does not match!");
            return false;
        }
        try {
            if (Objects.requireNonNull(login).length() >= 20) {
                throw new WrongLoginException("you need use smaller 20 chars", login.length());
            }
            if (password.length() < 20) {
                throw new WrongPasswordException("you need use bigger 20 chars", password.length());
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
            return false;
        }
    }
}
