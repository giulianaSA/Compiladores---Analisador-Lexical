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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Lexico lexico = new Lexico();
        Token token = lexico.token();
        if ("sprograma".equals(token.ssimbolo)) {
            token = lexico.token();

            if ("sidentificador".equals(token.ssimbolo)) {
                token = lexico.token();

                if ("spontovirgula".equals(token.ssimbolo)) {

//AnalisaBloco
                    if ("sponto".equals(token.ssimbolo)) {
                       
                        if (lexico.token() == null) {
//sucesso                   
                        }else
                            System.err.println("Comandos após o fim do programa, linha"+Lexico.cont);
                    }
                }

            }
        }

        while (token != null) {
            System.out.println(token.lexema + " " + token.ssimbolo + " ");
            token = lexico.token();
        }
    }

}
