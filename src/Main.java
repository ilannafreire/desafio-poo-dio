import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // Demonstrando uso dos novos construtores e validações
            Curso curso1 = new Curso("Curso Java Avançado", "Programação orientada a objetos com Java", 40);
            Curso curso2 = new Curso("Curso JavaScript", "Desenvolvimento web com JavaScript", 20);

            Mentoria mentoria = new Mentoria("Mentoria de Carreira", "Como se destacar como desenvolvedor", LocalDate.now().plusDays(7));

            // Demonstrando novo tipo de conteúdo
            Desafio desafio = new Desafio("Desafio POO", "Implemente um sistema de biblioteca", "Java", 4);

            // Usando a Factory (demonstrando polimorfismo)
            Conteudo cursoFactory = ConteudoFactory.criarCurso("Spring Boot", "Framework para Java", 30);

            System.out.println("=== CONTEÚDOS CRIADOS ===");
            System.out.println(curso1);
            System.out.println(curso2);
            System.out.println(mentoria);
            System.out.println(desafio);
            System.out.println(cursoFactory);

            // Criando bootcamp com validações
            Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Torne-se um desenvolvedor Java completo");
            bootcamp.adicionarConteudo(curso1);
            bootcamp.adicionarConteudo(curso2);
            bootcamp.adicionarConteudo(mentoria);
            bootcamp.adicionarConteudo(desafio);
            bootcamp.adicionarConteudo(cursoFactory);

            System.out.println("\n=== BOOTCAMP ===");
            System.out.println(bootcamp);

            // Criando devs com construtores
            Dev devCamila = new Dev("Camila Santos");
            Dev devJoao = new Dev("João Silva");

            // Demonstrando inscrição e progresso
            devCamila.inscreverBootcamp(bootcamp);
            devJoao.inscreverBootcamp(bootcamp);

            System.out.println("\n=== PROGRESSO INICIAL ===");
            System.out.println(devCamila);
            System.out.println(devJoao);

            // Simulando progresso
            System.out.println("\n=== SIMULANDO PROGRESSO ===");
            devCamila.progredir(); // Completa primeiro conteúdo
            devCamila.progredir(); // Completa segundo conteúdo
            devCamila.progredir(); // Completa terceiro conteúdo

            devJoao.progredir(); // Completa primeiro conteúdo

            System.out.println("Camila após progredir:");
            System.out.println("- XP Total: " + devCamila.calcularTotalXp());
            System.out.println("- Progresso: " + String.format("%.1f", devCamila.calcularProgressoPercentual()) + "%");
            System.out.println("- Tem conteúdo pendente: " + devCamila.temConteudoPendente());

            System.out.println("\nJoão após progredir:");
            System.out.println("- XP Total: " + devJoao.calcularTotalXp());
            System.out.println("- Progresso: " + String.format("%.1f", devJoao.calcularProgressoPercentual()) + "%");
            System.out.println("- Tem conteúdo pendente: " + devJoao.temConteudoPendente());

            System.out.println("\n=== STATUS FINAL DOS DEVS ===");
            System.out.println(devCamila);
            System.out.println(devJoao);

            System.out.println("\n=== INFORMAÇÕES DO BOOTCAMP ===");
            System.out.println("Total de devs inscritos: " + bootcamp.getTotalDevsInscritos());
            System.out.println("Total de conteúdos: " + bootcamp.getTotalConteudos());
            System.out.println("Bootcamp ativo: " + bootcamp.isAtivo());

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}

