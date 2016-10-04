package com.example.outgoing.Controller;

import com.example.outgoing.Entity.Language;
import com.example.outgoing.Entity.Stammdaten;
import com.example.outgoing.Service.LanguageService;
import com.example.outgoing.Service.StammdatenService;
import com.example.outgoing.Utility.ApplicationHelpers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ManagedBean
@ViewScoped
public class LanguageController implements Serializable {

    @ManagedProperty("#{languageService}")
    LanguageService languageService;

    private Language language = new Language();
    private List<Language> languages;

    public List<Language> index(){
        languages = languageService.findAll();
        return languages;
    }

    public Language show(){
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        Integer stammdaten_id = Integer.valueOf(params.get("id"));

        language = languageService.findById(stammdaten_id);
        return language;
    }

    public void create(){
        languageService.save(language);
        FacesContext fc = FacesContext.getCurrentInstance();
        ApplicationHelpers.setSuccessMessage("Language created successfully", null);
    }

    @PostConstruct
    public void init() {
        languages = languageService.findAll();
    }

    public LanguageService getLanguageService() {
        return languageService;
    }

    public void setLanguageService(LanguageService languageService) {
        this.languageService = languageService;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
}
