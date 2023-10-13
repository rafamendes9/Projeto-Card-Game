package CardGame;
public enum H3_EnumHabilidade {
    
    AMEDRONTAR(0.5),  
    ATROPELAR(1),   
    UNIR(2),  
    CURA(3),  
    VENENO(4), 
    ESCUDOREFLETOR(5); 

    private double habilidadeAleatoria;

    private H3_EnumHabilidade(double habilidadeAleatoria){
        this.habilidadeAleatoria = habilidadeAleatoria;
    }
   
    public double getHabilidadeAleatoria(){
        return habilidadeAleatoria;
    }
}