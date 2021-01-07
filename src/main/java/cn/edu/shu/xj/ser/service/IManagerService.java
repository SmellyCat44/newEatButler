package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Manager;
import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IManagerService extends IService<Manager> {

    public Manager findOneManager(String managerId);
}
