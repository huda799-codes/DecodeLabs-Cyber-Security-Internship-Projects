import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GUI {


    JFrame frame;
    JTextArea output;


    public GUI(){


        frame = new JFrame(
                "Cyber Security Vulnerability Scanner"
        );


        frame.setSize(
                800,
                600
        );


        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );


        frame.setLayout(
                new BorderLayout()
        );


        // Title

        JLabel title =
                new JLabel(
                        "SYSTEM VULNERABILITY ASSESSMENT TOOL",
                        SwingConstants.CENTER
                );


        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );


        title.setForeground(
                Color.WHITE
        );


        title.setBackground(
                Color.BLACK
        );


        title.setOpaque(true);


        frame.add(
                title,
                BorderLayout.NORTH
        );



        // Output Area

        output =
                new JTextArea();


        output.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14
                )
        );


        output.setEditable(
                false
        );


        JScrollPane scroll =
                new JScrollPane(
                        output
                );


        frame.add(
                scroll,
                BorderLayout.CENTER
        );



        // Button

        JButton scanButton =
                new JButton(
                        "START SECURITY AUDIT"
                );


        scanButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );



        scanButton.addActionListener(e -> runAudit());



        frame.add(
                scanButton,
                BorderLayout.SOUTH
        );



        frame.setVisible(true);


    }





    private void runAudit(){


        output.setText("");

        output.append(
                "Starting Security Audit...\n\n"
        );



        ArrayList<Vulnerability> findings =
                new ArrayList<>();


        UserScanner users =
                new UserScanner();


        FirewallScanner firewall =
                new FirewallScanner();


        UpdateScanner updates =
                new UpdateScanner();


        EncryptionScanner encryption =
                new EncryptionScanner();



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



        for(
                Vulnerability v: findings
        ){


            output.append(
                    v.toString()
            );


        }



        ReportGenerator report =
                new ReportGenerator();


        report.generate(
                findings
        );


        output.append(
                "\n\nREPORT GENERATED SUCCESSFULLY"
        );


    }





    public static void main(String[] args){


        new GUI();


    }


}