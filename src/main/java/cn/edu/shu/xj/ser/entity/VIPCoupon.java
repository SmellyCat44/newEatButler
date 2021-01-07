package cn.edu.shu.xj.ser.entity;

import lombok.Data;

import java.util.Date;

@Data
public class VIPCoupon {
    private String vcId;
    private Date vcStart;
    private Date vcDue;
}
