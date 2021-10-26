import java.util.LinkedList;

public class Main {

    private static LinkedList<Student> array = new LinkedList<>();
    private static final DataBase dataBase = new DataBase();
    private static final DataBase2 dataBase2 = new DataBase2();

    static {
        dataBase.add(new Student("Kyrylo", "Maltsev", 19, 3, 100));
        dataBase.add(new Student("Max", "Dyachok", 19, 3, 71));
        dataBase.add(new Student("Nazar", "Russu", 19, 3, 51));
        dataBase.add(new Student("Alina", "Artimyak", 20, 3, 95));

        dataBase2.addStudentFirst(new Student("Kyrylo", "Maltsev", 19, 3, 100));
    }


    public static void main(String[] args) {
        dataBase.showAll();
        dataBase.remove(new Student("Nazar", "Russu", 19, 3, 51));
        dataBase.edit(dataBase.getStudent(0), new Student("Olga", "Toma", 19, 3, 80));
        dataBase.showAll();
    }
}