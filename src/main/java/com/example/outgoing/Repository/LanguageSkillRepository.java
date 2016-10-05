package com.example.outgoing.Repository;

import com.example.outgoing.Entity.LanguageProficiencyLevel;
import com.example.outgoing.Entity.LanguageSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageSkillRepository extends JpaRepository<LanguageSkill, Integer>{

}
