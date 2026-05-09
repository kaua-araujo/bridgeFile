package concrete;

import abstraction.Documento;
import implementation.GeradorArquivo;

public class PropostaComercial extends Documento {

    private String empresa;
    private String descricao;
    private String prazoEntrega;
    private String valor;
    private String validade;

    public PropostaComercial(
            GeradorArquivo gerador,
            String empresa,
            String descricao,
            String prazoEntrega,
            String valor,
            String validade) {

        super(gerador);
        this.empresa = empresa;
        this.descricao = descricao;
        this.prazoEntrega = prazoEntrega;
        this.valor = valor;
        this.validade = validade;
    }

    @Override
    public void gerar() {
        String conteudo = "PROPOSTA COMERCIAL\n" +
                "------------------\n" +
                "Empresa: " + empresa + "\n" +
                "Descrição: " + descricao + "\n" +
                "Prazo de entrega: " + prazoEntrega + "\n" +
                "Valor da proposta: " + valor + "\n" +
                "Validade da proposta: " + validade;

        gerador.escrever(conteudo);
    }
}