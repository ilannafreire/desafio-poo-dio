package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp() {}

    public Bootcamp(String nome, String descricao) {
        setNome(nome);
        setDescricao(descricao);
    }

    public void adicionarConteudo(Conteudo conteudo) {
        if (conteudo == null) {
            throw new IllegalArgumentException("Conteúdo não pode ser nulo");
        }
        this.conteudos.add(conteudo);
    }

    public void removerConteudo(Conteudo conteudo) {
        this.conteudos.remove(conteudo);
    }

    public int getTotalDevsInscritos() {
        return devsInscritos.size();
    }

    public int getTotalConteudos() {
        return conteudos.size();
    }

    public boolean isAtivo() {
        LocalDate hoje = LocalDate.now();
        return !hoje.isBefore(dataInicial) && !hoje.isAfter(dataFinal);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do bootcamp não pode ser nulo ou vazio");
        }
        this.nome = nome.trim();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição do bootcamp não pode ser nula ou vazia");
        }
        this.descricao = descricao.trim();
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return new HashSet<>(devsInscritos); // Retorna cópia para preservar encapsulamento
    }

    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = new HashSet<>(devsInscritos);
    }

    public Set<Conteudo> getConteudos() {
        return new LinkedHashSet<>(conteudos); // Retorna cópia para preservar encapsulamento
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = new LinkedHashSet<>(conteudos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(dataInicial, bootcamp.dataInicial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataInicial);
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", periodo=" + dataInicial + " a " + dataFinal +
                ", ativo=" + isAtivo() +
                ", devsInscritos=" + devsInscritos.size() +
                ", conteudos=" + conteudos.size() +
                '}';
    }
}
