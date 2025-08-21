package br.com.dio.desafio.dominio;

/**
 * Interface que define estratégias para cálculo de XP
 * Aplicando o padrão Strategy para maior flexibilidade
 */
public interface CalculadoraXP {

    /**
     * Calcula o XP baseado no tipo e características do conteúdo
     * @param conteudo O conteúdo para calcular XP
     * @return Valor do XP calculado
     */
    double calcular(Conteudo conteudo);
}
