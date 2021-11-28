import java.io.Serializable;
import java.lang.ref.Cleaner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TrainRoute {
    private String departure;
    private String destination;
    private Calendar departureDate;
    private Calendar destinationDate;

    private static String dateFormat = "dd.MM.yyyy HH:mm";

    TrainRoute() {
        this("-", "-", new GregorianCalendar(), new GregorianCalendar());
    }

    TrainRoute(String departure, String destination, Calendar departureDate, Calendar destinationDate) {
        if (isValidDepatrue(departure) && isValidDestination(destination) && departureDate != null && destinationDate != null) {
            this.departure = departure;
            this.destination = destination;
            this.departureDate = departureDate;
            this.destinationDate = destinationDate;
        } else {
            this.departure = "-";
            this.destination = "-";
            this.departureDate = new GregorianCalendar();
            this.destinationDate = new GregorianCalendar();
        }
    }

    public void print() {
        System.out.println("Пунтк отправления -> Пункт назначения: " + departure + " -> " + destination);
        SimpleDateFormat dateFormat = new SimpleDateFormat(TrainRoute.dateFormat);  //пример вывода 16.10.2021 14:05
        System.out.println("Дата отправления: " + dateFormat.format(departureDate.getTime()));
        System.out.println("Дата прибытия: " + dateFormat.format(destinationDate.getTime()));
        System.out.println("Время в пути: " + travelTime());
    }

    public static void setDateFormat(String newDateFormat){
        dateFormat = newDateFormat;
    }

    public static String getDateFormat(){
        return dateFormat;
    }

    private String travelTime() {
        long day1 = departureDate.getTimeInMillis();
        long day2 = destinationDate.getTimeInMillis();
        long difference = day2 - day1;
        double travelDay = Math.floor((double) difference / 86400000); //86 400 000 - колличесвто миллисикунд в сутках
        String travelTime = String.format("%.0f дней", travelDay);
        return  travelTime;
    }

    @Override
    public String toString() {
        return "TrainRoute{" +
                "departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate=" + departureDate.getTime() +
                ", destinationDate=" + destinationDate.getTime() +
                '}';
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) throws Exception {
        if (isValidDepatrue(departure)) {
            this.departure = departure;
        } else {
            throw new Exception("Ошибка при вводе пункта отправления!");
        }
    }

    private boolean isValidDepatrue(String departure) {
        return departure.trim().length() > 0;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) throws Exception {
        if (isValidDestination(destination)) {
            this.destination = destination;
        } else {
            throw new Exception("Ошибка при вводе пункта назначения!");
        }
    }

    private boolean isValidDestination(String destination) {
        return destination.trim().length() > 0;
    }

    public Calendar getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Calendar departureDate) {
        if (departureDate != null)
            this.departureDate = departureDate;
    }

    public Calendar getDestinationDate() {
        return destinationDate;
    }

    public void setDestinationDate(Calendar destinationDate) {
        if (destinationDate != null)
            this.destinationDate = destinationDate;
    }
}
