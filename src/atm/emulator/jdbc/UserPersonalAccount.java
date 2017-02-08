/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.emulator.jdbc;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Deepank Dixit
 */
public class UserPersonalAccount extends javax.swing.JFrame {

    public static String str1, str2, acno;
    //All of the above three variables bring the user entered account number into appropriate format so it can be 
    //used in the SQL query
    public static int checkIfItIsFirstRunVar;
    
    public void checkIfItIsFirstRun(){
        try{
            if (LoginJdbc2.userEnteredAcno.equals("")){
            JOptionPane.showMessageDialog(this, "1You shouldn't run this page directly!", "Mad Run", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            }
            else checkIfItIsFirstRunVar = 1;
        }
        catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, "You shouldn't run this page directly!", "Mad Run", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
            
    }
    
    public UserPersonalAccount() {
        initComponents();
        
        connectionRetrievalAndSet();
    }

    public static void connectionRetrievalAndSet(){
    
        
        try{
            //STEP 1: ESTABLISHING THE CONNECTION
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "password");
            
            //STEP 2: OPENING THE TABLE
            String openQuery = "SELECT * from userdetails";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(openQuery);
            
            /*STEP 3: RETRIEVING THE DATA TO DISPLAY
            Note that the fields name in retrieve query are mentioned in a particular order, so as to 
            ease the way of getting string from the returned result set.*/
            str1 = "\"";
            str2 = "\"";
            acno = str1 + LoginJdbc2.userEnteredAcno + str2;
            
            String retrieveQuery = "SELECT Name, Account_Number, Account_Type, Bank_Branch, Email_ID, "
                    + "Mobile_Number, Account_Balance from userdetails "
                    + "WHERE Account_Number = " + acno;
            rs = stmt.executeQuery(retrieveQuery);
            
            //STEP 4: SET THE VALUES IN TEXT FIELDSs
            while (rs.next()){
                jLabelWelcomeName.setText(rs.getString(1));
                //jLabelAccountNumber.setText(rs.getString(2));
                jLabelAccountNumber.setText(LoginJdbc2.userEnteredAcno);
                jLabelAccountType.setText(rs.getString(3));
                jLabelBranchName.setText(rs.getString(4));
                jLabelEmailID.setText(rs.getString(5));
                jLabelMobileNumber.setText(rs.getString(6));
                jLabelCurrentBalance.setText(rs.getString(7));
                
                
            }
        }
        catch(Exception e){
            System.out.println("Something bad occured!" + e.getMessage());
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

        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelCurrentBalance = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabelAccountNumber = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelWelcomeName = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelAccountType = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelEmailID = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelBranchName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelMobileNumber = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Personal Account - HPES");

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jLabel9.setText("Email ID:");

        jLabel10.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jLabel10.setText("Mobile Number:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("Welcome, ");

        jLabel11.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 204));
        jLabel11.setText("Make a transaction");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabelCurrentBalance.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCurrentBalance.setForeground(new java.awt.Color(51, 51, 51));

        jLabel18.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jLabel18.setText("Current Balance:");

        jLabel21.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jLabel21.setText("Account Number:");

        jLabelAccountNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelAccountNumber.setForeground(new java.awt.Color(51, 51, 51));

        jLabel2.setForeground(new java.awt.Color(0, 153, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("We keep track of your acoount details.");

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 204));
        jLabel12.setText("Log Out");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabelWelcomeName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelWelcomeName.setForeground(new java.awt.Color(0, 102, 204));
        jLabelWelcomeName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelWelcomeNameMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 204));
        jLabel13.setText("Click above to make a transaction");

        jLabel4.setBackground(new java.awt.Color(0, 204, 204));
        jLabel4.setFont(new java.awt.Font("Georgia", 1, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 204));
        jLabel4.setText("HPES Bank");

        jLabelAccountType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelAccountType.setForeground(new java.awt.Color(51, 51, 51));

        jLabel6.setBackground(new java.awt.Color(0, 204, 204));
        jLabel6.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("User Account");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabelEmailID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelEmailID.setForeground(new java.awt.Color(51, 51, 51));

        jLabelBranchName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelBranchName.setForeground(new java.awt.Color(51, 51, 51));

        jLabel7.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jLabel7.setText("Account Type:");

        jLabelMobileNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMobileNumber.setForeground(new java.awt.Color(51, 51, 51));

        jLabel8.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jLabel8.setText("Branch name:");

        jLabel3.setForeground(new java.awt.Color(0, 153, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("You are currently logged in.");

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Rs.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelWelcomeName, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(41, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAccountType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEmailID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelMobileNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAccountNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelBranchName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(235, 235, 235))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabelCurrentBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(86, 86, 86)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel6))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelWelcomeName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabelAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabelAccountType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelBranchName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelEmailID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addComponent(jLabelCurrentBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        
        checkIfItIsFirstRun();
        if (checkIfItIsFirstRunVar == 1){
            
            dispose();
            
            DepositOrWithdrawl depositOrWithdrawlObj = new DepositOrWithdrawl();
            depositOrWithdrawlObj.setVisible(true);
        }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        
        checkIfItIsFirstRun();
        if (checkIfItIsFirstRunVar == 1){
            
            dispose();
            
            AfterLoggingOut finalObj = new AfterLoggingOut();
            finalObj.setVisible(true);
        }

    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabelWelcomeNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelWelcomeNameMouseClicked

    }//GEN-LAST:event_jLabelWelcomeNameMouseClicked

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
            java.util.logging.Logger.getLogger(UserPersonalAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPersonalAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPersonalAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPersonalAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPersonalAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jLabelAccountNumber;
    public static javax.swing.JLabel jLabelAccountType;
    public static javax.swing.JLabel jLabelBranchName;
    public static javax.swing.JLabel jLabelCurrentBalance;
    public static javax.swing.JLabel jLabelEmailID;
    public static javax.swing.JLabel jLabelMobileNumber;
    public static javax.swing.JLabel jLabelWelcomeName;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
