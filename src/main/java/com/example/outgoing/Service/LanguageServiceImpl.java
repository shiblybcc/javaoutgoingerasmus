package com.example.outgoing.Service;

import com.example.outgoing.Entity.Language;
import com.example.outgoing.Repository.LanguageRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("languageService")
@Transactional
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Language> findAll() {
        return Lists.newArrayList(languageRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Language findById(Integer id) {
        return languageRepository.findOne(id);
    }

    @Override
    @Transactional
    public Language save(Language language) {
        return languageRepository.save(language);
    }


    @Override
    public void destroy(Language language) {
        languageRepository.delete(language);
    }
}
