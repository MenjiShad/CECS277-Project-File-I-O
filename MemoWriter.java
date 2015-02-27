/* James Dinh
 * 2015/02/26
 * Purpose: Write and read memos from a file
 * Input: File name, Memo topic, Memo body into File
 * Output: Memo topic, Date Stamp, Memo Body from File
 */
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class MemoWriter {
  
  //instance variables
  private java.util.Date dateStamp;
  private PrintWriter writer;
  private String delimiter;
  private File outFile;
  
  // Constructor to initialize date stamp, delimiter, PrintWriter, and File
  // By initializing the PrintWriter and File in the constructor
  // Each object of MemoWriter created will have its own PrintWriter and File
  public MemoWriter(String outFileName, String delimiter) {
    dateStamp = new java.util.Date();
    this.delimiter = delimiter;
    outFile = new File(outFileName);
    
    // Don't overwrite exisiting files
    if (outFile.exists()) {
      System.out.println("File already exists. Exiting...");
      System.exit(0);
    }
    
    // Create the PrintWriter
    try {
      writer = new PrintWriter(outFile);
    }
    catch (FileNotFoundException fnfe) {
      System.out.println("File not found.");
    }
  }
  
  // Write memos to a File
  public void writeMemo(String topic, String body) {
    writer.println(topic + delimiter + dateStamp + delimiter + body + delimiter);
  }
  
  // Closes the writer
  public void closeWriter() {
    writer.close();
  }
}
