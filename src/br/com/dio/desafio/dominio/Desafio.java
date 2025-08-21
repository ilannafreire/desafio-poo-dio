package br.com.dio.desafio.dominio;

public class Desafio extends Conteudo {

    private String linguagem;
    private int nivelDificuldade; // 1-5

    public Desafio() {
        super();
    }

    public Desafio(String titulo, String descricao, String linguagem, int nivelDificuldade) {
        super(titulo, descricao);
        setLinguagem(linguagem);
        setNivelDificuldade(nivelDificuldade);
    }

    @Override
    public double calcularXp() {
        // XP baseado no nível de dificuldade
        return XP_PADRAO * nivelDificuldade * 2;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        if (linguagem == null || linguagem.trim().isEmpty()) {
            throw new IllegalArgumentException("Linguagem não pode ser nula ou vazia");
        }
        this.linguagem = linguagem.trim();
    }

    public int getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(int nivelDificuldade) {
        if (nivelDificuldade < 1 || nivelDificuldade > 5) {
            throw new IllegalArgumentException("Nível de dificuldade deve estar entre 1 e 5");
        }
        this.nivelDificuldade = nivelDificuldade;
    }

    @Override
    public String toString() {
        return "Desafio{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", linguagem='" + linguagem + '\'' +
                ", nivelDificuldade=" + nivelDificuldade +
                ", xp=" + calcularXp() +
                '}';
    }
}
