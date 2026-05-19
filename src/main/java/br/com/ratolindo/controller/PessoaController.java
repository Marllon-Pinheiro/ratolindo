package br.com.ratolindo.controller;

import br.com.ratolindo.dto.Pessoa;
import br.com.ratolindo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> incluirPessoa(@RequestBody Pessoa pessoa) {
        pessoaService.incluirPessoa(pessoa);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(pessoaService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> buscarTodos() {
        return ResponseEntity.ok(pessoaService.buscarTodos());
    }

}
