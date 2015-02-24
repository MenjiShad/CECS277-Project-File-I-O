/* James Dinh
 * 2015/02/23
 * Purpose: Write and read memos from a file
 * Input: File name, Memo topic, Memo body into File
 * Output: Memo topic, Date Stamp, Memo Body from File
 */
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class MemoWriter {
  
  //instance variables
  private java.util.Date dateStamp;
  private PrintWriter writer;
  private String delimiter;
  
  // Constructor to initialize date stamp and delimiter
  MemoWriter(String delimiter) {
    dateStamp = new java.util.Date();
    this.delimiter = delimiter;
  }

  // Write memos to a File
  public void writeMemo(String outFileName) {
    String choice;
    File outFile = new File(outFileName);
    Scanner input = new Scanner(System.in);
    if (outFile.exists()) {
      System.out.println("File already exists. Exiting...");
      System.exit(0);
    }
    
    try {
      writer = new PrintWriter(outFile);
      
      // Loop to allow user to enter memos to their heart's content
      do {
        System.out.println("Enter the topic of memo: ");
        writer.print(input.nextLine() + delimiter);
        writer.print(dateStamp.toString() + delimiter);
        
        System.out.println("Enter the line of text for your memo: ");
        writer.print(input.nextLine() + delimiter);
        
        System.out.println("Would you like to enter another memo? (Y/N)");
        choice = input.nextLine();
      } while (choice.charAt(0) == 'y' || choice.charAt(0) == 'Y');
    }
    catch (FileNotFoundException fnfe) {
      System.out.println("File not found.");
    }
    finally {
      // Close PrintWriter and Scanner
      writer.close();
      input.close();
    }
  }
}
