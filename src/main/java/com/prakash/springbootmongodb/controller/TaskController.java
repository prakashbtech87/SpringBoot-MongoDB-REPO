package com.prakash.springbootmongodb.controller;

import com.prakash.springbootmongodb.model.Task;
import com.prakash.springbootmongodb.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author prakashkaruppusamy
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return service.findAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId) {
        return service.getTaskByTaskId(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> findTaskUsingSeverity(@PathVariable int severity) {
        return service.getTaskBySeverity(severity);
    }

    @GetMapping("/assignee/{assingee}")
    public List<Task> getTaskByAssignee(@PathVariable String assignee) {
        return service.getTasksByAssignee(assignee);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task taskRequest) {
        return service.updateTask(taskRequest);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId) {
        return service.deleteTask(taskId);
    }

}
