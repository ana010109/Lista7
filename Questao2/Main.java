package Questao2;
public class Main {

    public static void main(String[] args) {
        CalcularViagem viagem = new CalcularViagem(7);

        viagem.adicionarLugar("Museu",   10, 2);
        viagem.adicionarLugar("Torre",   18, 5);
        viagem.adicionarLugar("Parque",   8, 1);
        viagem.adicionarLugar("Castelo", 12, 3);

        viagem.selecionarLugares();
        viagem.exibirResultado();
    }
}