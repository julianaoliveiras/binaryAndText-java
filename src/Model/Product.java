package Model;

/**
 *
 * @author Juliana Oliveira
 */
public class Product implements java.io.Serializable{
    public int id;
    public String nome;
    public String tipo;

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }    
}
