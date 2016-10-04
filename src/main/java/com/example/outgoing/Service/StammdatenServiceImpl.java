package com.example.outgoing.Service;

import com.example.outgoing.Entity.Stammdaten;
import com.example.outgoing.Entity.User;
import com.example.outgoing.Repository.StammdatenRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("stammdatenService")
@Transactional
public class StammdatenServiceImpl implements StammdatenService {

    @Autowired
    private StammdatenRepository stammdatenRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Stammdaten> findAll() {
        return Lists.newArrayList(stammdatenRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Stammdaten findById(Integer id) {
        return stammdatenRepository.findOne(id);
    }

    @Override
    @Transactional
    public Stammdaten save(Stammdaten stammdaten) {
        return stammdatenRepository.save(stammdaten);
    }


    @Override
    public void destroy(Stammdaten stammdaten) {
        stammdatenRepository.delete(stammdaten);
    }
}
