package br.com.romario.todosimple.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.romario.todosimple.models.Task;
import br.com.romario.todosimple.models.User;
import br.com.romario.todosimple.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public Task findById(Long id) {
        Optional<Task> obj = taskRepository.findById(id);
        return obj.orElseThrow(() -> new  RuntimeException(
            "Tarefa não encontrado! Id: " + id + ", Tipo: " + Task.class.getName()
        ));
    }

    public List<Task> findAllByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    @Transactional
    public Task create(Task obj) {
        User user = userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(user);
        taskRepository.save(obj);
        return taskRepository.save(obj);
    }

    @Transactional
    public Task update(Task obj) {
        Task newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        return taskRepository.save(newObj);
    }

    public void delete(Long id) {
        Task obj = findById(id);
        taskRepository.delete(obj);
    }
}   

