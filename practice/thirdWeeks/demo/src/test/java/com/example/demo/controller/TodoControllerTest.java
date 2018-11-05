package com.example.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TodoControllerTest {

    @Autowired
    private TodoController todoController;

    @Before
    public void setUp() {
        todoController.setUp();
    }

    @Test
    public void test_add_todo() {
        assertThat(todoController.addTodo().getText()).isEqualTo("text1");
    }

    @Test
    public void list_all_todo() {
        assertThat(todoController.getAllTodo().size()).isEqualTo(3);
    }

    @Test
    public void deleteById() {
        todoController.getAllTodo();
        assertThat(todoController.deleteTodoById(1).getId()).isEqualTo(1);
    }

    @Test
    public void deleteTodo() {
        todoController.getAllTodo();
        assertThat(todoController.deleteTodo(0)).isEqualTo(2);
    }

    @Test
    public void modify() {
        todoController.getAllTodo();
        assertThat(todoController.modify(1, "modify").getText()).isEqualTo("modify");
    }

    @Test
    public void filter() {
        todoController.getAllTodo();
        assertThat(todoController.filterByCompleted(true).size()).isEqualTo(3);
        assertThat(todoController.filterByCompleted(false).size()).isEqualTo(0);
    }

}