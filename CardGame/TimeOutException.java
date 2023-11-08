package CardGame;

public class TimeOutException extends Exception{
    public TimeOutException() {
        super("Tempo de espera excedido. Aguarde no máximo 3 minutos.");
    }
}
