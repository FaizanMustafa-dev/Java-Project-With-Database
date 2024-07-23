import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {
    private static BufferedImage image;
    private JFrame frame;
    private JPanel loginPanel;
   
    private static final Color DARK_BLUE = new Color(25, 50, 100);
    public Main() {
        frame = new JFrame("Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1536, 864);
        frame.setUndecorated(true); // Remove window decorations (title bar, borders)
        frame.setLayout(null); // We will set component bounds manually

        // Load the image
        try {
            image = ImageIO.read(new File("src/Payroll Management System.png")); // Replace with your image path
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Login Panel
        loginPanel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, 1536, 864, this);  
            }
        };
        loginPanel.setLayout(null);

        loginPanel.setBackground(Color.BLUE);
        loginPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        //loginPanel.setLayout(new FlowLayout());
        JButton loginButton = new JButton("Login");
        JButton ExitButton = new JButton("Quit");
        Color ButtonColor = new Color(12, 28, 60);
        loginButton.setBounds(1210, 700, 160, 45); // Setting position and size of the button
        loginButton.setBackground(DARK_BLUE);

        Font boldStylishFont = new Font("Serif", Font.BOLD, 20);

        loginButton.setFont(boldStylishFont);
       
        loginButton.setForeground(Color.WHITE);
        loginPanel.add(loginButton);


        ExitButton.setBounds(990, 700, 160, 45); // Setting position and size of the button
        ExitButton.setBackground(DARK_BLUE);
        
        ExitButton.setFont(boldStylishFont);
       
        ExitButton.setForeground(Color.WHITE);
        loginPanel.add(ExitButton);

        Font StylishFont = new Font("Serif", Font.PLAIN, 20);
// Add text field for username
JTextField usernameField = new JTextField();
usernameField.setBounds(1100, 458, 250, 35);
usernameField.setFont(StylishFont);
loginPanel.add(usernameField);

// Add password field
JPasswordField passwordField = new JPasswordField();
passwordField.setBounds(1100, 558, 250, 35);
passwordField.setFont(boldStylishFont);
loginPanel.add(passwordField);


        // Add_Employee_Panel
        JPanel Add_Employee_Panel = new JPanel();
        Color CUSTOM_BLUE = new Color(30, 74, 147);
        Add_Employee_Panel.setBackground(Color.WHITE);
        Add_Employee_Panel.setBounds(361, 0, frame.getWidth() - 100, frame.getHeight());
        Add_Employee_Panel.setVisible(false);
        Add_Employee_Panel.setLayout(new FlowLayout());

        // Add_Grade
        JPanel Add_Grade_Panel = new JPanel();  
        Add_Grade_Panel.setBackground(Color.WHITE);
        Add_Grade_Panel.setBounds(361, 0, frame.getWidth() - 100, frame.getHeight());
        Add_Grade_Panel.setVisible(false);
        Add_Grade_Panel.setLayout(new FlowLayout());

        // Add_Department_Panel
        JPanel Add_Department_Panel = new JPanel();
        Add_Department_Panel.setBackground(Color.WHITE);
        Add_Department_Panel.setBounds(361, 0, frame.getWidth() - 100, frame.getHeight());
        Add_Department_Panel.setVisible(false);
        Add_Department_Panel.setLayout(new FlowLayout());
       
         // Employee_Detail Panel
         JPanel Add_Emp_Salary_Panel = new JPanel();
         Add_Emp_Salary_Panel.setBackground(Color.WHITE);
         Add_Emp_Salary_Panel.setBounds(361, 0, frame.getWidth() - 100, frame.getHeight());
         Add_Emp_Salary_Panel.setVisible(false);
         Add_Emp_Salary_Panel.setLayout(new FlowLayout());      

         
         JPanel Employee_Payroll_Panel = new JPanel();
         Employee_Payroll_Panel.setBackground(Color.ORANGE);
         Employee_Payroll_Panel.setBounds(361, 0, frame.getWidth() - 100, frame.getHeight());
         Employee_Payroll_Panel.setVisible(false);
         Employee_Payroll_Panel.setLayout(null); 
       
        Color ButtoNColor = new Color(25, 50, 100);
        JPanel panel = new JPanel(null);
        panel.setBackground(DARK_BLUE);
        panel.setBounds(0, 0, 360, 900);

        JSeparator separator23 = new JSeparator();
        separator23.setBounds(50, 101, 250, 5); 
        panel.add(separator23);

        JSeparator separator24 = new JSeparator();
        separator24.setBounds(50, 102, 250, 5); 
        panel.add(separator24);

        JSeparator separator2 = new JSeparator();
        separator2.setBounds(50, 103, 250, 5); 
        panel.add(separator2);
        panel.setVisible(false);
       frame.add(panel);
       panel.setVisible(false);
      


        JLabel label = new JLabel("Data Base Project");
                                                                                                                                           
        label.setBounds(70, 30, 350, 70);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 25));

       

        JButton Add_Employee = new JButton("Add Employee");
        JButton Add_Grade = new JButton("Employee Payroll");
        JButton Add_Emp_Salary = new JButton("Add Employee Grade");
        JButton Employee_Detail = new JButton("Employee Detail");
        JButton Employee_Payroll = new JButton("Employee Payroll");
        JButton logoutButton = new JButton("Logout");

       
        JButton[] buttons = { Add_Employee, Add_Emp_Salary, Employee_Detail,Add_Grade, logoutButton };
        int y = 80 + 60 + 20;

        for (JButton button : buttons) {
            button.setBounds(0, y, 360, 40);
            button.setBackground(DARK_BLUE);
            button.setForeground(Color.WHITE);
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            panel.add(button);
            y += 80; 
        }

      
        panel.add(label);
        panel.setVisible(false);
     

       //Permanent Items Ends

       //Dasboard Start

   

       logoutButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Add_Employee_Panel.setVisible(false);
            loginPanel.setVisible(true);
            panel.setVisible(false);

            Add_Employee_Panel.setVisible(false);
            Add_Grade_Panel.setVisible(false);
            Add_Department_Panel.setVisible(false);
            Add_Emp_Salary_Panel.setVisible(false);
            
            
        }
    });





    // Set layout to null for manual component positioning
Add_Employee_Panel.setLayout(null);

// Create a stylish label for the title
JLabel titleLabel = new JLabel("Insert New Employee Details");
Font titleFont = new Font("Serif", Font.BOLD, 36); // Big font size
titleLabel.setFont(titleFont);
titleLabel.setForeground(CUSTOM_BLUE); // Blue color
titleLabel.setBounds(320, 70, 500, 50); // Position at the top center
Add_Employee_Panel.add(titleLabel);

Font labelFont = new Font("Serif", Font.PLAIN, 20);
Font textFieldFont = new Font("Serif", Font.PLAIN, 20);
int labelWidth = 150;
int labelHeight = 40;
int fieldWidth = 250;
int fieldHeight = 40;
int xOffset = 40;
int yOffset = 50;
int spacing = 40;
int yAdditionalOffset = 170; // Additional offset to move components down
int xAdditionalOffset = 90; // Additional offset to move components to the right

