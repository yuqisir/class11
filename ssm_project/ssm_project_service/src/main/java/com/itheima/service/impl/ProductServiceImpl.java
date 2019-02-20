package com.itheima.service.impl;

import com.itheima.domain.Product;
import com.itheima.mapper.ProductMapper;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() throws Exception {

        return productMapper.findAll();
    }

    @Override
    public void deleteAll(String[] ids) throws Exception {
        productMapper.deleteAll(ids);
    }
}
