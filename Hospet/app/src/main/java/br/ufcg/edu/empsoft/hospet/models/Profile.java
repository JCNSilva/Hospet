package br.ufcg.edu.empsoft.hospet.models;


public class Profile {



    private String name;
    private String info;
    private String preco;
    private String date;

    public Profile(){
        this.name = "Test_user";
        this.info = "Informações";
        this.preco = "R$ 50,00";
        this.date = "10/11 a 11/11";

    }
    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
