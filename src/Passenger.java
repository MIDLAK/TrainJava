
import java.io.*;

public class Passenger {
    private String name;
    private String firstName;
    private int age;

    Passenger() {
        this("-", "-", 0);
    }

    Passenger(String name, String firstName, int age) {
        if (isValidAge(age) && isValidName(name) && isValidFirstName(firstName)) {
            this.name = name;
            this.firstName = firstName;
            this.age = age;
        } else {
            this.age = 0;
            this.name = "-";
            this.firstName = "-";
        }
    }

    /*готовый пользовательский интерфейс ввода*/
    public void userInput() throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите: ");

        System.out.print("Имя: ");
        String name = reader.readLine();

        System.out.print("Фамилию: ");
        String firstName = reader.readLine();

        System.out.print("Возраст: ");
        int age = Integer.parseInt(reader.readLine());

        if (isValidAge(age) && isValidName(name) && isValidFirstName(firstName)) {
            this.age = age;
            this.name = name;
            this.firstName = firstName;
        } else {
            throw new IOException("Ошибка при вводе!");
        }
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }

    public void print() {
        System.out.println("Имя: " + name + "\nФамилия: " + firstName + "\nВозраст: " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (isValidName(name)) {
            this.name = name;
        } else {
            throw new Exception("Была передано пустое имя!");
        }
    }

    private boolean isValidName(String name) {
        return name.trim().length() > 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception {
        if (isValidFirstName(firstName)) {
            this.firstName = firstName;
        } else {
            throw new Exception("Была передана пустая фамилия!");
        }
    }

    private boolean isValidFirstName(String firstName) {

        return firstName.trim().length() > 0;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (isValidAge(age)) {
            this.age = age;
        } else {
            throw new Exception("Возраст человека должен быть больше нуля!");
        }
    }

    private boolean isValidAge(int age) {
        return age > 0;
    }

}

