package br.com.italo.biblioteca.repositorio;

import br.com.italo.biblioteca.dominio.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepositorio extends JpaRepository<Livro, Integer> {

    Optional<Livro> findByTitulo(String titulo);
}
