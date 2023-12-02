package Model.Exceptions;
public class J3_TimeOutException extends Exception{
    public J3_TimeOutException() {
        super("Tempo de espera excedido. Aguarde no máximo 3 minutos.");
    }
}