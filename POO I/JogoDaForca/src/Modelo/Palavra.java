package Modelo;

// @author Robson Rosa

import java.util.Objects;



public class Palavra {
    private String palavra, dica;
    private EnumDificuldade dificuldade;

    public Palavra(String palavra, EnumDificuldade dificuldade, String dica) {
        this.palavra = palavra;
        this.dificuldade = dificuldade;
        this.dica = dica;
    }

    public Palavra() {
    
    }
    
    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public EnumDificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(EnumDificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }
    
    public String getDica() {
        return dica;
    }
    
    public void setDica(String dica){
        this.dica = dica;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.palavra);
        hash = 83 * hash + Objects.hashCode(this.dificuldade);
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
        final Palavra other = (Palavra) obj;
        if (!Objects.equals(this.palavra, other.palavra)) {
            return false;
        }
        return this.dificuldade == other.dificuldade;
    }

    @Override
    public String toString() {
        return "Palavra{" + "palavra=" + palavra + ", dificuldade=" + dificuldade + '}';
    }
    
    
}
