import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class PasswordGeneratorGUI  extends JFrame{

    private PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI(){
        super("Password Generator");

    setSize(540,570); 

    setResizable(false);

    setLayout(null);

    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setLocationRelativeTo(null);

    passwordGenerator = new PasswordGenerator();

    addGuiComponents();

    }
       private void addGuiComponents(){
    JLabel titleLabel = new JLabel("Password Generator");

    titleLabel.setFont(new Font("Dialog",Font.BOLD,32));

    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

    titleLabel.setBounds(0,10,540,39);

    add(titleLabel);

    JTextArea passwordOutput = new JTextArea();

    passwordOutput.setEditable(false);
    passwordOutput.setFont(new Font("Dialog",Font.BOLD,32));

    JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
    passwordOutputPane.setBounds(25,97,479,70);

    passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    add(passwordOutputPane);

    JLabel passwordLengthLabel = new JLabel("Password Length: ");
    passwordLengthLabel.setFont(new Font("Dialog",Font.PLAIN,32));
    passwordLengthLabel.setBounds(25, 215, 272, 39);
    add(passwordLengthLabel);

   JTextArea passwordLenghtInputArea = new JTextArea();
   passwordLenghtInputArea.setFont(new Font("Dialog",Font.PLAIN,32));
   passwordLenghtInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
   passwordLenghtInputArea.setBounds(310,215,192,39);
   add(passwordLenghtInputArea);


    JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
    uppercaseToggle.setFont(new Font("Dialog",Font.PLAIN,26));
    uppercaseToggle.setBounds(25,302,225,56);
    add(uppercaseToggle);

    JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
    lowercaseToggle.setFont(new Font("Dialog",Font.PLAIN,26));
    lowercaseToggle.setBounds(282,302,225,56);
    add(lowercaseToggle);

    JToggleButton numbersToggle = new JToggleButton("Numbers");
    numbersToggle.setFont(new Font("Dialog",Font.PLAIN,26));
    numbersToggle.setBounds(25,373,225,56);
    add(numbersToggle);

    JToggleButton symbolsToggle = new JToggleButton("Symbols");
    symbolsToggle.setFont(new Font("Dialog",Font.PLAIN,26));
    symbolsToggle.setBounds(282,373,225,56);
    add(symbolsToggle);


    JButton generateButton = new JButton("Generate");
    generateButton.setFont(new Font("Dialog",Font.PLAIN,32));
    generateButton.setBounds(155,477,222,41);
    generateButton.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
          if(passwordLenghtInputArea.getText().length() <=0) return;
          boolean anyToggleSelected = lowercaseToggle.isSelected() ||
                  uppercaseToggle.isSelected() || 
                  numbersToggle.isSelected() ||
                  symbolsToggle.isSelected();

          int passwordLenght = Integer.parseInt(passwordLenghtInputArea.getText());  
          if(anyToggleSelected){
            String generatedPassword = passwordGenerator.generatePassword(passwordLenght,
                                                         uppercaseToggle.isSelected(),
                                                         lowercaseToggle.isSelected(),
                                                         numbersToggle.isSelected(),
                                                         symbolsToggle.isSelected());


        passwordOutput.setText(generatedPassword);

          }
       } 
    });
    add(generateButton);


    } 
}
