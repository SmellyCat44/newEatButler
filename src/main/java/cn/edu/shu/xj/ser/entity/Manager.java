package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Manager {
    @TableId(value = "manager_id",type = IdType.INPUT)
    private String managerId;
    private String managerPwd;
    private String managerName;
}
