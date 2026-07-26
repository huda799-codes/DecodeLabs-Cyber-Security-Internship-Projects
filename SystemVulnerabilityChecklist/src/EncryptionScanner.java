import java.util.ArrayList;


public class EncryptionScanner {


    public ArrayList<Vulnerability> checkEncryption(){


        ArrayList<Vulnerability> list =
                new ArrayList<>();


        list.add(

                new Vulnerability(

                        "Disk Encryption",

                        "Storage encryption should be verified",

                        RiskLevel.MEDIUM,

                        "Enable full disk encryption"

                )

        );


        return list;

    }

}