package cn.edu.shu.xj.ser.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Coupon {
    private Integer cId;
    private String shopId;
    private Integer oId;
    private Double cMon;
    private Date cStartDate;
    private Date cEndDate;
}
