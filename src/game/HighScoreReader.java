package game;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 * Demonstrates how high-score data can be read from a text
 * file and printed to the terminal.
 * @author Sonia Mathews
 * @version 3
 * @since 3
 */
public class HighScoreReader {

    private String fileName;
    private String outputFileName = "data/output.txt";
    /**
     * Initialise a new HighScoreReader
     * @param fileName the name of the high-score file
     */
    public HighScoreReader(String fileName) {
        this.fileName = fileName;
        
    }

    /**
     * Read the high-score data from the high-score file 
     */
    public void readScores() throws IOException {
     //public void readScores(JList<String> jList1) throws IOException {

        FileReader fr = null;
        BufferedReader reader = null; //creating a Bufferedeader object to read the input text file
        BufferedWriter x = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            //Creating an arrayList to hold User objects
            ArrayList<User> userRecords = new ArrayList<User>();
            //reading the User recores one by one
            String line = reader.readLine();
            //String text = "";
            while (line != null) {
                // file is assumed to contain one name, score pair per line
                String[] tokens = line.split(",");
                String name = tokens[0];
                int score = Integer.parseInt(tokens[1]);
                //Creating User objet for every studen and adding it to the ArrayList
                userRecords.add(new User(name,score));
                //text = text + name + " " + score + "\n";
                line = reader.readLine();
            }
            //Sorting the ArrayList userRecords based on scores
            Collections.sort(userRecords, new scoresCompare());
            
            //Creating a BufferedWriter object to write into output text file
            x = new BufferedWriter(new FileWriter("data/output.txt"));
            //Writing every userRecords to output file
            for(User user : userRecords){
           
            x.write(user.name);
             
            x.write(" "+user.score);
             
            x.newLine();
            
            }
            
            System.out.println("...done.");
        } finally { //closing the resources
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
            
            if(x != null){
                x.close();
            }
        }
    }   
   /**
    * 
    * @param textArea the place where highscore is displayed on the score panel
    * @throws IOException incase error occurs when reading files 
    * <p> Another buffered and file reader is used here to output the sorted text file of scores </p>
    */
   public void outputScores (JTextArea textArea) throws IOException {
       FileReader fr = null;
        BufferedReader reader = null; // creating BufferedReader object to read the input text file
        try {
            System.out.println("Reading " + outputFileName + " ...");
            fr = new FileReader(outputFileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            String text = "";
            int rank = 1;
            int i = 0;
            while ((line != null)&& i < 10) { //in order to only display top ten scores 
                // file is assumed to contain one name, score pair per line
                String[] tokens = line.split(" ");
                String name = tokens[0];               
                System.out.println(tokens[1]);

                int score = Integer.parseInt(tokens[1]);
                text = text + rank + ". " + name + " " + score + "\n"; //outputs rank of player with name and score 
                textArea.setText(text);
                
                line = reader.readLine();
                rank++;
                i++;
            }
            System.out.println("...done.");
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    
 
   }
}   