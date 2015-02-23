import java.util.Scanner;

public class MemoTester {
 
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter a name for your output file: ");
    MemoWriter memoWrite = new MemoWriter(input.nextLine());
    
    System.out.println("How many memos would you like to make?");
    int numOfMemos = input.nextInt();
    memoWrite.writeMemo(numOfMemos);
    
    MemoReader memoRead = new MemoReader();
    memoRead.readMemo();
    
    input.close();
  }
}
