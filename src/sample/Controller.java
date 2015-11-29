package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Model.Chart;
import sample.Model.CollectionStudent;
import sample.Model.Observer.TableData;
import sample.Model.Students;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField ID_NUM_STUDENTS;
    public CheckBox ID_CHART1;
    public CheckBox ID_CHART2;
    public TableColumn ID_FIRST_COL;
    public TableColumn ID_SECOND_COL;
    public TableView ID_TAB;
    private CollectionStudent model;
    private Students students;
    public Controller2 controller2;
    private Chart chart1;
    private Chart chart2;
    private List<TableData> tableDatas;
    private ObservableList<TableData> observableList;

    public void generate(ActionEvent actionEvent) {
        try {
            int n = Integer.valueOf(ID_NUM_STUDENTS.getText().toString());
            if(n < 1 || n > 10)
                n = 5;
            students.generate();

            chart1.informuj();
            chart2.informuj();
            controller2.setChart2();
            controller2.setChart1();
            observableList = FXCollections.observableList(tableDatas);
            //setTableData();
            System.out.println("Lista " + tableDatas.get(0).getMark());
            ID_TAB.setItems(observableList);
            ID_SECOND_COL.setVisible(false);
            ID_SECOND_COL.setVisible(true);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Prosze wpisac liczbe z przedzialu od 0 do 10!");
        }
    }

    public void clearList(ActionEvent actionEvent) {
        //model.clearList();
    }

    public CollectionStudent getModel() {
        return model;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        students = new Students(6); // create 6 students
        students.generate(); // generate marks for students
        chart1 = new Chart(students);
        chart2 = new Chart(students);
        model = CollectionStudent.getInstance(chart1,chart2);
        students.setObserver(chart1);
        students.setObserver(chart2);
        students.generate();
        model.getChart2().remove();
        model.getChart1().remove();
        tableDatas = new ArrayList<>();
        for(int i = 0;i < students.getSize();++i){
            tableDatas.add(new TableData(i,students));
        }
        observableList = FXCollections.observableList(tableDatas);
        this.ID_FIRST_COL.setCellValueFactory(new PropertyValueFactory<TableData, String>("Name"));
        this.ID_SECOND_COL.setCellValueFactory(new PropertyValueFactory<TableData, String>("Mark"));
        ID_TAB.setItems(observableList);
    }



    public void observeChart1(ActionEvent actionEvent) {
        if(ID_CHART1.isSelected()){
            students.setObserver(chart1);
        }else{
            model.getChart1().remove();
        }
    }

    public void observeChart2(ActionEvent actionEvent) {
        if(ID_CHART2.isSelected()){
            students.setObserver(chart2);
        }else {
            model.getChart2().remove();
        }
    }

    private void setTableData(){
        for(int i = 0;i < students.getSize();++i){
            tableDatas.get(i).setStudents(students);
        }
    }
}
