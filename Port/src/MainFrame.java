import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

public class MainFrame extends JFrame{
    Scanner scan = new Scanner(System.in);
    //set of attributes associated with each container HUB
    private int ID;
    private int weight;
    private String origin;
    private boolean inspected;
    private int priority;
    private String description[] = new String[100];
    private String sender[] = new String[20];
    private String receiver[] = new String[20];
    //GUI attributes
    private JLabel IDNumberLabel;
    private JLabel weightTonsLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel countryLabel;
    private JLabel priorityLabel;
    private JComboBox comboBox1;
    private JLabel companyLogoLabel;
    private JTextPane a150X128TextPane;
    private JRadioButton a1RadioButton;
    private JLabel stateHubPlanLabel;
    private JTextArea textArea1;
    private JLabel customInspectionLabel;
    private JCheckBox checkBox1;
    private JLabel descriptionLabel;
    private JTextArea descriptionIsShownHereTextArea;
    private JLabel remitentCompanyLabel;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel receiverCompanyLabel;
    private JButton pileButton;
    private JButton UNPILEButton;
    private JButton showContainerDescriptionButton;
    private JButton numberOfContainersButton;
    private JLabel operationsLabel;
    private JComboBox comboBox2;
    private JTextField textField5;
    private JTextArea descriptionIsShownHereTextArea1;
    private JTextField textField6;
    private JRadioButton a3RadioButton;
    private JRadioButton a2RadioButton;
    private JPanel mainPanel;
    //HUB DEFINITION
    private int hub[][] = new int[10][12];

    //CONSTRUCTORS
    public MainFrame(int ID, int weight, String origin, boolean inspected, int priority, String[] description, String [] sender, String[] receiver){
        this.ID=ID;
        this.weight=weight;
        this.origin=origin;
        this.inspected=inspected;
        this.priority=priority;
        this.description=description;
        this.sender=sender;
        this.receiver=receiver;
    }
    //GETTERS AND SETTERS

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public ActionEvent setOrigin(String origin) {
        this.origin = origin;
        return null;
    }

    public boolean isInspected() {
        return inspected;
    }

    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public String[] getSender() {
        return sender;
    }

    public void setSender(String[] sender) {
        this.sender = sender;
    }

    public String[] getReceiver() {
        return receiver;
    }

    public void setReceiver(String[] receiver) {
        this.receiver = receiver;
    }
    //Method toString
    public String toString(){
        return "Information of the container hub: ID =" + this.ID + " weight: " +this.weight+ " country of origin: " + this.origin + " inspected: " +this.inspected+ " priority: " + this.priority + " content description: "
                + this.description + " company which sends: " + this.sender + " company that receives: " + this.receiver;
    }
    public void addContainer(){
        if(this.priority==1){
            for(int i = 0; i<hub.length; i++){
                for(int j=0;j<=1;j++){
                    hub[i][j]=1;
                }
            }
        }
        else if(this.priority==2){
            for(int i = 0; i<hub.length; i++){
                for(int j=1;j<=2;j++){
                    hub[i][j]=1;
                }
            }
        }
        else{ //priority 3
            for(int i = 0; i<hub.length; i++){
                for(int j=2;j<hub.length;j++){
                    hub[i][j]=1;
                }
            }
        }
    }
    public void removeContainer(){
        System.out.println("Select column to remove: ");
        int c = scan.nextInt();
        for(int i = 0; i<hub.length;i++){
            for(int j = c; j<hub.length;j++) {
                hub[i][j]=0;
            }
        }
    }
    public void showContainer(){
        for(int i = 0; i<hub.length;i++){
            for(int j = 0; j<hub.length;j++){
                if(getID()==this.ID){
                    System.out.println(toString());
                }
                else{
                    System.out.println("We are sorry, but this container is not in the hub");
                }
            }
        }
    }
    public int quantityCountry(){
        int quantity = 0;
        for(int i = 0; i<hub.length;i++){
            for(int j = 0; j<hub.length;j++){
                if(getOrigin() == this.origin){
                    quantity++;
                }
            }
        }
        return quantity;
    }
    public MainFrame(){
        setTitle("Welcome to port management");
        setSize(950, 800);
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = textField1.getText();
            }
        });
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String weight = textField2.getText();
            }
        });
        descriptionIsShownHereTextArea.addComponentListener(new ComponentAdapter() {
            String description = descriptionIsShownHereTextArea.getText();
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] countries ={"Germany, Italy, Denmark"};
                DefaultComboBoxModel<String> country = new DefaultComboBoxModel<>(countries);
                JComboBox<String> comboBox = new JComboBox<>(country);
            }
        });
        a1RadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        a2RadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        a3RadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        textArea1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                String area1 = textArea1.getText();
            }
        });
        textField3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sender = textField3.getText();
            }
        });
        textField4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String receiver = textField4.getText();
            }
        });
        pileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        UNPILEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        showContainerDescriptionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        numberOfContainersButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        textField6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textField = textField6.getText();
            }
        });
        descriptionIsShownHereTextArea1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                showContainerDescriptionButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                    }
                });
                descriptionIsShownHereTextArea.getText();
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] number ={"1", "2", "3", "4", "5"};
                DefaultComboBoxModel<String> containerNum = new DefaultComboBoxModel<>(number);
                JComboBox<String> comboBox2 = new JComboBox<>(containerNum);
            }
        });
        textField5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text5 = textField5.getText();
            }
        });
        checkBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

    }
    public static void main(String[] args) {
        MainFrame myGUI = new MainFrame();
    }
}
