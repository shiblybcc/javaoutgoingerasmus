package com.example.outgoing.Service;


import com.example.outgoing.Entity.StammdatenFile;

import java.util.List;

public interface StammdatenFileService {

    public List<StammdatenFile> findAll();
    public StammdatenFile findById(Integer id);
    public StammdatenFile save(StammdatenFile stammdatenFile);
    public void destroy(StammdatenFile stammdatenFile);

}
