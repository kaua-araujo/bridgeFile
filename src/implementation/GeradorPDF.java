package implementation;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeradorPDF implements GeradorArquivo {

    @Override
    public void escrever(String conteudo) {
        String nomeArquivo = "documento.pdf";

        try {

            Document document = new Document();

            PdfWriter.getInstance(
                    document,
                    new FileOutputStream(nomeArquivo));

            document.open();

            String[] linhas = conteudo.split("\\n");

            for (String linha : linhas) {
                document.add(new Paragraph(linha));
            }

            document.close();

            System.out.println(
                    "Arquivo PDF gerado com sucesso: " + nomeArquivo);

        } catch (Exception e) {
            System.out.println(
                    "Erro ao gerar PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
}