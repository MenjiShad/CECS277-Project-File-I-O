/* James Dinh
 * 2015/02/23
 * Purpose: Write and read memos from a file
 * Input: File name, Memo topic, Memo body into File
 * Output: Memo topic, Date Stamp, Memo Body from File
 */
import java.util.Scanner;

public class MemoTester {
 
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
        // delimiter is declared here to make it easy to make changes to the demiliter
    // It's final in order to prevent the user from changing the delim
    final String delimiter = "-delim-";
    MemoWriter memoWrite = new MemoWriter(delimiter);
    MemoReader memoRead = new MemoReader(delimiter); 
    
    // Call to write memos into a File
    System.out.println("Enter a name for your output file: ");
    memoWrite.writeMemo(input.nextLine());
    
    // Call to read memos from a File
    memoRead.readMemo();
    
    // close Scanner
    input.close();
  }
}
