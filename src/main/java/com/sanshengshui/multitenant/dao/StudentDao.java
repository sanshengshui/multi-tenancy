package com.sanshengshui.multitenant.dao;


import com.sanshengshui.multitenant.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {}
