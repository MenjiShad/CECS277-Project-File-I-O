import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class MemoWriter {
  
  //instance variables
  private File outFile;
  private Scanner input;
  private PrintWriter writer;
  private java.util.Date dateStamp;
  
  MemoWriter(String outFileName) {
    dateStamp = new java.util.Date();
    outFile = new File(outFileName);
    input = new Scanner(System.in);
    if (outFile.exists()) {
      System.out.println("File already exists. Exiting...");
      System.exit(0);
    }
    try {
    writer = new PrintWriter(outFile);
    } 
    catch (FileNotFoundException fnfe) {
      System.out.println("File not found.");
    }
  }

  public void writeMemo(int numOfMemos) {
    for (int i = 0; i < numOfMemos; i++) {
      System.out.println("Enter the topic of memo " + (i + 1) + ": ");
      writer.print(input.nextLine() + "-delim-");
      writer.print(dateStamp.toString() + "-delim-");
      
      System.out.println("Enter the line of text for your memo: ");
      writer.println(input.nextLine() + "-delim-");
    }
    writer.close();
    input.close();
  }
  
}
