package br.com.italo.biblioteca.servico;

import br.com.italo.biblioteca.dominio.Categoria;
import br.com.italo.biblioteca.repositorio.CategoriaRepositorio;
import br.com.italo.biblioteca.servico.exception.ObjetoExistente;
import br.com.italo.biblioteca.servico.exception.ObjetoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServico {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public Categoria buscarId(Integer id){

        Optional<Categoria> c = Optional.ofNullable(categoriaRepositorio.findById(id)
                .orElseThrow(() -> new ObjetoNaoEncontrado("Id não encontrado")));

        Categoria c1 = c.get();
        return c1;
    }

    public List<Categoria> buscarTudo() {
        List Listacategoria = (categoriaRepositorio.findAll());

        if(Listacategoria.isEmpty()){
            throw new ObjetoNaoEncontrado("Não existe itens");
        }
        return Listacategoria;
    }
    public Categoria adicionarCategoria(Categoria categoria){
        categoria.setId(null); ; //Não atualizar id existente aqui
        Optional<Categoria> c = categoriaRepositorio.findByNome(categoria.getNome());
        if (c.isPresent()){
            throw new ObjetoExistente("Categoria existente");
        }
        categoriaRepositorio.save(categoria);
        return categoria;

        /*1 - Só cria se o nome da categoria for diferente.
          2 - Posso implementar jogando ID para null e gerar outro no BD
          3 - posso criar se o ID não existir no BD
         */
    }

    public Categoria atualizarCategoria(Integer id, Categoria categoria){

        Optional<Categoria> c = Optional.ofNullable(categoriaRepositorio.findById(id)
                .orElseThrow(() -> new ObjetoNaoEncontrado("Categoria não encontrada")));
       //Pego o objeto caso não tenha exception e atualizo
        Categoria c1 = c.get();
        atualizarCategoriaInterno(c1, categoria);
        categoriaRepositorio.save(c1);
        return c1;

    }

    private void atualizarCategoriaInterno(Categoria c1, Categoria categoria) {
        c1.setNome(categoria.getNome());
        c1.setDescricao(categoria.getDescricao());
    }

    public void deletarCategoria(Integer id){

        Optional<Categoria> c = Optional.ofNullable(categoriaRepositorio.findById(id))
                .orElseThrow(()-> new ObjetoNaoEncontrado("Essa categoria não existe"));
        //Caso existe deleto categoria.
        categoriaRepositorio.deleteById(id);


    }


}
