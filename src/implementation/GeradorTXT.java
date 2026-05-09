package implementation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeradorTXT implements GeradorArquivo {

    @Override
    public void escrever(String conteudo) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("documento.txt"));
            writer.print(conteudo);
            writer.close();

            System.out.println("Arquivo TXT gerado com sucesso: documento.txt");
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo TXT: " + e.getMessage());
        }
    }
}