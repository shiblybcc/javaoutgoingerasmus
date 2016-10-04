package com.example.outgoing.Repository;

import com.example.outgoing.Entity.Address;
import com.example.outgoing.Entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer>{

}
