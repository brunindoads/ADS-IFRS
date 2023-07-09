package Modelo;

// @author Robson Rosa

public enum EnumDificuldade {
    F, M, D;
    
    public String getDescricao() {
        switch(this) {
            case F: return "Facil";
            case M: return "Medio";
            case D: return "Dificil";
            default : return "";
        }
    }
    

}
