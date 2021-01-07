package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Address;
import cn.edu.shu.xj.ser.mapper.AddressMapper;
import cn.edu.shu.xj.ser.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService extends ServiceImpl<AddressMapper, Address> implements IAddressService {
    @Autowired
    AddressMapper addressMapper;

    public List<Address> userlist(String userId){
        return addressMapper.userlist(userId);
    }
}