
package padrao;

// Classe Prato
class Prato {
    private String nome;
    private String ingredientePrincipal;
    private String acompanhamento;
    private String sobremesa;
    
    public Prato(String nome, String ingredientePrincipal, 
            String acompanhamento, String sobremesa) {
        this.nome = nome;
        this.ingredientePrincipal = ingredientePrincipal;
        this.acompanhamento = acompanhamento;
        this.sobremesa = sobremesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientePrincipal() {
        return ingredientePrincipal;
    }

    public void setIngredientePrincipal(String ingredientePrincipal) {
        this.ingredientePrincipal = ingredientePrincipal;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public String getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(String sobremesa) {
        this.sobremesa = sobremesa;
    }
    
    public String toString() {
        return "Prato: " + nome + "\n" +
                "Ingrediente Principal: " + ingredientePrincipal + "\n" +
                "Acompanhamento: " + acompanhamento + "\n" +
                "Sobremesa: " + sobremesa;
    }
}

// Classe Builder
class Builder {
    private String nome;
    private String ingredientePrincipal;
    private String acompanhamento;
    private String sobremesa;
    
    public Builder() {
    }
    
    public Builder setNome(String nome) {
        this.nome = nome;
        return this;
    }
    
    public Builder setIngredientePrincipal(String ingredientePrincipal) {
        this.ingredientePrincipal = ingredientePrincipal;
        return this;
    }
    
    public Builder setAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
        return this;
    }
    
    public Builder setSobremesa(String sobremesa) {
        this.sobremesa = sobremesa;
        return this;
    }
    
    public Prato build() {
        return new Prato(nome, ingredientePrincipal, acompanhamento, sobremesa);
    }
}

// Exemplo de uso do padrão Builder
public class Padrao {
    public static void main(String[] args) {
        Prato prato = new Builder()
                .setNome("Prato do Dia")
                .setIngredientePrincipal("Frango")
                .setAcompanhamento("Arroz e Feijao")
                .setSobremesa("Pudim")
                .build();
        
        System.out.println(prato);
    }
}