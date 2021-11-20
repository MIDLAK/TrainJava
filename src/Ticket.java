public class Ticket implements Observer {
    private int price;
    private int seat;
    private Passenger passenger;
    private Train train;

    Ticket(){
        this(0, 0, new Passenger(), new Train());
    }

    Ticket(int price, int seat, Passenger passenger, Train train) {
        if (isValidPrice(price) && isValidSeat(seat) && train.getCapacity() >= seat && passenger != null && train != null) {
            this.price = price;
            this.seat = seat;
            this.passenger = passenger;
            this.train = train;

            train.registerObserver(this);   //регистрация наблюдателя

        } else {
            this.price = 0;
            this.seat = 0;
            this.passenger = new Passenger();
            this.train = new Train();
        }
    }

    public void update(TrainRoute route, int trainID, int capacity){
        System.out.println("-!-!-!-!-!-!-ВНИМАНИЕ-!-!-!-!-!-!-");
        System.out.println("Произошло обновление информации в биллете. Ознакомтесь: ");
        this.print();
    }

    public void print(){
        System.out.println("-------------*Билет*-------------");
        System.out.println("Цена: " + price + " рублей");
        System.out.println("Место: " + seat);
        passenger.print();
        train.print();
        System.out.println("---------------------------------");
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "price=" + price +
                ", seat=" + seat +
                ", passenger=" + passenger +
                ", train=" + train +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws Exception {
        if (isValidPrice(price)) {
            this.price = price;
        } else {
            throw new Exception("Такой цены за биллет не предусмотрено!");
        }
    }

    private boolean isValidPrice(int price) {
        return price >= 0;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) throws Exception {
        if (isValidSeat(seat) && train.getCapacity() >= seat) {
            this.seat = seat;
        } else {
            throw new Exception("Такого койка-места в поезде быть не может!");
        }
    }

    private boolean isValidSeat(int seat) {
        return seat > 0;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) throws NullPointerException {
        if (passenger != null) {
            this.passenger = passenger;
        } else {
            throw new NullPointerException("На пассажира была передана null сслыка!");
        }
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        if (train != null) {
            this.train = train;
        } else {
            throw new NullPointerException("На поезд была передана null сслыка!");
        }
    }
}
