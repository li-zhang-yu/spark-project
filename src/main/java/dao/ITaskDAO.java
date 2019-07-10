package dao;


import entity.Task;

/**
 * 任务管理DAO接口
 */
public interface ITaskDAO {

    /**
     * 根据主键查询任务
     *
     * @param taskid
     * @return
     */
    Task findById(long taskid);

}
