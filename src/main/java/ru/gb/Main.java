package ru.gb;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        String name = "Name ";
        for (int i = 0; i < 1000; i++) {
            studentDAO.save(new Student(name + i, 1 + (int) (Math.random() * 5)));
        }
        Student student = new Student("Name", 5);
        studentDAO.save(student);
        student.setMark(5);
        studentDAO.update(student);
        Student student1 = studentDAO.findById(1L);
        System.out.println(student1);
        studentDAO.delete(student1);
        List<Student> list = studentDAO.findAll();
        for (Student stud : list) {
            System.out.println(stud);
        }
    }
}