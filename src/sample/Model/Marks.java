package sample.Model;

import java.util.Random;

/**
 * Created by Wojciech on 2015-11-26.
 */
public class Marks {
    private int[] marks;

    public Marks(int n) {
        Random random = new Random(System.currentTimeMillis());
        marks = new int[n];
        for(int i = 0;i < n;++i){
           marks[i] = Math.abs(random.nextInt(10));
        }
    }

    public void setMarks(int[] marks) {

        this.marks = marks;
    }

}
