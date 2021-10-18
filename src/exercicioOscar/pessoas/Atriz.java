package exercicioOscar.pessoas;

public class Atriz {
       private int ano, idade;
       private String nomeAtriz, nomeFilme;

        public Atriz() {
        }

        public Atriz(int ano, int idade, String nomeAtriz, String nomeFilme) {
                this.ano = ano;
                this.idade = idade;
                this.nomeAtriz = nomeAtriz;
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
                return nomeAtriz;
        }

        public void setNomeAtriz(String nomeAtriz) {
                this.nomeAtriz = nomeAtriz;
        }

        public String getNomeFilme() {
                return nomeFilme;
        }

        public void setNomeFilme(String nomeFilme) {
                this.nomeFilme = nomeFilme;
        }

        @Override
        public String toString() {
                return "Atriz{" +
                        "ano=" + ano +
                        ", idade=" + idade +
                        ", nomeAtriz='" + nomeAtriz + '\'' +
                        ", nomeFilme='" + nomeFilme + '\'' +
                        '}';
        }
}
