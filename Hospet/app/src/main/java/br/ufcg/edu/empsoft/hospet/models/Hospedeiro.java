package br.ufcg.edu.empsoft.hospet.models;

import android.graphics.Bitmap;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Veruska on 10/10/2016.
 */
public class Hospedeiro {

    private String nome;
    private String descricao;
    private Double precoDiaria;
    private Calendar inicioDisp;
    private Calendar fimDisp;
    private Double numEstrelas;
    private Integer qntCriancas;
    private List<ConstantesFiltro.TipoAnimal> animais;
    private ConstantesFiltro.TipoLocal tipoCasa;
    private List<ConstantesFiltro.TipoPagamento> tipoPagamento;
    private List<Bitmap> fotos;
    private Bitmap fotoDePerfil;
    private Double distancia;

    public Hospedeiro(String nome, String descricao, Double precoDiaria, Calendar inicioDisp,
                      Calendar fimDisp, Integer qntCriancas, List<ConstantesFiltro.TipoAnimal> animais,
                      ConstantesFiltro.TipoLocal tipoCasa, List<ConstantesFiltro.TipoPagamento> tipoPagamento,
                      Double distancia) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoDiaria = precoDiaria;
        this.inicioDisp = inicioDisp;
        this.fimDisp = fimDisp;
        this.qntCriancas = qntCriancas;
        this.animais = animais;
        this.tipoCasa = tipoCasa;
        this.tipoPagamento = tipoPagamento;
        this.numEstrelas = 0.0;
        this.distancia = distancia;
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

    public Calendar getInicioDisp() {
        return inicioDisp;
    }

    public void setInicioDisp(Calendar inicioDisp) {
        this.inicioDisp = inicioDisp;
    }

    public Calendar getFimDisp() {
        return fimDisp;
    }

    public void setFimDisp(Calendar fimDisp) {
        this.fimDisp = fimDisp;
    }

    public Double getNumEstrelas() {
        return numEstrelas;
    }

    public void setNumEstrelas(Double numEstrelas) {
        this.numEstrelas = numEstrelas;
    }

    public Integer getQntCriancas() {
        return qntCriancas;
    }

    public void setQntCriancas(Integer qntCriancas) {
        this.qntCriancas = qntCriancas;
    }

    public List<ConstantesFiltro.TipoAnimal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<ConstantesFiltro.TipoAnimal> animais) {
        this.animais = animais;
    }

    public ConstantesFiltro.TipoLocal getTipoCasa() {
        return tipoCasa;
    }

    public void setTipoCasa(ConstantesFiltro.TipoLocal tipoCasa) {
        this.tipoCasa = tipoCasa;
    }

    public List<ConstantesFiltro.TipoPagamento> getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(List<ConstantesFiltro.TipoPagamento> tipoPagamento) {
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

    public void addPagamento(ConstantesFiltro.TipoPagamento tipoPag){
        this.tipoPagamento.add(tipoPag);
    }

    public void addAnimal(ConstantesFiltro.TipoAnimal animal){
        this.animais.add(animal);
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }
}
