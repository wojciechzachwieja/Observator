package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import sample.model.CollectionStudent;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Wojciech on 2015-11-27.
 */
public class Controller2 implements Initializable {
    public PieChart ID_CHART_2;
    public BarChart ID_CHART_1;
    public CollectionStudent model;


    public void setChart1(){
        ID_CHART_1.getData().clear();
        ID_CHART_1.setTitle("Statistics");

        int size = model.getChart1().getSize();
        XYChart.Series series = new XYChart.Series();

        for(int i = 0;i < size;++i){
             series.getData().add(new XYChart.Data(model.getChart1().getName()[i], model.getChart1().getMarks()[i]));
        }

        ID_CHART_1.getXAxis().setLabel("Students");
        ID_CHART_1.getYAxis().setLabel("Marks");
        ID_CHART_1.getData().addAll(series);
    }

    public void setChart2(){
        ID_CHART_1.setTitle("Statistics");
        int size = model.getChart2().getSize();
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList();
        for(int i = 0;i < size;++i){
            pieChartData.add(new PieChart.Data(model.getChart2().getName()[i], model.getChart2().getMarks()[i]));
        }
        ID_CHART_2.setData(pieChartData);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        model = CollectionStudent.getInstance(null, null);
        setChart1();
        setChart2();
        model.getChart1().informuj();
    }

    public void setModel(CollectionStudent model) {
        this.model = model;
    }
}
