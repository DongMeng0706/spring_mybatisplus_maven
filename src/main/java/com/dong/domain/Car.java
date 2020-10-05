package com.dong.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:dm
 * @Date:2020/10/5 12:52
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_car")
public class Car {

    @TableId(value = "carnumber", type = IdType.INPUT)
    private String carnumber;
    private String carname;
    private String address;
}
