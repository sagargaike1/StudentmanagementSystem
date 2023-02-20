package com.sagar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sagar.model.StudentMarks;

@Repository
public interface StudentMarksRepository  extends JpaRepository<StudentMarks, Long>{

}
