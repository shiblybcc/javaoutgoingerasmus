package com.example.outgoing.Repository;

import com.example.outgoing.Entity.Address;
import com.example.outgoing.Entity.StammdatenFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StammdatenFileRepository extends JpaRepository<StammdatenFile, Integer>{

}
