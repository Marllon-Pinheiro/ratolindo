package br.com.ratolindo.service;

import br.com.ratolindo.dto.Pessoa;
import br.com.ratolindo.repository.PessoaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaDao pessoaDao;

    public void incluirPessoa(Pessoa pessoa) {
        pessoaDao.salvar(pessoa);
    }

    public List<Pessoa> buscarTodos() {
        return pessoaDao.buscarTodos();
    }

    public Pessoa buscarPorId(String id) {
        return pessoaDao.buscarPorId(id);
    }

}
