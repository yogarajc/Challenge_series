package com.yuvaraj.challenge.todo_list_api.Service;

import com.yuvaraj.challenge.common.ResponseDTO;
import com.yuvaraj.challenge.todo_list_api.Dto.TodoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;

@Service
public class TodoListApiService {

    private final HashMap<String, TodoDTO> todoMap = new HashMap<>();
    private final HashMap<String, TodoDTO> todoHistoryMap = new HashMap<>();

    private final Logger log = LoggerFactory.getLogger(TodoListApiService.class);

    public ResponseDTO addTask(TodoDTO todo){

        String resultMsg;
        try{
            if(!todoMap.containsKey(todo.getId())){
                todo.setCreatedAt(todo.getCreatedAt() != null ? todo.getCreatedAt() : LocalDateTime.now());
                todo.setStatus(todo.getStatus() != null ? todo.getStatus() : "Open");
                todoMap.put(todo.getId(), todo);
                resultMsg = todo.getTitle()+" added Successfully.";
            }else
                resultMsg = todo.getTitle() + " task already added.";
        }
        catch (Exception e){
            resultMsg = e.getMessage();
        }
        return new ResponseDTO(resultMsg);
    }

    public ResponseDTO getTaskList(){

        if(!todoMap.isEmpty())
            return new ResponseDTO("Success",todoMap.values().toArray());
        else return new ResponseDTO("No Data Found");
    }

    public ResponseDTO updateTask(String taskId, TodoDTO todoDTO){

        if (todoMap.containsKey(taskId)){
            if (!taskId.equals(todoDTO.getId()))
                throw new RuntimeException("Task Id and Object Id Values must be same");

            todoHistoryMap.put(taskId, (todoMap.put(taskId, todoDTO)));
            return new ResponseDTO("Task Id: "+taskId+" Successfully Updated");
        } else return new ResponseDTO("Task id not in the present List");
    }

    public ResponseDTO deleteTask(String taskId){

        if (todoMap.containsKey(taskId)){
            todoHistoryMap.put(taskId, (todoMap.remove(taskId)));

            return new ResponseDTO("Task Id: "+taskId+" Successfully Deleted");
        } else return new ResponseDTO("Task id not in the present List");
    }

}