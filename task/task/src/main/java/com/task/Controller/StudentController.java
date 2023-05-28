package com.task.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.task.Student;
import com.task.Respository.StudentRepository;
import com.task.Service.StudentService;

import ch.qos.logback.core.model.Model;

import java.awt.print.Pageable;
import java.util.List;


import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class StudentController {

  @Autowired
  private StudentRepository studentRepository;

  @GetMapping("/students")
  public String showStudents(@RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "10") int pageSize,
                             org.springframework.ui.Model model) {
    Pageable pageable = (Pageable) PageRequest.of(page - 1, pageSize);
    Page<Student> studentPage = studentRepository.findAll(pageable);
    List<Student> students = studentPage.getContent();
    int totalPages = studentPage.getTotalPages();

    model.addAttribute("students", students);
    model.addAttribute("totalPages", totalPages);
    model.addAttribute("currentPage", page);

    return "students";
  }

  @PostMapping("/students")
  public String addStudent(@ModelAttribute Student student) {
    studentRepository.save(student);
    return "redirect:/students";
  }

  @GetMapping("/filter")
  public String filterStudents(@RequestParam("nameFilter") String nameFilter,
                               @RequestParam("marksFilter") Integer marksFilter,
                               org.springframework.ui.Model model) {
    List<Student> filteredStudents = studentRepository.findByNameAndTotalMarks(nameFilter, marksFilter);

    model.addAttribute("students", filteredStudents);
    model.addAttribute("totalPages", 1);
    model.addAttribute("currentPage", 1);

    return "students";
  }
}


