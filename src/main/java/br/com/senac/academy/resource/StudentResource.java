package br.com.senac.academy.resource;

import br.com.senac.academy.dto.StudentDto;
import br.com.senac.academy.entity.Student;
import br.com.senac.academy.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentResource {

    private final StudentService _studentService;
    private final ModelMapper _mapper;

    public StudentResource(StudentService studentService, ModelMapper mapper) {
        _studentService = studentService;
        _mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto studentDto) {
        Student student = _mapper.map(studentDto, Student.class);
        student = _studentService.save(student);

        StudentDto newStudentDto = _mapper.map(student, StudentDto.class);
        return new ResponseEntity<>(newStudentDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll() {
        List<Student> students = _studentService.getAll();
        List<StudentDto> studentsDto = students.stream()
                .map(student -> _mapper.map(student, StudentDto.class))
                .toList();
        return new ResponseEntity<>(studentsDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable Integer id) {
        Student student = _studentService.getById(id);
        if (student != null) {
            StudentDto studentDto = _mapper.map(student, StudentDto.class);
            return ResponseEntity.ok().body(studentDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> put(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        Student student = _mapper.map(studentDto, Student.class);
        student = _studentService.update(id, student);

        StudentDto updatedStudentDto = _mapper.map(student, StudentDto.class);

        return new ResponseEntity<>(updatedStudentDto, HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> patch(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        Student student = _mapper.map(studentDto, Student.class);
        student = _studentService.update(id, student);

        StudentDto updatedStudentDto = _mapper.map(student, StudentDto.class);

        return new ResponseEntity<>(updatedStudentDto, HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean deleted = _studentService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

