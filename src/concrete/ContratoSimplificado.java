package concrete;

import abstraction.Documento;
import implementation.GeradorArquivo;

public class ContratoSimplificado extends Documento {

    private String contratante;
    private String contratado;
    private String objeto;
    private String valor;
    private String prazo;
    private String assinatura;

    public ContratoSimplificado(
            GeradorArquivo gerador,
            String contratante,
            String contratado,
            String objeto,
            String valor,
            String prazo,
            String assinatura) {

        super(gerador);
        this.contratante = contratante;
        this.contratado = contratado;
        this.objeto = objeto;
        this.valor = valor;
        this.prazo = prazo;
        this.assinatura = assinatura;
    }

    @Override
    public void gerar() {
        String conteudo = "CONTRATO SIMPLIFICADO\n" +
                "---------------------\n" +
                "Contratante: " + contratante + "\n" +
                "Contratado: " + contratado + "\n" +
                "Objeto do contrato: " + objeto + "\n" +
                "Valor acordado: " + valor + "\n" +
                "Prazo de execução: " + prazo + "\n" +
                "Assinatura: " + assinatura;

        gerador.escrever(conteudo);
    }
}