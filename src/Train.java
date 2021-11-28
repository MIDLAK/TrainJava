
import java.util.ArrayList;

public class Train implements Subject {
    private ArrayList<Observer> observers;	//ArrayList для хранения наблюдателей
    private TrainRoute route;
    private int trainID;
    private int capacity;   //максимальное кол-во пассажиров

    Train(){
        this(new TrainRoute(), 0, 1);
    }

    Train(int trainID){
        this(new TrainRoute(), trainID, 1);
    }

    Train(TrainRoute route, int trainID, int capacity) {

        observers = new ArrayList<Observer>();

        if (route != null && isValidCapacity(capacity) && isValidTrainID(trainID)) {
            this.route = route;
            this.trainID = trainID;
            this.capacity = capacity;
        } else {
            this.route = new TrainRoute();
            this.trainID = 0;
            this.capacity = 0;
        }
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /*оповещение наблюдателей об изенении состояния ч/з метод update(), реализуемый всеми наблюдателями*/
    public void notifyObservers(){
        for (int i = 0; i < observers.size(); i++){
            Observer observer = (Observer) observers.get(i);
            observer.update(route, trainID, capacity);
        }
    }

    /*оповещени наблюдателей об изменении*/
    public void measurementsChanged() {
        notifyObservers();
    }

    public void print(){
        System.out.println("Номер поезда: " + trainID);
        route.print();
    }

    @Override
    public String toString() {
        return "Train{" +
                "route=" + route +
                ", trainID=" + trainID +
                ", capacity=" + capacity +
                '}';
    }

    public TrainRoute getRoute() {
        return route;
    }

    public void setRoute(TrainRoute route) throws Exception {
        if (route != null) {
            this.route = route;
        } else {
            throw new Exception("Пустая ссылка на TrainRoute!");
        }

        measurementsChanged();	//оповещение наблюдателей
    }

    public int getTrainID() {
        return trainID;
    }

    public void setTrainID(int trainID) throws Exception {
        if (isValidTrainID(trainID)) {
            this.trainID = trainID;
        } else {
            throw new Exception("Такой номер поезда невозомжен!");
        }

        measurementsChanged();	//оповещение наблюдателей
    }

    private boolean isValidTrainID(int trainID) {
        return trainID > 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) throws Exception {
        if (isValidCapacity(capacity)) {
            this.capacity = capacity;
        } else {
            throw new Exception("Такое количество пассажиров невозможно!");
        }

        measurementsChanged();	//оповещение наблюдателей
    }

    private boolean isValidCapacity(int capacity) {
        return capacity > 0;
    }
}
