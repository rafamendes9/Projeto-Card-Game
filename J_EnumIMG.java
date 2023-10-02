public enum J_EnumIMG {
    BLADEMASTER("img\\Blademaster.gif", 0.2),
    Bloodmage("img\\Bloodmage.gif", 0.3),

    Arthas("img\\Arthas.png", 0.3),
    Chieftain("img\\Chieftain.gif", 0.3),
    Demonhunter("img\\Demonhunter.gif", 0.3),
    jakiro("img\\jakiro.gif", 0.3),
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

    TheOlho("img\\TheOlho.gif", 0.3),
    Wc3Alchemist("img\\Wc3Alchemist.gif", 0.3),
    Wc3Archmage("img\\Wc3Archmage.gif", 0.3),
    Wc3BTNBansheeRanger("img\\Wc3BTNBansheeRanger.gif", 0.3),
    Wc3BTNBeastMaster("img\\Wc3BTNBeastMaster.gif", 0.3),
    Wc3BTNHeroAvatarOfFlame("img\\Wc3BTNHeroAvatarOfFlame.gif", 0.3),
    Wc3BTNHeroCryptLord("img\\Wc3BTNHeroCryptLord.gif", 0.3),
    Wc3BTNHeroDeathKnight("img\\Wc3BTNHeroDeathKnight.gif", 0.3),
    Wc3BTNHeroDreadLord("img\\Wc3BTNHeroDreadLord.gif", 0.3),
    Wc3BTNHeroFarseer("img\\Wc3BTNHeroFarseer.gif", 0.3),
    Wc3BTNHeroMountainKing("img\\Wc3BTNHeroMountainKing.gif", 0.3),
    Wc3BTNHeroPaladin("img\\Wc3BTNHeroPaladin.gif", 0.3),
    Wc3BTNHeroTinker("img\\Wc3BTNHeroTinker.gif", 0.3),
    Wc3BTNKeeperOfTheGrove("img\\Wc3BTNKeeperOfTheGrove.gif", 0.3),
    Wc3BTNLichVersion2("img\\Wc3BTNLichVersion2.gif", 0.3),
    Wc3BTNNagaSeaWitch("img\\Wc3BTNNagaSeaWitch.gif", 0.3),
    Wc3BTNPandarenBrewmaster("img\\Wc3BTNPandarenBrewmaster.gif", 0.3),
    Wc3BTNPitLord("img\\Wc3BTNPitLord.gif", 0.3),
    Wc3BTNPriestessOfTheMoon("img\\Wc3BTNPriestessOfTheMoon.gif", 0.3),
    Wc3BTNShadowHunter("img\\Wc3BTNShadowHunter.gif", 0.3),
    WC3Warden("img\\WC3Warden.gif", 0.3);

    private String imagePath; // Caminho relativo da imagem
    private double dropProbabilidade; // Probabilidade de drop

    // Construtor privado para associar o caminho da imagem e a probabilidade
    private J_EnumIMG(String imagePath, double dropProbabilidade) {
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
