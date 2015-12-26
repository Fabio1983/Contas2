/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contas;

import java.util.Calendar;

/**
 *
 * @author Fabio
 */
public class Contas {
    private String nome;
    private float valor;
    Calendar data = Calendar.getInstance();
    private String vencimento;
    private String estado;

    public Contas(String nome, float valor, String vencimento, String estado) {
        this.nome = nome;
        this.valor = valor;
        this.vencimento = vencimento;
        this.estado = estado;
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

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
