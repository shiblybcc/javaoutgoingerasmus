package com.example.outgoing.Repository;

import com.example.outgoing.Entity.Language;
import com.example.outgoing.Entity.LanguageProficiencyLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageProficiencyLevelRepository extends JpaRepository<LanguageProficiencyLevel, Integer>{

}
