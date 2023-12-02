package Model.ENUMs;
public enum H2_EnumIMG {
    monster1("img\\monster1.gif"),
    monster2("img\\monster2.gif"),
    monster3("img\\monster3.gif"),
    monster4("img\\monster4.gif"),
    monster5("img\\monster5.gif"),
    monster6("img\\monster6.gif"),
    monster7("img\\monster7.gif"),
    monster8("img\\monster8.gif"),
    monster9("img\\monster9.gif"),
    monster10("img\\monster10.gif"),
    monster11("img\\monster11.gif"),
    monster12("img\\monster12.gif"),
    monster13("img\\monster13.gif"),
    monster14("img\\monster14.gif"),
    monster15("img\\monster15.gif"),
    monster16("img\\monster16.gif"),
    monster17("img\\monster17.gif"),
    monster18("img\\monster18.gif"),
    monster19("img\\Wc3Alchemist.gif"),
    monster20("img\\Wc3Archmage.gif"),
    monster21("img\\Wc3BTNBansheeRanger.gif"),
    monster22("img\\Wc3BTNBeastMaster.gif"),
    monster23("img\\Wc3BTNHeroAvatarOfFlame.gif"),
    monster24("img\\Wc3BTNHeroCryptLord.gif"),
    monster25("img\\Wc3BTNHeroDeathKnight.gif"),
    monster26("img\\Wc3BTNHeroDreadLord.gif"),
    monster27("img\\Wc3BTNHeroFarseer.gif"),
    monster28("img\\Wc3BTNHeroMountainKing.gif"),
    monster29("img\\Wc3BTNHeroPaladin.gif"),
    monster30("img\\Wc3BTNHeroTinker.gif"),
    monster31("img\\Wc3BTNKeeperOfTheGrove.gif"),
    monster32("img\\Wc3BTNLichVersion2.gif"),
    monster33("img\\Wc3BTNNagaSeaWitch.gif"),
    monster34("img\\Wc3BTNPandarenBrewmaster.gif"),
    monster35("img\\Wc3BTNPitLord.gif"),
    monster36("img\\Wc3BTNPriestessOfTheMoon.gif"),
    monster37("img\\Wc3BTNShadowHunter.gif"),
    monster38("img\\WC3Warden.gif"),
    monster39("img\\Blademaster.gif"),
    monster40("img\\Bloodmage.gif"),
    monster41("img\\Arthas.png"),
    monster42("img\\Chieftain.gif"),
    monster43("img\\Demonhunter.gif"),
    monster44("img\\jakiro.gif");

    private String imagePath; // Caminho relativo da imagem
    

    // Construtor privado para associar o caminho da imagem e a probabilidade
    private H2_EnumIMG(String imagePath) {
        this.imagePath = imagePath;
        
    }

    // Método para obter o caminho relativo da imagem
    public String getImagePath() {
        return imagePath;
    }
}
