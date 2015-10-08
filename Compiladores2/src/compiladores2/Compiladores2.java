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

                if ("sponto_virgula".equals(token.ssimbolo)) {

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
                    System.err.println("; Não encontrado, linha" + lexico.cont);
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

        if ("svar".equals(token.ssimbolo)) {
            token = lexico.token();
            if ("sidentificador".equals(token.ssimbolo)) {
                while ("sidentificador".equals(token.ssimbolo)) {
                    analisaVariaveis();
                    if ("sponto_virgula".equals(token.ssimbolo)) {
                        token = lexico.token();
                    } else {
                        System.err.println("; Não encontrado, linha" + lexico.cont);
                        System.exit(1);
                    }
                }
            } else {
                System.err.println("Var sem nenhuma declaracao, linha" + lexico.cont);
                System.exit(1);
            }
        }
    }

    private static void analisaSubrotinas() {

        int flag = 0;

        if ("sprocedimento".equals(token.ssimbolo) || "sfuncao".equals(token.ssimbolo)) {

        }

        while ("sprocedimento".equals(token.ssimbolo) || "sfuncao".equals(token.ssimbolo)) {
            if ("sprocedimento".equals(token.ssimbolo)) {
                analisaDeclaracaoProcedimento();
            } else {
                analisaDeclaracaoFuncao();
            }

            if ("sponto_virgula".equals(token.ssimbolo)) {
                token = lexico.token();
            } else {
                System.err.println("Falta o ;, linha" + lexico.cont);
                System.exit(1);
            }

            if (flag == 1) {

            }

        }

    }

    private static void analisaComandos() {
        if ("sinicio".equals(token.ssimbolo)) {
            token = lexico.token();
            analisaComandoSimples();

            while (!"sfim".equals(token.ssimbolo)) {
                if ("sponto_virgula".equals(token.ssimbolo)) {
                    token = lexico.token();
                    if (!"sfim".equals(token.ssimbolo)) {
                        analisaComandoSimples();
                    }

                } else {
                    System.err.println(" ; nao encontrado, linha" + lexico.cont);
                    System.exit(1);
                }

                token = lexico.token();
            }
        } else {
            System.err.println("Palavra reservada inicio nao encontrada, linha" + lexico.cont);
            System.exit(1);
        }

    }

    private static void analisaVariaveis() {
        do {
            if ("sidentificador".equals(token.ssimbolo)) {
                token = lexico.token();

                if ("svirgula".equals(token.ssimbolo) || "sdoispontos".equals(token.ssimbolo)) {

                    if ("svirgula".equals(token.ssimbolo)) {

                        token = lexico.token();
                        if ("sdoispontos".equals(token.ssimbolo)) {
                            System.err.println(", não pode vir acompanhada de ;, linha" + lexico.cont);
                            System.exit(1);
                        }
                    }
                } else {
                    System.err.println("Falta , ou :, linha" + lexico.cont);
                    System.exit(1);
                }
            } else {
                System.err.println("Falta o identificador, linha" + lexico.cont);
                System.exit(1);
            }
        } while (!"sdoispontos".equals(token.ssimbolo));

        token = lexico.token();
        analisaTipo();
    }

    private static void analisaTipo() {
        if (!"sinteiro".equals(token.ssimbolo) || !"sbooleano".equals(token.ssimbolo)) {
            System.err.println("Tipo invalido, linha" + lexico.cont);
            System.exit(1);
        }

        token = lexico.token();

    }

    private static void analisaComandoSimples() {
        if ("sidentificador".equals(token.ssimbolo)) {
            analisaAtribChProcedimento();
        } else if ("sse".equals(token.ssimbolo)) {
            analisaSe();
        } else if ("senquanto".equals(token.ssimbolo)) {
            analisaEnquanto();
        } else if ("sleia".equals(token.ssimbolo)) {
            analisaLeia();
        } else if ("sescreva".equals(token.ssimbolo)) {
            analisaEscreva();
        } else {
            analisaComandos();
        }

    }

    private static void analisaAtribChProcedimento() {
        token = lexico.token();
        if ("satribuicao".equals(token.ssimbolo)) {
            analisaAtribuicao();
        } else {
            chamadaProcedimento();
        }
    }

    private static void analisaLeia() {
        token = lexico.token();
        if ("sabre_parenteses".equals(token.ssimbolo)) {
            token = lexico.token();
            if ("sidentificador".equals(token.ssimbolo)) {
                token = lexico.token();
                if ("sfecha_parenteses".equals(token.ssimbolo)) {
                    token = lexico.token();
                } else {
                    System.err.println("Falta o ), linha" + lexico.cont);
                    System.exit(1);
                }
            } else {
                System.err.println("Falta o identificador, linha" + lexico.cont);
                System.exit(1);
            }
        } else {
            System.err.println("Falta o (, linha" + lexico.cont);
            System.exit(1);
        }
    }

    private static void analisaEscreva() {

        token = lexico.token();
        if ("sabre_parenteses".equals(token.ssimbolo)) {
            token = lexico.token();

            if ("sidentificador".equals(token.ssimbolo)) {
                token = lexico.token();

                if ("sfecha_parenteses".equals(token.ssimbolo)) {
                    token = lexico.token();
                } else {
                    System.err.println("Falta o ), linha" + lexico.cont);
                    System.exit(1);
                }

            } else {
                System.err.println("Falta o identificador, linha" + lexico.cont);
                System.exit(1);
            }
        } else {
            System.err.println("Falta o (, linha" + lexico.cont);
            System.exit(1);
        }
    }

    private static void analisaEnquanto() {

    }

    private static void analisaSe() {

    }

    private static void analisaDeclaracaoProcedimento() {

        token = lexico.token();
        if ("sidentificador".equals(token.ssimbolo)) {
            token = lexico.token();
            if ("sponto_virgula".equals(token.ssimbolo)) {
                analisaBloco();
            } else {
                System.err.println("; Não encontrado, linha" + lexico.cont);
                System.exit(1);
            }
        } else {
            System.err.println("Falta o identificador, linha" + lexico.cont);
            System.exit(1);
        }
    }

    private static void analisaDeclaracaoFuncao() {

    }

    private static void analisaExpressao() {
        analisaExpressaoSimples();
        if ("smaior".equals(token.ssimbolo) || "smaiorig".equals(token.ssimbolo) || "smenor".equals(token.ssimbolo) || "smenorig".equals(token.ssimbolo)) {
            token = lexico.token();
            analisaExpressaoSimples();
        }
    }

    private static void analisaExpressaoSimples() {

    }

    private static void analisaTermo() {
        analisaFator();
        while ("smult".equals(token.ssimbolo) || "sdiv".equals(token.ssimbolo) || "se".equals(token.ssimbolo)) {
            token = lexico.token();
            analisaFator();
        }
    }

    private static void analisaFator() {

    }

    private static void chamadaFuncao() {

    }

    private static void analisaAtribuicao() {

    }

    private static void chamadaProcedimento() {

    }
}
