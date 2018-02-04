package id.or.greenlabs.demo.jpa.dao;

import id.or.greenlabs.demo.jpa.dao.impl.StudentDAOImpl;
import id.or.greenlabs.demo.jpa.entity.Address;
import id.or.greenlabs.demo.jpa.entity.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author krissadewo
 * @Date 16/01/18
 **/
public class StudentDAOTest {

    private StudentDAO studentDAO;

    {
        studentDAO = new StudentDAOImpl();
    }

    @Test
    public void save() {
        Student student = new Student();

        Address address = new Address();
        address.setCity("Yogyakarta");
        address.setCountry("Indonesia");
        address.setStudent(student);

        student.setName("kris");
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