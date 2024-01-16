package ru.aiber.app.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aiber.app.StudentService;
import ru.aiber.app.models.Student;

import java.util.List;

@RestController
@RequestMapping("/group")
@AllArgsConstructor
public class GroupController {
    StudentService<Student> studentService;
    @GetMapping("/{groupName}/student")
    public ResponseEntity<List<Student>> getStudentsFrom(@PathVariable String groupName) {
        try {
            List<Student> result = studentService.getStudentByGroup(groupName);
            return new ResponseEntity<>(result,HttpStatus.FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