// Employee ID
JLabel empIdLabel = new JLabel("Employee ID");
empIdLabel.setFont(labelFont);
empIdLabel.setBounds(xOffset + xAdditionalOffset, yOffset + yAdditionalOffset, labelWidth, labelHeight);
Add_Employee_Panel.add(empIdLabel);
JTextField empIdField = new JTextField();
empIdField.setFont(textFieldFont);
empIdField.setBounds(xOffset + labelWidth + 10 + xAdditionalOffset, yOffset + yAdditionalOffset, fieldWidth, fieldHeight);
Add_Employee_Panel.add(empIdField);

// Employee Title
JLabel empTitleLabel = new JLabel("Employee Title");
empTitleLabel.setFont(labelFont);
empTitleLabel.setBounds(xOffset + labelWidth + fieldWidth + 40 + xAdditionalOffset, yOffset + yAdditionalOffset, labelWidth, labelHeight);
Add_Employee_Panel.add(empTitleLabel);
JTextField empTitleField = new JTextField();
empTitleField.setFont(textFieldFont);
empTitleField.setBounds(xOffset + 2 * (labelWidth + fieldWidth + 40) - fieldWidth + xAdditionalOffset, yOffset + yAdditionalOffset, fieldWidth, fieldHeight);
Add_Employee_Panel.add(empTitleField);

// Employee Name
yOffset += labelHeight + spacing;
JLabel empNameLabel = new JLabel("Employee Name");
empNameLabel.setFont(labelFont);
empNameLabel.setBounds(xOffset + xAdditionalOffset, yOffset + yAdditionalOffset, labelWidth, labelHeight);
Add_Employee_Panel.add(empNameLabel);
JTextField empNameField = new JTextField();
empNameField.setFont(textFieldFont);
empNameField.setBounds(xOffset + labelWidth + 10 + xAdditionalOffset, yOffset + yAdditionalOffset, fieldWidth, fieldHeight);
Add_Employee_Panel.add(empNameField);

// Date of Birth
JLabel empDOBLabel = new JLabel("Date of Birth");
empDOBLabel.setFont(labelFont);
empDOBLabel.setBounds(xOffset + labelWidth + fieldWidth + 40 + xAdditionalOffset, yOffset + yAdditionalOffset, labelWidth, labelHeight);
Add_Employee_Panel.add(empDOBLabel);
JTextField empDOBField = new JTextField();
empDOBField.setFont(textFieldFont);
empDOBField.setBounds(xOffset + 2 * (labelWidth + fieldWidth + 40) - fieldWidth + xAdditionalOffset, yOffset + yAdditionalOffset, fieldWidth, fieldHeight);
Add_Employee_Panel.add(empDOBField);

// Date of Joining
yOffset += labelHeight + spacing;
JLabel empDOJLabel = new JLabel("Date of Joining");
empDOJLabel.setFont(labelFont);
empDOJLabel.setBounds(xOffset + xAdditionalOffset, yOffset + yAdditionalOffset, labelWidth, labelHeight);
Add_Employee_Panel.add(empDOJLabel);
JTextField empDOJField = new JTextField();
empDOJField.setFont(textFieldFont);
empDOJField.setBounds(xOffset + labelWidth + 10 + xAdditionalOffset, yOffset + yAdditionalOffset, fieldWidth, fieldHeight);
Add_Employee_Panel.add(empDOJField);

// Address
JLabel empAddressLabel = new JLabel("Address");
empAddressLabel.setFont(labelFont);
empAddressLabel.setBounds(xOffset + labelWidth + fieldWidth + 40 + xAdditionalOffset, yOffset + yAdditionalOffset, labelWidth, labelHeight);
Add_Employee_Panel.add(empAddressLabel);
JTextField empAddressField = new JTextField();
empAddressField.setFont(textFieldFont);
empAddressField.setBounds(xOffset + 2 * (labelWidth + fieldWidth + 40) - fieldWidth + xAdditionalOffset, yOffset + yAdditionalOffset, fieldWidth, fieldHeight);
Add_Employee_Panel.add(empAddressField);

// Mobile No
yOffset += labelHeight + spacing;
JLabel empMobileNoLabel = new JLabel("Mobile No");
empMobileNoLabel.setFont(labelFont);
empMobileNoLabel.setBounds(xOffset + xAdditionalOffset, yOffset + yAdditionalOffset, labelWidth, labelHeight);
Add_Employee_Panel.add(empMobileNoLabel);
JTextField empMobileNoField = new JTextField();
empMobileNoField.setFont(textFieldFont);
empMobileNoField.setBounds(xOffset + labelWidth + 10 + xAdditionalOffset, yOffset + yAdditionalOffset, fieldWidth, fieldHeight);
Add_Employee_Panel.add(empMobileNoField);

// Mail ID
JLabel empMailIdLabel = new JLabel("Mail ID");
empMailIdLabel.setFont(labelFont);
empMailIdLabel.setBounds(xOffset + labelWidth + fieldWidth + 40 + xAdditionalOffset, yOffset + yAdditionalOffset, labelWidth, labelHeight);
Add_Employee_Panel.add(empMailIdLabel);
JTextField empMailIdField = new JTextField();
empMailIdField.setFont(textFieldFont);
empMailIdField.setBounds(xOffset + 2 * (labelWidth + fieldWidth + 40) - fieldWidth + xAdditionalOffset, yOffset + yAdditionalOffset, fieldWidth, fieldHeight);
Add_Employee_Panel.add(empMailIdField);

yOffset += labelHeight + spacing;
JLabel empDepLabel = new JLabel("Department ID");
empDepLabel.setFont(labelFont);
empDepLabel.setBounds(xOffset + xAdditionalOffset, yOffset + yAdditionalOffset, labelWidth, labelHeight);
Add_Employee_Panel.add(empDepLabel);
JTextField empDepField = new JTextField();
empDepField.setFont(textFieldFont);
empDepField.setBounds(xOffset + labelWidth + 10 + xAdditionalOffset, yOffset + yAdditionalOffset, fieldWidth, fieldHeight);
Add_Employee_Panel.add(empDepField);

Font buttonFont = new Font("Serif", Font.BOLD, 20);


// Add Button
JButton addButton = new JButton("Add");
addButton.setFont(buttonFont);
addButton.setBackground(DARK_BLUE);
addButton.setForeground(Color.WHITE);
addButton.setBounds(850,700,160,45);
Add_Employee_Panel.add(addButton);

// Clear Button
JButton clearButton = new JButton("Clear");
clearButton.setFont(buttonFont);
clearButton.setBackground(DARK_BLUE);
clearButton.setForeground(Color.WHITE);
clearButton.setBounds(650,700,160,45);
Add_Employee_Panel.add(clearButton);
  
clearButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        empIdField.setText(null);
        empTitleField.setText(null);
        empNameField.setText(null);
        empDOBField.setText(null);
        empDOJField.setText(null);
        empAddressField.setText(null);
        empMobileNoField.setText(null);
        empMailIdField.setText(null);
        empDepField.setText(null);
       
    }
});

