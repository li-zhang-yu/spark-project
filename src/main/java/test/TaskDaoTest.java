package test;

import dao.ITaskDAO;
import dao.factory.DAOFactory;
import entity.Task;

public class TaskDaoTest {

    public static void main(String[] args) {
        ITaskDAO taskDAO = DAOFactory.getTaskDAO();
        Task task = taskDAO.findById(1);
        System.out.println(task.getTaskName());
    }

}
