import java.util.ArrayList;


public class UserScanner {


    public ArrayList<Vulnerability> checkUsers(){


        ArrayList<Vulnerability> list =
                new ArrayList<>();


        list.add(
                new Vulnerability(
                        "User Account Review",
                        "User accounts should be reviewed regularly",
                        RiskLevel.MEDIUM,
                        "Remove unused accounts and enable strong passwords"
                )
        );


        return list;

    }

}