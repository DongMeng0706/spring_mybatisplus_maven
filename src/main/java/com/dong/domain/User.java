package com.dong.domain;

/**
 * @Author:dm
 * @Date:2020/10/5 11:28
 * @Description:
 */
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "address")
    private String address;
    @TableField(value = "birthday")
    private Date birthday;

}
