package Model;

/**
 *
 * @author Juliana Oliveira
 */
public class Client implements java.io.Serializable{
    public int id;
    public String nome;
    public String endereço;

    public String getNome() {
        return nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
