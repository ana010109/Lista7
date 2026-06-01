package Questao1;

import java.util.*;

public class CaminhaoGuloso {

    public static void carregarCaminhao(int capacidade, Map<Integer, Integer> itens) {
        List<Map.Entry<Integer, Integer>> ordenados = ordenarPorVolume(itens);
        Map<Integer, Integer> carga = montarCarga(capacidade, ordenados);
        int volumeUsado = carga.values().stream().mapToInt(Integer::intValue).sum();

        exibirResultado(capacidade, carga, volumeUsado);
    }

    private static List<Map.Entry<Integer, Integer>> ordenarPorVolume(Map<Integer, Integer> itens) {
        return itens.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .toList();
    }

    private static Map<Integer, Integer> montarCarga(int capacidade, List<Map.Entry<Integer, Integer>> ordenados) {
        Map<Integer, Integer> carga = new LinkedHashMap<>();
        int volumeUsado = 0;
        int contador = 0;

        int menorVolume = ordenados.get(0).getValue();
        while (volumeUsado + menorVolume <= capacidade) {
            carga.put(contador++, menorVolume);
            volumeUsado += menorVolume;
        }

        carga.remove(--contador);
        volumeUsado -= menorVolume;

        Integer itemQueCabe = encontrarItemQueCabe(ordenados, capacidade - volumeUsado);
        if (itemQueCabe != null) {
            carga.put(contador, itemQueCabe);
        }

        return carga;
    }

    private static Integer encontrarItemQueCabe(List<Map.Entry<Integer, Integer>> ordenados, int espacoRestante) {
        for (int i = ordenados.size() - 1; i >= 0; i--) {
            if (ordenados.get(i).getValue() <= espacoRestante) {
                return ordenados.get(i).getValue();
            }
        }
        return null;
    }

    private static void exibirResultado(int capacidade, Map<Integer, Integer> carga, int volumeUsado) {
        System.out.println("Capacidade do caminhão: " + capacidade + "L");
        System.out.println("\nItens carregados (" + carga.size() + " itens):");
        carga.forEach((id, volume) -> System.out.println("  Item " + id + " -> " + volume + "L"));
        System.out.println("\nVolume utilizado: " + volumeUsado + "L");
        System.out.println("Volume desperdiçado: " + (capacidade - volumeUsado) + "L");
    }
}