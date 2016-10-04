package com.example.outgoing.Service;

import com.example.outgoing.Entity.Language;
import com.example.outgoing.Entity.LanguageProficiencyLevel;
import com.example.outgoing.Repository.LanguageProficiencyLevelRepository;
import com.example.outgoing.Repository.LanguageRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("languageProficiencyLevelService")
@Transactional
public class LanguageProficiencyLevelServiceImpl implements LanguageProficiencyLevelService {

    @Autowired
    private LanguageProficiencyLevelRepository languageProficiencyLevelRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LanguageProficiencyLevel> findAll() {
        return Lists.newArrayList(languageProficiencyLevelRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public LanguageProficiencyLevel findById(Integer id) {
        return languageProficiencyLevelRepository.findOne(id);
    }

    @Override
    @Transactional
    public LanguageProficiencyLevel save(LanguageProficiencyLevel languageProficiencyLevel) {
        return languageProficiencyLevelRepository.save(languageProficiencyLevel);
    }


    @Override
    public void destroy(LanguageProficiencyLevel languageProficiencyLevel) {
        languageProficiencyLevelRepository.delete(languageProficiencyLevel);
    }
}
