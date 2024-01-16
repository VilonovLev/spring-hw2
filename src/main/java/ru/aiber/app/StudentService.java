package ru.aiber.app;

import ru.aiber.app.models.Student;
import java.util.List;

public interface StudentService<S extends Student> {
    boolean add(S student);
    S getStudentById(long id);
    boolean removeStudentById(long id);
    List<S> getAll();
    List<S> findByNameLike(String regExp);
    List<S> getStudentByGroup(String groupName);

}
