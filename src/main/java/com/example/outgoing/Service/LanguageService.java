package com.example.outgoing.Service;


import com.example.outgoing.Entity.Address;
import com.example.outgoing.Entity.Language;

import java.util.List;

public interface LanguageService {

    public List<Language> findAll();
    public Language findById(Integer id);
    public Language save(Language language);
    public void destroy(Language language);

}
