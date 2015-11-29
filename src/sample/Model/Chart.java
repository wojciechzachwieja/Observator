package sample.Model;

import sample.Model.Observer.IObservable;
import sample.Model.Observer.IObserver;

/**
 * Created by Wojciech on 2015-11-26.
 */
public class Chart implements IObserver{
    private int[] marks;
    private String[] name;
    private Students students;
    private int size;

    public Chart(Students students){
        size = students.getSize();
        marks = new int[size];
        name = new String[size];
        this.students = students;
    }


    public void informuj(){
        System.out.println("Dzisiejsze losowanie Totolotka by TVP");
        for(int i:marks)
            System.out.print(i + " ");
        System.out.println();
    }

    public int[] getMarks() {
        return marks;
    }

    public String[] getName() {
        return name;
    }

    public void remove(){
        students.unsetObserver(this);
    }

    @Override
    public void update(int[] marks, String[] names) {
        for(int i=0;i<size;i++){
            this.marks[i] = marks[i];
            this.name[i] = names[i];
        }
    }

    public int getSize() {
        return size;
    }
}
