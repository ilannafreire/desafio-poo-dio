package br.com.dio.desafio.dominio;

import java.time.LocalDate;

/**
 * Factory para criação de conteúdos
 * Aplicando o padrão Factory Method para centralizar a criação de objetos
 */
public class ConteudoFactory {

    public static Curso criarCurso(String titulo, String descricao, int cargaHoraria) {
        return new Curso(titulo, descricao, cargaHoraria);
    }

    public static Mentoria criarMentoria(String titulo, String descricao, LocalDate data) {
        return new Mentoria(titulo, descricao, data);
    }

    public static Desafio criarDesafio(String titulo, String descricao, String linguagem, int nivelDificuldade) {
        return new Desafio(titulo, descricao, linguagem, nivelDificuldade);
    }

    /**
     * Cria conteúdo baseado no tipo especificado
     * @param tipo Tipo do conteúdo ("CURSO", "MENTORIA", "DESAFIO")
     * @param parametros Array com os parâmetros necessários para cada tipo
     * @return Conteúdo criado
     */
    public static Conteudo criarConteudo(String tipo, Object... parametros) {
        switch (tipo.toUpperCase()) {
            case "CURSO":
                if (parametros.length >= 3) {
                    return criarCurso((String) parametros[0], (String) parametros[1], (Integer) parametros[2]);
                }
                break;
            case "MENTORIA":
                if (parametros.length >= 3) {
                    return criarMentoria((String) parametros[0], (String) parametros[1], (LocalDate) parametros[2]);
                }
                break;
            case "DESAFIO":
                if (parametros.length >= 4) {
                    return criarDesafio((String) parametros[0], (String) parametros[1], (String) parametros[2], (Integer) parametros[3]);
                }
                break;
        }
        throw new IllegalArgumentException("Tipo de conteúdo inválido ou parâmetros insuficientes");
    }
}
