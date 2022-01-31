package ru.gb;

import java.util.List;

public interface StudentDAO {
    Student findById(Long id);

    void save(Student user);

    void update(Student user);

    void delete(Student user);

    List<Student> findAll();
}

