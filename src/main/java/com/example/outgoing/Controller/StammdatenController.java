package com.example.outgoing.Controller;

import com.example.outgoing.Entity.*;
import com.example.outgoing.Service.*;
import com.example.outgoing.Utility.ApplicationHelpers;
import com.example.outgoing.Utility.LanguageProficiency;
import org.apache.commons.io.FileUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@ManagedBean
@ViewScoped
public class StammdatenController implements Serializable {

    private List<LanguageProficiency> languageProficiencies = new ArrayList<LanguageProficiency>();

    @ManagedProperty("#{stammdatenService}")
    StammdatenService stammdatenService;

    private Stammdaten stammdaten = new Stammdaten();
    private List<Stammdaten> stammdatens;

    @ManagedProperty("#{addressService}")
    AddressService addressService;

    private Address homeAddress = new Address();
    private Address semesterAddress = new Address();
    private List<Address> addresses;

    @ManagedProperty("#{languageService}")
    LanguageService languageService;

    private Language language = new Language();
    private List<Language> languages = new ArrayList<Language>();

    @ManagedProperty("#{languageProficiencyLevelService}")
    LanguageProficiencyLevelService languageProficiencyLevelService;

    private LanguageProficiencyLevel languageProficiencyLevel = new LanguageProficiencyLevel();
    private List<LanguageProficiencyLevel> languageProficiencyLevels = new ArrayList<LanguageProficiencyLevel>();

    @ManagedProperty("#{languageSkillService}")
    LanguageSkillService languageSkillService;


    @ManagedProperty("#{stammdatenFileService}")
    StammdatenFileService stammdatenFileService;

    private StammdatenFile stammdatenFile = new StammdatenFile();
    private List<StammdatenFile> stammdatenFiles;

    private Part file;


    public List<Stammdaten> index(){
        stammdatens = stammdatenService.findAll();
        return stammdatens;
    }

    public Stammdaten show(){
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        Integer stammdaten_id = Integer.valueOf(params.get("id"));

        stammdaten = stammdatenService.findById(stammdaten_id);
//        addresses = (List) stammdaten.getAddresses();
        addresses =  stammdaten.getAddresses();

        return stammdaten;
    }


    public void create() throws IOException{

        stammdaten.getAddresses().add(homeAddress);
        stammdaten.getAddresses().add(semesterAddress);
        homeAddress.setStammdaten(stammdaten);
        semesterAddress.setStammdaten(stammdaten);

        addressService.save(homeAddress);
        addressService.save(semesterAddress);
        stammdatenService.save(stammdaten);

        Set<Integer> idList = new HashSet<Integer>();
        for (LanguageProficiency languageProficiency : languageProficiencies) {
            if (idList.add(languageProficiency.getLanguage_id())){
                Language myLanguage = languageService.findById(languageProficiency.getLanguage_id());
                LanguageProficiencyLevel myLanguageProficiencyLevel = languageProficiencyLevelService.findById(languageProficiency.getLanguage_proficiency_id());

                LanguageSkill myLanguageSkill = new LanguageSkill();
                myLanguageSkill.setLanguage(myLanguage);
                myLanguageSkill.setLanguageProficiencyLevel(myLanguageProficiencyLevel);
                myLanguageSkill.setStammdaten(stammdaten);

                languageSkillService.save(myLanguageSkill);
            }
        }

        try (InputStream input = file.getInputStream()) {
            FileUtils.copyToFile(input, new File("/home/bcc/Pictures/asfdk/teste.jpg"));
        }

        FacesContext fc = FacesContext.getCurrentInstance();
        ApplicationHelpers.setSuccessMessage("Application created successfully successfully", null);
    }


    public void addLanguageProficiency(){
        languageProficiencies.add(new LanguageProficiency());
    }

    public void removeLanguageProficiency(LanguageProficiency languageProficiency){
        languageProficiencies.remove(languageProficiency);
    }



    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

//******************** getters setters ***************************//


    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public StammdatenFileService getStammdatenFileService() {
        return stammdatenFileService;
    }

    public void setStammdatenFileService(StammdatenFileService stammdatenFileService) {
        this.stammdatenFileService = stammdatenFileService;
    }

    public StammdatenFile getStammdatenFile() {
        return stammdatenFile;
    }

    public void setStammdatenFile(StammdatenFile stammdatenFile) {
        this.stammdatenFile = stammdatenFile;
    }

    public List<StammdatenFile> getStammdatenFiles() {
        return stammdatenFiles;
    }

    public void setStammdatenFiles(List<StammdatenFile> stammdatenFiles) {
        this.stammdatenFiles = stammdatenFiles;
    }

    public List<LanguageProficiency> getLanguageProficiencies() {
        return languageProficiencies;
    }

    public void setLanguageProficiencies(List<LanguageProficiency> languageProficiencies) {
        this.languageProficiencies = languageProficiencies;
    }

    public LanguageSkillService getLanguageSkillService() {
        return languageSkillService;
    }

    public void setLanguageSkillService(LanguageSkillService languageSkillService) {
        this.languageSkillService = languageSkillService;
    }


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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public AddressService getAddressService() {
        return addressService;
    }

    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getSemesterAddress() {
        return semesterAddress;
    }

    public void setSemesterAddress(Address semesterAddress) {
        this.semesterAddress = semesterAddress;
    }

    public StammdatenService getStammdatenService() {
        return stammdatenService;
    }

    public void setStammdatenService(StammdatenService stammdatenService) {
        this.stammdatenService = stammdatenService;
    }

    public Stammdaten getStammdaten() {
        return stammdaten;
    }

    public void setStammdaten(Stammdaten stammdaten) {
        this.stammdaten = stammdaten;
    }

    public List<Stammdaten> getStammdatens() {
        return stammdatens;
    }

    public void setStammdatens(List<Stammdaten> stammdatens) {
        this.stammdatens = stammdatens;
    }
}
