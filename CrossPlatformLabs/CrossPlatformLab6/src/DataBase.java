import java.util.ArrayList;
import java.util.List;

public class DataBase {

    List<DBInstance<Student>> database;
    private int currentID;

    DataBase(List<DBInstance<Student>> array) {
        this.database = array;
        this.currentID = database.get(database.size() - 1).getId();
    }


    DataBase() {
        database = new ArrayList<>();
        currentID = 0;
    }


    public void edit(Student targetStudent, Student student) {
        remove(targetStudent);
        DBInstance<Student> instance = new DBInstance<>(student, currentID++);
        database.add(instance);
    }


    public void remove(Student student) {
        database.removeIf(instance -> instance.getInstance().equals(student));
    }
    
    
    public void showAll() {
        for (DBInstance<Student> instance: database) {
            Student student = instance.getInstance();
            String string =
                    "ID: " + instance.getId() + "\n" +
                    "Surname: " + student.getSurname() + "\n" +
                    "Name: " + student.getName() + "\n" +
                    "Age: " + student.getAge() + "\n" +
                    "Course: " + student.getCourse() + "\n" +
                    "AverageMark: " + student.getAverageMark() + "\n";

            System.out.println(string);
        }
    }


    public Student getStudent(int id) {
        return database.get(id).getInstance();
    }


    public void add(Student student) {
        DBInstance<Student> instance = new DBInstance<>(student, currentID++);
        database.add(instance);
    }
    
    
    public void add(Student ... students) {
        ArrayList<DBInstance<Student>> dbInstanceArrayList = new ArrayList<>();
        DBInstance<Student> instance;
        for (Student student : students) {
            instance = new DBInstance<>(student, currentID++);
            dbInstanceArrayList.add(instance);
        }
        add(dbInstanceArrayList);
    }


    public void add(List<DBInstance<Student>> instances) {
        database.addAll(instances);
    }
}
