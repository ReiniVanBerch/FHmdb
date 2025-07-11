package at.ac.fhcampuswien.fhmdb;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Object event);
}