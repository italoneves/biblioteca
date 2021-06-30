package br.com.italo.biblioteca.servico;

import br.com.italo.biblioteca.dominio.Categoria;
import br.com.italo.biblioteca.dominio.Livro;
import br.com.italo.biblioteca.repositorio.CategoriaRepositorio;
import br.com.italo.biblioteca.repositorio.LivroRepositorio;
import br.com.italo.biblioteca.servico.exception.ObjetoExistente;
import br.com.italo.biblioteca.servico.exception.ObjetoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroServico{

    @Autowired
    private LivroRepositorio livroRepositorio;
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public Livro buscarId(Integer id) {
        Livro l = livroRepositorio.findById(id)
                .orElseThrow(()-> new ObjetoNaoEncontrado("Livro não encontrado"));
        //Não foi lançado exception então não ta null
       return  l;

    }

    public Livro adicionarLivro(Livro livro, Integer cat_id){
        livro.setId(null); //Não atualizar id existente
        Optional<Livro> l = livroRepositorio.findByTitulo(livro.getTitulo());
        if(l.isPresent()){
            throw new ObjetoExistente("O livro já está cadastrado");
        }
        Categoria c = categoriaRepositorio.findById(cat_id)
            .orElseThrow(() -> new ObjetoNaoEncontrado("Objeto não possui categoria"));

        livro.setCategoria(c); //categoria em livro
        livroRepositorio.save(livro);
        return livro;

    }

    public Livro atualizarLivro(Integer id, Livro novoLivro) {
        Livro livro = livroRepositorio.findById(id)
                .orElseThrow(() -> new ObjetoNaoEncontrado("Livro não existe, impossível atualizar"));
        atualizarLivroInterno(novoLivro, livro);
        livroRepositorio.save(livro);
        return livro;
    }

    private void atualizarLivroInterno(Livro novoLivro, Livro livro) {
        livro.setTitulo(novoLivro.getTitulo());
        livro.setAutor(novoLivro.getAutor());
        livro.setTexto(novoLivro.getTexto());
        livro.setData(novoLivro.getData());
    }

    public void deletarLivro(Integer id) {
        Livro l = livroRepositorio.findById(id)
                .orElseThrow(()-> new ObjetoNaoEncontrado("Livro não existe, impossível deletar."));
        livroRepositorio.deleteById(id);
    }
}
