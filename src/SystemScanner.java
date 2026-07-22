import java.util.ArrayList;
public class SystemScanner {
    public ArrayList<Vulnerability> scanSystem(){

        ArrayList<Vulnerability> list =
                new ArrayList<>();


        String os =
                System.getProperty("os.name");


        System.out.println(
                "Operating System: "
                        + os
        );


        return list;

    }

}
