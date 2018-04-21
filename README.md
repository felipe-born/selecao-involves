# Seleção Involves - Desenvolvedor Java

Especificações em: https://github.com/involvestecnologia/selecaoinvolves/blob/master/teste-java-2017-07.md

Atualizado pela última vez em: 21/04/2018 às 16:40.

## Usage

Para construir a aplicação, é só usar o comando:
  * mvn clean package
  * navegar no diretório target e verificar o arquivo JAR.

Para executar o arquivo jar, supondo que o nome do arquivo seja selecao-involves.jar:
  * java -classpath selecao-involves.jar br.com.involves.principal.Programa
    * Parâmetro:
    * --file: especifica o arquivo de leitura (ex: --file=cidades.csv). Padrão: cidades.csv.
  
## Teste

Para testar a aplicação, é só usar o comando abaixo:
  * mvn clean test
    * A aplicação possui um plugin do maven para gerar relatório de coverage.