package com.itheima.mapper;

import com.itheima.domain.SysLog;

import java.util.List;

public interface SysLogMapper {
    List<SysLog> findAll() throws Exception;

    void saveSysLog(SysLog sysLog) throws Exception;
}
