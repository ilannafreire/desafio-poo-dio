package br.com.dio.desafio.dominio;

public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    // Construtor protegido para ser usado pelas subclasses
    protected Conteudo(String titulo, String descricao) {
        setTitulo(titulo);
        setDescricao(descricao);
    }

    // Construtor padrão mantido para compatibilidade
    protected Conteudo() {}

    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser nulo ou vazio");
        }
        this.titulo = titulo.trim();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia");
        }
        this.descricao = descricao.trim();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Conteudo conteudo = (Conteudo) obj;
        return titulo.equals(conteudo.titulo);
    }

    @Override
    public int hashCode() {
        return titulo.hashCode();
    }
}
