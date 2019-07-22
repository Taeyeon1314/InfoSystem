package cn.zh.dao;


import cn.zh.pojo.Info;

import java.util.List;

public interface InfoDao {

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    Info findInfoById(Integer id);

    /**
     * 查询所有的用户信息
     *
     * @return
     */
    List<Info> findAll();

    /**
     * 通过用户id删除用户信息
     *
     * @param id
     * @return
     */
    int delInfoById(Integer id);

    /**
     * 添加用户信息
     *
     * @param info
     * @return
     */
    int addInfo(Info info);

    /**
     * 根据id修改用户信息
     *
     * @param info
     * @return
     */
    int updateInfo(Info info);
}
