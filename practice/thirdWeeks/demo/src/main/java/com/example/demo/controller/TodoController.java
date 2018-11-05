package com.example.demo.controller;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/addTodo")
    public Todo addTodo(String text) {
        Todo todo = new Todo(text, false);
        if (todoService.addTodo(todo))
            return todo;
        return null;
    }

    @GetMapping("/listAll")
    public List<Todo> getAllTodo() {
        return todoService.getAllTodo();
    }

    @GetMapping(value = "/findTodo")
    public Todo findTodoById(@RequestParam(value = "id") int id) {
        Todo todo = todoService.findTodoById(id);
        if (null != todo) {
            return todo;
        }
        return null;
    }

    @GetMapping("/deleteTodoById")
    public String deleteTodoById(int id) {
        if (todoService.deleteTodoById(id)) {
            return "delete";
        }
        return "false";
    }

    @PostMapping("/modify")
    public Todo modify(int id, String text) {
        Todo todo = todoService.modify(id, text);
        return todo;
    }

    @GetMapping("filterByCompleted")
    public List<Todo> filterByCompleted(boolean completed) {
        List<Todo> filter = new ArrayList<Todo>();
        filter=todoService.filterByCompleted(completed);
        return filter;
    }
}
