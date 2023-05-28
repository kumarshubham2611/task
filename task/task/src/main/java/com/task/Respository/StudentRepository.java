package com.task.Respository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.task.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByNameIgnoreCase(String name);

	

	List<Student> findByNameAndTotalMarks(String nameFilter, Integer marksFilter);



	Page<Student> findAll(Pageable pageable);

}
