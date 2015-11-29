package sample.Model.Observer;

import sample.Model.Students;

/**
 * Created by Wojciech on 2015-11-28.
 */
public class TableData {
    private int n; // number of student in arr
    private Students students;

    public TableData(int n, Students students) {
        this.n = n;
        this.students = students;
    }

    public String getName(){
        return students.getName()[n];
    }
    public int getMark(){
        return students.getMarks()[n];
    }

    public void setStudents(Students students) {
        this.students = students;
    }
}
