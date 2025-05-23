/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Config.dbConnector;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import travelagency.regForm;
import static travelagency.regForm.uemail;
import static travelagency.regForm.usname;

/**
 *
 * 
 */
public class createUserForm extends javax.swing.JFrame {

    /**
     * Creates new form createUserForm
     */
    public createUserForm() {
        initComponents();
    }
     public String destination= "";
     File selectedFile;
     public String oldpath;
      public String path;
      
      public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
      public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
      
      public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
    public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
      
    
     public boolean updateCheck(){
        dbConnector dbc= new dbConnector();
        try{
             String query= "SELECT*FROM tbl_user WHERE( u_username='"+un.getText()+"'OR u_email= '"
                     +email.getText()+"')AND u_id != '"+uiid.getText()+"'";
            ResultSet resultSet= dbc.getData(query);
            
            if(resultSet.next()){
                uemail= resultSet.getString("u_email");
                if(uemail.equals(email.getText())){
                    JOptionPane.showMessageDialog(null,"Email is Already Used!");
                    email.setText("");
                }
                usname= resultSet.getString("u_username");
                        if(usname.equals(un.getText())){
                    JOptionPane.showMessageDialog(null,"Username is Already Used!");
                    un.setText("");
                }
                
                  return true;
            }else{
                return false;
            }
                    
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
            
            
        }
        
    }
     
