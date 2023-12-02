# Projeto-Card-Game


## Descrição

O projeto **CardGame** é um jogo de cartas implementado em Java, com o objetivo de proporcionar uma experiência envolvente de estratégia e diversão. O jogo inclui elementos como cartas, jogadores, habilidades e progressão.

## Estrutura do Projeto

O projeto está organizado em pacotes que representam diferentes aspectos do jogo:

- **CardGame:** Pacote principal que contém a classe principal do jogo.
- **CardGame.Exceptions:** Pacote que inclui exceções personalizadas para lidar com situações específicas do jogo.
- **CardGame.Enums:** Pacotes que contêm enumerações para representar diferentes categorias, como raridade, tipos de cartas, habilidades, etc.
- **CardGame.Classes:** Pacote que contém as classes principais que representam elementos fundamentais do jogo, como cartas, usuários e progressão.
- **CardGame.Controllers:** Pacote que poderia conter controladores responsáveis pela lógica de controle do jogo.
- **CardGame.Utils:** Pacote que inclui utilitários para operações diversas.

## Principais Classes

1. **C_Carta:** Representa uma carta no jogo, contendo informações como nome, ataque, defesa, tipo, etc.
2. **A_Usuario:** Classe que representa um usuário do jogo, contendo informações do jogador, como nome, nível, moedas, etc.
3. **H_EnumRaridade:** Enumeração que define a raridade das cartas no jogo.
4. **H2_EnumIMG:** Enumeração que define os caminhos relativos das imagens associadas às cartas.
5. **H3_EnumHabilidade:** Enumeração que define diferentes habilidades que uma carta pode ter.
6. **H4_EnumTipo:** Enumeração que define os diferentes tipos de cartas no jogo.
7. **J1_InsufficientCoinsException:** Exceção lançada quando um jogador não possui moedas suficientes para uma compra.
8. **J2_IrregularDeckException:** Exceção lançada quando a quantidade de cartas no deck de um jogador está fora do intervalo permitido.
9. **J3_TimeOutException:** Exceção lançada quando ocorre um timeout durante uma partida.
10. **J4_InsufficientGemsException:** Exceção lançada quando um jogador não possui gemas suficientes para uma compra.
11. **K_Feitico:** Classe que contém métodos estáticos para ativar diferentes habilidades em uma carta.
12. **K2_Cronometro:** Classe que implementa um cronômetro para controlar o tempo de uma partida.
13. **Progresso:** Classe abstrata que representa o progresso de um jogador no jogo.
14. **PasseComum e PassePremium:** Classes que estendem `Progresso` e definem recompensas específicas para passes comum e premium.

## Como Jogar

1. **Iniciar o Jogo:** Para iniciar o jogo, crie uma instância da classe principal `CardGame` e inicie a execução do programa.
2. **Interagir com o Jogo:** Implemente lógica de controle (controladores) para permitir interações do jogador, como comprar cartas, jogar partidas, etc.
3. **Progressão do Jogador:** O jogo inclui um sistema de progressão, com passes comum e premium, proporcionando recompensas ao jogador conforme avança de nível.
4. **Exceções Personalizadas:** Esteja ciente das exceções personalizadas para lidar com situações específicas do jogo, como falta de moedas, deck irregular, timeout, etc.

## Conclusão

Espero que apreciem esse projeto CardGame oferece uma estrutura sólida para a implementação de um jogo de cartas em Java. Sua modularidade e a aplicação do padrão MVC que contribue para uma fácil manutenção e expansão. Sinta-se à vontade para contribuir, relatar problemas ou fazer melhorias para tornar o jogo ainda mais envolvente e divertido. Divirta-se jogando!  


### PS

esse projeto  foi feito como muito suor e esforço, sei que tem muito caminho pela frente (abro a oportunidade da comunidade ajudar em futuras implementaçoes), de toda forma SE DIRVITÃO !!!!

