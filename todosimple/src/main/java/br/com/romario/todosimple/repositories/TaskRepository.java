package br.com.romario.todosimple.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.romario.todosimple.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    //List<Task> findByUser_id(Long id);

    // @Query(value = "SELECT t FROM Task t WHERE t.user.id = :id")
    // List<Task> findByUserId(@Param("id") Long id);

    @Query(
        value = "SELECT * FROM Task t WHERE t.user_FK = :id"
        ,nativeQuery = true)
    List<Task> findByUserId(@Param("id") Long id);
}