// Action listener for Add button to get text from all fields and print it
addButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int empId = Integer.parseInt(empIdField.getText());
        String empTitle = empTitleField.getText();
        String empName = empNameField.getText();
        String empDOB = empDOBField.getText();
        String empDOJ = empDOJField.getText();
        String empAddress = empAddressField.getText();
        String empMobileNo = empMobileNoField.getText();
        String empMailId = empMailIdField.getText();
        
       try{
        if(EmployeeQueries.insertEmployee(empId, empTitle, empName, empDOB, empDOJ, empAddress, empMobileNo, empMailId)){
            JOptionPane.showMessageDialog(frame, "Successful Inserted!");
            empIdField.setText(null);
            empTitleField.setText(null);
            empNameField.setText(null);
            empDOBField.setText(null);
            empDOJField.setText(null);
            empAddressField.setText(null);
            empMobileNoField.setText(null);
            empMailIdField.setText(null);
            empDepField.setText(null);

        }
        else{
            JOptionPane.showMessageDialog(frame, "Failed to Inseted!");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Invalid input for Employee ID or Role ID!");
    }
    }
});









// Set layout to null for manual component positioning
Add_Grade_Panel.setLayout(null);


Add_Grade_Panel.setLayout(null);

        // Create a font and set dimensions as provided
        Font Payroll_labelFont = new Font("Serif", Font.PLAIN, 20);
        Font Payroll_textFieldFont = new Font("Serif", Font.PLAIN, 20);
        int Payroll_labelWidth = 150;
        int Payroll_labelHeight = 40;
        int Payroll_fieldWidth = 250;
        int Payroll_fieldHeight = 40;
        int Payroll_xOffset = 40;
        int Payroll_yOffset = 50;
        int Payroll_spacing = 15;
        int Payroll_yAdditionalOffset = 170; 
        int Payroll_xAdditionalOffset = 90; 

        // Employee ID
        JLabel Payroll_empIdLabel = new JLabel("Transaction ID:");
        Payroll_empIdLabel.setFont(Payroll_labelFont);
        Payroll_empIdLabel.setBounds(Payroll_xOffset + Payroll_xAdditionalOffset,120+ Payroll_yOffset, Payroll_labelWidth, Payroll_labelHeight);
        Add_Grade_Panel.add(Payroll_empIdLabel);
        JTextField Payroll_empIdField = new JTextField();
        Payroll_empIdField.setFont(Payroll_textFieldFont);
        Payroll_empIdField.setBounds(Payroll_xOffset + Payroll_labelWidth + 10 + Payroll_xAdditionalOffset, 120+Payroll_yOffset, Payroll_fieldWidth, Payroll_fieldHeight);
        Add_Grade_Panel.add(Payroll_empIdField);

        JButton ShowButton = new JButton("Show");
        ShowButton.setFont(new Font("Serif", Font.BOLD, 20));
        ShowButton.setBackground(new Color(0, 123, 255));
        ShowButton.setForeground(Color.WHITE);
        ShowButton.setBounds( 650,120+ Payroll_yOffset, Payroll_labelWidth, Payroll_labelHeight);
        Add_Grade_Panel.add(ShowButton);

        // Emp Salary Month
        JLabel Payroll_empSalaryMonthLabel = new JLabel("Salary Month:");
        Payroll_empSalaryMonthLabel.setFont(Payroll_labelFont);
        Payroll_empSalaryMonthLabel.setBounds(Payroll_xOffset + Payroll_xAdditionalOffset,150+ Payroll_yOffset + Payroll_yAdditionalOffset, Payroll_labelWidth, Payroll_labelHeight);
        Add_Grade_Panel.add(Payroll_empSalaryMonthLabel);
        JTextField Payroll_empSalaryMonthField = new JTextField();
        Payroll_empSalaryMonthField.setFont(Payroll_textFieldFont);
        Payroll_empSalaryMonthField.setBounds(Payroll_xOffset + Payroll_labelWidth + 10 + Payroll_xAdditionalOffset, 150+Payroll_yOffset + Payroll_yAdditionalOffset, Payroll_fieldWidth, Payroll_fieldHeight);
        Payroll_empSalaryMonthField.setEditable(false);
        Add_Grade_Panel.add(Payroll_empSalaryMonthField);

        // Emp Grade ID
        JLabel Payroll_empGradeIdLabel = new JLabel("Grade ID:");
        Payroll_empGradeIdLabel.setFont(Payroll_labelFont);
        Payroll_empGradeIdLabel.setBounds(330+Payroll_xOffset + Payroll_xAdditionalOffset + Payroll_labelWidth + Payroll_spacing,150+ Payroll_yOffset + Payroll_yAdditionalOffset, Payroll_labelWidth, Payroll_labelHeight);
        Add_Grade_Panel.add(Payroll_empGradeIdLabel);
        JTextField Payroll_empGradeIdField = new JTextField();
        Payroll_empGradeIdField.setFont(Payroll_textFieldFont);
        Payroll_empGradeIdField.setBounds(300+Payroll_xOffset + Payroll_labelWidth + 10 + Payroll_xAdditionalOffset + Payroll_labelWidth + Payroll_spacing,150+ Payroll_yOffset + Payroll_yAdditionalOffset, Payroll_fieldWidth, Payroll_fieldHeight);
        Payroll_empGradeIdField.setEditable(false);
        Add_Grade_Panel.add(Payroll_empGradeIdField);

        // Emp Basic Salary
        JLabel Payroll_empBasicLabel = new JLabel("Basic Salary:");
        Payroll_empBasicLabel.setFont(Payroll_labelFont);
        Payroll_empBasicLabel.setBounds(Payroll_xOffset + Payroll_xAdditionalOffset, Payroll_yOffset + 2 * Payroll_yAdditionalOffset+50, Payroll_labelWidth, Payroll_labelHeight);
        Add_Grade_Panel.add(Payroll_empBasicLabel);
        JTextField Payroll_empBasicField = new JTextField();
        Payroll_empBasicField.setFont(Payroll_textFieldFont);
        Payroll_empBasicField.setBounds(Payroll_xOffset + Payroll_labelWidth + 10 + Payroll_xAdditionalOffset, Payroll_yOffset + 2 * Payroll_yAdditionalOffset+50, Payroll_fieldWidth, Payroll_fieldHeight);
        Payroll_empBasicField.setEditable(false);
        Add_Grade_Panel.add(Payroll_empBasicField);

        // Emp Travel Allowance
        JLabel Payroll_empTravelAllowanceLabel = new JLabel("Travel Allow");
        Payroll_empTravelAllowanceLabel.setFont(Payroll_labelFont);
        Payroll_empTravelAllowanceLabel.setBounds(330+Payroll_xOffset + Payroll_xAdditionalOffset + Payroll_labelWidth + Payroll_spacing, Payroll_yOffset + 2 * Payroll_yAdditionalOffset+50, Payroll_labelWidth, Payroll_labelHeight);
        Add_Grade_Panel.add(Payroll_empTravelAllowanceLabel);
        JTextField Payroll_empTravelAllowanceField = new JTextField();
        Payroll_empTravelAllowanceField.setFont(Payroll_textFieldFont);
        Payroll_empTravelAllowanceField.setBounds(300+Payroll_xOffset + Payroll_labelWidth + 10 + Payroll_xAdditionalOffset + Payroll_labelWidth + Payroll_spacing, Payroll_yOffset + 2 * Payroll_yAdditionalOffset+50, Payroll_fieldWidth, Payroll_fieldHeight);
        Payroll_empTravelAllowanceField.setEditable(false);
        Add_Grade_Panel.add(Payroll_empTravelAllowanceField);

        // Emp House Rent Allowance
