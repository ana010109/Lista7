package Questao3;

import java.util.*;

public class EstacoesGuloso {

    public static void escolherEstacoes(Set<String> estadosAlvo, Map<String, Set<String>> estacoes) {
        Set<String> estadosRestantes = new HashSet<>(estadosAlvo);
        List<String> contratadas = new ArrayList<>();

        while (!estadosRestantes.isEmpty()) {
            String melhorEstacao = encontrarMelhorEstacao(estadosRestantes, estacoes);

            if (melhorEstacao == null) {
                break;
            }

            contratadas.add(melhorEstacao);
            estadosRestantes.removeAll(estacoes.get(melhorEstacao));
        }

        exibirResultado(estadosAlvo, estadosRestantes, contratadas, estacoes);
    }

    private static String encontrarMelhorEstacao(Set<String> estadosRestantes, Map<String, Set<String>> estacoes) {
        String melhorEstacao = null;
        int maiorCobertura = 0;

        for (Map.Entry<String, Set<String>> estacao : estacoes.entrySet()) {
            Set<String> cobertos = new HashSet<>(estacao.getValue());
            cobertos.retainAll(estadosRestantes);

            if (cobertos.size() > maiorCobertura) {
                maiorCobertura = cobertos.size();
                melhorEstacao = estacao.getKey();
            }
        }

        return melhorEstacao;
    }

    private static void exibirResultado(Set<String> estadosAlvo, Set<String> estadosRestantes,
                                        List<String> contratadas, Map<String, Set<String>> estacoes) {
        System.out.println("Estados alvo: " + estadosAlvo);
        System.out.println("\nEstações contratadas (" + contratadas.size() + "):");
        contratadas.forEach(estacao ->
                System.out.println("  " + estacao + " -> " + estacoes.get(estacao)));

        if (estadosRestantes.isEmpty()) {
            System.out.println("\nTodos os estados alvo foram cobertos!");
        } else {
            System.out.println("\nEstados não cobertos: " + estadosRestantes);
        }
    }
}
