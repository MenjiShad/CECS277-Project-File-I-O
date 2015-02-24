/* James Dinh
 * 2015/02/23
 * Purpose: Write and read memos from a file
 * Input: File name, Memo topic, Memo body into File
 * Output: Memo topic, Date Stamp, Memo Body from File
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

public class MemoReader {
  
  // instance variables
  private Scanner fileReader;
  private Scanner input = new Scanner(System.in);
  private String delimiter;
  
  // Constructor to initialize the delimiter
  MemoReader(String delimiter) {
    this.delimiter = delimiter;
  }
  
// Read memos from a File
  public void readMemo() {
    JFileChooser dialogBox = new JFileChooser();
    if (dialogBox.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      File inFile = dialogBox.getSelectedFile();
      
      try {
        fileReader = new Scanner(inFile);
        fileReader.useDelimiter(delimiter); // set the delimiter
        
        // As long as there are memos, enable option to read
        int counter = 0;
        while (fileReader.hasNextLine()) {
          // Each memo is 3 lines, so pause after 3 lines are read
          if (counter % 3 != 0 || counter == 0) { 
            System.out.println(fileReader.next());
            counter++;
          } else {
            System.out.println("Read the next memo? (Y/N)");
            String choice = input.next();
            counter = 0; // Reset counter
            
            // If there are no more memos, end of file is reached
            if (!fileReader.hasNext()) {
              System.out.println("End of file reached.");
              break;
            }
            
            // If the user does not want to read memos, exit the loop
            // Otherwise, read another memo
            if (choice.charAt(0) == 'N' || choice.charAt(0) == 'n')
              break;
          }
        }
      }
      catch (FileNotFoundException fnfe) {
        System.out.println("File not found.");
      }
      finally {
        // Close Scanners
        fileReader.close();
        input.close();
      }
    } 
  }
}
