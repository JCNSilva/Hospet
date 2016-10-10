package br.ufcg.edu.empsoft.hospet.models;

import android.graphics.Bitmap;

import java.util.Date;
import java.util.List;

/**
 * Created by Veruska on 10/10/2016.
 */
public class Hospedeiro {

    private String nome;
    private String descricao;
    private Double precoDiaria;
    private Date inicioDisp;
    private Date fimDisp;
    private Integer numEstrelas;
    private Integer qntCriancas;
    private List<String> animais;
    private String tipoCasa;
    private List<String> tipoPagamento;
    private List<Bitmap> fotos;
    private Bitmap fotoDePerfil;

    public Hospedeiro(String nome, String descricao, Double precoDiaria, Date inicioDisp,
                      Date fimDisp, Integer qntCriancas, List<String> animais, String tipoCasa,
                      List<String> tipoPagamento) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoDiaria = precoDiaria;
        this.inicioDisp = inicioDisp;
        this.fimDisp = fimDisp;
        this.qntCriancas = qntCriancas;
        this.animais = animais;
        this.tipoCasa = tipoCasa;
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hospedeiro that = (Hospedeiro) o;

        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null)
            return false;
        return !(precoDiaria != null ? !precoDiaria.equals(that.precoDiaria) : that.precoDiaria != null);

    }

    @Override
    public String toString() {
        return "Hospedeiro{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", precoDiaria=" + precoDiaria +
                ", inicioDisp=" + inicioDisp +
                ", fimDisp=" + fimDisp +
                ", numEstrelas=" + numEstrelas +
                ", qntCriancas=" + qntCriancas +
                ", animais=" + animais +
                ", tipoCasa='" + tipoCasa + '\'' +
                ", tipoPagamento=" + tipoPagamento +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(Double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public Date getInicioDisp() {
        return inicioDisp;
    }

    public void setInicioDisp(Date inicioDisp) {
        this.inicioDisp = inicioDisp;
    }

    public Date getFimDisp() {
        return fimDisp;
    }

    public void setFimDisp(Date fimDisp) {
        this.fimDisp = fimDisp;
    }

    public Integer getNumEstrelas() {
        return numEstrelas;
    }

    public void setNumEstrelas(Integer numEstrelas) {
        this.numEstrelas = numEstrelas;
    }

    public Integer getQntCriancas() {
        return qntCriancas;
    }

    public void setQntCriancas(Integer qntCriancas) {
        this.qntCriancas = qntCriancas;
    }

    public List<String> getAnimais() {
        return animais;
    }

    public void setAnimais(List<String> animais) {
        this.animais = animais;
    }

    public String getTipoCasa() {
        return tipoCasa;
    }

    public void setTipoCasa(String tipoCasa) {
        this.tipoCasa = tipoCasa;
    }

    public List<String> getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(List<String> tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public List<Bitmap> getFotos() {
        return fotos;
    }

    public Bitmap getFotoDePerfil() {
        return fotoDePerfil;
    }

    public void setFotoDePerfil(Bitmap fotoDePerfil) {
        this.fotoDePerfil = fotoDePerfil;
    }

    public void setFotos(List<Bitmap> fotos) {
        this.fotos = fotos;
    }

    public void addFoto(Bitmap foto){
        this.fotos.add(foto);
    }

    public void addPagamento(String tipoPag){
        this.tipoPagamento.add(tipoPag);
    }

    public void addAnimal(String animal){
        this.animais.add(animal);
    }
}
