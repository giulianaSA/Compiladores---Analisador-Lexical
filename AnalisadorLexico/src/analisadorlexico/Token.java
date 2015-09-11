/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package analisadorlexico;

/**
 *
 * @author Giuliana e Matheus
 */
public class Token {
   
    public String lexema;
    public String ssimbolo;

    @Override
    public String toString() {
        return this.lexema + " - " + this.ssimbolo; //To change body of generated methods, choose Tools | Templates.
    }

    public Token()
    {
        
    }

    public Token(String palavra)
    {
             this.lexema = palavra;
             
        if(palavra.trim().equals("programa"))
            this.ssimbolo = "sprograma";
        else if(palavra.trim().equals("var"))
                this.ssimbolo = "svar";
        else if(palavra.trim().equals("inicio"))
                this.ssimbolo = "sinicio";
        else if(palavra.trim().equals("fim"))
                this.ssimbolo = "sfim";
        else if(palavra.trim().equals("procedimento"))
                this.ssimbolo = "sprocedimento";
        else if(palavra.trim().equals("funcao"))
                this.ssimbolo = "sfuncao";
        else if(palavra.trim().equals("se"))
                this.ssimbolo = "sse";
        else if(palavra.trim().equals("entao"))
                this.ssimbolo = "sentao";
        else if(palavra.trim().equals("senao"))
                this.ssimbolo = "ssenao";
        else if(palavra.trim().equals("enquanto"))
                this.ssimbolo = "senquanto";
        else if(palavra.trim().equals("faca"))
                this.ssimbolo = "sfaca";
        else if(palavra.trim().equals(":="))
                this.ssimbolo = "satribuicao";
        else if(palavra.trim().equals("escreva"))
                this.ssimbolo = "sescreva";
        else if(palavra.trim().equals("leia"))
                this.ssimbolo = "sleia";
        else if(palavra.trim().equals("inteiro"))
                this.ssimbolo = "sinteiro";
        else if(palavra.trim().equals("booleano"))
                this.ssimbolo = "sbooleano";
        else if(palavra.trim().equals("identificador"))
                this.ssimbolo = "sidentificador";
        else if(palavra.trim().equals("numero"))
                this.ssimbolo = "snumero";
        else if(palavra.trim().equals("."))
                this.ssimbolo = "sponto";
        else if(palavra.trim().equals(";"))
                this.ssimbolo = "sponto_virgula";
        else if(palavra.trim().equals(","))
                this.ssimbolo = "svirgula";
        else if(palavra.trim().equals("("))
                this.ssimbolo = "sabre_parenteses";
        else if(palavra.trim().equals(")"))
                this.ssimbolo = "sfecha_parenteses";
        else if(palavra.trim().equals(">"))
                this.ssimbolo = "smaior";
        else if(palavra.trim().equals("<"))
                this.ssimbolo = "smenor";
        else if(palavra.trim().equals(">="))
                this.ssimbolo = "smaiorig";
        else if(palavra.trim().equals("<="))
                this.ssimbolo = "smenorig";
        else if(palavra.trim().equals("="))
                this.ssimbolo = "sig";
        else if(palavra.trim().equals("!="))
                this.ssimbolo = "sdif";
        else if(palavra.trim().equals("+"))
                this.ssimbolo = "smais";
        else if(palavra.trim().equals("-"))
                this.ssimbolo = "smenos";
        else if(palavra.trim().equals("*"))
                this.ssimbolo = "smult";
        else if(palavra.trim().equals("div"))
                this.ssimbolo = "sdiv";
        else if(palavra.trim().equals("e"))
                this.ssimbolo = "Se";
        else if(palavra.trim().equals("nao"))
                this.ssimbolo = "snao";
        else if(palavra.trim().equals("ou"))
                this.ssimbolo = "Sou";
        else if(palavra.trim().equals(":"))
                this.ssimbolo = "sdoispontos";
        else if(palavra.trim().equals("integer"))
                this.ssimbolo = "sinteiro";
         else if(palavra.trim().equals("\n"))
                this.ssimbolo = "SPulaLinha";
        else 
           this.ssimbolo = "Sidentificador";   
    }
    
