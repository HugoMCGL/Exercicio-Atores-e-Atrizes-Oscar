package exercicioOscar.pessoas;

public class Ator {
    private int ano, idade;
    private String nomeAtor, nomeFilme;

    public Ator() {
    }

    public Ator(int ano, int idade, String nomeAtriz, String nomeFilme) {
        this.ano = ano;
        this.idade = idade;
        this.nomeAtor = nomeAtriz;
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

    public String getNomeAtriz() {
        return nomeAtor;
    }

    public void setNomeAtriz(String nomeAtriz) {
        this.nomeAtor = nomeAtriz;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    @Override
    public String toString() {
        return "Ator{" +
                "ano=" + ano +
                ", idade=" + idade +
                ", nomeAtor='" + nomeAtor + '\'' +
                ", nomeFilme='" + nomeFilme + '\'' +
                '}';
    }
}
