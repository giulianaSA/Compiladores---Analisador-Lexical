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

                    analisaBloco();
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

    public static void analisaBloco() {
        token = lexico.token();
        analisaEtVariaveis();
        analisaSubrotinas();
        analisaComandos();
    }

    private static void analisaEtVariaveis() {
        
    }

    private static void analisaSubrotinas() {

    }

    private static void analisaComandos() {

    }
    
    private static void analisaVariaveis() {

    }
    
    private static void analisaTipo() {

    }
    
    private static void analisaComandoSimples() {

    }
    
    private static void analisaAtribChProcedimento() {

    }

    private static void analisaLeia() {

    }
    
    private static void analisaEscreva() {

    }
    
    private static void analisaEnquanto() {

    }
    
    private static void analisaSe() {

    }
    
    private static void analisaDeclaracaoProcedimento() {

    }
    
    private static void analisaDeclaracaoFuncao() {

    }
    
    private static void analisaExpressao() {

    }
    
    private static void analisaExpressaoSimples() {

    }
    
    private static void analisaTermo() {

    }
    
    private static void analisaFator() {

    }
    
    private static void analisaChamadaProcedimento() {

    }
    
    private static void analisaChamadaFuncao() {

    }
}
