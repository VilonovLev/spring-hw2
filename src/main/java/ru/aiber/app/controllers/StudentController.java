package ru.aiber.app.controllers;

import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aiber.app.StudentService;
import ru.aiber.app.models.Student;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    StudentService<Student> studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> getByName(@RequestParam String name){
        return new ResponseEntity<>(studentService.findByNameLike(name), HttpStatus.OK);
    }

    @PostMapping
    public HttpStatus addStudent(@RequestBody Student student){
       return studentService.add(student) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteStudent(@PathVariable("id") long id){
        return studentService.removeStudentById(id) ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST;
    }

}
