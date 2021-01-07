package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("shop_account")
public class ShopAccount {
    @TableId(value = "o_id",type = IdType.INPUT)
    private Integer oId;
    private String shopId;
    private Double sIncome;
    private Date sTime;
}
