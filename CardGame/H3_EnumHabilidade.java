package CardGame;
public enum H3_EnumHabilidade {
    
    AMEDRONTAR(0),  
    ATROPELAR(1),   
    UNIR(2),  
    CURA(3),  
    VENENO(4), 
    ESCUDOREFLETOR(5); 

    private int habilidadeAleatoria;

    private H3_EnumHabilidade(int habilidadeAleatoria){
        this.habilidadeAleatoria = habilidadeAleatoria;
    }
   
    public int getHabilidadeAleatoria(){
        return habilidadeAleatoria;
    }
}