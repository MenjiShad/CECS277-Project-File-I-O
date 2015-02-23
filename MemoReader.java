import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

public class MemoReader {
  
  // instance variables
  private JFileChooser dialogBox;
  private File inFile;
  private Scanner fileReader;
  private Scanner input = new Scanner(System.in);
  
  MemoReader() {}
  
  public void readMemo() {
    dialogBox = new JFileChooser();
    if (dialogBox.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      inFile = dialogBox.getSelectedFile();
      try {
      fileReader = new Scanner(inFile);
      fileReader.useDelimiter("-delim-");
      } 
      catch (FileNotFoundException fnfe) {
        System.out.println("File not found.");
      }
      
      int counter = 0;
      while (fileReader.hasNextLine()) {
        if (counter % 3 != 0 || counter == 0) {
          System.out.println(fileReader.next());
          counter++;
        } else {
          System.out.println("Read the next memo? (Y/N)");
          String choice = input.next();
          counter = 0;
          
          if (!fileReader.hasNext()) {
            System.out.println("End of File reached.");
            break;
          }
          
          if (choice.charAt(0) == 'N' || choice.charAt(0) == 'n')
            break;
        }
      }
    }
    fileReader.close();
    input.close();
  }
  
}
