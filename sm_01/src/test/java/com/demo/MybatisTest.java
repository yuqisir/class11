package com.demo;

import com.itheima.domain.Account;
import com.itheima.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisTest {
    public static void main(String[] args) throws Exception {
        InputStream is = Resources.getResourceAsStream("sqlConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);

        SqlSession session=factory.openSession();
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        Account account = mapper.findById(1);
        System.out.println(account.getName());
    }
}
