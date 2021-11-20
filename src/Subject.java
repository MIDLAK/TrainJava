public interface Subject {
    public void registerObserver(Observer o);	//регистрируемый наблюдатель
    public void removeObserver(Observer o);		//исключаемый наблюдатель
    public void notifyObservers();	//оповещение наблюдателей об изменении состояния субъекта
}
