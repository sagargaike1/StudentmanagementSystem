package com.sagar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.model.StudentInfo;
import com.sagar.model.StudentMarks;
import com.sagar.model.StudentResponse;
import com.sagar.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	//Insert Student Details
	@PostMapping("/details")
	public ResponseEntity<String> insertStudentDetails(@RequestHeader("operation") String operation, 
			@RequestBody List<StudentInfo> studentInfoList) {
		if(operation.equals("insert")) {
			studentService.insertStudentDetails(studentInfoList);
			return new ResponseEntity<String>("2 records inserted successful", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Invalid operation", HttpStatus.BAD_REQUEST);
		}
	}

	//Read Student Details
	@GetMapping("/details")
	public ResponseEntity<List<StudentInfo>> getStudentDetails(@RequestHeader("operation") String operation) {
		if(operation.equals("read")) {
			return new ResponseEntity<List<StudentInfo>>(studentService.getStudentDetails(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<StudentInfo>>(HttpStatus.BAD_REQUEST);
		}
	}

	//Insert Student Marks
	@PostMapping("/marks/detail")
	public ResponseEntity<String> insertStudentMarks(@RequestHeader("operation") String operation,
			@RequestBody StudentMarks studentMarks) {
		if(operation.equals("insert")) {
			boolean isInserted = studentService.insertStudentMarks(studentMarks);
			if(isInserted) {
				return new ResponseEntity<String>("record inserted successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("record insert failed", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<String>("Invalid operation", HttpStatus.BAD_REQUEST);
		}
	}

	//Read Student Details and Marks
	@GetMapping("/details/{id}")
	public ResponseEntity<StudentResponse> getStudentDetailsAndMarks(@RequestHeader("operation") String operation, 
			@PathVariable("id") Long id) {
		if(operation.equals("read")) {
			StudentResponse studentResponse = studentService.getStudentDetailsAndMarks(id);
			if(studentResponse != null) {
				return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.OK);
			} else {
				return new ResponseEntity<StudentResponse>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<StudentResponse>(HttpStatus.BAD_REQUEST);
		}
	}
}




