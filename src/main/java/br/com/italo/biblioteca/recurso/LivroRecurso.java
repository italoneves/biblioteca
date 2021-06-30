package br.com.italo.biblioteca.recurso;

import br.com.italo.biblioteca.dominio.Livro;
import br.com.italo.biblioteca.servico.LivroServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/livro")
public class LivroRecurso {

    @Autowired
    private LivroServico livroServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> buscarId(@PathVariable Integer id ){
        Livro l = livroServico.buscarId(id);
        return ResponseEntity.status(HttpStatus.OK).body(l);
    }

    @PostMapping
    public ResponseEntity<Livro> adicionarLivro(@RequestParam(value = "categoria",defaultValue = "0")
                                                            Integer cat_id,@Valid @RequestBody Livro livro){
        Livro l = livroServico.adicionarLivro(livro,cat_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(l);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Integer id,@Valid @RequestBody Livro livro){
        Livro l = livroServico.atualizarLivro(id, livro);
        return ResponseEntity.status(HttpStatus.OK).body(l);
    }
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> atualizarLivroParcial(@PathVariable Integer id,@Valid @RequestBody Livro livro){
        Livro l = livroServico.atualizarLivro(id, livro);
        return ResponseEntity.status(HttpStatus.OK).body(l);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Integer id){
        livroServico.deletarLivro(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
