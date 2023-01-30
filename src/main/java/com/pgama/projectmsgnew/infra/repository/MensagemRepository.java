package com.pgama.projectmsgnew.infra.repository;

import com.pgama.projectmsgnew.infra.entity.MensagemEntityDb;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MensagemRepository extends JpaRepository<MensagemEntityDb, Long> {


}