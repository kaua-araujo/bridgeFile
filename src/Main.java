import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import abstraction.Documento;
import concrete.ContratoSimplificado;
import concrete.ItemNotaFiscal;
import concrete.NotaFiscal;
import concrete.PropostaComercial;
import concrete.RelatorioGerencial;
import implementation.GeradorArquivo;
import implementation.GeradorHTML;
import implementation.GeradorJSON;
import implementation.GeradorPDF;
import implementation.GeradorTXT;

public class Main {

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("========================================");
                System.out.println("   SISTEMA DE GERAÇÃO DE DOCUMENTOS");
                System.out.println("========================================");

                System.out.println("\nEscolha o documento que deseja gerar:");
                System.out.println("1 - Relatório Gerencial");
                System.out.println("2 - Nota Fiscal");
                System.out.println("3 - Proposta Comercial");
                System.out.println("4 - Contrato Simplificado");
                System.out.print("Opção: ");
                int opcaoDocumento = Integer.parseInt(scanner.nextLine());

                System.out.println("\nEscolha o formato de saída:");
                System.out.println("1 - TXT");
                System.out.println("2 - HTML");
                System.out.println("3 - PDF");
                System.out.println("4 - JSON");
                System.out.println("5 - Todos os formatos");
                System.out.print("Opção: ");
                int opcaoFormato = Integer.parseInt(scanner.nextLine());

                Documento documento = criarDocumento(
                                opcaoDocumento,
                                new GeradorTXT(),
                                scanner);

                if (documento == null) {
                        System.out.println("Documento inválido.");
                        scanner.close();
                        return;
                }

                if (opcaoFormato == 5) {
                        GeradorArquivo[] geradores = {
                                        new GeradorTXT(),
                                        new GeradorHTML(),
                                        new GeradorPDF(),
                                        new GeradorJSON()
                        };

                        for (GeradorArquivo gerador : geradores) {
                                documento.setGerador(gerador);
                                documento.gerar();
                        }
                } else {
                        GeradorArquivo gerador = criarGerador(opcaoFormato);

                        if (gerador == null) {
                                System.out.println("Formato inválido.");
                                scanner.close();
                                return;
                        }

                        documento.setGerador(gerador);
                        documento.gerar();
                }

                scanner.close();
        }

        private static GeradorArquivo criarGerador(int opcao) {
                switch (opcao) {
                        case 1:
                                return new GeradorTXT();
                        case 2:
                                return new GeradorHTML();
                        case 3:
                                return new GeradorPDF();
                        case 4:
                                return new GeradorJSON();
                        default:
                                return null;
                }
        }

        private static Documento criarDocumento(
                        int opcao,
                        GeradorArquivo gerador,
                        Scanner scanner) {

                switch (opcao) {

                        case 1:
                                System.out.println("\n=== RELATÓRIO GERENCIAL ===");

                                System.out.print("Faturamento do mês: ");
                                String faturamento = scanner.nextLine();

                                System.out.print("Despesas operacionais: ");
                                String despesas = scanner.nextLine();

                                System.out.print("Lucro líquido: ");
                                String lucro = scanner.nextLine();

                                System.out.print("Crescimento (%): ");
                                String crescimento = scanner.nextLine();

                                System.out.print("Observações: ");
                                String observacoes = scanner.nextLine();

                                return new RelatorioGerencial(
                                                gerador,
                                                faturamento,
                                                despesas,
                                                lucro,
                                                crescimento,
                                                observacoes);

                        case 2:
                                System.out.println("\n=== NOTA FISCAL ===");

                                System.out.print("Número da nota: ");
                                String numero = scanner.nextLine();

                                System.out.print("Cliente: ");
                                String cliente = scanner.nextLine();

                                List<ItemNotaFiscal> itens = new ArrayList<>();

                                System.out.print("Quantidade de itens: ");
                                int quantidadeItens = Integer.parseInt(scanner.nextLine());

                                for (int i = 1; i <= quantidadeItens; i++) {
                                        System.out.println("\nItem " + i);

                                        System.out.print("Descrição: ");
                                        String descricao = scanner.nextLine();

                                        System.out.print("Quantidade: ");
                                        int quantidade = Integer.parseInt(scanner.nextLine());

                                        System.out.print("Valor unitário: ");
                                        double valorUnitario = Double.parseDouble(
                                                        scanner.nextLine().replace(",", "."));

                                        itens.add(new ItemNotaFiscal(
                                                        descricao,
                                                        quantidade,
                                                        valorUnitario));
                                }

                                return new NotaFiscal(
                                                gerador,
                                                numero,
                                                cliente,
                                                itens);

                        case 3:
                                System.out.println("\n=== PROPOSTA COMERCIAL ===");

                                System.out.print("Empresa: ");
                                String empresa = scanner.nextLine();

                                System.out.print("Descrição do serviço/produto: ");
                                String descricaoProposta = scanner.nextLine();

                                System.out.print("Prazo de entrega: ");
                                String prazoEntrega = scanner.nextLine();

                                System.out.print("Valor da proposta: ");
                                String valorProposta = scanner.nextLine();

                                System.out.print("Validade da proposta: ");
                                String validade = scanner.nextLine();

                                return new PropostaComercial(
                                                gerador,
                                                empresa,
                                                descricaoProposta,
                                                prazoEntrega,
                                                valorProposta,
                                                validade);

                        case 4:
                                System.out.println("\n=== CONTRATO SIMPLIFICADO ===");

                                System.out.print("Contratante: ");
                                String contratante = scanner.nextLine();

                                System.out.print("Contratado: ");
                                String contratado = scanner.nextLine();

                                System.out.print("Objeto do contrato: ");
                                String objeto = scanner.nextLine();

                                System.out.print("Valor acordado: ");
                                String valorContrato = scanner.nextLine();

                                System.out.print("Prazo de execução: ");
                                String prazo = scanner.nextLine();

                                System.out.print("Assinatura: ");
                                String assinatura = scanner.nextLine();

                                return new ContratoSimplificado(
                                                gerador,
                                                contratante,
                                                contratado,
                                                objeto,
                                                valorContrato,
                                                prazo,
                                                assinatura);

                        default:
                                return null;
                }
        }
}