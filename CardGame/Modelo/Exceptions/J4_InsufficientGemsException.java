package Modelo.Exceptions;

public class J4_InsufficientGemsException extends Exception {
    public J4_InsufficientGemsException() {
        super("Você não possui CardGems suficientes para fazer esta compra.");
    }
}
