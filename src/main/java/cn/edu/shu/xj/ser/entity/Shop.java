package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.awt.*;

@Data
@TableName("shop")
public class Shop {
    @TableId(value = "shop_id",type = IdType.INPUT) //type = IdType.INPUT,没有的话无法插入主键
    private String shopId;
    private String shopName;
    private String shopBriefintro;
    private String shopAddress;
    private String shkperName;
    private String shopPwd;
    private String shkperTel;
    private String shopBalance;
    private String shopPortrait;
    private Image shopImage;
    private Integer shopAverage;
    private Double shopRank;
}
