package com.example.outgoing.Controller;

import com.example.outgoing.Entity.Address;
import com.example.outgoing.Entity.Language;
import com.example.outgoing.Entity.Stammdaten;
import com.example.outgoing.Service.AddressService;
import com.example.outgoing.Service.LanguageService;
import com.example.outgoing.Service.StammdatenService;
import com.example.outgoing.Utility.ApplicationHelpers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@ManagedBean
@ViewScoped
public class StammdatenController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer language_id;

    private List<Language> items = new ArrayList<Language>();

    public void addLanguageId(){
        items.add(new Language());
    }

    public void removeLanguageId(Language item) {
        items.remove(item);
    }



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



    public void create(){

        Set<Integer> idList = new HashSet<Integer>();
        for (Language language_id : items) {
            if (idList.add(language_id.getId())){
                stammdaten.getLanguages().add(languageService.findById(language_id.getId()));
            }
        }

        stammdaten.getAddresses().add(homeAddress);
        stammdaten.getAddresses().add(semesterAddress);
        homeAddress.setStammdaten(stammdaten);
        semesterAddress.setStammdaten(stammdaten);

        addressService.save(homeAddress);
        addressService.save(semesterAddress);

        stammdatenService.save(stammdaten);
        FacesContext fc = FacesContext.getCurrentInstance();
        ApplicationHelpers.setSuccessMessage("Application created successfully successfully", null);
    }


    public List<Language> getItems() {
        return items;
    }



    public Integer getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(Integer language_id) {
        this.language_id = language_id;
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
