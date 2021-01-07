package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Product;
import cn.edu.shu.xj.ser.mapper.ProductMapper;
import cn.edu.shu.xj.ser.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Autowired
    ProductMapper productMapper;
    public double findPrice(Integer productId){
    return productMapper.findPrice(productId);
}
    public Product productdetailbyId(String productId){
        return productMapper.productdetaibyId(productId);
    }
    public List<Product> productlist(String shopId){
        return productMapper.productlist(shopId);
    }
}