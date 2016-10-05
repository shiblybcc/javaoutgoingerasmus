package com.example.outgoing.Service;

import com.example.outgoing.Entity.Address;
import com.example.outgoing.Entity.StammdatenFile;
import com.example.outgoing.Repository.AddressRepository;
import com.example.outgoing.Repository.StammdatenFileRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("stammdatenFileService")
@Transactional
public class StammdatenFileServiceImpl implements StammdatenFileService {

    @Autowired
    private StammdatenFileRepository stammdatenFileRepository;

    @Override
    @Transactional(readOnly = true)
    public List<StammdatenFile> findAll() {
        return Lists.newArrayList(stammdatenFileRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public StammdatenFile findById(Integer id) {
        return stammdatenFileRepository.findOne(id);
    }

    @Override
    @Transactional
    public StammdatenFile save(StammdatenFile stammdatenFile) {
        return stammdatenFileRepository.save(stammdatenFile);
    }


    @Override
    public void destroy(StammdatenFile stammdatenFile) {
        stammdatenFileRepository.delete(stammdatenFile);
    }
}
