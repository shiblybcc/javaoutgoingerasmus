package com.example.outgoing.Entity;

import javax.persistence.*;

@Entity
public class LanguageSkill {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "stammdaten_id")
    private Stammdaten stammdaten;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "languageProficiencyLevel_id")
    private LanguageProficiencyLevel languageProficiencyLevel;


    public Stammdaten getStammdaten() {
        return stammdaten;
    }

    public void setStammdaten(Stammdaten stammdaten) {
        this.stammdaten = stammdaten;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public LanguageProficiencyLevel getLanguageProficiencyLevel() {
        return languageProficiencyLevel;
    }

    public void setLanguageProficiencyLevel(LanguageProficiencyLevel languageProficiencyLevel) {
        this.languageProficiencyLevel = languageProficiencyLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
