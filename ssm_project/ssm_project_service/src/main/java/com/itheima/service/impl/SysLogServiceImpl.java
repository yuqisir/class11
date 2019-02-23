package com.itheima.service.impl;

import com.itheima.domain.SysLog;
import com.itheima.mapper.SysLogMapper;
import com.itheima.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;
    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogMapper.findAll();
    }

    @Override
    public void saveSysLog(SysLog sysLog) throws Exception {
        sysLogMapper.saveSysLog(sysLog);
    }
}