JLabel Payroll_empHouseRentAllowanceLabel = new JLabel("House Rent");
Payroll_empHouseRentAllowanceLabel.setFont(Payroll_labelFont);
Payroll_empHouseRentAllowanceLabel.setBounds(330 + Payroll_xOffset + Payroll_xAdditionalOffset + Payroll_labelWidth + Payroll_spacing, Payroll_yOffset + 2 * Payroll_yAdditionalOffset + 120, Payroll_labelWidth, Payroll_labelHeight);
Add_Grade_Panel.add(Payroll_empHouseRentAllowanceLabel);
JTextField Payroll_empHouseRentAllowanceField = new JTextField();
Payroll_empHouseRentAllowanceField.setFont(Payroll_textFieldFont);
Payroll_empHouseRentAllowanceField.setBounds(300 + Payroll_xOffset + Payroll_labelWidth + 10 + Payroll_xAdditionalOffset + Payroll_labelWidth + Payroll_spacing, Payroll_yOffset + 2 * Payroll_yAdditionalOffset + 120, Payroll_fieldWidth, Payroll_fieldHeight);
Payroll_empHouseRentAllowanceField.setEditable(false);
Add_Grade_Panel.add(Payroll_empHouseRentAllowanceField);

// Emp Medical Allowance
JLabel Payroll_empMedicalAllowanceLabel = new JLabel("Medical Allow");
Payroll_empMedicalAllowanceLabel.setFont(Payroll_labelFont);
Payroll_empMedicalAllowanceLabel.setBounds(Payroll_xOffset + Payroll_xAdditionalOffset, Payroll_yOffset + 2 * Payroll_yAdditionalOffset + 120, Payroll_labelWidth, Payroll_labelHeight);
Add_Grade_Panel.add(Payroll_empMedicalAllowanceLabel);
JTextField Payroll_empMedicalAllowanceField = new JTextField();
Payroll_empMedicalAllowanceField.setFont(Payroll_textFieldFont);
Payroll_empMedicalAllowanceField.setBounds(Payroll_xOffset + Payroll_labelWidth + 10 + Payroll_xAdditionalOffset, Payroll_yOffset + 2 * Payroll_yAdditionalOffset + 120, Payroll_fieldWidth, Payroll_fieldHeight);
Payroll_empMedicalAllowanceField.setEditable(false);
Add_Grade_Panel.add(Payroll_empMedicalAllowanceField);

// Emp Professional Tax
JLabel Payroll_empProfessionalTaxLabel = new JLabel("Tax:");
Payroll_empProfessionalTaxLabel.setFont(Payroll_labelFont);
Payroll_empProfessionalTaxLabel.setBounds(330 + Payroll_xOffset + Payroll_xAdditionalOffset + Payroll_labelWidth + Payroll_spacing, Payroll_yOffset + 2 * Payroll_yAdditionalOffset + 190, Payroll_labelWidth, Payroll_labelHeight);
Add_Grade_Panel.add(Payroll_empProfessionalTaxLabel);
JTextField Payroll_empProfessionalTaxField = new JTextField();
Payroll_empProfessionalTaxField.setFont(Payroll_textFieldFont);
Payroll_empProfessionalTaxField.setBounds(300 + Payroll_xOffset + Payroll_labelWidth + 10 + Payroll_xAdditionalOffset + Payroll_labelWidth + Payroll_spacing, Payroll_yOffset + 2 * Payroll_yAdditionalOffset + 190, Payroll_fieldWidth, Payroll_fieldHeight);
Payroll_empProfessionalTaxField.setEditable(false);
Add_Grade_Panel.add(Payroll_empProfessionalTaxField);

// Emp Gross Salary
JLabel Payroll_empGrossSalaryLabel = new JLabel("Gross Salary:");
Payroll_empGrossSalaryLabel.setFont(Payroll_labelFont);
Payroll_empGrossSalaryLabel.setBounds(Payroll_xOffset + Payroll_xAdditionalOffset, Payroll_yOffset + 2 * Payroll_yAdditionalOffset + 190, Payroll_labelWidth, Payroll_labelHeight);
Add_Grade_Panel.add(Payroll_empGrossSalaryLabel);
JTextField Payroll_empGrossSalaryField = new JTextField();
Payroll_empGrossSalaryField.setFont(Payroll_textFieldFont);
Payroll_empGrossSalaryField.setBounds(Payroll_xOffset + Payroll_labelWidth + 10 + Payroll_xAdditionalOffset, Payroll_yOffset + 2 * Payroll_yAdditionalOffset + 190, Payroll_fieldWidth, Payroll_fieldHeight);
Payroll_empGrossSalaryField.setEditable(false);
Add_Grade_Panel.add(Payroll_empGrossSalaryField);

// Emp Total Salary
JLabel Payroll_empTotalSalaryLabel = new JLabel("Total Salary:");
Payroll_empTotalSalaryLabel.setFont(Payroll_labelFont);
Payroll_empTotalSalaryLabel.setBounds(105+Payroll_xOffset , Payroll_yOffset + 2 * Payroll_yAdditionalOffset + 260, Payroll_labelWidth, Payroll_labelHeight);
Add_Grade_Panel.add(Payroll_empTotalSalaryLabel);
JTextField Payroll_empTotalSalaryField = new JTextField();
Payroll_empTotalSalaryField.setFont(Payroll_textFieldFont);
Payroll_empTotalSalaryField.setBounds(230+Payroll_xOffset+Payroll_spacing, Payroll_yOffset + 2 * Payroll_yAdditionalOffset + 260, Payroll_fieldWidth, Payroll_fieldHeight);
Payroll_empTotalSalaryField.setEditable(false);
Add_Grade_Panel.add(Payroll_empTotalSalaryField);


ShowButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        
        int tansID = Integer.parseInt(Payroll_empIdField.getText());
        
        
        EmployeeSalaryDetails salaryDetails = EmployeeSalaryDetailsQueries.selectEmployeeSalaryDetails(tansID);
         

        int empID=salaryDetails.empId;
        Employee empdetail=EmployeeQueries.selectEmployee(empID);
        EmployeeGradeDetails gradeDetails= EmployeeGradeDetailsQueries.selectEmployeeGradeDetails(empID);
