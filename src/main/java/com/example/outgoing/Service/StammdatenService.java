package com.example.outgoing.Service;

import com.example.outgoing.Entity.Stammdaten;

import java.util.List;

public interface StammdatenService {

    public List<Stammdaten> findAll();

    public Stammdaten findById(Integer id);
//    public Stammdaten findByUsername(String username);

    public Stammdaten save(Stammdaten stammdaten);
    //    public User update(User user);
    public void destroy(Stammdaten stammdaten);
}
