package com.exemple.todoList.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.todoList.models.Task;
import com.exemple.todoList.models.User;
import com.exemple.todoList.repositories.TaskRepository;
import com.exemple.todoList.repositories.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Null;

@Service
public class TaskService {
  @Autowired
  private TaskRepository taskRepository;

  @Autowired
  private UserService userService;

  public Task findById(Long id){
    Optional<Task> task = this.taskRepository.findById(id);
    return task.orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
  }

  @Transactional // Importante em persistencia
  public Task create(Task obj){
    User user = this.userService.findById(obj.getUser().getId());
    //obj.setId(null);
    obj.setUser(user);
    obj = this.taskRepository.save(obj);
    return obj;
  }

  @Transactional
  public Task update(Task obj){
    Task newObj = findById(obj.getId());
    newObj.setDescription(obj.getDescription());
    newObj.setDate(obj.getDate());
    return this.taskRepository.save(newObj);
  }

  @Transactional
  public void delete (Long id){
    Task newObj = findById(id);
    try{
      this.taskRepository.deleteById(id);
    }catch(Exception e){
      throw new RuntimeException("Há entidades relacionadas, impossivel excluir");
    }
  }
}

