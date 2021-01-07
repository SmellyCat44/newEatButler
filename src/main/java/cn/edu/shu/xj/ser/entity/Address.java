package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("addrinfo")
public class Address {
    @TableId(value = "address_id",type = IdType.INPUT)
    private String addressId;
    private String userId;
    private String province;
    private String city;
    private String region;
    private String address;
    private String linkman;
    private String tel;
}
