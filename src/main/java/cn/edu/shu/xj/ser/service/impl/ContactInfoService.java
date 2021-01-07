package cn.edu.shu.xj.ser.service.impl;


import cn.edu.shu.xj.ser.entity.ContactInfo;
import cn.edu.shu.xj.ser.entity.Student;
import cn.edu.shu.xj.ser.mapper.ContactInfoMapper;
import cn.edu.shu.xj.ser.mapper.StudentMapper;
import cn.edu.shu.xj.ser.service.IContactInfoService;
import cn.edu.shu.xj.ser.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactInfoService extends ServiceImpl<ContactInfoMapper, ContactInfo> implements IContactInfoService {

    @Autowired
    ContactInfoMapper contactInfoMapper;



}
