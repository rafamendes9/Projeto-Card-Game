package CardGame;
import java.util.Random;


public class E_Loja {
    private String numeroCartao;
    private String codigoVerificador;

    //novos atributos da 2 entrega
    private boolean promocao = false; // definido nao por padrao por n ter promocao / ainda sem uso em codigo da classe e metodo ( 3 entrega)
    private int precoBoosterComum = 100; // Preço do booster comum, definido como atributo de classe para facilitar a modificar varios metodos de compra

    public E_Loja(String numeroCartao, String codigoVerificador) {
        this.numeroCartao = numeroCartao;
        this.codigoVerificador = codigoVerificador;
    }

    // metodo compra booster

    public void compraDeBooster(A_Usuario usuario) {
        // Verificar se o usuário possui cardcoins suficientes para comprar um booster
        
        int cardcoinsDoUsuario = usuario.getCardCoins();

        if (cardcoinsDoUsuario >= precoBoosterComum) { // verifica se o usuário tem cardcoins suficientes para comprar um booster

            int quantidadeCartasBooster = 12; // Um booster contém 12 cartas aleatórias

            for (int i = 0; i < quantidadeCartasBooster; i++) {
                // Simula obtenção de cartas aleatórias
                C_Carta novaCarta = gerarCartaAleatoria(); 

                // Verificar se o usuário já possui 3 unidades dessa carta (exceto mana)
                if (!novaCarta.getNome().equals("mana") && usuario.getInventario().possuiMaximoCarta(novaCarta)) {
                    // O usuário já possui 3 unidades da carta, receber cardcoins
                    int valorCardcoins = 10; // Defina o valor a ser recebido em cardcoins
                    cardcoinsDoUsuario += valorCardcoins;
                } else {
                    // Adicionar a carta ao inventário do usuário
                    usuario.getInventario().adicionarCarta(novaCarta);
                }
            }
           
            // Deduzir preço do booster dos cardcoins do usuário
            cardcoinsDoUsuario -= precoBoosterComum;
            usuario.setCardCoins(cardcoinsDoUsuario);

            System.out.println(
                    "Compra bem-sucedida! Você recebeu " + quantidadeCartasBooster + " cartas no seu inventário.");

        } else {
            System.out.println("Você não possui cardcoins suficientes para comprar um booster.");
        }
    }

    //metodo extra para verificar promocao
    public boolean isPromocao() {
        return promocao = true;
    }
    
    
    //agora o metodo recebe valores aleatorios de raridade fixo ( definido no enum)
    public C_Carta gerarCartaAleatoria() {
        Random random = new Random();
        String[] nomesCartas = { "Carta 1", "Carta 2", "Carta 3", "Carta 4", "Carta 5", "Carta 6" }; // Nome da carta random
        String nomeAleatorio = nomesCartas[random.nextInt(nomesCartas.length)];
        int ataqueAleatorio = random.nextInt(10) + 1;
        int defesaAleatoria = random.nextInt(10) + 1;
        int custoAleatorio = random.nextInt(10) + 1; 
        int pontoVidaCarta = random.nextInt(10) + 1; 
        int mana = random.nextInt(10) + 2; 
        
        // Gera uma raridade aleatória com base nas probabilidades do J_Enum
        H_EnumRaridade raridadeAleatoria = gerarRaridadeAleatoria();//implementa raridade para a carta
        
        // Obtenha um caminho de imagem aleatório usando o método gerarImagemAleatoria()
        String imagemAleatoria = gerarImagemAleatoria();//implementa imagem para a carta
        
        // Obtenha uma habilidade aleatório usando o método gerarHabilidadeAleatorio()
        H3_EnumHabilidade habilidadeAleatorio = gerarHabilidadeAleatorio();//implementa habilidade para a carta
        
        // Obtenha um tipo aleatório usando o método gerarTipoAleatorio()
    H4_EnumTipo tipoAleatorio = gerarTipoAleatorio();//implementa tipo para a carta

    
    // Criação da carta com os valores aleatórios e a raridade
    // imagem | tipo | habilidade | custo ( FASE 2) desenvolvimento ENUM !!!!!!!
    C_Carta cartaAleatoria = new C_Carta(nomeAleatorio, imagemAleatoria, tipoAleatorio, raridadeAleatoria, habilidadeAleatorio, ataqueAleatorio,
    defesaAleatoria, custoAleatorio, pontoVidaCarta, mana);
    
    return cartaAleatoria;
}  

//metodo refeito para se adequar a raridade fixa
public H_EnumRaridade gerarRaridadeAleatoria() { 
    Random random = new Random();
    double valorProbabilidade = random.nextDouble(); // Gera um valor de probabilidade aleatório entre 0 e 1
    
    // Mapeia o valor gerado para a raridade com base nas probabilidades do J_Enum
    if (valorProbabilidade <= H_EnumRaridade.MITICA.getDropProbabilidade()) {
        return H_EnumRaridade.MITICA;
    } else if (valorProbabilidade <= H_EnumRaridade.LENDARIA.getDropProbabilidade()) {
        return H_EnumRaridade.LENDARIA;
    } else if (valorProbabilidade <= H_EnumRaridade.EPICA.getDropProbabilidade()) {
        return H_EnumRaridade.EPICA;
    } else if (valorProbabilidade <= H_EnumRaridade.RARA.getDropProbabilidade()) {
        return H_EnumRaridade.RARA;
    } else {
        return H_EnumRaridade.NORMAL;
    }
  }
  
