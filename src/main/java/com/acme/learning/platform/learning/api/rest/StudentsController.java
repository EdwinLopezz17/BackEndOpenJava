package com.acme.learning.platform.learning.api.rest;

import com.acme.learning.platform.learning.domain.service.StudentService;
import com.acme.learning.platform.learning.mapping.StudentMapper;
import com.acme.learning.platform.learning.resource.CreateStudentResource;
import com.acme.learning.platform.learning.resource.StudentResource;
import com.acme.learning.platform.learning.resource.UpdateStudentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentsController {
    private StudentService studentService;
    private StudentMapper studentMapper;


    public StudentsController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @GetMapping
    public Page<StudentResource> getAllStudents(Pageable pageable) {
        return studentMapper.modelListPage(studentService.getAll(), pageable);
    }

    @GetMapping
    public StudentResource getStudentById(@PathVariable Long studentId){
        return studentMapper.toResource(studentService.getById(studentId));
    }

    @PostMapping
    public ResponseEntity<StudentResource>createStudent(CreateStudentResource resource){
        return new ResponseEntity<>(studentMapper.toResource(studentService.create(studentMapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping
    public StudentResource updateStudent(@PathVariable Long studentId,
                                         UpdateStudentResource resource){
        return studentMapper.toResource(studentService.update(studentId, studentMapper.toModel(resource)));
    }

    @DeleteMapping
    public ResponseEntity<?>deleteStudent(@PathVariable Long studentId){
        return studentService.delete(studentId);
    }
}
