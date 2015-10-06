/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisadorlexico;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giuliana e Matheus
 */
public class AnalisadorLexico {

    public static InputStreamReader entrada;
    public static List<Token> lista = new ArrayList<>();
    public static int letra;
    public static  int cont = 1;
     
    public static void arquivo() {

        String arquivo= "/Users/thiagoalves/Documents/Projects/Compiladores---Analisador-Lexical/teste3.txt";

        FileInputStream arq;
        try {
            arq = new FileInputStream(arquivo);
            entrada = new InputStreamReader(arq);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AnalisadorLexico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int proximoCaracter() {
        try {
            return entrada.read();
        } catch (IOException ex) {
            Logger.getLogger(AnalisadorLexico.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public static void main(String[] args) {

       
        arquivo();
      String string="";
    
      letra = proximoCaracter();

        while (letra != -1) {

           if((char)letra==' ')
            {

                letra = proximoCaracter();
                while((char)letra==' ')
                    letra = proximoCaracter();
            }
            
                        
            if((char)letra=='{')
            while(letra!=-1){
                letra=proximoCaracter();

                 if((char)letra=='}' )
                  {
                   letra=proximoCaracter();
                   break;
                  }
                if(letra == -1)
                {
                    System.out.printf("Nao foi encontrado um }.Linha %d\n",cont);
                    System.exit(0);
                }
                
                 if ((char) letra == '\n') {
                    cont++;
                }
            }
             if((char)letra=='}')
            {
                System.out.printf("Nao foi encontrado um { correspondente. Linha %d\n",cont);
                System.exit(0);
            }

             
            if ((char) letra == '\n') {
                cont++;
            }

            if (letra != -1) {
                pegaToken((char) letra);
            }
        }

        for (Token lista1 : lista) {
            System.out.println(lista1);
        }

    }

    public static void pegaToken(char letra) {
        if ((char) letra == '1' || (char) letra == '2' || (char) letra == '3' || (char) letra == '4' || (char) letra == '5' || (char) letra == '6' || (char) letra == '7' || (char) letra == '8' || (char) letra == '9') {
            trataDigito((char) letra);
        } else if ((char) letra == ':') {
            trataAtribuicao((char) letra);
        } else if ((char) letra == '+' || (char) letra == '-' || (char) letra == '*') {
            trataOperadorAritmetico();
        } else if ((char) letra == '>' || (char) letra == '<' || (char) letra == '!') {
            trataOperadorRelacional((char) letra);
        } else if ((char) letra == '.' || (char) letra == ',' || (char) letra == ';' || (char) letra == '(' || (char) letra == ')' || (char) letra == '=') {
            trataPontuacao((char) letra);
        } else if ((char) letra == '\n') {
            trataPulaLinha();
        } else {
            trataLetra((char) letra);
        }
              
    }

    public static void trataDigito(char opdigito) {
        letra = opdigito;
        String digito = "";
        while (((char) letra == '0' || (char) letra == '1' || (char) letra == '2' || (char) letra == '3' || (char) letra == '4' || (char) letra == '5' || (char) letra == '6' || (char) letra == '7' || (char) letra == '8' || (char) letra == '9') && letra != -1) {
            digito += (char)letra;
            letra = proximoCaracter();
            // System.out.printf("Letra d = %c\n",(char)letra);
        }
        Token token = new Token();
        token.lexema = digito;
        token.ssimbolo = "Snumero";
        lista.add(token);
    }

    public static void trataAtribuicao(char doisPontos) {
        letra = doisPontos;
        String atribuicao = "" + doisPontos;

        letra = proximoCaracter();
        if ((char) letra == '=') {
            atribuicao += (char) letra;
            letra = proximoCaracter();
        }
        lista.add(new Token(atribuicao));
        letra = proximoCaracter();
    }

    public static void trataOperadorAritmetico() {
        lista.add(new Token((char) letra + ""));
        letra = proximoCaracter();
    }

    public static void trataOperadorRelacional(char opR) {
        letra = opR;
        String operadorRelacional = "";

        operadorRelacional += (char) letra;
        letra = proximoCaracter();
        if ((char) letra == '=') {
            operadorRelacional += (char) letra;
            lista.add(new Token(operadorRelacional));
            letra = proximoCaracter();
        } else if (((char) letra != '=') && operadorRelacional.equals("!")) {
            System.out.printf("Operador ! necessita vir acompanhado de um operador = em seguida\n");
        } else {
            lista.add(new Token(operadorRelacional));
            letra = proximoCaracter();
        }
    }

    public static void trataPontuacao(char opPontuacao) {
        letra = opPontuacao;
        String pontuacao = "" + opPontuacao;
        lista.add(new Token(pontuacao));
        letra = proximoCaracter();
    }

    public static void trataLetra(char letraOuDigito) {
        Character character= new Character(letraOuDigito);
        String palavra = "";
        
        if(Character.isLetterOrDigit(character))
        {
             letra = letraOuDigito;
            palavra += (char) letra;
        
        
        letra = proximoCaracter();
            while(Character.isLetterOrDigit((char)letra)|| (char)letra=='_'){
            palavra += (char) letra;
            letra = proximoCaracter();
            }
        
         if(!(palavra.equals("\n")))
         lista.add(new Token(palavra.trim()));
       }
 else
          { 
                 if ((char) letra == '\r' || (char) letra == '\t') {
                trataPulaLinha();
                  }
                
               else{
                   System.out.printf("Simbolo inválido '%c' Linha:%d\n",(char)letra,cont);
                   System.exit(0);
               }
          }  
               
}
    private static void trataPulaLinha() {
        letra = proximoCaracter();
    }
}
