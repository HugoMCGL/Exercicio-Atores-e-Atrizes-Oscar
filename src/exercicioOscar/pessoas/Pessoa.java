package exercicioOscar.pessoas;

public class Pessoa {
    private int ano, idade;
    private String nomePessoa, nomeFilme;

    public Pessoa() {
    }

    public Pessoa(int ano, int idade, String nomePessoa, String nomeFilme) {
        this.ano = ano;
        this.idade = idade;
        this.nomePessoa = nomePessoa;
        this.nomeFilme = nomeFilme;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }
}
