package script_for_gmail;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class GmailScript {

    public static void main(String[] args) {

    }

    private static void writeToFile(String content) {
        String fileNameToStoreEmails = ".\\src\\script_for_gmail\\Emails.txt";

        try {
            Writer writer = new FileWriter(fileNameToStoreEmails);
            writer.write(content);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
