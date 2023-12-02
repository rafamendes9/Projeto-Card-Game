package Model.Exceptions;

public class J2_IrregularDeckException extends Exception{
    public J2_IrregularDeckException() {
        super("Quantidade de cartas no deck deve estar entre 45 e 60.");
    }
}
