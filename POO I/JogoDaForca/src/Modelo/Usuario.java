package Modelo;

// @author Robson Rosa

import java.util.Objects;


public class Usuario {
    private int id, tipo, pontuacao;
    private String nome, senha;

 // Construtor sem parâmetros
    public Usuario() {
    }

    // Construtor com parâmetros
    public Usuario(int id, String nome, int pontuacao) {
        this.id = id;
        this.nome = nome;
        this.pontuacao = pontuacao;
    }
  
    // Getters e Setter

    public int getId() { // Retorna ID
        return id;
    }
    
    public void setId(int id) { // Retorna ID
        this.id = id;
    }

    public String getSenha() { // Retorna Senha
        return senha;
    }

    public void setSenha(String senha) { // Define a senha
        this.senha = senha;
    }

    public int getTipo() { // Retorna Tipo
        return tipo;
    }

    public void setTipo(int tipo) { // Define o Tipo
        this.tipo = tipo;
    }

    public String getNome() { // Retorna o Nome
        return nome;
    }

    public void setNome(String nome) { // Define o nome
        this.nome = nome;
    }    

    public Object getPontuacao() {
        return pontuacao;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", tipo=" + tipo + ", pontuacao=" + pontuacao + ", nome=" + nome + ", senha=" + senha + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + this.tipo;
        hash = 29 * hash + this.pontuacao;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (this.pontuacao != other.pontuacao) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.senha, other.senha);
    }
    
    
}
