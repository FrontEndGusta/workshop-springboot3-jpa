package com.estudos.course.services;

import com.estudos.course.entities.User;
import com.estudos.course.repository.UserRepository;
import com.estudos.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow( () -> new ResourceNotFoundException(id));
    }
    public User insert(User obj) {
       return repository.save(obj);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User obj) {
        //monitora o obj com jpa, prepara o obj sem ir no banco de daoos
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
