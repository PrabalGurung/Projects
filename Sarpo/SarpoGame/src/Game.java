import javax.swing.*;

//I have no idea what this thing does
public class Game extends JFrame {

    public Game(){
        this.add(new Graphic());
        this.setTitle("Sarpo Game");
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
