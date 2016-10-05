package com.example.outgoing.Service;

import com.example.outgoing.Entity.LanguageProficiencyLevel;
import com.example.outgoing.Entity.LanguageSkill;
import com.example.outgoing.Repository.LanguageProficiencyLevelRepository;
import com.example.outgoing.Repository.LanguageSkillRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("languageSkillService")
@Transactional
public class LanguageSkillServiceImpl implements LanguageSkillService {

    @Autowired
    private LanguageSkillRepository languageSkillRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LanguageSkill> findAll() {
        return Lists.newArrayList(languageSkillRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public LanguageSkill findById(Integer id) {
        return languageSkillRepository.findOne(id);
    }

    @Override
    @Transactional
    public LanguageSkill save(LanguageSkill languageSkill) {
        return languageSkillRepository.save(languageSkill);
    }


    @Override
    public void destroy(LanguageSkill languageSkill) {
        languageSkillRepository.delete(languageSkill);
    }
}
