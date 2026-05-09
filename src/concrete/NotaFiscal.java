package concrete;

import java.util.List;

import abstraction.Documento;
import implementation.GeradorArquivo;

public class NotaFiscal extends Documento {

        private String numero;
        private String cliente;
        private List<ItemNotaFiscal> itens;

        public NotaFiscal(
                        GeradorArquivo gerador,
                        String numero,
                        String cliente,
                        List<ItemNotaFiscal> itens) {

                super(gerador);
                this.numero = numero;
                this.cliente = cliente;
                this.itens = itens;
        }

        @Override
        public void gerar() {
                StringBuilder conteudo = new StringBuilder();
                double subtotal = 0.0;

                conteudo.append("NOTA FISCAL\n");
                conteudo.append("===========\n");
                conteudo.append("Número: ").append(numero).append("\n");
                conteudo.append("Cliente: ").append(cliente).append("\n\n");
                conteudo.append("Itens:\n");

                for (ItemNotaFiscal item : itens) {
                        conteudo.append("- ")
                                        .append(item.getDescricao())
                                        .append(" | Qtd: ")
                                        .append(item.getQuantidade())
                                        .append(" | Unitário: R$ ")
                                        .append(String.format("%.2f", item.getValorUnitario()))
                                        .append(" | Total: R$ ")
                                        .append(String.format("%.2f", item.getTotal()))
                                        .append("\n");

                        subtotal += item.getTotal();
                }

                double impostos = subtotal * 0.10;
                double total = subtotal + impostos;

                conteudo.append("\nSubtotal: R$ ")
                                .append(String.format("%.2f", subtotal))
                                .append("\n");

                conteudo.append("Impostos (10%): R$ ")
                                .append(String.format("%.2f", impostos))
                                .append("\n");

                conteudo.append("Total: R$ ")
                                .append(String.format("%.2f", total));

                gerador.escrever(conteudo.toString());
        }
}