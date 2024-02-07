public class Produto {
    private String nome;
    private double valor;
    
    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    
    public String getNome(){
        return this.nome;
    }
    public double getValor(){
        return this.valor;
    }
    
    public String toString() {
        return this.nome + " - R$ " + this.valor ;
            
    }
    
    
}