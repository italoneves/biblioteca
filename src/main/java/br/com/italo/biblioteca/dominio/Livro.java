package br.com.italo.biblioteca.dominio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "livro")
public class Livro  implements Serializable {

    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gerado pela coluna de autoIncremento do BD
    private Integer id;                                 //Faz parte de uma única tabela
    @NotBlank(message = "Campo TÍTULO não pode ficar em branco")
    private String titulo;
    @NotBlank(message = "Campo AUTOR não pode ficar em branco")
    private String autor;
    @NotBlank(message = "Campo TEXTO não pode ficar em branco")
    private String texto;
    @JsonFormat(pattern = "yyyy-MM-dd") // Formato de retorno da data
    private LocalDate data;
    //@JsonIgnore //Proteger contra o loop
    @JsonBackReference //Proteger contra o loop
    @ManyToOne // Temos muitos livros para uma categoria
    @JoinColumn(name = "categoria_id") // nome da chave estrangeira
    private Categoria categoria;


    public Livro() {
    }

    public Livro(Integer id, String titulo, String autor, String texto, LocalDate data, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
        this.data = data;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return Objects.equals(getId(), livro.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
