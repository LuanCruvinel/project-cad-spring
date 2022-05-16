package com.api.cad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping()
    public ResponseEntity<List<Pessoa>> getPessoa(){
        return ResponseEntity.ok(pessoaService.buscarPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> buscarPorId(@PathVariable Long id){
        Optional<Pessoa> pessoa = Optional.ofNullable(pessoaService.buscarPorId(id));
        return  pessoa.isPresent() ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
    }




}
