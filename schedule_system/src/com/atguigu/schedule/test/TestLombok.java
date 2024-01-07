package com.atguigu.schedule.test;

import com.atguigu.schedule.pojo.SysUser;

public class TestLombok {

    public void testAnnotation() {
        SysUser sysUser = new SysUser(1, "", "");
        System.out.println("toString: " + sysUser.toString());
    }
}
