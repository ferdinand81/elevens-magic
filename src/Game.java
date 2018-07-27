/*
By Ferdinand Mudjialim, 07/14/18
Based on the 11th card magic trick
 */
import java.util.Scanner;
public class Game {
    public static void main(String[] args) throws Exception{
        Scanner reader = new Scanner(System.in);
        Grid grid = new Grid(7, 3);
        grid.populate();
        System.out.println(grid);
        System.out.printf("Pick a card and remember it. ");
        Thread.sleep(5000);

        int i = 0;
        while (i < 3) {
            System.out.printf("Which column is your card in? (1-3) ");
            int column = reader.nextInt() - 1;
            if (column == 0) {
                grid.deal(1);
                grid.deal(0);
                grid.deal(2);
            }
            if (column == 1) {
                grid.deal(0);
                grid.deal(1);
                grid.deal(2);
            }
            if (column == 2) {
                grid.deal(0);
                grid.deal(2);
                grid.deal(1);
            }
            grid.updateGrid();
            grid.resetTemp();
            System.out.println(grid);
            i++;
        }

        System.out.println(grid.getValueAtLinearIndex(10) + " is your magic number!");

        /*
        pick a random number b/w 1-21
        deal();
        which column?
        deal();
        which column?
        deal();
        which column?
        deal();
        get 11th card.
        */
    }
}
