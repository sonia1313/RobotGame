package game;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Demonstrates how high-score data can be written to a text file.
 * @author Sonia Mathews
 * @version 3
 * @since 3
 */
public class HighScoreWriter {

    private String fileName;
    /**
     * 
     * @param fileName where scores are written to
     */
    public HighScoreWriter(String fileName) {
        this.fileName = fileName;
    }
/**
 * 
 * @param name of the player as the string
 * @param score of the player after he/she has finished the game returned as an integer
 * @throws IOException when writing to file
 */
    public void writeHighScore(String name, int score) throws IOException {
        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(name + "," + score + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