    public Token trataToken (String palavra)
    {
        this.lexema = palavra;
        
       if(palavra.trim().equals("programa"))
            this.ssimbolo = "sprograma";
        else if(palavra.trim().equals("var"))
                this.ssimbolo = "svar";
        else if(palavra.trim().equals("inicio"))
                this.ssimbolo = "sinicio";
        else if(palavra.trim().equals("fim"))
                this.ssimbolo = "sfim";
        else if(palavra.trim().equals("procedimento"))
                this.ssimbolo = "sprocedimento";
        else if(palavra.trim().equals("funcao"))
                this.ssimbolo = "sfuncao";
        else if(palavra.trim().equals("se"))
                this.ssimbolo = "sse";
        else if(palavra.trim().equals("entao"))
                this.ssimbolo = "sentao";
        else if(palavra.trim().equals("senao"))
                this.ssimbolo = "ssenao";
        else if(palavra.trim().equals("enquanto"))
                this.ssimbolo = "senquanto";
        else if(palavra.trim().equals("faca"))
                this.ssimbolo = "sfaca";
        else if(palavra.trim().equals(":="))
                this.ssimbolo = "satribuicao";
        else if(palavra.trim().equals("escreva"))
                this.ssimbolo = "sescreva";
        else if(palavra.trim().equals("leia"))
                this.ssimbolo = "sleia";
        else if(palavra.trim().equals("inteiro"))
                this.ssimbolo = "sinteiro";
        else if(palavra.trim().equals("booleano"))
                this.ssimbolo = "sbooleano";
        else if(palavra.trim().equals("identificador"))
                this.ssimbolo = "sidentificador";
        else if(palavra.trim().equals("numero"))
                this.ssimbolo = "snumero";
        else if(palavra.trim().equals("."))
                this.ssimbolo = "sponto";
        else if(palavra.trim().equals(";"))
                this.ssimbolo = "sponto_virgula";
        else if(palavra.trim().equals(","))
                this.ssimbolo = "svirgula";
        else if(palavra.trim().equals("("))
                this.ssimbolo = "sabre_parenteses";
        else if(palavra.trim().equals(")"))
                this.ssimbolo = "sfecha_parenteses";
        else if(palavra.trim().equals(">"))
                this.ssimbolo = "smaior";
        else if(palavra.trim().equals("<"))
                this.ssimbolo = "smenor";
        else if(palavra.trim().equals(">="))
                this.ssimbolo = "smaiorig";
        else if(palavra.trim().equals("<="))
                this.ssimbolo = "smenorig";
        else if(palavra.trim().equals("="))
                this.ssimbolo = "sig";
        else if(palavra.trim().equals("!="))
                this.ssimbolo = "sdif";
        else if(palavra.trim().equals("+"))
                this.ssimbolo = "smais";
        else if(palavra.trim().equals("-"))
                this.ssimbolo = "smenos";
        else if(palavra.trim().equals("*"))
                this.ssimbolo = "smult";
        else if(palavra.trim().equals("div"))
                this.ssimbolo = "sdiv";
        else if(palavra.trim().equals("e"))
                this.ssimbolo = "Se";
        else if(palavra.trim().equals("nao"))
                this.ssimbolo = "snao";
        else if(palavra.trim().equals("ou"))
                this.ssimbolo = "Sou";
        else if(palavra.trim().equals(":"))
                this.ssimbolo = "sdoispontos";
        else if(palavra.trim().equals("integer"))
                this.ssimbolo = "sinteiro";
         else if(palavra.trim().equals("\n"))
                this.ssimbolo = "SPulaLinha";
        else 
           this.ssimbolo = "Sidentificador";
       
       return this;
    }
       
}
