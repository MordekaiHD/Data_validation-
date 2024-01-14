package Intermediate_certification;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (Фамилия Имя Отчество, дата рождения, номер телефона, пол):");
        String input = scanner.nextLine();
        scanner.close();

        try {
            UserDataParser parser = new DefaultUserDataParser();
            UserData userData = parser.parse(input);
            writeToUserFile(userData);
            System.out.println("Данные успешно записаны в файл.");
        } catch (IllegalArgumentException e) {
            System.out.println(STR."Ошибка: \{e.getMessage()}");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToUserFile(UserData userData) throws IOException {
        String fileName = STR."\{userData.getLastName()}.txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(STR."\{userData}\n");
        }
    }
}