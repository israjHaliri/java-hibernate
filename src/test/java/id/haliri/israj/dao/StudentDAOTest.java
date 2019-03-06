package id.haliri.israj.dao;

import id.haliri.israj.dao.impl.StudentDAOImpl;
import id.haliri.israj.entity.Address;
import id.haliri.israj.entity.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOTest {

    private StudentDAO studentDAO;

    {
        studentDAO = new StudentDAOImpl();
    }

    @Before
    public void save() {
        Student student = new Student();

        Address address = new Address();
        address.setCity("JKT");
        address.setCountry("Indonesia");
        address.setStudent(student);

        student.setName("jhon");
        student.getAddresses().add(address);

        studentDAO.save(student);
    }

    @Test
    public void delete() {
        List<Student> students = new ArrayList<Student>(studentDAO.find(null, 0, 1));

        studentDAO.delete(students.get(0));
    }

    @Test
    public void update() {
        List<Student> students = new ArrayList<Student>(studentDAO.find(null, 0, 1));

        Student student = students.get(0);
        student.setName("Sadewo");

        studentDAO.update(student);
    }

}