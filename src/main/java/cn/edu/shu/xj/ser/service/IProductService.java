package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Address;
import cn.edu.shu.xj.ser.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IProductService extends IService<Product> {
//    public boolean changeProduct(Product product);
    public Product productdetailbyId(String productId);
    public double findPrice(Integer productId);
    public List<Product> productlist(String shopId);
}
