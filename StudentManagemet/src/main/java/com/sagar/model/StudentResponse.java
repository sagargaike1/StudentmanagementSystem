package com.sagar.model;

public class StudentResponse {

	private StudentInfo studentInfo;
	private StudentMarks studentMarks;

	public StudentResponse(StudentInfo studentInfo, StudentMarks studentMarks) {
		this.studentInfo = studentInfo;
		this.studentMarks = studentMarks;
	}

}
