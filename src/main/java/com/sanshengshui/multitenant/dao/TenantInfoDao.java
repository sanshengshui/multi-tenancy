package com.sanshengshui.multitenant.dao;

import com.sanshengshui.multitenant.entity.TenantInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantInfoDao extends JpaRepository<TenantInfo, Integer> {
}
