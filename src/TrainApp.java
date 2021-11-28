import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TrainApp {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Passenger passenger1 = new Passenger("Вадим", "Калуга", 19);
        /*
        System.out.println(passenger1.toString());
        try {
            passenger1.userInput();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        */


        TrainRoute trainRoute = new TrainRoute();

        Calendar dep = new GregorianCalendar(2021, Calendar.OCTOBER, 16, 14, 7);
        Calendar des = new GregorianCalendar(2021, Calendar.OCTOBER, 25, 12, 55);
        trainRoute = new TrainRoute("Барнаул", "Новосибирск", dep, des);

        System.out.println("-------------*Демонстрация конструкторов*-------------");
        Train train = new Train();
        train.print();
        System.out.println("------------------------------------------------------");
        train = new Train(25);
        train.print();
        System.out.println("------------------------------------------------------");
        train = new Train(trainRoute, 15, 55);
        train.print();
        System.out.println("------------------------------------------------------");


        Ticket ticket = new Ticket(155, 3, passenger1, train);
        ticket.print();

        TrainRoute.setDateFormat("yyyy-MM-dd HH:mm:ss");	//пример вывода 2008-05-30 08:20:12

        try{
            train.setTrainID(55);	//для демонстрации наблюдателя
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
