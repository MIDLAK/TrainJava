import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TrainApp {
    public static void main(String[] args) {
        TicketFactory ticketFactory = new TicketFactory();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Passenger passenger1 = new Passenger("Вадим", "Калуга", 19);
        Passenger passenger2 = new Passenger("Егор", "Голиков", 19);
        Passenger passenger3 = new Passenger("Шевченко", "Валерия", 19);
        while (true)
            try {
                passenger1.userInput();
                break;
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
                System.out.println("\nПожалуйста, повторите ввод.");
            }
        System.out.println(passenger1.toString());  //вывод строкового представления пользователя


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

        Train train1 = new Train(56);
        Train train2 = new Train(77);
        Train train3 = new Train(81);


        Depot depot = new Depot(3);
        try {
            depot.toParkTrain(train2);
            depot.toParkTrain(train1);
            depot.toParkTrain(train3);

        } catch (Exception e) {
            e.printStackTrace();
        }

        depot.print();
        try {
            Train tr = depot.toLeaveTrain(56);
        } catch (Exception e) {
            e.printStackTrace();
        }
        depot.print();


        Ticket lux = ticketFactory.createTicket(TypeCar.LUX);
        Ticket mid = ticketFactory.createTicket(TypeCar.MIDDLE);
        Ticket eco = ticketFactory.createTicket(TypeCar.ECONOM);

        lux.setPassenger(passenger1);
        lux.setTrain(train);
        try {
            lux.setSeat(11);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mid.setPassenger(passenger2);
        mid.setTrain(train);
        try {
            mid.setSeat(22);
        } catch (Exception e) {
            e.printStackTrace();
        }

        eco.setPassenger(passenger3);
        eco.setTrain(train);
        try {
            eco.setSeat(33);
        } catch (Exception e) {
            e.printStackTrace();
        }

        lux.print();
        mid.print();
        eco.print();

        TrainRoute.setDateFormat("yyyy-MM-dd HH:mm:ss");    //пример вывода 2008-05-30 08:20:12

        try {
            train.setTrainID(55);    //для демонстрации наблюдателя
        } catch (Exception e) {
            e.printStackTrace();
        }


        /*создание массива в 5 строк*/
        TrainRoute[][] array = new TrainRoute[5][];

        /*выделение памяти "под столбцы"*/
        for (int i = 0; i < 5; i++) {
            array[i] = new TrainRoute[i + 1];
        }

        /*заполнение "треугольного" массива*/
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new TrainRoute("пункт №" + i + "" + j, "пункт №" + i + "" + (j + 1), new GregorianCalendar(), new GregorianCalendar());
            }
        }

        /*вывод "треугольного" массива*/
        for (int i = 0; i < 5; i++) {
            System.out.println("");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print('[' + array[i][j].getDeparture() + "->" + array[i][j].getDestination() + ']');
            }
        }

        /*одномерный массив поездов*/
        Train[] trainArray = new Train[15];

        /*выделение памяти под поезда с маршрутами из массива array*/
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int k = i + j + (int)(i*(i-1)/2); // магическая формула
                trainArray[k] = new Train(array[i][j], k+1, (i + j) * 100 + 1);
                System.out.println("Поезд №" + trainArray[k].getTrainID() + " (" + trainArray[k].getRoute().getDeparture() + "->" + trainArray[k].getRoute().getDestination() + ")");
            }
        }


    }
}
