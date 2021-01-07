package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.RiderAccount;
import cn.edu.shu.xj.ser.mapper.RiderAccountMapper;
import cn.edu.shu.xj.ser.service.IRiderAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderAccountService extends ServiceImpl<RiderAccountMapper, RiderAccount> implements IRiderAccountService {
    @Autowired
    RiderAccountMapper riderAccountMapper;
    public List<RiderAccount> riderBalanceDetail(String riderId){
        return riderAccountMapper.riderBalanceDetail(riderId);
    }
}
