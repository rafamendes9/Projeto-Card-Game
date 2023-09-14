public class Enum {
    public enum CardType {
        CREATURE("Creature"),
        SPELL("Spell"),
        ARTIFACT("Artifact"),
        ENCHANTMENT("Enchantment"),
        LAND("Land"),
        PLANESWALKER("Planeswalker");
    
        private String typeName;
    
        // Constructor
        private CardType(String typeName) {
            this.typeName = typeName;
        }
    
        // Getter for typeName
        public String getTypeName() {
            return typeName;
        }
    
        // Setter for typeName (optional, you can remove this if not needed)
        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }
    }

    public enum Raridade{
        NORMAL(1),
        INCOMUM(2),
        RARO(3),
        MUITORARO(4),
        EPICO(5),

    }
    
}
