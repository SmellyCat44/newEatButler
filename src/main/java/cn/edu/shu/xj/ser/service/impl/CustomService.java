package cn.edu.shu.xj.ser.service.impl;


import cn.edu.shu.xj.ser.entity.Custom;
import cn.edu.shu.xj.ser.entity.Student;
import cn.edu.shu.xj.ser.mapper.CustomMapper;
import cn.edu.shu.xj.ser.mapper.StudentMapper;
import cn.edu.shu.xj.ser.service.ICustomService;
import cn.edu.shu.xj.ser.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomService extends ServiceImpl<CustomMapper, Custom> implements ICustomService {

    @Autowired
    CustomService customService;

}
