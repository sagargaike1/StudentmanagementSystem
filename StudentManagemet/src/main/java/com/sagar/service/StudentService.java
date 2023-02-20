package com.sagar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.DAO.StudentInfoRepository;
import com.sagar.DAO.StudentMarksRepository;
import com.sagar.model.StudentInfo;
import com.sagar.model.StudentMarks;
import com.sagar.model.StudentResponse;


@Service
public class StudentService {

	@Autowired
	private StudentInfoRepository studentInfoRepository;

	@Autowired
	private StudentMarksRepository studentMarksRepository;

	
	public void insertStudentDetails(List<StudentInfo> studentInfoList) {
		studentInfoRepository.saveAll(studentInfoList);
	}

	//Read Student Details
	public List<StudentInfo> getStudentDetails() {
		return studentInfoRepository.findAll();
	}

	//Insert Student Marks
	public boolean insertStudentMarks(StudentMarks studentMarks) {
		if(studentInfoRepository.existsById(studentMarks.getId())) {
			studentMarksRepository.save(studentMarks);
			return true;
		} else {
			return false;
		}
	}

	//Read Student Details and Marks
	public StudentResponse getStudentDetailsAndMarks(Long id) {
		Optional<StudentInfo> studentInfoOpt = studentInfoRepository.findById(id);
		if(studentInfoOpt.isPresent()) {
			StudentInfo studentInfo = studentInfoOpt.get();
			Optional<StudentMarks> studentMarksOpt = studentMarksRepository.findById(id);
			if(studentMarksOpt.isPresent()) {
				StudentMarks studentMarks = studentMarksOpt.get();
				return new StudentResponse(studentInfo, studentMarks);
			} else {
				return new StudentResponse(studentInfo, null);
			}
		} else {
			return null;
		}
	}
}
