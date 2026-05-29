package Questao1;

import java.util.*;

public class CaminhaoGuloso {

    public static void carregarCaminhao(int capacidade, Map<Integer, Integer> itens) {
        List<Map.Entry<Integer, Integer>> ordenados = itens.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .toList();

        Map.Entry<Integer, Integer> menorItem = ordenados.get(0);

        Map<Integer, Integer> carga = new LinkedHashMap<>();
        int volumeUsado = 0;
        int contador = 0;

        while (volumeUsado + menorItem.getValue() <= capacidade) {
            carga.put(contador++, menorItem.getValue());
            volumeUsado += menorItem.getValue();
        }

        carga.remove(--contador);
        volumeUsado -= menorItem.getValue();

        int espacoRestante = capacidade - volumeUsado;
        for (int i = ordenados.size() - 1; i >= 0; i--) {
            if (ordenados.get(i).getValue() <= espacoRestante) {
                carga.put(contador, ordenados.get(i).getValue());
                volumeUsado += ordenados.get(i).getValue();
                break;
            }
        }

        System.out.println("Capacidade do caminhão: " + capacidade + "L");
        System.out.println("\nItens carregados (" + carga.size() + " itens):");
        carga.forEach((id, volume) -> System.out.println("  Item " + id + " -> " + volume + "L"));
        System.out.println("\nVolume utilizado: " + volumeUsado + "L");
        System.out.println("Volume desperdiçado: " + (capacidade - volumeUsado) + "L");
    }
}