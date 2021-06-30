package br.com.italo.biblioteca.repositorio;

import br.com.italo.biblioteca.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByNome(String nome);

}
