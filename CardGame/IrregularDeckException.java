package CardGame;

public class IrregularDeckException extends Exception{
    public IrregularDeckException() {
        super("Quantidade de cartas no deck deve estar entre 45 e 60.");
    }
}
