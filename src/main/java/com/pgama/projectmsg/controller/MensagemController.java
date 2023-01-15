package com.pgama.projectmsg.controller;

import com.pgama.projectmsg.model.Mensagem;
import com.pgama.projectmsg.model.StatusMensagem;
import com.pgama.projectmsg.repository.MensagemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping({"/mensagens"})
public class MensagemController {

    private MensagemRepository repository;

    MensagemController(MensagemRepository mensagemRepository) {
        this.repository = mensagemRepository;
    }

    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Mensagem create(@RequestBody Mensagem mensagem){
        mensagem.setDataEnvio(LocalDateTime.now());
        mensagem.setStatus(StatusMensagem.ENVIADA);
        return repository.save(mensagem);
    }
    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Mensagem mensagem) {
        return repository.findById(id)
                .map(record -> {
                    record.setTitulo(mensagem.getTitulo());
                    record.setTexto(mensagem.getTexto());
                    record.setTipoMensagem(mensagem.getTipoMensagem());
                    record.setDestinatarioNome(mensagem.getDestinatarioNome());
                    record.setDestinatarioContato(mensagem.getDestinatarioContato());
                    record.setDataEnvio(mensagem.getDataEnvio());
                    record.setStatus(StatusMensagem.ENVIADA);
                    Mensagem updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/cancelar/{id}")
    public ResponseEntity cancelarMensagem (@PathVariable("id") long id,
                                 @RequestBody Mensagem mensagem) {
        return repository.findById(id)
                .map(record -> {
                    record.setTitulo(mensagem.getTitulo());
                    record.setTexto(mensagem.getTexto());
                    record.setTipoMensagem(mensagem.getTipoMensagem());
                    record.setDestinatarioNome(mensagem.getDestinatarioNome());
                    record.setDestinatarioContato(mensagem.getDestinatarioContato());
                    record.setDataEnvio(mensagem.getDataEnvio());
                    record.setStatus(StatusMensagem.CANCELADA);
                    Mensagem updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}

