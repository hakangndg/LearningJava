package Collections.HashCodes.Setup;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactData {

  private static final String phoneData = """
      Hakan Gündoğ, 123
      Alan Ritchson, 456
      Roscoe W, 789
      """;
  
  private static final String emailData = """
      Henry Cavill, henry@gmail.com
      Steph Curry, curry@gmail.com
      """;

    public static List<Contact> getData(String type) {
        List<Contact> dataList = new ArrayList<>();
        Scanner scanner = new Scanner(type.equals("phone") ? phoneData : emailData);
        while (scanner.hasNext()) {
            String[] data = scanner.nextLine().split(",");
            Arrays.asList(data).replaceAll(String::trim);
            if (type.equals("phone")) {
                dataList.add(new Contact(data[0], Long.parseLong(data[1])));
            }
            else if(type.equals("email")) {
                dataList.add(new Contact(data[0], data[1]));
            }
        }
        return dataList;


    }
}
