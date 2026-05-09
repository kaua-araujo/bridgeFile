package implementation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeradorHTML implements GeradorArquivo {

    @Override
    public void escrever(String conteudo) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("documento.html"));

            writer.println("<!DOCTYPE html>");
            writer.println("<html lang=\"pt-BR\">");
            writer.println("<head>");
            writer.println("    <meta charset=\"UTF-8\">");
            writer.println("    <title>Documento</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("    <pre>");
            writer.println(conteudo);
            writer.println("    </pre>");
            writer.println("</body>");
            writer.println("</html>");

            writer.close();

            System.out.println("Arquivo HTML gerado com sucesso: documento.html");
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo HTML: " + e.getMessage());
        }
    }
}