  public String gerarImagemAleatoria() {//chama as imagens do enum de forma aleatoria
    Random random = new Random();
    H2_EnumIMG[] imagens = H2_EnumIMG.values();
    int indiceAleatorio = random.nextInt(imagens.length);
    return imagens[indiceAleatorio].getImagePath();
}


public H3_EnumHabilidade gerarHabilidadeAleatorio() {
    Random random = new Random();
    int valorHabilidade = random.nextInt(6); // 0 a 5, representando habilidade  AMEDRONTAR, ATROPELAR, METAL, UNIR, CURA, VENENO, ESCUDOREFLETOR
    
    // Mapea o valor gerado em H3_EnumHabilidade
    switch (valorHabilidade) {
        case 0:
        return H3_EnumHabilidade.AMEDRONTAR;
        case 1:
        return H3_EnumHabilidade.ATROPELAR;
        case 2:
        return H3_EnumHabilidade.UNIR;
        case 3:
        return H3_EnumHabilidade.CURA;
        case 4:
        return H3_EnumHabilidade.VENENO;
        case 5:
        return H3_EnumHabilidade.ESCUDOREFLETOR;
        
        default:
        // Lida com casos inesperados, se necessário( caso o random bug)
        throw new IllegalArgumentException("Valor de Habilidade inválido: " + valorHabilidade);
    }
}

public H4_EnumTipo gerarTipoAleatorio() {
    Random random = new Random();
    int valorTipo = random.nextInt(8); // 0 a 7, representando tipo  FOGO, AGUA, METAL, PEDRA, VENTO, RAIO, LUZ, TREVAS
    
    // Mapea o valor gerado em H4_EnumTipo
    switch (valorTipo) {
        case 0:
        return H4_EnumTipo.FOGO;
        case 1:
        return H4_EnumTipo.AGUA;
        case 2:
        return H4_EnumTipo.METAL;
        case 3:
        return H4_EnumTipo.PEDRA;
        case 4:
        return H4_EnumTipo.VENTO;
        case 5:
        return H4_EnumTipo.VENTO;
        case 6:
        return H4_EnumTipo.VENTO;
        case 7:
        return H4_EnumTipo.VENTO;
        
        default:
        // Lida com casos inesperados, se necessário( caso o random bug)
                throw new IllegalArgumentException("Valor do Tipo inválido: " + valorTipo);
            }
        }
        
        
        
        
        //METODO PAY 2 WIN hahahahaha
        // metodo que chama outro metodo em inventario, ele aumenta o tamnho do vetor "inventario de cartas" em 30 e custa um valor em card coins
        public void aumentarTamanhoDoInventario(B_Inventario inventario, int novoTamanho, A_Usuario usuario) {
            novoTamanho = 30;// define o aumento em 30 o tamanho do vetor
           // Verifica se o usuário possui cardcoins suficientes
            if (usuario.getCardCoins() >= 1000) {
            // Subtrai o custo do aumento do tamanho dos cardcoins do usuário
            usuario.setCardCoins(usuario.getCardCoins() - 1000);

            // Chama o método para aumentar o tamanho do inventário
            inventario.aumentarTamanhoDoVetor(novoTamanho);
        } else {
            System.out.println("Você não possui cardcoins suficientes para aumentar o tamanho do inventário.");
}
}



    // get set
    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCodigoVerificador() {
        return codigoVerificador;
    }

    public void setCodigoVerificador(String codigoVerificador) {
        this.codigoVerificador = codigoVerificador;
    }

    //get/set entrega 2 inserido por preco boster ser atributo da classe ao inves de local
    public int getPrecoBoosterComum() {
        return precoBoosterComum;
    }

    public void setPrecoBoosterComum(int precoBoosterComum) {
        this.precoBoosterComum = precoBoosterComum;
    }

    public boolean getPromocao() {
        return promocao;
    }
    
    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }




}