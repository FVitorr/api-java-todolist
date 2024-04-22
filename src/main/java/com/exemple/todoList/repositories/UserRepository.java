package com.exemple.todoList.repositories;

// Importa a interface JpaRepository do Spring Data JPA,
// que fornece métodos CRUD para operações de banco de dados
import org.springframework.data.jpa.repository.JpaRepository;

// Importa a anotação @Repository do Spring,
// que marca esta interface como um componente de repositório gerenciado pelo Spring.
import org.springframework.stereotype.Repository;

import com.exemple.todoList.models.User;

// Declara a interface UserRepository,
// que estende JpaRepository para a entidade User e o tipo da chave primária Long.
@Repository
public interface UserRepository extends JpaRepository<User, Long>{  
  
} 