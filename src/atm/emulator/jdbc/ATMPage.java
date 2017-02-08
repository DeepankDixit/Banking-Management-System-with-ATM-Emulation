/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.emulator.jdbc;

import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author Deepank Dixit
 */
public class ATMPage extends javax.swing.JFrame {

    public static String buttonNumber, str;
    public static String depositQuery, withdrawlQuery;
    public static String textFieldEntry;
    public static int textFieldEntryInt = 0;
    
    public static String name, pin, email, mob, acType, balanceToString, branch;
    public static int balance;
    
    public static int validationSuccessful = 1, checkIfAmountIsSufficient;
    
    public static int  userThousandNotes, userFiveHundredNotes, userHundredNotes, userFiftyNotes;
    
    public ATMPage() {
        initComponents();
    }

    public static void functionWritesInTextField(String buttonNumber){
        if (jTextFieldCashField.getText().equals("")){
            jTextFieldCashField.setText(buttonNumber);
        }
        else {
            str = jTextFieldCashField.getText();
            if (str.equals("0")){
                jTextFieldCashField.setText(buttonNumber);
            }
            else jTextFieldCashField.setText(str + buttonNumber);
        }
    }
    
    public void basicValidationMoney(){
        try{
            //CHECK IF TEXTFIELD HAS SOME ENTRY OR NOT
            textFieldEntry = jTextFieldCashField.getText();
            
            textFieldEntryInt = Integer.parseInt(textFieldEntry);
            //System.out.println(textFieldEntryInt+2);
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Don't\nEnter characters OR\nLeave the field empty OR\nEnter very large amounts.\n\nLog in to your account again!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        
        if (textFieldEntryInt % 50 != 0){
            JOptionPane.showMessageDialog(this, "Enter the amount in multiple of 50", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            validationSuccessful = 0;
            dispose();
            ATMPage atmPageObj = new ATMPage();
            atmPageObj.setVisible(true);
        }
        else if (textFieldEntryInt > 100000){
            JOptionPane.showMessageDialog(this, "No transaction of more than 1,00000 Rs. is allowed!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            validationSuccessful = 0;
            dispose();
            ATMPage atmPageObj = new ATMPage();
            atmPageObj.setVisible(true);
        }
//        else if (textFieldEntryInt > 100000){
//            JOptionPane.showMessageDialog(this, "No transaction of more than 1,00000 Rs. is allowed!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
//            validationSuccessful = 0;
//            ATMPage atmPageObj = new ATMPage();
//            atmPageObj.setVisible(true);
//        }
        else if (textFieldEntryInt % 50 == 0 && textFieldEntryInt < 100000){
            validationSuccessful = 1;
        }
    }

    
    public void cashDistribution(){
        userThousandNotes = textFieldEntryInt / 1000;
        int rest = textFieldEntryInt % 1000;
        userFiveHundredNotes = rest / 500;
        rest = rest % 500;
        userHundredNotes = rest / 100;
        rest = rest % 100;
        userFiftyNotes = rest / 50;
        System.out.println(userThousandNotes + " " + userFiveHundredNotes + " " + userHundredNotes + " "  + userFiftyNotes);
        
        
    }
    
    
        public void updateCashManager(int checkIfAmountIsSufficient){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "password");
            
            //SELECT 
            String selectQuery = "SELECT * from CashManager";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            
            //UPDATE ONLY WHEN THE AMOUNT ENTERED IS SUFFICIENT
            if (checkIfAmountIsSufficient == 1){
                String updateQuery = "update CashManager set Thousands = Thousands - " + userThousandNotes
                    + ",fivehundreds = fivehundreds - " + userFiveHundredNotes + ", hundreds = hundreds - " + userHundredNotes
                    + ",fifties = fifties - " + userFiftyNotes + ", totalcash = thousands*1000 + Fivehundreds*500 + "
                    + "fifties*50 + hundreds*100";  
                int status = stmt.executeUpdate(updateQuery);
                if (status > 0)
                    System.out.println("updated!");
                else
                    System.out.println("Not updated!");
            }
        }
        
        catch (ClassNotFoundException e1){
            System.out.println("Could not find class" + e1.getMessage());
        }
        catch (SQLException e2){
            System.out.println("Saving from SQL Exception" + e2.getMessage());
            if (e2.getMessage().equals("Data truncation: Out of range value adjusted for column 'thousands' at row 1") 
                || e2.getMessage().equals("Data truncation: Out of range value adjusted for column 'fivehundreds' at row 1")
                || e2.getMessage().equals("Data truncation: Out of range value adjusted for column 'hundreds' at row 1")
                || e2.getMessage().equals("Data truncation: Out of range value adjusted for column 'fifties' at row 1")){
                JOptionPane.showMessageDialog(this, "Cash unavailable currently. Refilling is in order! "
                        + "You are logged out. Kindly visit us later.", "OUT OF CASH", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldCashField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButtonBackspace = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jButton0 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonOK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ATM - HPES");

        jTextFieldCashField.setBackground(new java.awt.Color(246, 246, 251));
        jTextFieldCashField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldCashField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setBackground(new java.awt.Color(0, 204, 204));
        jLabel4.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 204));
        jLabel4.setText("HPES ATM");

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setText("8");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton9.setText("9");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButtonBackspace.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonBackspace.setText("Backspace");
        jButtonBackspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackspaceActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButtonReset.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jButton0.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton0.setText("0");
        jButton0.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jButton0StateChanged(evt);
            }
        });
        jButton0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton0MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton0MouseEntered(evt);
            }
        });
        jButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0ActionPerformed(evt);
            }
        });
        jButton0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton0KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButtonOK.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jLabel1.setText("Amount (in Rupees)");

        jLabel2.setText("Press OK when done");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldCashField, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldCashField, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1)))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        buttonNumber = "1";
        functionWritesInTextField(buttonNumber);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        buttonNumber = "3";
        functionWritesInTextField(buttonNumber);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        buttonNumber = "2";
        functionWritesInTextField(buttonNumber);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        buttonNumber = "6";
        functionWritesInTextField(buttonNumber);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        buttonNumber = "4";
        functionWritesInTextField(buttonNumber);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        buttonNumber = "5";
        functionWritesInTextField(buttonNumber);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        buttonNumber = "8";
        functionWritesInTextField(buttonNumber);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        
        buttonNumber = "9";
        functionWritesInTextField(buttonNumber);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButtonBackspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackspaceActionPerformed
        
        str = jTextFieldCashField.getText();
        
        if (str.equals("0")){
            jTextFieldCashField.setText("0");
        }
        else if (str.equals("")){
            jTextFieldCashField.setText("0");
        }
        else jTextFieldCashField.setText(str.substring(0, str.length()-1));
    }//GEN-LAST:event_jButtonBackspaceActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        buttonNumber = "7";
        functionWritesInTextField(buttonNumber);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        
        jTextFieldCashField.setText("0");
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButton0StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jButton0StateChanged
        
        
    }//GEN-LAST:event_jButton0StateChanged

    private void jButton0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton0MouseClicked
        
    }//GEN-LAST:event_jButton0MouseClicked

    private void jButton0MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton0MouseEntered
        
    }//GEN-LAST:event_jButton0MouseEntered

    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton0ActionPerformed
        
        buttonNumber = "0";
        functionWritesInTextField(buttonNumber);
    }//GEN-LAST:event_jButton0ActionPerformed

    private void jButton0KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton0KeyPressed

    }//GEN-LAST:event_jButton0KeyPressed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered

    }//GEN-LAST:event_jPanel1MouseEntered

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed

        //BASIC VALIDATION FUNCTION VALIDATES 4 PARAMETERS
        basicValidationMoney();
        
        /*  IF I USE THE FOLLOWING COMMENTED CODE, I GET NULLPOINTER EXCEPTION BECAUSE STRING VARIABLE OPTION
            BELONGS TO DepositOrWithdrawl PAGE AND SINCE I'M RUNNING IT HERE, IT HAS NOT BEEN INITIALIZED. THE 
            PURPOSE WAS TO BRING USER ONTO THIS PAGE THROUGH LAST PAGE. THAT WAY STRING VARIABLE option MUST HAVE 
            HAD A VALUE- EITHER "deposit" OR "withdrawl"
            if (DepositOrWithdrawl.option.equals("deposit")){
                System.out.println("Deposit");
            }
            else {
                System.out.println("Withdrawl");
        }*/
        
        if (validationSuccessful == 1){
            try {
                if (DepositOrWithdrawl.option.equals("deposit")){
                    System.out.println("Deposit");                
                    methodForDepositQuery(textFieldEntryInt);               
                }
                else {
                    System.out.println("Withdrawl");
                    methodForWithdrawlQuery(textFieldEntryInt);
                }
            }
            catch (NullPointerException e){
                JOptionPane.showMessageDialog(this, "You shouldn't run this page directly.\n", "Error Message.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
        
        
    }//GEN-LAST:event_jButtonOKActionPerformed

    
    public void methodForDepositQuery(int textFieldEntryInt){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "password");
            
            //SELECT 
            String selectQuery = "SELECT * from userdetails WHERE Account_Number = " + UserPersonalAccount.acno;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            
            //RETRIEVE
            while (rs.next()){
                pin = rs.getString(2);
                name = rs.getString(3);
                email = rs.getString(4);
                mob = rs.getString(5);
                acType = rs.getString(6);
                balance = rs.getInt(7);
                branch = rs.getString(8);
            }
            
            //DELETE
            String deleteQuery = "DELETE from userdetails where account_number = " + UserPersonalAccount.acno;
            int status = stmt.executeUpdate(deleteQuery);
            if (status > 0)
                System.out.println("Deleted!");
            else
                System.out.println("Not deleted!");
            
            //INSERT
            balance = balance + textFieldEntryInt;
            balanceToString = String.valueOf(balance);
            
            String insertQuery = "INSERT INTO userdetails VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insertQuery);
            pst.setString(1, LoginJdbc2.userEnteredAcno);
            System.out.println(LoginJdbc2.userEnteredAcno);
            pst.setString(2, pin);
            pst.setString(3, name);
            pst.setString(4, email);
            pst.setString(5, mob);
            pst.setString(6, acType);
            pst.setString(7, balanceToString);
            pst.setString(8, branch);
            
            int status1 = pst.executeUpdate();
            if (status1 > 0){
                System.out.println("Inserted!");
                JOptionPane.showMessageDialog(this, "The amount has been successfully deposited.\n", "Secured", JOptionPane.PLAIN_MESSAGE);
                //AMOUNT DEPOSITED BY JOPTION PANE CONFIRMED AND TO NEXT PAGE.ANOTHER TRANSACTION??
                dispose();
            }
                
            else{
                System.out.println("Not inserted!");
                JOptionPane.showMessageDialog(this, "The amount could not be deposited.\n", "Secured", JOptionPane.ERROR_MESSAGE);
                
            }
                

            //System.out.println("check");
            
            
            AfterDepositOrWithdrawlOption afterDepositOrWithdrawlOptionObj = new AfterDepositOrWithdrawlOption();
            afterDepositOrWithdrawlOptionObj.setVisible(true);
            
        }
        
        catch (ClassNotFoundException e1){
            System.out.println("Could not find class" + e1.getMessage());
        }
        catch (SQLException e2){
            System.out.println("Saving from SQL Exception" + e2.getMessage());
        }
    }
    
    
    public void methodForWithdrawlQuery(int textFieldEntryInt){
        
        //FOLLOWING TWO FUNCTIONS ARE CALLED FROM THIS FUNCTION ONLY, BECAUSE IT IS ONLY IN CASE OF WITHDRAWL THAT I
        //NEED TO KEEP TRACK OF CASH DISTRIBUTION AND ITS UPDATE IN CashManager TABLE.
        cashDistribution();
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "password");
            
            //SELECT 
            String selectQuery = "SELECT * from userdetails WHERE Account_Number = " + UserPersonalAccount.acno;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            
            //RETRIEVE
            while (rs.next()){
                pin = rs.getString(2);
                name = rs.getString(3);
                email = rs.getString(4);
                mob = rs.getString(5);
                acType = rs.getString(6);
                balance = rs.getInt(7);
                branch = rs.getString(8);
            }
            
            //DELETE
            //MAKE SURE THAT THE ENTERED AMOUNT IS LESS THAN THE CURRENT BALANCE & INSERT
            if (textFieldEntryInt > balance){
                String deleteQuery = "DELETE from userdetails where account_number = " + UserPersonalAccount.acno;
                int status = stmt.executeUpdate(deleteQuery);
                if (status > 0)
                    System.out.println("Deleted!");
                else
                    System.out.println("Not deleted!");
            
                JOptionPane.showMessageDialog(this, "You don't have enough amount!", "Insufficient Balance", JOptionPane.ERROR_MESSAGE);
                checkIfAmountIsSufficient = 0;
                updateCashManager(checkIfAmountIsSufficient);
                
                balance = balance;
                balanceToString = String.valueOf(balance);
                
                String insertQuery = "INSERT INTO userdetails VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(insertQuery);
                pst.setString(1, LoginJdbc2.userEnteredAcno);
                pst.setString(2, pin);
                pst.setString(3, name);
                pst.setString(4, email);
                pst.setString(5, mob);
                pst.setString(6, acType);
                pst.setString(7, balanceToString);
                pst.setString(8, branch);
                
                int status1 = pst.executeUpdate();
                if (status1 > 0){
                    System.out.println("Inserted!");
                    //JOptionPane.showMessageDialog(this, "The entered amount has been deducted from your account.\n", "Secured", JOptionPane.PLAIN_MESSAGE);
                    //AMOUNT DEPOSITED BY JOPTION PANE CONFIRMED AND TO NEXT PAGE.ANOTHER TRANSACTION??
                    //dispose();
                }
                else{
                    System.out.println("Not inserted!");
                    //JOptionPane.showMessageDialog(this, "The amount can not be withdrawn right now. Try later!\n", "Secured", JOptionPane.ERROR_MESSAGE);
                
                }
                
                dispose();
            
            }
            
            else {
                checkIfAmountIsSufficient = 1; //MEANS YOU HAVE ENOUGH AMOUNT
                updateCashManager(checkIfAmountIsSufficient);
                
                String deleteQuery = "DELETE from userdetails where account_number = " + UserPersonalAccount.acno;
                int status = stmt.executeUpdate(deleteQuery);
                if (status > 0)
                    System.out.println("Deleted!");
                else
                    System.out.println("Not deleted!");
                
                balance = balance - textFieldEntryInt;
                balanceToString = String.valueOf(balance);
            
                String insertQuery = "INSERT INTO userdetails VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(insertQuery);
                pst.setString(1, LoginJdbc2.userEnteredAcno);
                //System.out.println(LoginJdbc2.userEnteredAcno);
                pst.setString(2, pin);
                pst.setString(3, name);
                pst.setString(4, email);
                pst.setString(5, mob);
                pst.setString(6, acType);
                pst.setString(7, balanceToString);
                pst.setString(8, branch);
            
                int status1 = pst.executeUpdate();
                if (status1 > 0){
                    System.out.println("Inserted!");
                    JOptionPane.showMessageDialog(this, "The entered amount has been deducted from your account.\n", "Secured", JOptionPane.PLAIN_MESSAGE);
                    //updateCashManager(checkIfAmountIsSufficient);
                    
                    dispose();
                }
                
                else{
                    System.out.println("Not inserted!");
                    JOptionPane.showMessageDialog(this, "The amount can not be withdrawn right now. Try later!\n", "Secured", JOptionPane.ERROR_MESSAGE);
                    dispose();
                }
            }

            AfterDepositOrWithdrawlOption afterDepositOrWithdrawlOptionObj = new AfterDepositOrWithdrawlOption();
            afterDepositOrWithdrawlOptionObj.setVisible(true);            
        }
        
        catch (ClassNotFoundException e1){
            System.out.println("Could not find class" + e1.getMessage());
        }
        catch (SQLException e2){
            System.out.println("Saving from SQL Exception" + e2.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ATMPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ATMPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ATMPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ATMPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ATMPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonBackspace;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JTextField jTextFieldCashField;
    // End of variables declaration//GEN-END:variables
}
