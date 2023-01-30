package com.pgama.projectmsgnew.controller;

import com.pgama.projectmsgnew.domain.MensagemMapper;
import com.pgama.projectmsgnew.domain.usecase.*;
import com.pgama.projectmsgnew.domain.entity.*;
import com.pgama.projectmsgnew.controller.dto.MensagemDTO;
import com.pgama.projectmsgnew.exception.MensagemNaoEncontradaException;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/mensagens")
@Validated
@Api(value="Mensagens api")
public class MensagemController {
    private final AtualizarMensagemUseCase atualizarMensagemUseCase;
    private final BuscarMensagemPorIdUseCase buscarMensagemPorIdUseCase;
     private final CadastrarMensagemUseCase cadastrarMensagemUseCase;
    private final DeletarMensagemUseCase deletarMensagemUseCase;
    private final ListarMensagensUseCase listarMensagensUseCase;

    @Autowired
    private MensagemMapper mapper;

    public MensagemController(DeletarMensagemUseCase deletarMensagemUseCase, ListarMensagensUseCase listarMensagensUseCase, AtualizarMensagemUseCase atualizarMensagemUseCase, BuscarMensagemPorIdUseCase buscarMensagemPorIdUseCase, CadastrarMensagemUseCase cadastrarMensagemUseCase, MensagemMapper mapper) {
        this.atualizarMensagemUseCase = atualizarMensagemUseCase;
        this.buscarMensagemPorIdUseCase = buscarMensagemPorIdUseCase;
        this.cadastrarMensagemUseCase = cadastrarMensagemUseCase;
        this.listarMensagensUseCase = listarMensagensUseCase;
        this.deletarMensagemUseCase = deletarMensagemUseCase;
        this.mapper = mapper;

    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<MensagemDTO> findById(@PathVariable Long id) {
        try {
            MensagemDTO mensagemDTO = buscarMensagemPorIdUseCase.buscarMensagemPorId(id);
            return new ResponseEntity<>(mensagemDTO, HttpStatus.OK);
        } catch (MensagemNaoEncontradaException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Page<MensagemDTO>> listarMensagens(Pageable pageable) {
        Page<MensagemEntity> mensagens = listarMensagensUseCase.listarMensagens(pageable);
        Page<MensagemDTO> mensagensDto = mensagens.map(mapper::toDto);
        return ResponseEntity.ok(mensagensDto);
    }

    @PostMapping
    public ResponseEntity<MensagemEntity> cadastrarMensagem(@RequestBody MensagemEntity mensagem) {
        MensagemEntity mensagemCriada = cadastrarMensagemUseCase.cadastrarMensagem(mensagem);
        return new ResponseEntity<>(mensagemCriada, HttpStatus.CREATED);
    }

    @PutMapping(path ="/{id}")
    public ResponseEntity<MensagemEntity> atualizarMensagem(@PathVariable Long id, @RequestBody MensagemDTO request) {
        try {
            MensagemEntity mensagem = mapper.toEntity(request);
            mensagem.setId(id);
            MensagemEntity mensagemAtualizada = atualizarMensagemUseCase.atualizarMensagem(id, mensagem);
            return new ResponseEntity<>(mensagemAtualizada, HttpStatus.OK);
        } catch (MensagemNaoEncontradaException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path ="/{id}")
    public ResponseEntity<Void> deletarMensagem(@PathVariable Long id) {
        try {
            deletarMensagemUseCase.deletarMensagem(id);
            return new ResponseEntity<>((HttpStatus.NO_CONTENT));
        } catch (MensagemNaoEncontradaException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


