package br.com.italo.biblioteca.servico.configuracao;

import br.com.italo.biblioteca.dominio.Categoria;
import br.com.italo.biblioteca.dominio.Livro;
import br.com.italo.biblioteca.repositorio.CategoriaRepositorio;
import br.com.italo.biblioteca.repositorio.LivroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class BdTestService {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    @Autowired
    private LivroRepositorio livroRepositorio;

    public void popularDados(){

        Categoria c1 = new Categoria(null, "Teste", "qualquer coisa");
        Categoria c2 = new Categoria(null, "livro 2", "outro negocio");
        Livro l1 = new Livro(null, "qualquer coisa", "fulano", "nada",
                LocalDate.of(2021,06,22),c1);
        Livro l2 = new Livro(null, "qualquer bbbbbbb  coisa", "fulano 2 novo", "nadsdsadsada",
                LocalDate.of(2021,06,22),c1);
        Livro l3 = new Livro(null, "novo livro", "fulano 3", "naaaaaaaaaaaaaaada",
                LocalDate.of(2021,06,22),c2);

        categoriaRepositorio.saveAll(Arrays.asList(c1,c2));
        livroRepositorio.saveAll(Arrays.asList(l1,l2,l3));

    }


}
