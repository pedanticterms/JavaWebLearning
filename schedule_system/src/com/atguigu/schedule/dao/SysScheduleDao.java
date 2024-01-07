package com.atguigu.schedule.dao;

import com.atguigu.schedule.pojo.SysSchedule;

import java.util.List;

/**
 *
 *
 * */
public interface SysScheduleDao {

    /**
     * 用于向数据库中增加一条日程记录
     * @param schedule 日程数据一 SysSchedule 实体类对象形式入参
     * @return 返回影响数据库记录的行数,行数为 0 表示增加失败,行数 > 0 说明增加成功
     */
    public int addSchedule(SysSchedule schedule);

    /**
     * 查询所有用户的日程
     * @return 将所有日程放入 List<SysSchedule>
     */
    List<SysSchedule> findAll();
}