     public boolean duplicateCheck(){
        dbConnector dbc= new dbConnector();
        
        try{
             String query= "SELECT*FROM tbl_user WHERE u_username='"+un.getText()+"'OR u_email= '"
                     +email.getText()+"'";
            ResultSet resultSet= dbc.getData(query);
            
            if(resultSet.next()){
                uemail= resultSet.getString("u_email");
                if(uemail.equals(email.getText())){
                    JOptionPane.showMessageDialog(null,"Email is Already Used!");
                    email.setText("");
                }
                usname= resultSet.getString("u_username");
                        if(usname.equals(un.getText())){
                    JOptionPane.showMessageDialog(null,"Username is Already Used!");
                    un.setText("");
                }
                
                  return true;
            }else{
                return false;
            }
                    
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
            
            
        }
        
    }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ln = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        fn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        un = new javax.swing.JTextField();
        ps = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        ut = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        uiid = new javax.swing.JTextField();
        us = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        update = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(253, 251, 212));

        jPanel2.setBackground(new java.awt.Color(253, 251, 212));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 14, 71)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 174, 365, 38));
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 241, 160, 38));
        jPanel2.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 107, 365, 38));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 14, 71));
        jLabel1.setText("First Name:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 79, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(15, 14, 71));
        jLabel2.setText("Email:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 218, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(15, 14, 71));
        jLabel3.setText("Last Name:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 151, -1, -1));
        jPanel2.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 313, 160, 38));
        jPanel2.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 313, 199, 38));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(15, 14, 71));
        jLabel4.setText("Password:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(15, 14, 71));
        jLabel5.setText("Username:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 290, -1, -1));

        add.setBackground(new java.awt.Color(119, 136, 153));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 86, 34));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(15, 14, 71));
        jLabel9.setText("User Type:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 12, -1, -1));

        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        jPanel2.add(ut, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 35, 199, 38));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(15, 14, 71));
        jLabel6.setText("User ID:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 12, -1, -1));

        uiid.setEnabled(false);
        jPanel2.add(uiid, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 35, 160, 38));

        us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        jPanel2.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 241, 199, 38));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(15, 14, 71));
        jLabel10.setText("User Status:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 218, -1, -1));

        delete.setBackground(new java.awt.Color(119, 136, 153));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 86, 34));

        clear.setBackground(new java.awt.Color(119, 136, 153));
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel2.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 86, 34));

        update.setBackground(new java.awt.Color(119, 136, 153));
        update.setText("UPDATE");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel2.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 86, 34));

        refresh.setBackground(new java.awt.Color(119, 136, 153));
        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel2.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 86, 34));

        cancel.setBackground(new java.awt.Color(119, 136, 153));
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel2.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 86, 34));

        jPanel4.setBackground(new java.awt.Color(15, 14, 71));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("TRAVEL AGENCY SYSTEM");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 870, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 14, 71)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        select.setBackground(new java.awt.Color(119, 136, 153));
        select.setText("SELECT");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });

        remove.setBackground(new java.awt.Color(119, 136, 153));
        remove.setText("REMOVE");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71))
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
      
        
        if (fn.getText().isEmpty() || ln.getText().isEmpty() || email.getText().isEmpty() || un.getText().isEmpty() || ps.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "All fields are required!");
} else if (ps.getText().length() < 8) {
    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long, contains at least one uppercase letter, one lowercase letter, one number, and one special character.");
    ps.setText(""); 
} else if (!ps.getText().matches(".*[A-Z].*")) {
    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long, contains at least one uppercase letter, one lowercase letter, one number, and one special character.");
    ps.setText(""); 
} else if (!ps.getText().matches(".*[a-z].*")) {
    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long, contains at least one uppercase letter, one lowercase letter, one number, and one special character..");
    ps.setText(""); 
} else if (!ps.getText().matches(".*[0-9].*")) {
    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long, contains at least one uppercase letter, one lowercase letter, one number, and one special character.");
    ps.setText(""); 
} else if (!ps.getText().matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long, contains at least one uppercase letter, one lowercase letter, one number, and one special character.");
    ps.setText(""); 
} else if (!email.getText().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
    JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
    email.setText("");
} else if (duplicateCheck()) {
    JOptionPane.showMessageDialog(null, "Duplicate exist.");
} else {
         dbConnector dbc= new dbConnector();
                  {
                if( dbc.insertData("INSERT INTO tbl_user(u_fname, u_lname, u_email, u_username, u_password, u_type, u_status, u_image)"
                    + "VALUES('"+fn.getText()+"','"+ln.getText()+"','"+email.getText()+"','"+un.getText()+"','"+ps.getText()+"','"+ut.getSelectedItem()+"','"+us.getSelectedItem()+"','"+destination+"')"))
                {
                    try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(),StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null,"Inserted Successfully!");
                usersForm uf= new usersForm();
                uf.setVisible(true);
                this.dispose();
                }catch( IOException ex){
                        System.out.println("Insert Image Error: "+ex);
                        }
            }else{
                JOptionPane.showMessageDialog(null, "Connection error!");
            }

         }
        }

    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       if (fn.getText().isEmpty() || ln.getText().isEmpty() || email.getText().isEmpty() || un.getText().isEmpty() || ps.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
         
        }else if (ps.getText().length() < 8 || !ps.getText().matches(".*[A-Z].*") || !ps.getText().matches(".*[a-z].*") || !ps.getText().matches(".*[0-9].*") || !ps.getText().matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one number, and one special character.");
            ps.setText("");
       
         } else if (!email.getText().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
            email.setText("");
       
         } else if (updateCheck()) {
            JOptionPane.showMessageDialog(null, "Duplicate exists.");
       
         } else {
            dbConnector dbc = new dbConnector();
            dbc.updateData("UPDATE tbl_user SET u_fname= '"+fn.getText()+"', u_lname= '"+ln.getText()+"', u_email= '"+email.getText()+"', u_username= '"+un.getText()+
                           "', u_password= '"+ps.getText()+"', u_type= '"+ut.getSelectedItem()+"', u_status= '"+us.getSelectedItem()+"',u_image= '"+destination+"' WHERE u_id= '"+uiid.getText()+"'");

                
            if(destination.isEmpty()){
                File existingFile = new File(oldpath);
                if(existingFile.exists()){
                   existingFile.delete();
                }
            }else{
               if(!(oldpath.equals(path))){
                   imageUpdater(oldpath, path);
               }
            }
            
            
            
            usersForm uf= new usersForm();
                uf.setVisible(true);
                this.dispose();
}

    }//GEN-LAST:event_updateActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        usersForm usf= new usersForm();
        usf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
    selectedFile = fileChooser.getSelectedFile();
    destination = "src/userimages/" + selectedFile.getName();
    path  = selectedFile.getAbsolutePath();
                        
                        
     if(FileExistenceChecker(path) == 1){
    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
         destination = "";
         path="";
        }else{
     image.setIcon(ResizeImage(path, null, image));
         select.setEnabled(false);
         remove.setEnabled(true);
           }
        } catch (Exception ex) {
            System.out.println("File Error!");
             }
      }
    }//GEN-LAST:event_selectActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
      remove.setEnabled(false);
       select.setEnabled(true);
       image.setIcon(null);
       destination="";
       path= "";
    }//GEN-LAST:event_removeActionPerformed

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
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    public javax.swing.JButton cancel;
    public javax.swing.JButton clear;
    public javax.swing.JButton delete;
    public javax.swing.JTextField email;
    public javax.swing.JTextField fn;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JTextField ln;
    public javax.swing.JTextField ps;
    public javax.swing.JButton refresh;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JTextField uiid;
    public javax.swing.JTextField un;
    public javax.swing.JButton update;
    public javax.swing.JComboBox<String> us;
    public javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
