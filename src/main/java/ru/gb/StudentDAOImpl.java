package ru.gb;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO{
    private Session session;

    public StudentDAOImpl() {
        openSession();
    }

    public void openSession() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
    }

    public void closeSession() {
        session.close();
    }

    public Session getSession() {
        return session;
    }

    @Override
    public Student findById(Long id) {
        return session.get(Student.class, id);
    }

    @Override
    public void save(Student student) {
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
    }

    @Override
    public void update(Student student) {
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
    }

    @Override
    public void delete(Student student) {
        Transaction transaction = session.beginTransaction();
        session.delete(student);
        transaction.commit();
    }

    @Override
    public List<Student> findAll() {
        return (List<Student>) session.createQuery("From Student").list();
    }
}
