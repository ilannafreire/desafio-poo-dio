package br.com.dio.desafio.dominio;

public class Curso extends Conteudo{

    private int cargaHoraria;

    public Curso() {
        super();
    }

    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);
        setCargaHoraria(cargaHoraria);
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("Carga horária deve ser maior que zero");
        }
        if (cargaHoraria > 200) {
            throw new IllegalArgumentException("Carga horária não pode exceder 200 horas");
        }
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", xp=" + calcularXp() +
                '}';
    }
}
