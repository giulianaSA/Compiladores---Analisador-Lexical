/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores2;

/**
 *
 * @author thiagoalves
 */
public class Compiladores2 {

    private static final Lexico lexico = new Lexico();
    private static Token token;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        token = lexico.token();
        if ("sprograma".equals(token.ssimbolo)) {
            token = lexico.token();

            if ("sidentificador".equals(token.ssimbolo)) {
                token = lexico.token();

                if ("spontovirgula".equals(token.ssimbolo)) {

                    AnalisaBloco();
                    if ("sponto".equals(token.ssimbolo)) {

                        if (lexico.token() == null) {
                            System.out.println("Compilado com sucesso");
                        } else {
                            System.err.println("Comandos após o fim do programa, linha" + lexico.cont);
                            System.exit(1);

                        }
                    } else {
                        System.err.println(". Não encontrado, linha" + lexico.cont);
                        System.exit(1);
                    }
                } else {
                    System.err.println(". Não encontrado, linha" + lexico.cont);
                    System.exit(1);

                }

            } else {
                System.err.println("Nome do programa não encontrado, linha " + token.ssimbolo);
                System.exit(1);

            }
        } else {
            System.err.println("Palavra reservada programa não encontrado, linha" + lexico.cont);
            System.exit(1);

        }

        while (token != null) {
            System.out.println(token.lexema + " " + token.ssimbolo + " ");
            token = lexico.token();
        }
    }

    public static void AnalisaBloco() {
        token = lexico.token();
        Analisa_et_variaveis();
        Analisa_subrotinas();
        Analisa_comandos();
    }

    private static void Analisa_et_variaveis() {
        
    }

    private static void Analisa_subrotinas() {

    }

    private static void Analisa_comandos() {

    }

}
