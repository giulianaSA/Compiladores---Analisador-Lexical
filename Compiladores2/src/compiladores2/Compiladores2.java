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
        while (token != null) {
            System.out.println(token.lexema + " " + token.ssimbolo + " ");
            token = lexico.token();
        }
    }

}
