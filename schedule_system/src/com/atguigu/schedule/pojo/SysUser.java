package com.atguigu.schedule.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * 1. 实体类的类名应该和表的名称对应
 * 2. 实体类的属性名应该和表的列名对应
 * 3. 每个属性必须是私有的
 * 4. 每个属性都应具备 getter & setter
 * 5. 必须具备无参构造器
 * 6. 应该实现序列化接口(缓存, 分布式项目数据传递, 可能会将对象序列化)
 * 7. 应该重写类的 hashcode 和 equals 方法
 * 8. toString 是否重写均可以
 *
 * */
@AllArgsConstructor // 添加全参构造器
@NoArgsConstructor // 添加无参构造器
@Data // 相当于添加了 getter, setter, hashcode, equal, toString
public class SysUser implements Serializable {

    private Integer uid;
    private String username;
    private String userPwd;


}
