package br.ufcg.edu.empsoft.hospet.models;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by Julio on 30/09/2016.
 */
public class Usuario {

    private long id;
    private String nome;
    private String estado;
    private String cidade;
    private String endereco;
    private String nomeAnimal;
    private String especieAnimal;
    private String racaAnimal;
    private String detalhesAnimal;
    private List<Bitmap> galeria;
    private Bitmap fotoDePerfil;

    private Usuario(long id, String nome, String estado, String cidade, String endereco,
                   String nomeAnimal, String especieAnimal, String racaAnimal,
                   String detalhesAnimal, Bitmap fotoDePerfil)
            throws  IllegalArgumentException{

        if(!argumentosValidos(nome, estado, cidade, endereco,
                nomeAnimal, especieAnimal, racaAnimal, detalhesAnimal, fotoDePerfil)) {
            throw new IllegalArgumentException("Algum dos valores passados no construtor é inválido");
        }

        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.cidade = cidade;
        this.endereco = endereco;
        this.nomeAnimal = nomeAnimal;
        this.especieAnimal = especieAnimal;
        this.racaAnimal = racaAnimal;
        this.detalhesAnimal = detalhesAnimal;
        this.fotoDePerfil = fotoDePerfil;
    }

    public Usuario(String nome, String estado, String cidade, String endereco,
                    String nomeAnimal, String especieAnimal, String racaAnimal,
                    String detalhesAnimal, Bitmap fotoDePerfil) {

        this(-1, nome, estado, cidade, endereco, nomeAnimal, especieAnimal,
                racaAnimal, detalhesAnimal, fotoDePerfil);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getRacaAnimal() {
        return racaAnimal;
    }

    public void setRacaAnimal(String racaAnimal) {
        this.racaAnimal = racaAnimal;
    }

    public String getEspecieAnimal() {
        return especieAnimal;
    }

    public void setEspecieAnimal(String especieAnimal) {
        this.especieAnimal = especieAnimal;
    }

    public String getDetalhesAnimal() {
        return detalhesAnimal;
    }

    public void setDetalhesAnimal(String detalhesAnimal) {
        this.detalhesAnimal = detalhesAnimal;
    }

    public Bitmap getFotoDePerfil() {
        return fotoDePerfil;
    }

    public void setFotoDePerfil(Bitmap fotoDePerfil) {
        this.fotoDePerfil = fotoDePerfil;
    }

    public List<Bitmap> getGaleria() {
        return galeria;
    }

    public boolean adicionarNaGaleria(Bitmap imagem) {
        return galeria.add(imagem);
    }

    public boolean removerDaGaleria(Bitmap imagem) {
        return galeria.remove(imagem);
    }

    private boolean argumentosValidos(String nome, String estado, String cidade, String endereco,
                                      String nomeAnimal, String especieAnimal, String racaAnimal,
                                      String detalhesAnimal, Bitmap fotoDePerfil){
        return nome != null && !nome.isEmpty() &&
                estado != null && !estado.isEmpty() &&
                cidade != null && !cidade.isEmpty() &&
                endereco != null && !endereco.isEmpty() &&
                nomeAnimal != null && !nomeAnimal.isEmpty() &&
                especieAnimal != null && !especieAnimal.isEmpty() &&
                racaAnimal != null && !racaAnimal.isEmpty() &&
                detalhesAnimal != null &&
                fotoDePerfil != null;
    }
}
