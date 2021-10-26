import java.util.LinkedList;

public class DataBase2 extends DataBase {


    private static int currentID;
    private LinkedList<DBInstance<Student>> database;
    DataBase2(LinkedList<DBInstance<Student>> database) {
        this.database = database;
    }


    DataBase2() {
        this.database = new LinkedList<>();
        currentID = 0;
    }


    public void addStudentFirst(Student student) {
        DBInstance<Student> instance = new DBInstance<>(student, currentID++);
        database.addFirst(instance);
    }


    public void addStudentLast(Student student) {
        DBInstance<Student> instance = new DBInstance<>(student, currentID++);
        database.addLast(instance);
    }
}
