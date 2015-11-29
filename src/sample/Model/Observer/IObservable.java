package sample.Model.Observer;

/**
 * Created by Wojciech on 2015-11-26.
 */
public interface IObservable {
    void unsetObserver(IObserver o);
    void setObserver(IObserver o);
    void notifyObserver();
    //TODO
}
