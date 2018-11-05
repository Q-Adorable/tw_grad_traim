package com.example.demo.service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo findTodoById(int id){
        Todo todo=null;
        try{
            todo=todoRepository.findById(id).get();
        }catch (Exception e){}
        return todo;
    }

    public List<Todo> getAllTodo(){
        List<Todo> listTodo=new ArrayList<Todo>();
        listTodo=todoRepository.findAll();
        return listTodo;
    }

    public boolean addTodo(Todo todo){
        int size=todoRepository.findAll().size();
        todoRepository.save(todo);
        int length=todoRepository.findAll().size();
        if((length-size)==1){
            return true;
        }
        return false;
    }

    public boolean deleteTodoById(int id){
        int size=todoRepository.findAll().size();
        todoRepository.deleteById(id);
        int length=todoRepository.findAll().size();
        if((size-length)==1){
            return true;
        }
        return false;
    }

    public Todo modify(int id,String text){
        Todo todo=null;
        todo=todoRepository.findById(id).get();
        if(todo!=null){
            todo.setText(text);
            todoRepository.save(todo);
        }
        return todo;
    }

    public List<Todo> filterByCompleted(boolean completed){
        List<Todo> list=new ArrayList<Todo>();
        list=todoRepository.findByCompleted(completed);
        return list;
    }
}
