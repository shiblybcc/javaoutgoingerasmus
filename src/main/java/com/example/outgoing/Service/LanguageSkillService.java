package com.example.outgoing.Service;


import com.example.outgoing.Entity.LanguageProficiencyLevel;
import com.example.outgoing.Entity.LanguageSkill;

import java.util.List;

public interface LanguageSkillService {

    public List<LanguageSkill> findAll();
    public LanguageSkill findById(Integer id);
    public LanguageSkill save(LanguageSkill languageSkill);
    public void destroy(LanguageSkill languageSkill);

}
