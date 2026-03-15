package com.example.service;

import java.util.*;

import com.example.model.User;

import jakarta.inject.Singleton;

@Singleton
public class UserService {
    private static Map<Integer, User> users = new HashMap<>();
    private static int counter = 1;

    public List <User> getAll(){
        return new ArrayList<>(users.values());
    }

    public User getById(int id){
        return users.get(id);
    }

    public User create(User user){
        user.setId(counter++);
        users.put(user.getId(), user);
        return user;
    }

    public User update(int id, User user){
        user.setId(id);
        users.put(id, user);
        return user;
    }

    public void delete(int id){
        users.remove(id);
    }

    public List<User> searchByName(String name){
        return users
                .values()
                .stream()
                .filter(u -> u.getName().equalsIgnoreCase(name))
                .toList();
    }
}
