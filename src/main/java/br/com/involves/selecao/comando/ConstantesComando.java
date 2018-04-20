package br.com.involves.selecao.comando;

public class ConstantesComando {
    public static String CM_CONTAR_TODOS = "count *";
    public static String DS_CONTAR_TODOS = "Contagem total de registros importados (sem incluir o cabeçalho)";

    public static String CM_PROPRIEDADES_DISTINTAS = "count distinct";
    public static String DS_PROPRIEDADES_DISTINTAS = "Total de valores distintos da propriedade enviada";

    public static String CM_FILTRAR_PROPRIEDADES = "filter";
    public static String DS_FILTRAR_PROPRIEDADES = "Linha de cabeçalho e todas as linhas em que a propriedade enviada possua o valor especificado";

    public static String CM_SAIR = "exit";
    public static String DS_SAIR = "Finaliza a execução do programa";

    public static String CM_AJUDA = "help";
    public static String DS_AJUDA = "Mostra os comandos disponíveis";
}
