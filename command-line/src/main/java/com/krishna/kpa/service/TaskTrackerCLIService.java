package com.krishna.kpa.service;

import com.krishna.kpa.data.DummyDevData;
import com.krishna.kpa.dto.TaskDTO;
import com.krishna.kpa.enums.TaskStatus;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Service this will be handling all the api calls
 *
 * @author Krishna Prasad A
 */
public class TaskTrackerCLIService {

    public List<TaskDTO> getAllTask(Integer id, TaskStatus status, Set<Integer> ids) {
        // Task getting logic needed
        List<TaskDTO> tasks = status == null
                ? DummyDevData.TASKS
                : DummyDevData.TASKS.stream().filter(x -> x.getStatus() == status).toList();
        List<TaskDTO> tasks2 = id == null ?
                tasks
                : tasks.stream().filter(x -> Objects.equals(x.getId(), id)).toList();
        List<TaskDTO> task3 = ids == null
                ? tasks2
                : tasks2.stream().filter(x -> ids.contains(x.getId())).toList();

        return task3;
    }

    public boolean createTask(TaskDTO taskDTO) {
        DummyDevData.TASKS.add(taskDTO);
        return true;
    }

    public boolean updateTask(int taskId, TaskDTO updatedTask) {
        return true;
    }

    public boolean deleteTask(Integer taskId) {
        return true;
    }
}
