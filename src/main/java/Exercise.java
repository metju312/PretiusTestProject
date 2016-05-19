import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exercise {

  private static String filePath;
  private List<Transaction> transactionList;
  private Float sum = 0f;
  private Float suma = 0f;

  public Exercise(String filePath) {
    this.filePath = filePath;
    transactionList = new ArrayList<Transaction>();

    try {
      readFile(filePath);
    } catch (IOException e) {
      e.printStackTrace();
    }

    printTransactionList();
  }

  private void printTransactionList() {
    for (Transaction transaction : transactionList) {
      System.out.println(transaction.getName());
      System.out.println(transaction.getSurname());
      System.out.println(transaction.getSrc_iban());
      System.out.println(transaction.getDst_iban());
      System.out.println(transaction.getAmount());

      sum+=transaction.getAmount();
      suma+=transaction.getAmount();
    }
    System.out.println("\nSuma transakcji:");
    System.out.printf("%.2f", sum);
  }

  public void readFile(String filePath) throws IOException {
    FileReader fileReader = new FileReader(filePath);
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    String textLine = bufferedReader.readLine();
    do {
      //System.out.println(textLine);
      if(!Objects.equals(textLine, "")){
        generateTransaction(textLine);
      }

      textLine = bufferedReader.readLine();
    } while(textLine != null);

    bufferedReader.close();
  }

  private void generateTransaction(String textLine) {
    String[] parts = textLine.split("(@|:)");

    for (String part : parts) {
      //System.out.println(part);
    }
    Transaction transaction = new Transaction();

//
//    System.out.println(parts[0]);//emptyline
//    System.out.println(parts[1]);//name
//    System.out.println(parts[2]);//Jan
//    System.out.println(parts[3]);//surname
//    System.out.println(parts[4]);//Kowalski
//    System.out.println(parts[5]);//84...
//    System.out.println(parts[6]);//dst_iban
//    System.out.println(parts[7]);//16...
//    System.out.println(parts[8]);//amount
//    System.out.println(parts[9]);//12...
//    System.out.println(parts[10]);//12...



    transaction.setName(parts[2]);
    transaction.setSurname(parts[4]);
    transaction.setSrc_iban(parts[6]);
    transaction.setDst_iban(parts[8]);
    //System.out.println(parts[10].substring(0,parts[10].length()-3));
    String amount = parts[10].replaceAll(",","\\.");
    transaction.setAmount(Float.valueOf(amount.substring(0,amount.length()-3)));
    transactionList.add(transaction);
  }


}
