package concrete;

import abstraction.Documento;
import implementation.GeradorArquivo;

public class RelatorioGerencial extends Documento {

    private String faturamento;
    private String despesas;
    private String lucro;
    private String crescimento;
    private String observacoes;

    public RelatorioGerencial(
            GeradorArquivo gerador,
            String faturamento,
            String despesas,
            String lucro,
            String crescimento,
            String observacoes) {

        super(gerador);
        this.faturamento = faturamento;
        this.despesas = despesas;
        this.lucro = lucro;
        this.crescimento = crescimento;
        this.observacoes = observacoes;
    }

    @Override
    public void gerar() {
        String conteudo = "RELATÓRIO GERENCIAL\n" +
                "-------------------\n" +
                "Faturamento do mês: " + faturamento + "\n" +
                "Despesas operacionais: " + despesas + "\n" +
                "Lucro líquido: " + lucro + "\n" +
                "Crescimento em relação ao mês anterior: " + crescimento + "\n" +
                "Observações: " + observacoes;

        gerador.escrever(conteudo);
    }
}