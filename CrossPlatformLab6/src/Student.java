public class Student {

    private String name;
    private String surname;
    private int age;
    private int course;
    private int averageMark;

    Student(String name, String surname, int age, int course, int averageMark) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.course = course;
        this.averageMark = averageMark;
    }

    public boolean equals(Student student) {
        return name.equals(student.getName()) && surname.equals(student.getSurname()) &&
                age == student.getAge() && course == student.getCourse() &&
                averageMark == student.getAverageMark();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getCourse() {
        return course;
    }

    public int getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(int averageMark) {
        this.averageMark = averageMark;
    }
}
