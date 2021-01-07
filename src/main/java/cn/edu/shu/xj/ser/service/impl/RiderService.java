package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Rider;
import cn.edu.shu.xj.ser.entity.Shop;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.mapper.RiderMapper;
import cn.edu.shu.xj.ser.mapper.UserMapper;
import cn.edu.shu.xj.ser.service.IRiderService;
import cn.edu.shu.xj.ser.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiderService extends ServiceImpl<RiderMapper, Rider> implements IRiderService {
    @Autowired
    RiderMapper riderMapper;
    public Rider findOneRiderbyId(String riderId){ return riderMapper.findOneRiderbyId(riderId); }
    public Rider findOneRiderbyTel(String riderTel){ return riderMapper.findOneRiderbyTel(riderTel); }
}
