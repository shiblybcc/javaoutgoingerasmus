package com.example.outgoing.Controller;

import com.example.outgoing.Entity.Language;
import com.example.outgoing.Entity.LanguageProficiencyLevel;
import com.example.outgoing.Service.LanguageProficiencyLevelService;
import com.example.outgoing.Service.LanguageService;
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
public class LanguageProficiencyController implements Serializable {

    @ManagedProperty("#{languageProficiencyLevelService}")
    LanguageProficiencyLevelService languageProficiencyLevelService;

    private LanguageProficiencyLevel languageProficiencyLevel = new LanguageProficiencyLevel();
    private List<LanguageProficiencyLevel> languageProficiencyLevels;

    public List<LanguageProficiencyLevel> index(){
        languageProficiencyLevels = languageProficiencyLevelService.findAll();
        return languageProficiencyLevels;
    }

    public LanguageProficiencyLevel show(){
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        Integer proficiency_level_id = Integer.valueOf(params.get("id"));

        languageProficiencyLevel = languageProficiencyLevelService.findById(proficiency_level_id);
        return languageProficiencyLevel;
    }

    public void create(){
        languageProficiencyLevelService.save(languageProficiencyLevel);
        FacesContext fc = FacesContext.getCurrentInstance();
        ApplicationHelpers.setSuccessMessage("Language created successfully", null);
    }

    @PostConstruct
    public void init() {
        languageProficiencyLevels = languageProficiencyLevelService.findAll();
    }



    //getters setters
    public LanguageProficiencyLevelService getLanguageProficiencyLevelService() {
        return languageProficiencyLevelService;
    }

    public void setLanguageProficiencyLevelService(LanguageProficiencyLevelService languageProficiencyLevelService) {
        this.languageProficiencyLevelService = languageProficiencyLevelService;
    }

    public LanguageProficiencyLevel getLanguageProficiencyLevel() {
        return languageProficiencyLevel;
    }

    public void setLanguageProficiencyLevel(LanguageProficiencyLevel languageProficiencyLevel) {
        this.languageProficiencyLevel = languageProficiencyLevel;
    }

    public List<LanguageProficiencyLevel> getLanguageProficiencyLevels() {
        return languageProficiencyLevels;
    }

    public void setLanguageProficiencyLevels(List<LanguageProficiencyLevel> languageProficiencyLevels) {
        this.languageProficiencyLevels = languageProficiencyLevels;
    }
}
