import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GUI {


    JFrame frame;
    JTextArea output;


    JLabel status;


    public GUI(){


        frame = new JFrame(
                "Cyber Security Vulnerability Scanner"
        );


        frame.setSize(900,650);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );


        frame.setLayout(
                new BorderLayout()
        );



        // HEADER

        JLabel header =
                new JLabel(
                        "CYBER SECURITY VULNERABILITY SCANNER",
                        SwingConstants.CENTER
                );


        header.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );


        header.setForeground(
                Color.WHITE
        );


        header.setBackground(
                new Color(20,30,50)
        );


        header.setOpaque(true);


        header.setPreferredSize(
                new Dimension(900,70)
        );


        frame.add(
                header,
                BorderLayout.NORTH
        );



        // CENTER PANEL


        output =
                new JTextArea();


        output.setFont(
                new Font(
                        "Consolas",
                        Font.PLAIN,
                        15
                )
        );


        output.setBackground(
                new Color(245,245,245)
        );


        output.setMargin(
                new Insets(15,15,15,15)
        );


        output.setEditable(false);



        JScrollPane scroll =
                new JScrollPane(output);



        frame.add(
                scroll,
                BorderLayout.CENTER
        );



        // FOOTER PANEL


        JPanel bottom =
                new JPanel();



        bottom.setLayout(
                new FlowLayout()
        );



        JButton scan =
                new JButton(
                        "START SECURITY AUDIT"
                );



        scan.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );



        status =
                new JLabel(
                        "Status: Ready"
                );



        scan.addActionListener(
                e -> runAudit()
        );



        bottom.add(status);

        bottom.add(scan);



        frame.add(
                bottom,
                BorderLayout.SOUTH
        );



        frame.setVisible(true);

    }







    void runAudit(){


        output.setText("");

        status.setText(
                "Status: Scanning..."
        );



        ArrayList<Vulnerability> findings =
                new ArrayList<>();



        findings.addAll(
                new UserScanner()
                        .checkUsers()
        );



        findings.addAll(
                new FirewallScanner()
                        .checkFirewall()
        );



        findings.addAll(
                new UpdateScanner()
                        .checkUpdates()
        );



        findings.addAll(
                new EncryptionScanner()
                        .checkEncryption()
        );



        for(
                Vulnerability v: findings
        ){


            output.append(
                    v.toString()
            );


        }



        new ReportGenerator()
                .generate(findings);



        status.setText(
                "Status: Audit Completed ✔"
        );



    }






    public static void main(String[] args){

        new GUI();

    }

}