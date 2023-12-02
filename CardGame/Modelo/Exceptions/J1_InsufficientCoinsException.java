package Modelo.Exceptions;


public class J1_InsufficientCoinsException extends Exception {
    public J1_InsufficientCoinsException() {
        super("Você não possui CardCoins suficientes para fazer esta compra.");
    }

}
