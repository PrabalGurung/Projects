import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Graphic extends JPanel implements ActionListener {

    //making frames 500x500
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    static final int TICK_SIZE = 50; //Dunno bro
    static final int BOARD_SIZE = (WIDTH * HEIGHT)/(TICK_SIZE * TICK_SIZE); //makes according to monitor size??

    final Font font = new Font("TimesRoman", Font.BOLD, 30); //gives font

    //starting position of the snake
    int[] snakePosX = new int[BOARD_SIZE];
    int[] snakePosY = new int[BOARD_SIZE];
    int snakeLength; //initializing snake length

    Food food; //calls food class
    int foodEaten; //initializes no of times food eaten

    char direction = 'R'; //initializes the direction of snake
    boolean isMoving = false; //initializes snake movement
    final Timer timer = new Timer(250, this); //determines speed of snake

    //makes graphic on start
    public Graphic() {
        //window
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //background color of window
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        //control function??
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //control
                if (isMoving) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT:
                            if (direction != 'R')
                                direction = 'L';
                            break;
                        case KeyEvent.VK_RIGHT:
                            if (direction != 'L')
                                direction = 'R';
                            break;
                        case KeyEvent.VK_UP:
                            if (direction != 'D')
                                direction = 'U';
                            break;
                        case KeyEvent.VK_DOWN:
                            if (direction != 'U')
                                direction = 'D';
                            break;
                    }
                }else {
                    start();
                }
            }
        });

        start();
    }

    //starting position
    protected void start() {
        //puts snake position in top right corner
        snakePosX = new int[BOARD_SIZE];
        snakePosY = new int[BOARD_SIZE];
        //determines snake length
        snakeLength = 5;
        //determines no of food taken
        foodEaten = 0;
        //determines the initial movement
        direction = 'R';
        //plays the game as long as isMoving is true
        isMoving = true;
        //spawns food in game
        spawnFood();
        //??
        timer.start();
    }

    //??
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isMoving) {
            g.setColor(Color.GREEN);
            g.fillOval(food.getPosX(), food.getPosY(), TICK_SIZE, TICK_SIZE);

            g.setColor(Color.DARK_GRAY);
            for (int i = 0; i < snakeLength; i++) {
                g.fillRect(snakePosX[i], snakePosY[i], TICK_SIZE, TICK_SIZE);
            }
        } else {
            String scoreText = String.format("The End...... Score: %d... Press any key to continue!", foodEaten);
            g.setColor(Color.BLUE);
            g.setFont(font);
            g.drawString(scoreText, (WIDTH - getFontMetrics(g.getFont()).stringWidth(scoreText)) / 2, HEIGHT / 2);

        }
    }

    protected void move() {
        //makes the snake face towards the moving position so all part of snake goes to same direction as used by user
        for (int i = snakeLength; i > 0; i--) {
            snakePosX[i] = snakePosX[i-1];
            snakePosY[i] = snakePosY[i-1];
        }
        //determines movement of snake according to user??
        switch (direction) {
            case 'U' -> snakePosY[0] -= TICK_SIZE;
            case 'D' -> snakePosY[0] += TICK_SIZE;
            case 'L' -> snakePosX[0] -= TICK_SIZE;
            case 'R' -> snakePosX[0] += TICK_SIZE;

        }
    }

    //??
    protected void spawnFood() {
        food = new Food();
    }

    //action that needs to occur after food taken
    protected void eatFood() {
        if ((snakePosX[0] == food.getPosX()) && (snakePosY[0] == food.getPosY())) {
            //increases length of snake
            snakeLength++;
            //increases score
            foodEaten++;
            //spawns new food
            spawnFood();
        }
    }

    //game over if any of the statement is true
    protected void collisionTest() {
        //game over if snake touches its body
        for (int i = snakeLength; i > 0; i--){
            if ((snakePosX[0] == snakePosX[i]) && (snakePosY[0] == snakePosY[i])) {
                isMoving =false;
                break;
            }
        }

        //game over if snake goes out of bound
        if (snakePosX[0] < 0 || snakePosX[0] > WIDTH - TICK_SIZE || snakePosY[0] < 0 || snakePosY[0] > HEIGHT - TICK_SIZE) {
            isMoving = false;
        }

        //stops game
        if (!isMoving) {
            timer.stop();
        }
    }

    //??
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isMoving){
            move();
            collisionTest();
            eatFood();
        }

        repaint();
    }
}
