package CardGame;

public class InsufficientCoinsException extends Exception {
    public InsufficientCoinsException() {
        super("Você não possui CardCoins suficientes para fazer esta compra.");
    }
}
