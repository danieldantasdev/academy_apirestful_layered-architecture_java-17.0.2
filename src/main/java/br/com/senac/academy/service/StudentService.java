package br.com.senac.academy.service;

import br.com.senac.academy.entity.Student;
import br.com.senac.academy.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository _studentRepository;

    public StudentService(StudentRepository _studentRepository) {
        this._studentRepository = _studentRepository;
    }

    public Student save(Student student) {
        return _studentRepository.save(student);
    }

    public Page<Student> getAll(PageRequest pageRequest) {
        return _studentRepository.findAll(pageRequest);
    }

    public Student getById(Integer id) {
        return _studentRepository.findById(id).orElse(null);
    }

    public Student update(Integer id, Student student) {
        Student _student = _studentRepository.findById(id).orElse(null);
        if (_student != null) {
            _student.setName(student.getName());
            _student.setSurname(student.getSurname());
            _student.setEmail(student.getEmail());
            return _studentRepository.save(_student);
        } else {
            return null;
        }

    }

    public Boolean delete(Integer id) {
        Student student = _studentRepository.findById(id).orElse(null);
        if (student != null) {
            _studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
