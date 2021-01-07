package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Manager;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.mapper.ManagerMapper;
import cn.edu.shu.xj.ser.mapper.UserMapper;
import cn.edu.shu.xj.ser.service.IManagerService;
import cn.edu.shu.xj.ser.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {
    @Autowired
    ManagerMapper managerMapper;
    public Manager findOneManager(String managerId){ return managerMapper.findOneManager(managerId);}
}
