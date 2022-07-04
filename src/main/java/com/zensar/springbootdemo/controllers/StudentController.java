package com.zensar.springbootdemo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springbootdemo.dto.StudentDto;
import com.zensar.springbootdemo.entity.Student;
import com.zensar.springbootdemo.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/student-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
//@RequestMapping(value = "/student-api")
public class StudentController {

	// http://localhost:9999/student-api/students

	@Autowired
	private StudentService studentService;

	// http://localhost:9999/students

//	@RequestMapping("/students/{studentId}")
	@Operation
	@GetMapping(value = "/students/{studentId}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable("studentId") int studentId) {
		return new ResponseEntity<StudentDto>(studentService.getStudent(studentId), HttpStatus.OK);

	}
	@GetMapping(value = "/mystudents/{studentId}")
	public ResponseEntity<StudentDto> getMyStudent(@PathVariable("studentId") int studentId) {
		return new ResponseEntity<StudentDto>(studentService.getStudent(studentId), HttpStatus.OK);
	}
	

//	@RequestMapping(value = {"/students","/ListOfstudents"},method = RequestMethod.GET)
	@GetMapping(value = { "/students", "/listOfStudents" })
	public ResponseEntity<List<StudentDto>> getAllStudents(
			@RequestParam(value = "pageNumber", required = false, defaultValue ="0") int pageNumber,
			@RequestParam(value ="pageSize",required=false,defaultValue="5") int pageSize,
			@RequestParam(value = "sortBy",required=false, defaultValue = "studentName")String sortBy,
			@RequestParam(value = "dir",required = false, defaultValue = "ASC")Direction dir) {
		return new ResponseEntity<List<StudentDto>>(studentService.getAllStudents(pageNumber, pageSize,sortBy,dir), HttpStatus.OK);
	}

//	@RequestMapping(value = {"/students","/ListOfstudents"}, method = RequestMethod.POST)
	@PostMapping(value = "/students")
	public ResponseEntity<StudentDto> insertStudent(@RequestBody StudentDto studentDto) {

		return new ResponseEntity<StudentDto>(studentService.insertStudents(studentDto), HttpStatus.CREATED);

	}

//	@RequestMapping(value = "students/{studentId}",method = RequestMethod.PUT)
	@PutMapping(value = "students/{studentId}")
	public ResponseEntity<String> updateStudent(@PathVariable("studentId") int studentId,
			@RequestBody StudentDto studentDto) {
		studentService.updateStudent(studentId, studentDto);
		return new ResponseEntity<String>("Student Updated Successfully!!!", HttpStatus.OK);
	}

	// http://localhost:9999/students--> Delete
//	@RequestMapping(value = "/students/{studentId}", method = RequestMethod.DELETE)
	// @RequestMapping(value="/students/{studentId}",method=RequestMethod.DELETE)
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId) {
		studentService.deleteStudent(studentId);
		return new ResponseEntity<String>("Student Deleted Successfully", HttpStatus.OK);

	}

	@GetMapping("/students/studentname/{studentName}")
	public ResponseEntity<List<StudentDto>> getByStudentName(@PathVariable("studentName") String studentName) {
		return new ResponseEntity<List<StudentDto>>(studentService.getByStudentName(studentName), HttpStatus.OK);
	}

	@GetMapping("/students/{studentName}/{studentAge}")
	public ResponseEntity<List<StudentDto>> findByStudentNameAndStudentAge(
			@PathVariable("studentName") String studentName, @PathVariable("studentAge") int age) {
		return new ResponseEntity<List<StudentDto>>(studentService.findByStudentNameAndStudentAge(studentName, age),
				HttpStatus.OK);
	}
}
