package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.ProductType;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.mapper.ProductTypeMapper;
import cn.edu.shu.xj.ser.service.IProductTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {
    @Autowired
    ProductTypeMapper producttypeMapper;

    public List<ProductType> producttypelist(String shopId){
        return producttypeMapper.producttypelist(shopId);
    }
}