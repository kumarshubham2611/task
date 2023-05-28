package com.task.Service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.task.Student;
import com.task.Respository.StudentRepository;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public Page<Student> getPaginatedStudents(int page, int pageSize) {
    Pageable pageable = (Pageable) PageRequest.of(page - 1, pageSize);
    return studentRepository.findAll(pageable);
  }

  public List<Student> filterStudents(String nameFilter, Integer marksFilter) {
    // Implement your filter logic here
    return studentRepository.findByNameAndTotalMarks(nameFilter, marksFilter);
  }
}
