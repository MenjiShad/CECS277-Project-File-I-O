/* James Dinh
 * 2015/02/26
 * Purpose: Write and read memos from a file
 * Input: File name, Memo topic, Memo body into File
 * Output: Memo topic, Date Stamp, Memo Body from File
 */
import java.util.Scanner;
import javax.swing.JFileChooser;

public class MemoTester {
  
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    String choice;
    // delimiter is declared here to make it easy to make changes to the demiliter
    // It's final in order to prevent the user from changing the delim
    final String delimiter = "-delim-";
    MemoReader reader = null;

    // Prompt user for output file name
    System.out.println("Enter a name for your output file: ");
    MemoWriter writer = new MemoWriter(input.nextLine(), delimiter);
    
    // Loop to allow user to enter memos to their heart's content
    do {
      System.out.println("Enter the topic of memo: ");
      String memoTopic = input.nextLine();
      
      System.out.println("Enter the line of text for your memo: ");
      writer.writeMemo(memoTopic, input.nextLine());
      
      System.out.println("Would you like to enter another memo? (Y/N)");
      choice = input.nextLine();
    } while (choice.charAt(0) == 'y' || choice.charAt(0) == 'Y');

    // Close PrintWriter from MemoWriter
    writer.closeWriter();

    // Allow user to choose a file via JFilechooser
    JFileChooser dialogBox = new JFileChooser();
    if (dialogBox.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
       reader = new MemoReader(dialogBox.getSelectedFile(), delimiter);
    }

    // If a file is chosen, then reader will be initialized
    // and this block will run -avoids Null exceptions-
    if (reader != null) {
      // Allows users to read memos to their heart's content
      do {
        reader.readMemo();
        System.out.println("Would you like to read another memo? (Y/N)");
        choice = input.nextLine();
      } while (choice.charAt(0) == 'y' || choice.charAt(0) == 'Y');
    }
    
    // Close the Scanner from MemoReader
    reader.closeReader();
    
    // close Scanner
    input.close();
  } 
}
