package com.pgama.projectmsg.controller;

import com.pgama.projectmsg.model.*;
import com.pgama.projectmsg.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.pgama.projectmsg.model.StatusMensagem.ENVIADA;

@RestController
@RequestMapping({"/mensagens"})
public class MensagemController {

    private MensagemService mensagemService;

    @Autowired
    public void setMensagemService(MensagemService mensagemService) { this.mensagemService = mensagemService; }


    @GetMapping
            Page<Mensagem> loadMensagensPage(

                    @PageableDefault(size = 5, page= 0)
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "titulo", direction = Sort.Direction.ASC),
                    @SortDefault(sort = "id", direction = Sort.Direction.ASC)
            })
            Pageable pageable) {

        return mensagemService.findAll(pageable);
    }



    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Mensagem> getMensagemById(@PathVariable long id) {
        return mensagemService.getMensagemById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElseThrow(() -> new MensagemNaoEncontradaException(id));
    }


    @PostMapping
    public Mensagem saveMensagem(@RequestBody Mensagem mensagem) {
        mensagem.setStatus(ENVIADA);
        List<CamposInvalidos> camposInvalidos = new ArrayList<>();
        validarCampos(mensagem, camposInvalidos);
        if(!camposInvalidos.isEmpty()) {
            throw new CamposInvalidosException(camposInvalidos);
        }
        return mensagemService.saveMensagem(mensagem);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Mensagem> update(@PathVariable("id") long id,
                                           @RequestBody Mensagem mensagem) {

        List<CamposInvalidos> camposInvalidos = new ArrayList<>();
        validarCampos(mensagem, camposInvalidos);

        if(!camposInvalidos.isEmpty()) {
            throw new CamposInvalidosException(camposInvalidos);
        }

        return mensagemService.getMensagemById(id)
                .map(record -> {
                    record.setTitulo(mensagem.getTitulo());
                    record.setTexto(mensagem.getTexto());
                    record.setTipoMensagem(mensagem.getTipoMensagem());
                    record.setDestinatarioNome(mensagem.getDestinatarioNome());
                    record.setDestinatarioContato(mensagem.getDestinatarioContato());
                    record.setDataEnvio(mensagem.getDataEnvio());
                    record.setStatus(mensagem.getStatus());
                    Mensagem updated = mensagemService.saveMensagem(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.internalServerError().build());
    }


    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return mensagemService.getMensagemById(id)
                .map(record -> {
                    mensagemService.deleteMensagem(id);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new MensagemNaoEncontradaException(id));
    }

    private void validarCampos(Mensagem mensagem, List<CamposInvalidos> camposInvalidos) {
        if (mensagem.getTipoMensagem() == null) {
            camposInvalidos.add(new CamposInvalidos("campo não preenchido", "tipo mensagem"));
        }
        if (mensagem.getDataEnvio() == null)  {
            camposInvalidos.add(new CamposInvalidos("campo não preenchido", "Data de Envio"));
        }
        if (mensagem.getDataEnvio().isBefore(LocalDateTime.now())) {
            camposInvalidos.add(new CamposInvalidos("data nao pode ser inferior a data atual", "Data de Envio"));

        }
        if (mensagem.getDestinatarioContato() == null) {
            camposInvalidos.add(new CamposInvalidos("campo não preenchido", "destinatario"));
        }
        if (mensagem.getTexto() == null) {
            camposInvalidos.add(new CamposInvalidos("campo não preenchido", "mensagem"));
        }
    }
}
