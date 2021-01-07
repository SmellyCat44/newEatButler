package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.awt.*;

@Data
@TableName("products")
public class Product {
    @TableId(value = "p_id",type = IdType.INPUT)
    private Integer pId;
    private Integer typeId;
    private String productName;
    private Double productPrice;
    private Image productImage;
    private String shopId;
}