// Check if details are retrieved successfully

    
    // Set retrieved details into text fields
    Payroll_empSalaryMonthField.setText(salaryDetails.empSalaryMonth);
    Payroll_empBasicField.setText(String.valueOf(salaryDetails.empBasic)+" Rs");
    Payroll_empTravelAllowanceField.setText(String.valueOf(salaryDetails.empTravelAllowance)+" Rs");
    Payroll_empHouseRentAllowanceField.setText(String.valueOf(salaryDetails.empHouseRentAllowance)+" Rs");
    Payroll_empMedicalAllowanceField.setText(String.valueOf(salaryDetails.empMedicalAllowance)+" Rs");
    Payroll_empProfessionalTaxField.setText(String.valueOf(salaryDetails.empProfessionalTax)+" Rs");
    Payroll_empGrossSalaryField.setText(String.valueOf(salaryDetails.empGrossSalary)+" Rs");
    Payroll_empTotalSalaryField.setText(String.valueOf(salaryDetails.empTotalSalary)+" Rs");
    Payroll_empGradeIdField.setText(String.valueOf(gradeDetails.empGradeId));
        }catch(Exception exceptions){
            JOptionPane.showMessageDialog(null,exceptions.getMessage());
        }
} 
       
       
    
});


// Assuming Add_Emp_Salary_Panel is already created
Add_Emp_Salary_Panel.setLayout(null);


// Create a stylish label for the title
JLabel GradeLabel = new JLabel("Insert Employee Grade Details");
GradeLabel.setFont(titleFont);
GradeLabel.setForeground(CUSTOM_BLUE); // Blue color
GradeLabel.setBounds(320, 100, 500, 50); // Position at the top center
Add_Emp_Salary_Panel.add(GradeLabel);

Font salarypanellabelFont = new Font("Serif", Font.PLAIN, 20);
Font salarypaneltextFieldFont = new Font("Serif", Font.PLAIN, 20);
int salarypanellabelWidth = 150;
int salarypanellabelHeight = 40;
int salarypanelfieldWidth = 250;
int salarypanelfieldHeight = 40;
int salarypanelxOffset = 40;
int salarypanelyOffset = 250;
int salarypanelspacing = 40;
int salarypanelyAdditionalOffset = 50;

// Transaction ID
JLabel transactionIdLabel = new JLabel("Transaction ID");
transactionIdLabel.setFont(salarypanellabelFont);
transactionIdLabel.setBounds(salarypanelxOffset, salarypanelyOffset + salarypanelyAdditionalOffset, salarypanellabelWidth, salarypanellabelHeight);
Add_Emp_Salary_Panel.add(transactionIdLabel);
JTextField transactionIdField = new JTextField();
transactionIdField.setFont(salarypaneltextFieldFont);
transactionIdField.setBounds(salarypanelxOffset + salarypanellabelWidth + 10, salarypanelyOffset + salarypanelyAdditionalOffset, salarypanelfieldWidth, salarypanelfieldHeight);
Add_Emp_Salary_Panel.add(transactionIdField);

// Employee ID
JLabel empIdLabel_Salary_Panel= new JLabel("Employee ID");
empIdLabel_Salary_Panel.setFont(salarypanellabelFont);
empIdLabel_Salary_Panel.setBounds(salarypanelxOffset + salarypanellabelWidth + salarypanelfieldWidth + 40, salarypanelyOffset + salarypanelyAdditionalOffset, salarypanellabelWidth, salarypanellabelHeight);
Add_Emp_Salary_Panel.add(empIdLabel_Salary_Panel);
JTextField empIdField_Salary_Panel = new JTextField();
empIdField_Salary_Panel.setFont(salarypaneltextFieldFont);
empIdField_Salary_Panel.setBounds(salarypanelxOffset + 2 * (salarypanellabelWidth + salarypanelfieldWidth + 40) - salarypanelfieldWidth, salarypanelyOffset + salarypanelyAdditionalOffset, salarypanelfieldWidth, salarypanelfieldHeight);
Add_Emp_Salary_Panel.add(empIdField_Salary_Panel);

// Department ID
salarypanelyOffset += salarypanellabelHeight + salarypanelspacing;
JLabel empDeptIdLabel = new JLabel("Department ID");
empDeptIdLabel.setFont(salarypanellabelFont);
empDeptIdLabel.setBounds(salarypanelxOffset, salarypanelyOffset + salarypanelyAdditionalOffset, salarypanellabelWidth, salarypanellabelHeight);
Add_Emp_Salary_Panel.add(empDeptIdLabel);
JTextField empDeptIdField = new JTextField();
empDeptIdField.setFont(salarypaneltextFieldFont);
empDeptIdField.setBounds(salarypanelxOffset + salarypanellabelWidth + 10, salarypanelyOffset + salarypanelyAdditionalOffset, salarypanelfieldWidth, salarypanelfieldHeight);
Add_Emp_Salary_Panel.add(empDeptIdField);

// Grade ID
JLabel empGradeIdLabel = new JLabel("Grade ID");
empGradeIdLabel.setFont(salarypanellabelFont);
empGradeIdLabel.setBounds(salarypanelxOffset + salarypanellabelWidth + salarypanelfieldWidth + 40, salarypanelyOffset + salarypanelyAdditionalOffset, salarypanellabelWidth, salarypanellabelHeight);
Add_Emp_Salary_Panel.add(empGradeIdLabel);
JTextField empGradeIdField = new JTextField();
empGradeIdField.setFont(salarypaneltextFieldFont);
empGradeIdField.setBounds(salarypanelxOffset + 2 * (salarypanellabelWidth + salarypanelfieldWidth + 40) - salarypanelfieldWidth, salarypanelyOffset + salarypanelyAdditionalOffset, salarypanelfieldWidth, salarypanelfieldHeight);
Add_Emp_Salary_Panel.add(empGradeIdField);

// Add Button
JButton salaryPanelAddButton = new JButton("Add");
salaryPanelAddButton.setFont(new Font("Serif", Font.BOLD, 20));
salaryPanelAddButton.setBackground(new Color(0, 123, 255));
salaryPanelAddButton.setForeground(Color.WHITE);
salaryPanelAddButton.setBounds(salarypanelxOffset+720, 100+salarypanelyOffset + salarypanelyAdditionalOffset + salarypanellabelHeight + salarypanelspacing, 160, 45);
Add_Emp_Salary_Panel.add(salaryPanelAddButton);

// Clear Button
JButton salaryPanelClearButton = new JButton("Clear");
salaryPanelClearButton.setFont(new Font("Serif", Font.BOLD, 20));
salaryPanelClearButton.setBackground(new Color(220, 53, 69));
salaryPanelClearButton.setForeground(Color.WHITE);
salaryPanelClearButton.setBounds(salarypanelxOffset + 500, 100+salarypanelyOffset + salarypanelyAdditionalOffset + salarypanellabelHeight + salarypanelspacing, 160, 45);
Add_Emp_Salary_Panel.add(salaryPanelClearButton);

// Action listeners
salaryPanelClearButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        transactionIdField.setText("");
        empIdField_Salary_Panel.setText("");
        empDeptIdField.setText("");
        empGradeIdField.setText("");
    }
});

salaryPanelAddButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int transactionId = Integer.parseInt(transactionIdField.getText());
        int empId = Integer.parseInt(empIdField_Salary_Panel.getText());
        int empDeptId = Integer.parseInt(empDeptIdField.getText());
        int empGradeId = Integer.parseInt(empGradeIdField.getText());
        
        // Call your method to insert the data here
        try{
        if (EmployeeGradeDetailsQueries.insertEmployeeGradeDetails(transactionId, empId, empDeptId, empGradeId)) {
            JOptionPane.showMessageDialog(null, "Employee Salary details added successfully!");
            transactionIdField.setText(null);
            empIdField_Salary_Panel.setText(null);
            empDeptIdField.setText(null);
            empGradeIdField.setText(null);

        } else {
            JOptionPane.showMessageDialog(null, "Failed to add Employee Salary details.");
        }
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
    }
});





// Fonts and dimensions
Font Add_Department_Panel_labelFont = new Font("Arial", Font.PLAIN, 20); // Panel name prefix added
Font Add_Department_Panel_textFieldFont = new Font("Arial", Font.PLAIN, 20); // Panel name prefix added
int Add_Department_Panel_labelWidth = 200; // Panel name prefix added
int Add_Department_Panel_labelHeight = 40; // Panel name prefix added
int Add_Department_Panel_fieldWidth = 250; // Panel name prefix added
int Add_Department_Panel_fieldHeight = 40; // Panel name prefix added
int Add_Department_Panel_xOffset = 40; // Panel name prefix added
int Add_Department_Panel_yOffset = 50; // Panel name prefix added
int Add_Department_Panel_spacing = 15; // Panel name prefix added

Add_Department_Panel.setLayout(null);
// Employee ID
JLabel Emp_Detail_empIdLabel = new JLabel("Employee ID:");
Emp_Detail_empIdLabel.setFont(Add_Department_Panel_labelFont);
Emp_Detail_empIdLabel.setBounds(Add_Department_Panel_xOffset, Add_Department_Panel_yOffset, Add_Department_Panel_labelWidth, Add_Department_Panel_labelHeight);
Add_Department_Panel.add(Emp_Detail_empIdLabel);
JTextField Emp_Detail_empIdField = new JTextField();
Emp_Detail_empIdField.setFont(Add_Department_Panel_textFieldFont);
Emp_Detail_empIdField.setBounds(Add_Department_Panel_xOffset + Add_Department_Panel_labelWidth + 10, Add_Department_Panel_yOffset, Add_Department_Panel_fieldWidth, Add_Department_Panel_fieldHeight);
Add_Department_Panel.add(Emp_Detail_empIdField);

JButton DetailPanelAddButton = new JButton("Show");
DetailPanelAddButton.setFont(new Font("Serif", Font.BOLD, 20));
DetailPanelAddButton.setBackground(new Color(0, 123, 255));
DetailPanelAddButton.setForeground(Color.WHITE);
DetailPanelAddButton.setBounds(Add_Department_Panel_xOffset + Add_Department_Panel_labelWidth + 10+500, Add_Department_Panel_yOffset, 160, 45);
Add_Department_Panel.add(DetailPanelAddButton);

Add_Department_Panel_yOffset += Add_Department_Panel_labelHeight + Add_Department_Panel_spacing;
Add_Department_Panel_yOffset += Add_Department_Panel_labelHeight + Add_Department_Panel_spacing;

// Employee Title
JLabel Emp_Detail_empTitleLabel = new JLabel("Employee Title:");
Emp_Detail_empTitleLabel.setFont(Add_Department_Panel_labelFont);
Emp_Detail_empTitleLabel.setBounds(300+Add_Department_Panel_xOffset + Add_Department_Panel_labelWidth + 40, Add_Department_Panel_yOffset+ Add_Department_Panel_labelHeight + Add_Department_Panel_spacing, Add_Department_Panel_labelWidth, Add_Department_Panel_labelHeight);
Add_Department_Panel.add(Emp_Detail_empTitleLabel);
JTextField Emp_Detail_empTitleField = new JTextField();
Emp_Detail_empTitleField.setFont(Add_Department_Panel_textFieldFont);
Emp_Detail_empTitleField.setBounds(250+Add_Department_Panel_xOffset + 2 * (Add_Department_Panel_labelWidth + 40) + 10, Add_Department_Panel_yOffset+ Add_Department_Panel_labelHeight + Add_Department_Panel_spacing, Add_Department_Panel_fieldWidth, Add_Department_Panel_fieldHeight);
Emp_Detail_empTitleField.setEditable(false); // Non-editable
Add_Department_Panel.add(Emp_Detail_empTitleField);



// Employee Name
JLabel Emp_Detail_empNameLabel = new JLabel("Employee Name:");
Emp_Detail_empNameLabel.setFont(Add_Department_Panel_labelFont);
Emp_Detail_empNameLabel.setBounds(Add_Department_Panel_xOffset, Add_Department_Panel_yOffset + Add_Department_Panel_labelHeight + Add_Department_Panel_spacing, Add_Department_Panel_labelWidth, Add_Department_Panel_labelHeight);
Add_Department_Panel.add(Emp_Detail_empNameLabel);
JTextField Emp_Detail_empNameField = new JTextField();
Emp_Detail_empNameField.setFont(Add_Department_Panel_textFieldFont);
Emp_Detail_empNameField.setBounds(Add_Department_Panel_xOffset + Add_Department_Panel_labelWidth + 10, Add_Department_Panel_yOffset + Add_Department_Panel_labelHeight + Add_Department_Panel_spacing, Add_Department_Panel_fieldWidth, Add_Department_Panel_fieldHeight);
Emp_Detail_empNameField.setEditable(false); // Non-editable
Add_Department_Panel.add(Emp_Detail_empNameField);

Add_Department_Panel_yOffset += Add_Department_Panel_labelHeight + Add_Department_Panel_spacing;

// Date of Birth
JLabel Emp_Detail_empDOBLabel = new JLabel("Date of Birth:");
Emp_Detail_empDOBLabel.setFont(Add_Department_Panel_labelFont);
Emp_Detail_empDOBLabel.setBounds(300+Add_Department_Panel_xOffset + Add_Department_Panel_labelWidth + 40, Add_Department_Panel_yOffset + Add_Department_Panel_labelHeight + Add_Department_Panel_spacing + Add_Department_Panel_labelHeight + Add_Department_Panel_spacing, Add_Department_Panel_labelWidth+ Add_Department_Panel_labelHeight + Add_Department_Panel_spacing, Add_Department_Panel_labelHeight);
Add_Department_Panel.add(Emp_Detail_empDOBLabel);
JTextField Emp_Detail_empDOBField = new JTextField();
Emp_Detail_empDOBField.setFont(Add_Department_Panel_textFieldFont);
Emp_Detail_empDOBField.setBounds(250+Add_Department_Panel_xOffset + 2 * (Add_Department_Panel_labelWidth + 40) + 10, Add_Department_Panel_yOffset + Add_Department_Panel_labelHeight + Add_Department_Panel_spacing+ Add_Department_Panel_labelHeight + Add_Department_Panel_spacing, Add_Department_Panel_fieldWidth, Add_Department_Panel_fieldHeight);
Emp_Detail_empDOBField.setEditable(false); // Non-editable
Add_Department_Panel.add(Emp_Detail_empDOBField);

