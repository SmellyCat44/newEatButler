package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;

@Data
@TableName("orders")
public class Order {
    @TableId(value = "o_id",type = IdType.INPUT)
    private Integer oId;
    private String userId;
    private Integer addressId;
    private Double row;
    private Double mon;
    private String orderStatus;
    private String riderId;
    private String shopId;
    private String shopAddress;
    private String userAddress;
    private String province;
    private String city;
    private String region;
    private String address;
    private String linkman;
    private String tel;
    private Date orderTime;
    private String shkperTel;
    private String shopName;
    private Date takeTime;
    private Date arriveTime;
}