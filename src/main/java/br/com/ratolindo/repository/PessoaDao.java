package br.com.ratolindo.repository;

import br.com.ratolindo.dto.Pessoa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class PessoaDao {

    private static final Logger log = LoggerFactory.getLogger(PessoaDao.class);
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public PessoaDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pessoa> buscarTodos() {
        String sql = "SELECT id, nome, email FROM pessoas";

        return jdbcTemplate.query(sql, new RowMapper<Pessoa>() {
            @Override
            public Pessoa mapRow(ResultSet rs, int rowNum) throws SQLException {
                Pessoa pessoa = new Pessoa();
                pessoa.setUuid(UUID.fromString(rs.getString("id")));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEmail(rs.getString("email"));
                return pessoa;
            }
        });
    }

    public int salvar(Pessoa pessoa) {
        String sql = "INSERT INTO pessoas (id, nome, email, cpf) VALUES (:id, :nome, :email, :cpf)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", UUID.randomUUID());
        params.addValue("nome", pessoa.getNome());
        params.addValue("email", pessoa.getEmail());
        params.addValue("cpf", pessoa.getCpf());
        return jdbcTemplate.update(sql, params);
    }

    public Pessoa buscarPorId(String id) {
        try {
            String sql = "SELECT id, nome, email, cpf FROM pessoas WHERE id = :id";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("id", UUID.fromString(id));
            return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
                return new Pessoa(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("cpf")
                );
            });
        } catch (Exception e) {
            log.error("Erro ao buscar pessoa", e);
            return null;
        }
    }
}