// Date of Joining
JLabel Emp_Detail_empDOJLabel = new JLabel("Date of Joining:");
Emp_Detail_empDOJLabel.setFont(Add_Department_Panel_labelFont);
Emp_Detail_empDOJLabel.setBounds(Add_Department_Panel_xOffset, Add_Department_Panel_yOffset + 2 * (Add_Department_Panel_labelHeight + Add_Department_Panel_spacing), Add_Department_Panel_labelWidth, Add_Department_Panel_labelHeight);
Add_Department_Panel.add(Emp_Detail_empDOJLabel);
JTextField Emp_Detail_empDOJField = new JTextField();
Emp_Detail_empDOJField.setFont(Add_Department_Panel_textFieldFont);
Emp_Detail_empDOJField.setBounds(Add_Department_Panel_xOffset + Add_Department_Panel_labelWidth + 10, Add_Department_Panel_yOffset + 2 * (Add_Department_Panel_labelHeight + Add_Department_Panel_spacing), Add_Department_Panel_fieldWidth, Add_Department_Panel_fieldHeight);
Emp_Detail_empDOJField.setEditable(false); // Non-editable
Add_Department_Panel.add(Emp_Detail_empDOJField);

Add_Department_Panel_yOffset += Add_Department_Panel_labelHeight + Add_Department_Panel_spacing;

// Employee Address
JLabel Emp_Detail_empAddressLabel = new JLabel("Employee Address:");
Emp_Detail_empAddressLabel.setFont(Add_Department_Panel_labelFont);
Emp_Detail_empAddressLabel.setBounds(300+Add_Department_Panel_xOffset + Add_Department_Panel_labelWidth + 40, Add_Department_Panel_yOffset + 2 * (Add_Department_Panel_labelHeight + Add_Department_Panel_spacing) + Add_Department_Panel_labelHeight + Add_Department_Panel_spacing , Add_Department_Panel_labelWidth, Add_Department_Panel_labelHeight);
Add_Department_Panel.add(Emp_Detail_empAddressLabel);
JTextField Emp_Detail_empAddressField = new JTextField();
Emp_Detail_empAddressField.setFont(Add_Department_Panel_textFieldFont);
Emp_Detail_empAddressField.setBounds(250+Add_Department_Panel_xOffset + 2 * (Add_Department_Panel_labelWidth + 40) + 10, Add_Department_Panel_yOffset + 2 * (Add_Department_Panel_labelHeight + Add_Department_Panel_spacing)+ Add_Department_Panel_labelHeight + Add_Department_Panel_spacing, Add_Department_Panel_fieldWidth, Add_Department_Panel_fieldHeight);
Emp_Detail_empAddressField.setEditable(false); // Non-editable
Add_Department_Panel.add(Emp_Detail_empAddressField);

// Employee Mobile No
JLabel Emp_Detail_empMobileNoLabel = new JLabel("Mobile No:");
Emp_Detail_empMobileNoLabel.setFont(Add_Department_Panel_labelFont);
Emp_Detail_empMobileNoLabel.setBounds(Add_Department_Panel_xOffset, Add_Department_Panel_yOffset + 3 * (Add_Department_Panel_labelHeight + Add_Department_Panel_spacing), Add_Department_Panel_labelWidth, Add_Department_Panel_labelHeight);
Add_Department_Panel.add(Emp_Detail_empMobileNoLabel);
JTextField Emp_Detail_empMobileNoField = new JTextField();
Emp_Detail_empMobileNoField.setFont(Add_Department_Panel_textFieldFont);
Emp_Detail_empMobileNoField.setBounds(Add_Department_Panel_xOffset + Add_Department_Panel_labelWidth + 10, Add_Department_Panel_yOffset + 3 * (Add_Department_Panel_labelHeight + Add_Department_Panel_spacing), Add_Department_Panel_fieldWidth, Add_Department_Panel_fieldHeight);
Emp_Detail_empMobileNoField.setEditable(false); // Non-editable
Add_Department_Panel.add(Emp_Detail_empMobileNoField);


Add_Department_Panel_yOffset += Add_Department_Panel_labelHeight + Add_Department_Panel_spacing;

// Employee Mail ID
JLabel Emp_Detail_empMailIdLabel = new JLabel("Mail ID:");
Emp_Detail_empMailIdLabel.setFont(Add_Department_Panel_labelFont);
Emp_Detail_empMailIdLabel.setBounds(300+Add_Department_Panel_xOffset + Add_Department_Panel_labelWidth + 40, Add_Department_Panel_yOffset + 3 * (Add_Department_Panel_labelHeight + Add_Department_Panel_spacing)+ Add_Department_Panel_labelHeight + Add_Department_Panel_spacing, Add_Department_Panel_labelWidth, Add_Department_Panel_labelHeight);
Add_Department_Panel.add(Emp_Detail_empMailIdLabel);
JTextField Emp_Detail_empMailIdField = new JTextField();
Emp_Detail_empMailIdField.setFont(Add_Department_Panel_textFieldFont);
Emp_Detail_empMailIdField.setBounds(250+Add_Department_Panel_xOffset + 2 * (Add_Department_Panel_labelWidth + 40) + 10, Add_Department_Panel_yOffset + 3 * (Add_Department_Panel_labelHeight + Add_Department_Panel_spacing)+ Add_Department_Panel_labelHeight + Add_Department_Panel_spacing, Add_Department_Panel_fieldWidth, Add_Department_Panel_fieldHeight);
Emp_Detail_empMailIdField.setEditable(false); // Non-editable
Add_Department_Panel.add(Emp_Detail_empMailIdField);

// Employee Department ID
JLabel Emp_Detail_empDeptIdLabel = new JLabel("Department ID:");
Emp_Detail_empDeptIdLabel.setFont(Add_Department_Panel_labelFont);
Emp_Detail_empDeptIdLabel.setBounds(Add_Department_Panel_xOffset, Add_Department_Panel_yOffset + 4 * (Add_Department_Panel_labelHeight + Add_Department_Panel_spacing), Add_Department_Panel_labelWidth, Add_Department_Panel_labelHeight);
Add_Department_Panel.add(Emp_Detail_empDeptIdLabel);
JTextField Emp_Detail_empDeptIdField = new JTextField();
Emp_Detail_empDeptIdField.setFont(Add_Department_Panel_textFieldFont);
Emp_Detail_empDeptIdField.setBounds(Add_Department_Panel_xOffset + Add_Department_Panel_labelWidth + 10, Add_Department_Panel_yOffset + 4 * (Add_Department_Panel_labelHeight + Add_Department_Panel_spacing), Add_Department_Panel_fieldWidth, Add_Department_Panel_fieldHeight);
Emp_Detail_empDeptIdField.setEditable(false); // Non-editable
Add_Department_Panel.add(Emp_Detail_empDeptIdField);

