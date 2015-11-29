package sample.Model;

import sample.Model.Observer.IObservable;
import sample.Model.Observer.IObserver;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Wojciech on 2015-11-26.
 */
public class Students implements IObservable{
    private String[] name;
    private ArrayList<IObserver> observers;
    private int[] marks;
    private int size;
    public Students(int n){
        observers = new ArrayList<IObserver>();
        size = n;
        marks = new int[size];
        name = new String[size];

    }


    public void generate(){
        Random random = new Random(System.currentTimeMillis());
        name = new String[size];
        int[] arr = new int[size];
        for(int i = 0;i < size;++i){
            name[i] = "student " + (i+1);
            arr[i] = Math.abs(random.nextInt(10));
        }
        marks = arr;
        notifyObserver();
    }


    public int[] getMarks() {
        return marks;
    }

    public String[] getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void unsetObserver(IObserver o) {
        int index = observers.indexOf(o);
        observers.remove(index);
    }

    @Override
    public void setObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void notifyObserver() {
        for(IObserver o : observers){
            o.update(marks,name);
        }
    }

}
