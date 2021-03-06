package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.mapper.UserMapper;
import cn.edu.shu.xj.ser.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;

    public User findOneUserbyId(String userId){ return userMapper.findOneUserbyId(userId);}
    public User findOneUserbyTel(String userTel){ return userMapper.findOneUserbyTel(userTel);}

}
