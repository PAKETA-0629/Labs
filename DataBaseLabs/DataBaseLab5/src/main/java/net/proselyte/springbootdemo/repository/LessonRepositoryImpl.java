package net.proselyte.springbootdemo.repository;

import net.proselyte.springbootdemo.model.STDMARK;
import net.proselyte.springbootdemo.model.Student;
import net.proselyte.springbootdemo.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class LessonRepositoryImpl {

    public static final String GET_ALL_PEOPLE =
            "SELECT students.Name, students.LName FROM students UNION SELECT teacher.Name, teacher.LName FROM teacher";
    public static final String GET_ALL_STUDENTS_MARKS =
            "SELECT students.id, students.Name, students.LName, students.StudentID, lessons.Mark FROM students JOIN lessons where students.StudentID = lessons.StdID;";

    private final DataSource dataSource;

    @Autowired
    public LessonRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Student> getAllPeople() {
        List<Student> students = new ArrayList<>();
        try(Connection conn = dataSource.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(GET_ALL_PEOPLE);
            while (rs.next()) {
                Student student = new Student();
                String name = rs.getString("Name");
                String lName = rs.getString("LName");
                student.setName(name);
                student.setLastName(lName);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;

    }

    public List<Subject> getTeacherLessons(String teacherID) {
        String GET_ALL_TEACHER_LESSONS = "SELECT SubjectName, ID FROM teacher_lessons WHERE TeacherID = '" + teacherID + "'";
        List<Subject> subjects = new ArrayList<>();
        try(Connection conn = dataSource.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(GET_ALL_TEACHER_LESSONS);
            while (rs.next()) {
                Subject subject = new Subject();
                String name = rs.getString("SubjectName");
                Long id = rs.getLong("ID");
                subject.setName(name);
                subject.setId(id);
                subjects.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;


    }

    public List<STDMARK> getStudentsMarks() {
        List<STDMARK> stdmarks = new ArrayList<>();
        try(Connection conn = dataSource.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(GET_ALL_STUDENTS_MARKS);
            while (rs.next()) {
                STDMARK stdmark = new STDMARK();
                Long id = rs.getLong("id");
                String name = rs.getString("Name");
                String lName = rs.getString("LName");
                String studentID = rs.getString("StudentID");
                int mark = rs.getInt("Mark");
                stdmark.setName(name);
                stdmark.setId(id);
                stdmark.setLastName(lName);
                stdmark.setMark(mark);
                stdmark.setStudentID(studentID);
                stdmarks.add(stdmark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stdmarks;



    }
}
