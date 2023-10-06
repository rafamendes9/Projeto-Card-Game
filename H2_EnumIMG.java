public enum H2_EnumIMG {
    monster1("img\\monster1.gif", 0.3),
    monster2("img\\monster2.gif", 0.3),
    monster3("img\\monster3.gif", 0.3),
    monster4("img\\monster4.gif", 0.3),
    monster5("img\\monster5.gif", 0.3),
    monster6("img\\monster6.gif", 0.3),
    monster7("img\\monster7.gif", 0.3),
    monster8("img\\monster8.gif", 0.3),
    monster9("img\\monster9.gif", 0.3),
    monster10("img\\monster10.gif", 0.3),
    monster11("img\\monster11.gif", 0.3),
    monster12("img\\monster12.gif", 0.3),
    monster13("img\\monster13.gif", 0.3),
    monster14("img\\monster14.gif", 0.3),
    monster15("img\\monster15.gif", 0.3),
    monster16("img\\monster16.gif", 0.3),
    monster17("img\\monster17.gif", 0.3),
    monster18("img\\monster18.gif", 0.3),
    monster19("img\\Wc3Alchemist.gif", 0.3),
    monster20("img\\Wc3Archmage.gif", 0.3),
    monster21("img\\Wc3BTNBansheeRanger.gif", 0.3),
    monster22("img\\Wc3BTNBeastMaster.gif", 0.3),
    monster23("img\\Wc3BTNHeroAvatarOfFlame.gif", 0.3),
    monster24("img\\Wc3BTNHeroCryptLord.gif", 0.3),
    monster25("img\\Wc3BTNHeroDeathKnight.gif", 0.3),
    monster26("img\\Wc3BTNHeroDreadLord.gif", 0.3),
    monster27("img\\Wc3BTNHeroFarseer.gif", 0.3),
    monster28("img\\Wc3BTNHeroMountainKing.gif", 0.3),
    monster29("img\\Wc3BTNHeroPaladin.gif", 0.3),
    monster30("img\\Wc3BTNHeroTinker.gif", 0.3),
    monster31("img\\Wc3BTNKeeperOfTheGrove.gif", 0.3),
    monster32("img\\Wc3BTNLichVersion2.gif", 0.3),
    monster33("img\\Wc3BTNNagaSeaWitch.gif", 0.3),
    monster34("img\\Wc3BTNPandarenBrewmaster.gif", 0.3),
    monster35("img\\Wc3BTNPitLord.gif", 0.3),
    monster36("img\\Wc3BTNPriestessOfTheMoon.gif", 0.3),
    monster37("img\\Wc3BTNShadowHunter.gif", 0.3),
    monster38("img\\WC3Warden.gif", 0.3),
    monster39("img\\Blademaster.gif", 0.3),
    monster40("img\\Bloodmage.gif", 0.3),
    monster41("img\\Arthas.png", 0.3),
    monster42("img\\Chieftain.gif", 0.3),
    monster43("img\\Demonhunter.gif", 0.3),
    monster44("img\\jakiro.gif", 0.3);

    private String imagePath; // Caminho relativo da imagem
    private double dropProbabilidade; // Probabilidade de drop

    // Construtor privado para associar o caminho da imagem e a probabilidade
    private H2_EnumIMG(String imagePath, double dropProbabilidade) {
        this.imagePath = imagePath;
        this.dropProbabilidade = dropProbabilidade;
    }

    // Método para obter o caminho relativo da imagem
    public String getImagePath() {
        return imagePath;
    }

    // Método para obter a probabilidade de drop
    public double getDropProbabilidade() {
        return dropProbabilidade;
    }
}
