package com.exemple.todoList.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemple.todoList.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
  //List<Task> findByUser_Id(long id);

  // @Query(value = "SELECT t FROM Task WHERE t.user.id == :id")
  // List<Task> findByUser_Id(@Param("id") long id);

  // @Query(value= "Select * from task Where t.user_id = :id",nativeQuery = true)
  // List<Task> findByUser_Id(@Param("id") long id);



}
