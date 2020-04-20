package Util;

public class CalculateCarport {


    public static void main(String[] args) {

        double length = 2.4;
        double width = 3.5;
        double materialPrice = 2000;
        double postsPrice =  50;
        double skrewPrice =  20;
        double strapPrice =  20;

        CalculateCarport car = new CalculateCarport();
        double price = car.calculateCarportPrice(length, width, materialPrice,postsPrice,skrewPrice,strapPrice);
        System.out.println(price);
    }

    /*Carport
            Længde, højde, bredde
    Hvilke andre materialer skal der bruges?
    Antal stolper og pris pr stolpe
    Hvis bredde > 4 så skal der 2 ekstra stolper
    Hvis længde > 4 så skal der 2 ekstra stolper
    Så pr 2 meter efterfølgende skal der være en ekstra stolpe
    Antal skruer pr stolpe: 4
    og pris pr skrue
    Antal møtrikker pr skrue = 1
    Beklædning
    Remme 2 pr bredde af carport
*/
    public double calculateCarportPrice(double length, double width, double materialPrice, double postsPrice, double skrewPrice, double strapPrice){

        double lengthPosts = 0;
        double widthPosts = 0;
        double totalStraps = 0;
        double totalPosts;
        double totalScrews;
        double price;

        double lengthWidthPrice = (length + width) * materialPrice;

        totalStraps = width * 2;

        if(length > 4) {
            lengthPosts += 4 + (length / 2);
        }

        if(width > 4) {
            widthPosts += 4 + (width / 2);
        }


        totalPosts = lengthPosts + widthPosts;
        totalScrews = 4 * totalPosts;

        price = lengthWidthPrice + (totalPosts * postsPrice) + (totalScrews * skrewPrice) + (totalStraps * strapPrice);

        return price;

    }

}
