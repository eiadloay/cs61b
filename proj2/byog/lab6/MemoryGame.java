package byog.lab6;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class MemoryGame {
    private int width;
    private int height;
    private int round;
    private final Random rand;
    private boolean gameOver;
    private boolean playerTurn;
    private static final Font mainFont = new Font("Monaco", Font.BOLD, 30);
    private static final Font headerFont = new Font("Monaco", Font.BOLD, 20);
    private static final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final String[] ENCOURAGEMENT = {"You can do this!", "I believe in you!",
                                                   "You got this!", "You're a star!", "Go Bears!",
                                                   "Too easy for you!", "Wow, so impressive!"};

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter a seed");
            return;
        }

        int seed = Integer.parseInt(args[0]);
        MemoryGame game = new MemoryGame(40, 40);
        game.startGame();
    }

    public MemoryGame(int width, int height) {
        /* Sets up StdDraw so that it has a width by height grid of 16 by 16 squares as its canvas
         * Also sets up the scale so the top left is (0,0) and the bottom right is (width, height)
         */
        this.width = width;
        this.height = height;
        StdDraw.setCanvasSize(this.width * 16, this.height * 16);
        StdDraw.setFont(mainFont);
        StdDraw.setXscale(0, this.width);
        StdDraw.setYscale(0, this.height);
        StdDraw.clear(Color.BLACK);
        StdDraw.enableDoubleBuffering();

        this.rand = new Random();
    }

    public String generateRandomString(int n) {
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            randomString.append(CHARACTERS[rand.nextInt(CHARACTERS.length)]);
        }
        return randomString.toString();
    }

    private void drawHeader() {
        String state = (playerTurn) ? "Type!" : "Watch!";
        StdDraw.setFont(headerFont);
        String encouragement = (playerTurn) ? ENCOURAGEMENT[rand.nextInt(ENCOURAGEMENT.length)] : ENCOURAGEMENT[0];
        StdDraw.textRight(width - 1, height - 1.5, encouragement);
        StdDraw.textLeft(1, height - 1.5, "Round : " + round);
        StdDraw.text((double) width / 2 - 1, height - 1.5, state);
        StdDraw.line(0, height - 3, width, height - 3);
    }

    public void drawFrame(String s) {
        StdDraw.clear(StdDraw.BLACK);
        double xCord = (double) width / 2;
        double yCord = (double) height / 2;

        StdDraw.setPenColor(Color.white);
        if (!gameOver) {
            drawHeader();
        }
        StdDraw.setFont(mainFont);
        StdDraw.text(xCord, yCord, s);
        StdDraw.show();
    }

    public void flashSequence(String letters) {
        for (int i = 0; i < letters.length(); i++) {
            drawFrame(String.valueOf(letters.charAt(i)));
            StdDraw.pause(1000);
            drawFrame("");
            StdDraw.pause(500);
        }
    }

    public String solicitNCharsInput(int n) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < n) {
            if (StdDraw.hasNextKeyTyped()) {
                sb.append(StdDraw.nextKeyTyped());
            }
        }
        return sb.toString();
    }

    public void startGame() {
        round = 1;
        gameOver = false;
        playerTurn = false;
        String randomString = generateRandomString(round);
        String playerInput;

        while (!gameOver) {
            if (!playerTurn) {
                StdDraw.clear(Color.BLACK);
                StdDraw.setPenColor(Color.white);
                StdDraw.setFont(mainFont);
                StdDraw.text((double) width / 2, (double) height / 2, "Round : " + round);
                StdDraw.show();
                StdDraw.pause(2000);
            }
            flashSequence(randomString);
            playerTurn = true;
            drawFrame("");
            playerInput = solicitNCharsInput(round);
            if (playerInput.equals(randomString)) {
                round++;
                playerTurn = false;
                randomString = generateRandomString(round);
            } else {
                gameOver = true;
            }
        }
        String endMessage = "Game Over! You made it to round : " + round;
        drawFrame(endMessage);
    }

}
