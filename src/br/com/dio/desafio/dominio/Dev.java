package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev() {}

    public Dev(String nome) {
        setNome(nome);
    }

    public void inscreverBootcamp(Bootcamp bootcamp){
        if (bootcamp == null) {
            throw new IllegalArgumentException("Bootcamp não pode ser nulo");
        }
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            throw new IllegalStateException("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public double calcularProgressoPercentual() {
        int totalConteudos = conteudosInscritos.size() + conteudosConcluidos.size();
        if (totalConteudos == 0) return 0.0;
        return (double) conteudosConcluidos.size() / totalConteudos * 100;
    }

    public boolean temConteudoPendente() {
        return !conteudosInscritos.isEmpty();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome.trim();
    }

    public Set<Conteudo> getConteudosInscritos() {
        return new LinkedHashSet<>(conteudosInscritos); // Retorna cópia para preservar encapsulamento
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = new LinkedHashSet<>(conteudosInscritos);
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return new LinkedHashSet<>(conteudosConcluidos); // Retorna cópia para preservar encapsulamento
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = new LinkedHashSet<>(conteudosConcluidos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Dev{" +
                "nome='" + nome + '\'' +
                ", xpTotal=" + calcularTotalXp() +
                ", progresso=" + String.format("%.1f", calcularProgressoPercentual()) + "%" +
                ", conteudosPendentes=" + conteudosInscritos.size() +
                ", conteudosConcluidos=" + conteudosConcluidos.size() +
                '}';
    }
}
