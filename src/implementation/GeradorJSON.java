package implementation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeradorJSON implements GeradorArquivo {

    @Override
    public void escrever(String conteudo) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("documento.json"));

            String conteudoEscapado = conteudo
                    .replace("\\", "\\\\")
                    .replace("\"", "\\\"")
                    .replace("\n", "\\n");

            writer.println("{");
            writer.println("  \"documento\": \"" + conteudoEscapado + "\"");
            writer.println("}");

            writer.close();

            System.out.println("Arquivo JSON gerado com sucesso: documento.json");
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo JSON: " + e.getMessage());
        }
    }
}