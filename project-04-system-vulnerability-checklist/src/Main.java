import java.util.ArrayList;


public class Main {


    public static void main(String[] args){


        System.out.println(
                "SYSTEM VULNERABILITY CHECKLIST"
        );


        ArrayList<Vulnerability> findings =
                new ArrayList<>();


        SystemScanner system =
                new SystemScanner();


        UserScanner users =
                new UserScanner();


        FirewallScanner firewall =
                new FirewallScanner();


        UpdateScanner updates =
                new UpdateScanner();


        EncryptionScanner encryption =
                new EncryptionScanner();



        findings.addAll(
                system.scanSystem()
        );


        findings.addAll(
                users.checkUsers()
        );


        findings.addAll(
                firewall.checkFirewall()
        );


        findings.addAll(
                updates.checkUpdates()
        );


        findings.addAll(
                encryption.checkEncryption()
        );



        ReportGenerator report =
                new ReportGenerator();


        report.generate(
                findings
        );


        System.out.println(
                "Security Audit Completed"
        );


    }

}