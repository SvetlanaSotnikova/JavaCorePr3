package org.Sem4.Task1;

import java.util.Scanner;

//Задача: Проверка логина и пароля
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
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter login: ");
        String login = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter password again: ");
        String confirmPassword = scanner.nextLine();

        boolean correctData = Authorization.checkData(login, password, confirmPassword);
        System.out.println(correctData);
    }
}
