package com.sagar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sagar.model.StudentInfo;

@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfo, Long> {

}
