package com.yuvaraj.challenge.todo_list_api.Controller;

import com.yuvaraj.challenge.common.ResponseDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.yuvaraj.challenge.todo_list_api.Service.TodoListApiService;
import com.yuvaraj.challenge.todo_list_api.Dto.TodoDTO;


@RestController
@RequestMapping("/api/v1/todo-list")
public class TodoListApiController {

    @Autowired
    private TodoListApiService todoListApiService;

    private final Logger log = LoggerFactory.getLogger(TodoListApiController.class);

    @PostMapping("/add-task")
    private ResponseEntity<ResponseDTO> addTask(@Valid @RequestBody TodoDTO todo) {
        log.info("Add Task Initiated. Req: {}",todo);
        return ResponseEntity.ok(todoListApiService.addTask(todo));
    }

    @GetMapping("/getAllTask")
    private ResponseEntity<ResponseDTO> getTaskList() {
        System.out.println("getAllTask");
        return ResponseEntity.ok(todoListApiService.getTaskList());
    }

    @PutMapping("/{taskId}")
    private ResponseEntity<ResponseDTO> updateTask(@PathVariable @NotBlank String taskId ,
                                                   @Valid @RequestBody TodoDTO todoDTO){
        return ResponseEntity.ok(todoListApiService.updateTask(taskId, todoDTO));
    }

    @DeleteMapping("/{taskId}")
    private ResponseEntity<ResponseDTO> deleteTask(@PathVariable @NotBlank String taskId){
        return ResponseEntity.ok(todoListApiService.deleteTask(taskId));
    }
}
