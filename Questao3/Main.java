package Questao3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<String> estadosAlvo = new HashSet<>(
                Arrays.asList("mt", "rj", "es", "sp", "sc", "rs", "pr", "ms"));

        Map<String, Set<String>> estacoes = new LinkedHashMap<>();
        estacoes.put("Kum", new HashSet<>(Arrays.asList("sp", "sc", "rs")));
        estacoes.put("Kdois", new HashSet<>(Arrays.asList("rj", "sp", "mt")));
        estacoes.put("Ktres", new HashSet<>(Arrays.asList("es", "sc", "pr")));
        estacoes.put("Kquatro", new HashSet<>(Arrays.asList("sc", "rs")));
        estacoes.put("Kcinco", new HashSet<>(Arrays.asList("pr", "ms")));

        EstacoesGuloso.escolherEstacoes(estadosAlvo, estacoes);
    }
}
