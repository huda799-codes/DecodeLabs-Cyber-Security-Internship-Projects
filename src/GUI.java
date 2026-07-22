import javax.swing.*;


public class GUI {


    public static void main(String args[]){


        JFrame frame =
                new JFrame(
                        "Cyber Security Vulnerability Scanner"
                );



        JButton button =
                new JButton(
                        "Start Security Audit"
                );



        button.setBounds(
                80,
                80,
                200,
                50
        );



        button.addActionListener(e->{


            Main.main(null);


        });



        frame.add(button);


        frame.setSize(
                350,
                250
        );


        frame.setLayout(null);


        frame.setVisible(true);


    }



}