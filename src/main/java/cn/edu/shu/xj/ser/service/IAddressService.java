package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Address;
import cn.edu.shu.xj.ser.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IAddressService extends IService<Address> {
    public List<Address> userlist(String userId);

}
