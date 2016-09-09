
package contas;

import java.util.Calendar;

/**
 *
 * @author Fabio
 */
public class Contas {
    private int idConta;
    private String nome;
    private float valor;
    private Calendar vencimento = Calendar.getInstance();
    private String estado;

    public Contas(int idConta, String nome,Calendar vencimento, float valor, String estado) {
        this.idConta = idConta;
        this.nome = nome;
        this.valor = valor;
        this.vencimento = vencimento;
        this.estado = estado;
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

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
