package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.RiderAccount;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IRiderAccountService extends IService<RiderAccount> {
    public List<RiderAccount> riderBalanceDetail(String riderId);
}
