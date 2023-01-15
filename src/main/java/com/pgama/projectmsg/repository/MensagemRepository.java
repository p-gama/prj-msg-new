package com.pgama.projectmsg.repository;

import com.pgama.projectmsg.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> { }
