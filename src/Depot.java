
public class Depot {
    private Train[] trains;

    Depot(int parkingСapacity) {
        trains = new Train[parkingСapacity];
    }

    /*припарковка поезда в депо*/
    public void toParkTrain(Train train) throws Exception {
        if (train != null) {
            boolean b = true;
            for (Train tr : trains) {
                if (tr != null && tr.getTrainID() == train.getTrainID()) {
                    b = false;
                }
            }
            for (int i = 0, len = trains.length; i < len; i++) {
                if (trains[i] == null && b) {
                    trains[i] = train;
                    b = true;
                    break;
                }
            }
            if (!b) {
                throw new Exception("ОШИБКА! Парковка поезда с номером " + "\"" + train.getTrainID() + "\"" + " не удалась.");
            }
        }
    }

    /*выезд поезда из депо*/
    public Train toLeaveTrain(int trainID) throws Exception {
        for (int i = 0, len = trains.length; i < len; i++) {
            if (trains[i].getTrainID() == trainID) {
                Train train = new Train(trains[i].getRoute(), trains[i].getTrainID(), trains[i].getCapacity()); //не совсем красиво созданная копия объекта
                trains[i] = null; //"освобождение" парковочного места
                return train;
            }
        }
        throw new Exception("Поезда с таким ID в данном депо нет!");
    }

    public void print() {
        System.out.println("Все позда, находящиеся в данный момет в депо: ");
        for (Train train : trains) {
            if (train != null)
                System.out.println(train.getTrainID());
        }
    }
}
