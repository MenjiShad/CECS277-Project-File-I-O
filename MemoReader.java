/* James Dinh
 * 2015/02/26
 * Purpose: Write and read memos from a file
 * Input: File name, Memo topic, Memo body into File
 * Output: Memo topic, Date Stamp, Memo Body from File
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MemoReader {
  
  // instance variables
  private Scanner fileReader;
  private final int NUM_OF_MEMO_LINES = 3;
  
  // Constructor to initialize the Scanner and delimiter
  // This allows each object of MemoReader to have it owns Scanner
  public MemoReader(File inFile, String delimiter) {
    try {
      fileReader = new Scanner(inFile);
      fileReader.useDelimiter(delimiter);
    }
    catch (FileNotFoundException fnfe) {
      System.out.println("File not found. Exiting...");
    }
  }
  
  // Read memos from a File
  public void readMemo() {
    int counter = 0;
    
    // Checks to see if there is another memo
    if (!fileReader.hasNextLine()) {
      System.out.println("End of File reached.");
      counter = NUM_OF_MEMO_LINES;
    }
    
    // Reads each "line"/token of the memo
    while (counter < NUM_OF_MEMO_LINES) {
      System.out.println(fileReader.next());
      if (counter == NUM_OF_MEMO_LINES - 1)
        fileReader.nextLine(); // Consume \n character
      counter++;
    }
  }
  
  // Closes the Scanner
  public void closeReader() {
    fileReader.close();
  }
}
