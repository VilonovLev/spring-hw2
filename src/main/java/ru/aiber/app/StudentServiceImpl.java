package ru.aiber.app;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aiber.app.models.Group;
import ru.aiber.app.models.Student;

import static ru.aiber.app.models.Group.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;



@Service
@NoArgsConstructor
public class StudentServiceImpl implements StudentService<Student>{

    private List<Student> studentList = new ArrayList<>();

    @Override
    public boolean add(Student student) {
        return studentList.add(student);
    }

    @Override
    public Student getStudentById(long id) {
        return studentList.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean removeStudentById(long id) {
        return studentList.remove(getStudentById(id));
    }

    @Override
    public List<Student> getAll() {
        return List.copyOf(studentList);
    }

    @Override
    public List<Student> findByNameLike(String regExp) {
        return studentList.stream()
                .filter(x -> x.getName().matches(String.format(".*%s.*",regExp)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getStudentByGroup(String groupName) throws IllegalArgumentException{
        Group group = Group.valueOf(groupName.toUpperCase(Locale.ROOT));
        return studentList
                .stream()
                .filter(x -> x.getGroup().equals(group))
                .collect(Collectors.toList());
    }

    @PostConstruct
    public void init() {
        studentList.add(new Student(2,"Igor", MATH));
        studentList.add(new Student(3,"Vladlen", PHYS));
        studentList.add(new Student(6,"Ira", ECON));
        studentList.add(new Student(8,"Vlad", MATH));
        studentList.add(new Student(23,"Lera", PHYS));
        studentList.add(new Student(1,"Katy", ECON));
    }
}
