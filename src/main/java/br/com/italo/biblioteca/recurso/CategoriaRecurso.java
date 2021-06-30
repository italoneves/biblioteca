package br.com.italo.biblioteca.recurso;
import br.com.italo.biblioteca.dominio.Categoria;
import br.com.italo.biblioteca.servico.CategoriaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/categoria") //Criação de Endpoint
public class CategoriaRecurso {

/* Faltando implementar o DTO */
    @Autowired
    private CategoriaServico categoriaServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> buscarId(@PathVariable Integer id){
            return ResponseEntity.ok().body(categoriaServico.buscarId(id));

    }
    @GetMapping
    public ResponseEntity<List<Categoria>> buscarTudo(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaServico.buscarTudo());
    }

    @PostMapping
    public ResponseEntity<Categoria> adicionarCategoria(@Valid @RequestBody Categoria categoria){
        Categoria categoria1 = categoriaServico.adicionarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria1);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Integer id,@Valid @RequestBody Categoria categoria){

        Categoria categoria1 = categoriaServico.atualizarCategoria(id, categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria1);

    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Integer id){
        categoriaServico.deletarCategoria(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        //NO_CONTENT -> SERVIDOR ATENDEU A SOLICITAÇÃO COM SUCESSO, MAS NÃO HÁ CONTEÚDO PARA SER ENVIADO NO CORPO
    }


}
