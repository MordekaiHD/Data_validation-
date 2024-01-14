package Intermediate_certification;

public class DefaultUserDataParser implements UserDataParser{

    @Override
    public UserData parse(String input) throws IllegalArgumentException {
        String[] data = input.split("\\s+");
        if (data.length != 6) {
            throw new IllegalArgumentException("Неверное количество данных. Введите все необходимые параметры.");
        }
        try {
            checkForDigits(data[0], "Фамилии");
            checkForDigits(data[1], "Имени");
            checkForDigits(data[2], "Отчестве");

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            return new UserData(lastName, firstName, middleName, birthDate, phoneNumber, gender);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Неверный формат данных. Проверьте введенные значения.");
        }
    }

    private void checkForDigits(String value, String fieldName) {
        if (value.matches(".*\\d+.*")) {
            throw new IllegalArgumentException(STR."В \{fieldName} не должны содержаться цифры.");
        }
    }
}
