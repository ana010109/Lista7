package Questao1;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Integer> itens = new HashMap<>();
        itens.put(1, 40);
        itens.put(2, 30);
        itens.put(3, 25);
        itens.put(4, 20);
        itens.put(5, 15);

        CaminhaoGuloso.carregarCaminhao(100, itens);
    }
}
