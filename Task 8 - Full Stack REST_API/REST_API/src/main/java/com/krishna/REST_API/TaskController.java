package com.krishna.REST_API;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController
{
    List<Task> tasks= new ArrayList<>();
    TaskController()
    {
        tasks.add(new Task(1,"Coding","Java"));
        tasks.add(new Task(2,"Sleeping","7 hrs"));
    }
    @GetMapping("/tasks")
    public List<Task> getAllTasks()
    {
        return tasks;
    }
    @PostMapping("tasks/new")
    public Task addTask(@RequestBody Task task)
    {
        tasks.add(task);
        return task;
    }
    @PutMapping("tasks/{id}")
    public boolean updateTask(@PathVariable int id,@RequestBody Task task)
    {
        for(Task t : tasks)
        {
            if(t.id==id) {
                t.title = task.title;
                t.description = task.description;
                return true;
            }
        }
        return false;
    }
    @DeleteMapping("tasks/{id}")
    public boolean updateTask(@PathVariable int id)
    {
        for(Task t : tasks)
        {
            if(t.id==id) {
                tasks.remove(t);
                return true;
            }
        }
        return false;
    }
}
