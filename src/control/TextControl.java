/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;


import java.io.IOException;
import model.Text;
import view.Menu;

/**
 *
 * @author LAPTOP ACER
 */
public class TextControl extends Menu<String>{
    private static Text t;
    private static String[] mc = new String[] {"Display text", "Normalize ", "Save to ", "Exit"};
    public TextControl(){
        super("NOMRALIZATION",mc);
        t = new Text();
    }
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                System.out.println(t.getNormalizedText());
                break;
            case 2:
                t.doNormalize();
                System.out.println("Successfully");
                break;
            case 3:
            {
                try {
                   t.saveFile("Text2.txt");
                    System.out.println("Successfully");
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
                break;

            case 4:
                System.out.println("Exitting...");
                System.exit(0);

        }
    }
    public static void main(String[] args) {
        new TextControl().run();
    }
}
