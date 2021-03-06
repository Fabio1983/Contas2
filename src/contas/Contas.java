
package contas;

import java.time.LocalDate;

/**
 *
 * @author Fabio
 */
public class Contas {
    private int idConta;
    private String nome;
    private float valor;
    private LocalDate vencimento;
    private String estado;
    private int idUsuario;

    public Contas(int idConta, String nome,LocalDate vencimento, float valor, String estado, int idUsuario) {
        this.idConta = idConta;
        this.nome = nome;
        this.valor = valor;
        this.vencimento = vencimento;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public Contas(){
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
