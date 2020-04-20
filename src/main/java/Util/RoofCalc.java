package Util;

public class RoofCalc {
    private final double spærPrisPrMeter = 14;
    private final double beslagPris = 50;
    private final double skruerPris = 5;
    private final double sternPrisPrMeter = 30;
    private final double tagPlastPladePris = 280;
    private final double teglPrisPrM2 = 2000;


    public double flatRoof(double længde, double bredde) {
        double totalPris = 0;
        bredde += 0.15;
        længde += 0.15;
        double antalSpær = længde/1;
        double antalBeslag = antalSpær * 2;
        double antalSkruer = (antalBeslag * 4) + (antalSpær * 5);

        //Plast plade pris:
        double tagPlastLængde = 2.4;
        double tagPlastBredde = 1.06;
        double totalTagPlastAreal = (tagPlastLængde / længde) + (tagPlastBredde / bredde);
        double tagPlastPris = totalTagPlastAreal * tagPlastPladePris;

        //Stern pris:
        int stern = 4;
        double totalSternPris = (bredde * sternPrisPrMeter) + (længde * sternPrisPrMeter);

        //Spær pris:
        double totalSpærPris = antalSpær * (bredde * spærPrisPrMeter);

        //Beslag pris:
        double totalPrisBeslag = antalBeslag * beslagPris;

        //Skruer pris:
        double totalPrisSkruer = antalSkruer * skruerPris;

        totalPris = tagPlastPris + totalSternPris + totalSpærPris + totalPrisSkruer + totalPrisBeslag;

        return totalPris;
    }

    public double highRoof(int hældning, int længde, int bredde) {
        double totalPris = 0;
        bredde += 0.15;
        længde += 0.15;
        double antalSpær = længde/1;
        double antalBeslag = antalSpær * 2;
        double antalSkruer = (antalBeslag * 4) + (antalSpær * 5);

        //Stern pris:
        int stern = 4;
        double totalSternPris = (bredde * sternPrisPrMeter) + (længde * sternPrisPrMeter);

        //Spær pris:
        double totalSpærPris = antalSpær * (bredde * spærPrisPrMeter);

        //Beslag pris:
        double totalPrisBeslag = antalBeslag * beslagPris;

        //Skruer pris:
        double totalPrisSkruer = antalSkruer * skruerPris;

        double højeSpærPris = 0;
        double tagHøjde = 0;
        double tagAreal;
        double tagMaterialePris = 0;

        //Tag areal udregning : https://www.bolius.dk/hvor-stort-er-mit-tag-89636

        switch (hældning) {
            case 15:
                højeSpærPris = antalSpær * ((bredde * 0.5)  * spærPrisPrMeter);
                tagHøjde = 0.5;
                tagAreal = længde * tagHøjde * 2;
                tagMaterialePris = teglPrisPrM2 * tagAreal;
                break;
            case 20:
                højeSpærPris = antalSpær * ((bredde * 0.55)  * spærPrisPrMeter);
                tagHøjde = 0.55;
                tagAreal = længde * tagHøjde * 2;
                tagMaterialePris = teglPrisPrM2 * tagAreal;
                break;
            case 25:
                højeSpærPris = antalSpær * ((bredde * 0.6)  * spærPrisPrMeter);
                tagHøjde = 0.6;
                tagAreal = længde * tagHøjde * 2;
                tagMaterialePris = teglPrisPrM2 * tagAreal;
                break;
            case 30:
                højeSpærPris = antalSpær * ((bredde * 0.65)  * spærPrisPrMeter);
                tagHøjde = 0.65;
                tagAreal = længde * tagHøjde * 2;
                tagMaterialePris = teglPrisPrM2 * tagAreal;
                break;
            case 35:
                højeSpærPris = antalSpær * ((bredde * 0.7)  * spærPrisPrMeter);
                tagHøjde = 0.7;
                tagAreal = længde * tagHøjde * 2;
                tagMaterialePris = teglPrisPrM2 * tagAreal;
                break;
            case 40:
                højeSpærPris = antalSpær * ((bredde * 0.75)  * spærPrisPrMeter);
                tagHøjde = 0.75;
                tagAreal = længde * tagHøjde * 2;
                tagMaterialePris = teglPrisPrM2 * tagAreal;
                break;
            case 45:
                højeSpærPris = antalSpær * ((bredde * 0.80)  * spærPrisPrMeter);
                tagHøjde = 0.8;
                tagAreal = længde * tagHøjde * 2;
                tagMaterialePris = teglPrisPrM2 * tagAreal;
                break;
            case 50:
                højeSpærPris = antalSpær * ((bredde * 0.85)  * spærPrisPrMeter);
                tagHøjde = 0.85;
                tagAreal = længde * tagHøjde * 2;
                tagMaterialePris = teglPrisPrM2 * tagAreal;
                break;
        }

        totalPris = tagMaterialePris + højeSpærPris + totalSternPris + totalSpærPris + totalPrisSkruer + totalPrisBeslag;

        return totalPris;
    }

    public static void main(String[] args) {
        int bredde = 4;
        int længde = 6;
        int hældning = 15;
        RoofCalc rc = new RoofCalc();
        System.out.println(rc.flatRoof(bredde, længde));
        System.out.println(rc.highRoof(hældning, bredde, længde));
    }
}
