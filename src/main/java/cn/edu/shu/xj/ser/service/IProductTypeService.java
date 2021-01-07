package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.ProductType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IProductTypeService extends IService<ProductType> {
    public List<ProductType> producttypelist(String shopId);
}
