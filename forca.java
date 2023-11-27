package treinamento;
import java.util.Scanner;

public class forca {
    public static void main(String[] args) {
        String palavra = "bicicleta";
        String letrasUsada = "";
        String palavraAdivinhada = "";
        int maxTentativas = 10;

        for (int i = 0; i < palavra.length(); i++) {
            palavraAdivinhada += "_";
            for (int tentativas = 0; tentativas < maxTentativas; tentativas++) {
                if (tentativas == maxTentativas - 1) {
                    System.out.printf("Foram 10 tentativas... A palavra era '%s'%n", palavra);
                    System.exit(0);
                }
                System.out.printf("Rodada %d. Ate agora adivinhada %s. Qual a sua proxima letra?%n", tentativas, palavraAdivinhada);

                char letraTentada = new Scanner(System.in).next().charAt(0);
                if (letrasUsada.indexOf(letraTentada) >= 0) {
                    System.out.printf("Você ja tentou a letra %c%n", letraTentada);
                } else {
                    letrasUsada += letraTentada;

                    boolean letraEncontrada = false;
                    StringBuilder novaPalavraAdivinhada = new StringBuilder();
                    for (int j = 0; j < palavra.length(); j++) {
                        if (letrasUsada.indexOf(palavra.charAt(j)) >= 0) {
                            novaPalavraAdivinhada.append(palavra.charAt(j));
                            letraEncontrada = true;
                        } else {
                            novaPalavraAdivinhada.append("_");
                        }
                    }

                    palavraAdivinhada = novaPalavraAdivinhada.toString();

                    if (letraEncontrada) {
                        System.out.printf("Muito bom! %s existe na palavra. Ainda tem letras escondidas%n", letraTentada);
                    }

                    if (!palavraAdivinhada.contains("_")) {
                        System.out.printf("Parabens! A palavra adivinhada era '%s'%n", palavraAdivinhada);
                        System.exit(0);
                    }
                }
            }
        }
    }
}
