package com.Dao;

import com.studnet.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentDao extends JpaRepository<StudentEntity,Integer> {
}
