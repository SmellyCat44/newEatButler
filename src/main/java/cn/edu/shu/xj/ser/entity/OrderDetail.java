package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("orderdetail")
public class OrderDetail {
    @TableId(value = "o_id",type = IdType.INPUT)
    private Integer oId;
    private Integer productId;
    private Integer amt;
    private Double finalPrice;
    private String productName;
}