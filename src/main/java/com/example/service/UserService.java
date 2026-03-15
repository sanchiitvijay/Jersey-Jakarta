package com.example.service;

import java.util.*;

import com.example.config.JPAUtil;
import com.example.model.User;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;

@Singleton
public class UserService {

    public List <User> getAll(){

        EntityManager em = JPAUtil.getEntityManager();

        List<User> userList = em.createQuery("from User", User.class).getResultList();

        em.close();
        return userList;
    }

    public User getById(int id){
        EntityManager em = JPAUtil.getEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    public User create(User user){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        return user;
    }

    public User update(int id, User user){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        User existing = em.find(User.class, id);
        if (existing == null) {
            em.getTransaction().commit();
            em.close();
            return null;
        }
        existing.setName(user.getName());
        em.merge(existing);
        em.getTransaction().commit();
        em.close();
        return existing;
    }

    public void delete(int id){
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        User user = em.find(User.class,id);

        if(user!=null){
            em.remove(user);
        }

        em.getTransaction().commit();

        em.close();
    }

    public List<User> searchByName(String name){

        EntityManager em = JPAUtil.getEntityManager();
        List<User> users = em.createQuery("from User", User.class).getResultList();
        em.close();
        return users;
    }
}
