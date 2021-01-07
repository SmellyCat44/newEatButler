package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.*;

@Data
@TableName("users")
public class User {
    @TableId(value = "user_id",type = IdType.INPUT) //type = IdType.INPUT,没有的话无法插入主键
    private String userId;//可作邮箱
    private String userPwd;
    private String userName;
    private String sex;
    private String userTel;
    private String email;
    private String userCity;
    //    private Date regTime;
    private String isVip;
    private Date vipDueDate;
    private Double userBalance;
}
