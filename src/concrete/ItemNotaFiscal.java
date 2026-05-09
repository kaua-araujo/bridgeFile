package concrete;

public class ItemNotaFiscal {

    private String descricao;
    private int quantidade;
    private double valorUnitario;

    public ItemNotaFiscal(String descricao, int quantidade, double valorUnitario) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double getTotal() {
        return quantidade * valorUnitario;
    }
}