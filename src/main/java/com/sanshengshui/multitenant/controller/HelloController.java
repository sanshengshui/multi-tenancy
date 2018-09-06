package com.sanshengshui.multitenant.controller;


import com.sanshengshui.multitenant.config.ConstId;
import com.sanshengshui.multitenant.dao.TenantInfoDao;
import com.sanshengshui.multitenant.entity.TenantInfo;
import com.sanshengshui.multitenant.service.StudentService;
import com.sanshengshui.multitenant.tenant.TenantDataSourceProvider;
import com.sanshengshui.multitenant.util.Result;
import com.sanshengshui.multitenant.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HelloController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TenantInfoDao tenantInfoDao;

    @RequestMapping
    public Result hello() {
        List<TenantInfo> tenantInfoList = tenantInfoDao.findAll();
        for (TenantInfo info : tenantInfoList) {
            TenantDataSourceProvider.addDataSource(info);
        }
        return ResultGenerator.genSuccessResult(tenantInfoList);
    }

    @RequestMapping("login")
    public Result login(@Param("t") String t) {
        ConstId.Id = t;
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("select")
    public Result getStudent(@Param("t") String t) {
        return ResultGenerator.genSuccessResult(studentService.findAll());
    }

}
