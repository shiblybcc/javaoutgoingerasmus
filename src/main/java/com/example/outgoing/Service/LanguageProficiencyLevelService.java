package com.example.outgoing.Service;


import com.example.outgoing.Entity.Language;
import com.example.outgoing.Entity.LanguageProficiencyLevel;

import java.util.List;

public interface LanguageProficiencyLevelService {

    public List<LanguageProficiencyLevel> findAll();
    public LanguageProficiencyLevel findById(Integer id);
    public LanguageProficiencyLevel save(LanguageProficiencyLevel languageProficiencyLevel);
    public void destroy(LanguageProficiencyLevel languageProficiencyLevel);

}
