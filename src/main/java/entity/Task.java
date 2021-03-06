package entity;

import java.io.Serializable;

/**
 * 任务实体类
 *
 * @author lizhangyu
 * @Date 2019-07-10
 */
public class Task implements Serializable {

    private long taskid;
    private String taskName;
    private String createTime;
    private String startTime;
    private String finishTime;
    private String taskType;
    private String taskStatus;
    private String taskParam;

    public long getTaskid() {
        return taskid;
    }

    public void setTaskid(long taskid) {
        this.taskid = taskid;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskParam() {
        return taskParam;
    }

    public void setTaskParam(String taskParam) {
        this.taskParam = taskParam;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskid=" + taskid +
                ", taskName='" + taskName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", taskType='" + taskType + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskParam='" + taskParam + '\'' +
                '}';
    }

}
