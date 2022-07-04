package com.zensar.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.springbootdemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

//	List<Student> getByStudentName(String studentName);
//	List<Student> findByStudentName(String studentName);
//	List<Student> readByStudentName(String studentName);
	
//	List<Student> getByStudentNameAndStudentAge(String studentName, int age);
	@Query(value = "select * from student where student_name=:name", nativeQuery = true)
	List<Student> test(@Param("name")String studentName);
	
	@Query("from Student s where s.studentName=:name and s.studentAge=:age")
	List<Student> test1(@Param("name")String studentName,@Param("age") int age);

	
	

}
