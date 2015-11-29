package sample.Model;

import java.util.Random;

/**
 * Created by Wojciech on 2015-11-25.
 */
public class CollectionStudent {
    protected static CollectionStudent instance = null;
    private Chart chart1;
    private Chart chart2;

    private CollectionStudent(Chart chart1, Chart chart2) {
        this.chart1 = chart1;
        this.chart2 = chart2;
    }

    public static synchronized CollectionStudent getInstance(Chart chart1, Chart chart2){
        if(instance == null){
            instance = new CollectionStudent(chart1, chart2);
        }
        return instance;
    }

    public Chart getChart2() {
        return chart2;
    }

    public Chart getChart1() {
        return chart1;
    }
}
