package Questao2;
import java.util.ArrayList;
import java.util.List;

public class CalcularViagem {

    private String nome;
    private int valor;
    private int tempo;
    private double prioridade;

    private List<CalcularViagem> lugares;
    private List<CalcularViagem> selecionados;
    private int diasDisponiveis;
    private int diasUsados;
    private int valorTotal;

    public CalcularViagem(int diasDisponiveis) {
        this.diasDisponiveis = diasDisponiveis;
        this.lugares = new ArrayList<>();
        this.selecionados = new ArrayList<>();
        this.diasUsados = 0;
        this.valorTotal = 0;
    }

    private CalcularViagem(String nome, int valor, int tempo) {
        this.nome = nome;
        this.valor = valor;
        this.tempo = tempo;
        this.prioridade = (double) valor / tempo;
    }

    public void adicionarLugar(String nome, int valor, int tempo) {
        lugares.add(new CalcularViagem(nome, valor, tempo));
    }

    private void ordenarPorPrioridade() {
        for (int i = 0; i < lugares.size() - 1; i++) {
            for (int j = 0; j < lugares.size() - 1 - i; j++) {
                if (lugares.get(j).prioridade < lugares.get(j + 1).prioridade) {
                    CalcularViagem temp = lugares.get(j);
                    lugares.set(j, lugares.get(j + 1));
                    lugares.set(j + 1, temp);
                }
            }
        }
    }

    public void selecionarLugares() {
        ordenarPorPrioridade();
        for (CalcularViagem lugar : lugares) {
            boolean cabeNaViagem = diasUsados + lugar.tempo <= diasDisponiveis;
            if (cabeNaViagem) {
                selecionados.add(lugar);
                diasUsados += lugar.tempo;
                valorTotal += lugar.valor;
            }
        }
    }

    public void exibirResultado() {
        System.out.println("Resultado:");

        for (CalcularViagem lugar : lugares) {
    String status = selecionados.contains(lugar) ? "true" : "false";
    System.out.printf("%-10s | tempo: %d | valor: %d | selecionado: %s%n",
            lugar.nome, lugar.tempo, lugar.valor, status);
}

        System.out.print("\nLocais visitados: ");
        for (int i = 0; i < selecionados.size(); i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(selecionados.get(i).nome);
        }

        System.out.printf("%nDias usados: %d de %d%nNão é a solução ideal",diasUsados, diasDisponiveis);
    }
}