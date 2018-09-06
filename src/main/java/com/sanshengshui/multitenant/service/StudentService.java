package com.sanshengshui.multitenant.service;

import com.sanshengshui.multitenant.dao.StudentDao;
import com.sanshengshui.multitenant.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> findAll() {
        return studentDao.findAll();
    }

}