Add_Department_Panel_yOffset += Add_Department_Panel_labelHeight + Add_Department_Panel_spacing;
Add_Department_Panel_yOffset += Add_Department_Panel_labelHeight + Add_Department_Panel_spacing;

// Employee Grade ID
JLabel Emp_Detail_grade_idLabel = new JLabel("Grade ID:");
Emp_Detail_grade_idLabel.setFont(Add_Department_Panel_labelFont);
Emp_Detail_grade_idLabel.setBounds(300+Add_Department_Panel_xOffset + Add_Department_Panel_labelWidth + 40, Add_Department_Panel_yOffset + 3 * (Add_Department_Panel_labelHeight + Add_Department_Panel_spacing)+ Add_Department_Panel_labelHeight + Add_Department_Panel_spacing, Add_Department_Panel_labelWidth, Add_Department_Panel_labelHeight);
Add_Department_Panel.add(Emp_Detail_grade_idLabel);
JTextField Emp_Detail_grade_idField = new JTextField();
Emp_Detail_grade_idField.setFont(Add_Department_Panel_textFieldFont);
Emp_Detail_grade_idField.setBounds(250+Add_Department_Panel_xOffset + 2 * (Add_Department_Panel_labelWidth + 40) + 10, Add_Department_Panel_yOffset + 3 * (Add_Department_Panel_labelHeight + Add_Department_Panel_spacing)+ Add_Department_Panel_labelHeight + Add_Department_Panel_spacing, Add_Department_Panel_fieldWidth, Add_Department_Panel_fieldHeight);
Emp_Detail_grade_idField.setEditable(false); // Non-editable
Add_Department_Panel.add(Emp_Detail_grade_idField);

// Employee Transaction ID
JLabel Emp_Detail_transaction_id = new JLabel("Transaction ID:");
Emp_Detail_transaction_id.setFont(Add_Department_Panel_labelFont);
Emp_Detail_transaction_id.setBounds(Add_Department_Panel_xOffset, Add_Department_Panel_yOffset + 4 * (Add_Department_Panel_labelHeight + Add_Department_Panel_spacing), Add_Department_Panel_labelWidth, Add_Department_Panel_labelHeight);
Add_Department_Panel.add(Emp_Detail_transaction_id);
JTextField Emp_Detail_transaction_idField = new JTextField();
Emp_Detail_transaction_idField.setFont(Add_Department_Panel_textFieldFont);
Emp_Detail_transaction_idField.setBounds(Add_Department_Panel_xOffset + Add_Department_Panel_labelWidth + 10, Add_Department_Panel_yOffset + 4 * (Add_Department_Panel_labelHeight + Add_Department_Panel_spacing), Add_Department_Panel_fieldWidth, Add_Department_Panel_fieldHeight);
Emp_Detail_transaction_idField.setEditable(false); // Non-editable
Add_Department_Panel.add(Emp_Detail_transaction_idField);




DetailPanelAddButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        // Parse employee ID
        int empid = Integer.parseInt(Emp_Detail_empIdField.getText());
       // EmployeeSalaryDetails EMP_Salary=EmployeeSalaryDetailsQueries.selectEmployeeSalaryDetails(transID);
        Employee  emp=EmployeeQueries.selectEmployee(empid);

        EmployeeGradeDetails empgrade=EmployeeGradeDetailsQueries.selectEmployeeGradeDetails(emp.empId);
           
            Emp_Detail_empNameField.setText(emp.empName);
            Emp_Detail_empTitleField.setText(emp.empTitle); // Assuming empSalaryMonth is the employee title
            Emp_Detail_empDOBField.setText(emp.empDateOfBirth); // Assuming empDeptId is the date of birth
            Emp_Detail_empDOJField.setText(emp.empDateOfJoining); // Assuming empGradeId is the date of joining
            Emp_Detail_empAddressField.setText(emp.empAddress); // Assuming empBasic is the employee address
            Emp_Detail_empMobileNoField.setText(emp.empMobileNo); // Assuming empTravelAllowance is the mobile number
            Emp_Detail_empMailIdField.setText(emp.empMailId); // Assuming empHouseRentAllowance is the email ID
            Emp_Detail_empDeptIdField.setText(String.valueOf(empgrade.empDeptId)); // Assuming empDeptId is the department ID
Emp_Detail_grade_idField.setText(String.valueOf(empgrade.empGradeId)); // Assuming empGradeId is the grade ID
Emp_Detail_transaction_idField.setText(String.valueOf(empgrade.transactionId));

        
    }catch(Exception exception){
        JOptionPane.showMessageDialog(null, exception.getMessage());
    }

        
    }
});




// Add action listener for exit button
ExitButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose(); // Close the frame completely
    }
});

// Add action listener for login button
loginButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        
        
        if (AdminQueries.isAdminValid(username,password)) {
            JOptionPane.showMessageDialog(frame, "Successful login!");
            usernameField.setText(null);
            passwordField.setText(null); 

            loginPanel.setVisible(false);
            Add_Employee_Panel.setVisible(true);
            panel.setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(frame, "Login failed. Incorrect Password"); // Failed login message
        }
    }
});




Add_Employee.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Add_Employee_Panel.setVisible(true);
        Add_Grade_Panel.setVisible(false);
        Add_Department_Panel.setVisible(false);
        Add_Emp_Salary_Panel.setVisible(false);
        Employee_Payroll_Panel.setVisible(false);
    }
});


Add_Grade.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Add_Employee_Panel.setVisible(false);
        Add_Grade_Panel.setVisible(true);
        Add_Department_Panel.setVisible(false);
        Add_Emp_Salary_Panel.setVisible(false);
        Employee_Payroll_Panel.setVisible(false);
    }
});


Add_Emp_Salary.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e){
        
        Add_Employee_Panel.setVisible(false);
        Add_Grade_Panel.setVisible(false);
        Add_Department_Panel.setVisible(false);
        Add_Emp_Salary_Panel.setVisible(true);
        Employee_Payroll_Panel.setVisible(false);
    }
});


Employee_Detail.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Add_Employee_Panel.setVisible(false);
        Add_Grade_Panel.setVisible(false);
        Add_Department_Panel.setVisible(true);
        Add_Emp_Salary_Panel.setVisible(false);
        Employee_Payroll_Panel.setVisible(false);
    }
});


Employee_Payroll.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Add_Employee_Panel.setVisible(false);
        Add_Grade_Panel.setVisible(false);
        Add_Department_Panel.setVisible(false);
        Add_Emp_Salary_Panel.setVisible(false);
        Employee_Payroll_Panel.setVisible(true);
    }
});


       

        frame.add(loginPanel);

        frame.add(Add_Employee_Panel);
        frame.add(Add_Grade_Panel);
        frame.add(Add_Department_Panel);
        frame.add(Add_Emp_Salary_Panel);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}

