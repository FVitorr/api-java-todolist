package com.exemple.todoList.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.exemple.todoList.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
 
}
