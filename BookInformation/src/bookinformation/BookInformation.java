/*
 *   ITPF 02 CASE STUDY 
 *   
 *   MEMBERS:
 *   John Arvin Estrella
 *   Alvin Magtalas
 *   Daniel John Pantalunan
 *   John Justine Linsangan
 *   Merryl Joie Mariano
 *   Russel Mendoza
 *   Steven Mendoza
 * 
 */

package bookinformation;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel & Arvin
 * 
 */
public class BookInformation extends javax.swing.JFrame {
    
    //----------------------------creating database connection----------------------------
    private static final String username = "root";
    private static final String password = "123456";
    private static final String dataConn = "jdbc:mysql://localhost:3306/book_information";
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    //------------------------------------------------------------------------------------
    
    String title ="";
    String author="";
    String category="";
    String language="";
    String edition="";
    String condition="";
    
    int SelectedRows;
    DefaultTableModel RecordTable = new DefaultTableModel();

    public BookInformation()
    {
        initComponents();
    }
    
   //===========================================TABLE FUNCTION================================================   
   public void displayDB()
    {
        try(Connection conn = DriverManager.getConnection(dataConn, username, password);
        Statement stmt = conn.createStatement())
        {
            ResultSet result = stmt.executeQuery("SELECT * FROM book_data");
            RecordTable = (DefaultTableModel)bookTable.getModel();
            RecordTable.setRowCount(0);
                    
                    while(result.next())
                    {
                        String id = result.getString("id");
                        title = result.getString("title");
                        author = result.getString("author");
                        category = result.getString("category");
                        language = result.getString("lang");
                        edition = result.getString("edition");
                        condition = result.getString("cond"); 
                        
                        RecordTable.addRow(new Object[]{id, title, author, category, language, edition, condition});
                    }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error Connecting to Server");
        }
    }
   //=========================================================================================================
   
   //========================================CLEAR FIELDS BUTTON FUNCTION=====================================  
   public void clearFields()
   {
        titleTextfield.setText("");
        authorTextfield.setText("");
        categCombo.setSelectedIndex(0);
        languageTextfield.setText("");
        editionTextfield.setText("");
        buttonGroup1.clearSelection();
        addBtn.setEnabled(true);
        updateBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        bookTable.clearSelection();
   }
   //=========================================================================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new javax.swing.JPanel();
        panel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        panel5 = new javax.swing.JPanel();
        titleLbl = new javax.swing.JLabel();
        authorLbl = new javax.swing.JLabel();
        categoryLbl = new javax.swing.JLabel();
        languageLbl = new javax.swing.JLabel();
        editionLbl = new javax.swing.JLabel();
        conditionLbl = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        titleTextfield = new javax.swing.JTextField();
        categCombo = new javax.swing.JComboBox<>();
        languageTextfield = new javax.swing.JTextField();
        editionTextfield = new javax.swing.JTextField();
        newRadioBtn = new javax.swing.JRadioButton();
        oldRadioBtn = new javax.swing.JRadioButton();
        authorTextfield = new javax.swing.JTextField();
        panel4 = new javax.swing.JPanel();
        panel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        showBtn = new javax.swing.JButton();
        panel3 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bgPhoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Registration");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("frameIcon.png")).getImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 204, 51), new java.awt.Color(153, 153, 153), new java.awt.Color(0, 0, 0), null));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 153, 0), 3, true));
        panel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Book Registration");
        panel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 20));

        panel1.add(panel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 40));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 360, 60));

        panel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 153, 51), new java.awt.Color(153, 153, 153), new java.awt.Color(0, 0, 0), null));

        panel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 153, 0), 3, true), "Book Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLbl.setText("Book Title");
        panel5.add(titleLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 40, -1, -1));

        authorLbl.setText("Author");
        panel5.add(authorLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 92, -1, -1));

        categoryLbl.setText("Category");
        panel5.add(categoryLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 144, -1, -1));

        languageLbl.setText("Language");
        panel5.add(languageLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 196, -1, -1));

        editionLbl.setText("Edition");
        panel5.add(editionLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 248, -1, -1));

        conditionLbl.setText("Condition");
        panel5.add(conditionLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 299, -1, -1));

        clearBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        clearBtn.setText("Clear Fields");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        panel5.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 264, 46));
        panel5.add(titleTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 37, 190, -1));

        categCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select Category-", "Encyclopedia", "Essays", "Fiction & Non-Fiction", "Graphic Novel", "History", "Memoir & Autobiography", "Novel", "Poetry", "Science Fiction(Sci-Fi)", "Short Stories" }));
        categCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel5.add(categCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 141, 190, -1));
        panel5.add(languageTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 193, 190, -1));
        panel5.add(editionTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 245, 190, -1));

        buttonGroup1.add(newRadioBtn);
        newRadioBtn.setText("New");
        panel5.add(newRadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 297, -1, -1));

        buttonGroup1.add(oldRadioBtn);
        oldRadioBtn.setText("Old");
        panel5.add(oldRadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 297, -1, -1));
        panel5.add(authorTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 89, 190, -1));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 300, 420));

        panel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 204, 51), new java.awt.Color(153, 153, 153), new java.awt.Color(0, 0, 0), null));

        panel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 153, 0), 3, true), "Registered Books"));
        panel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Title", "Author", "Category", "Language", "Edition", "Condition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bookTable);

        panel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 24, 658, 240));

        showBtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        showBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dataIcon.png"))); // NOI18N
        showBtn.setText("Show Records");
        showBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtnActionPerformed(evt);
            }
        });
        panel6.add(showBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 300, 40));

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel6, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel6, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 700, 340));

        panel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 204, 51), new java.awt.Color(153, 153, 153), new java.awt.Color(0, 0, 0), null));

        addBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        exitBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 700, 70));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 260, 40));

        bgPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        getContentPane().add(bgPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //=======================================BUTTON ACTIONS===================================================
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        
        // checking fields if they're empty
        title = titleTextfield.getText();
        author =authorTextfield.getText();
        category =(String) categCombo.getSelectedItem().toString();
        language= languageTextfield.getText();
        edition = editionTextfield.getText();
        if(newRadioBtn.isSelected()){
                condition = "New";
        }
        else if(oldRadioBtn.isSelected()){
                condition = "Old";
        }
        
        // Joption if fields are empty
        if (title.isEmpty() || author.isEmpty() || category.isEmpty()|| 
            language.isEmpty() || edition.isEmpty()|| condition.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please enter all fields",
                                    "Try Again", JOptionPane.ERROR_MESSAGE);
        }
        // execute when all fields are filled
        else
        { 
            try
            {   //adding data from fields to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn, username, password);
                pst = sqlConn.prepareStatement("INSERT INTO book_data(title, author, category, lang, edition, cond) values(?,?,?,?,?,?)");
            
                pst.setString(1, title);
                pst.setString(2, author);
                pst.setString(3, category);
                pst.setString(4, language);
                pst.setString(5, edition);
                pst.setString(6, condition);
            
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record Added");
                displayDB();
                clearFields();
            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BookInformation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(BookInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
         
        RecordTable = (DefaultTableModel)bookTable.getModel();
        SelectedRows = bookTable.getSelectedRow();        
        // prompt if no row is selected
        if (SelectedRows < 0) { 
            JOptionPane.showMessageDialog(this,
                                    "Please select a row to update",
                                    "Update ",JOptionPane.INFORMATION_MESSAGE);
        }
        // execute when selected
        else
        {
            // checking fields if they're empty
            title = titleTextfield.getText();
            author =authorTextfield.getText();
            category =(String) categCombo.getSelectedItem().toString();
            language= languageTextfield.getText();
            edition = editionTextfield.getText();
            if(newRadioBtn.isSelected()){
                    condition = "New";
            }else if(oldRadioBtn.isSelected()){
                condition = "Old";
            }
            
            // Joption if fields are empty
            if (title.isEmpty() || author.isEmpty() || category.isEmpty()|| 
                language.isEmpty() || edition.isEmpty()|| condition.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Please enter all fields",
                "Try Again", JOptionPane.ERROR_MESSAGE);
            }
            //execute when all fields are filled    
            else
            {
                try
                {   //updating data from the table
                    String id = RecordTable.getValueAt(bookTable.getSelectedRow(), 0).toString() ;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    sqlConn = DriverManager.getConnection(dataConn, username, password);
                    pst = sqlConn.prepareStatement("UPDATE book_data SET title = ?, author = ?, category = ?, lang = ?, edition = ?, cond = ? WHERE id = ?");
            
                    pst.setString(1, title);
                    pst.setString(2, author);
                    pst.setString(3, category);
                    pst.setString(4, language);
                    pst.setString(5, edition);
                    pst.setString(6, condition);
                    pst.setString(7, id);
            
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Book Record Updated");
                    displayDB();
                    clearFields();
            
                    addBtn.setEnabled(true);
                    updateBtn.setEnabled(true);
                    deleteBtn.setEnabled(true);
                    bookTable.clearSelection();
            
                }catch (ClassNotFoundException | SQLException ex) 
                {
                    Logger.getLogger(BookInformation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        
        SelectedRows = bookTable.getSelectedRow();
        if (SelectedRows < 0) { // prompt if no row is selected
            JOptionPane.showMessageDialog(this,
                                    "No row is selected! Please select one!",
                                    "Delete Selected Row",
                                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            //deleting data from a selected row
            try(Connection conn = DriverManager.getConnection(dataConn, username, password);
            Statement stmt = conn.createStatement())
            {
                int deleteItem=JOptionPane.showConfirmDialog(this,
                                    "Delete this item?",
                                    "Selected Row",
                                    JOptionPane.YES_NO_OPTION);
                if(deleteItem == JOptionPane.YES_OPTION)
                {
                    String delete = "DELETE FROM book_data WHERE id = '" + RecordTable.getValueAt(bookTable.getSelectedRow(), 0).toString()+"';";
                    stmt.executeUpdate(delete);
                    JOptionPane.showMessageDialog(this, titleTextfield.getText() + " Successfully Removed");
                    displayDB();
                    clearFields();
                    addBtn.setEnabled(true);    
                    updateBtn.setEnabled(true);
                    deleteBtn.setEnabled(true);      
                    bookTable.clearSelection();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }    
    }//GEN-LAST:event_deleteBtnActionPerformed
    
    
    private JFrame frame;
    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        
        //exit button
        frame  = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame,"Do you want to Exit","Book Registration",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_exitBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        
        //clear button
        clearFields();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void bookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTableMouseClicked
        
        //data will show on the fields when clicked at the table
        titleTextfield.setText(RecordTable.getValueAt(bookTable.getSelectedRow(), 1).toString());
        authorTextfield.setText(RecordTable.getValueAt(bookTable.getSelectedRow(), 2).toString());
        categCombo.setSelectedItem(RecordTable.getValueAt(bookTable.getSelectedRow(), 3).toString());
        languageTextfield.setText(RecordTable.getValueAt(bookTable.getSelectedRow(), 4).toString());
        editionTextfield.setText(RecordTable.getValueAt(bookTable.getSelectedRow(), 5).toString());
        if(RecordTable.getValueAt(bookTable.getSelectedRow(), 6).toString().equals("New")){
            newRadioBtn.setSelected(true);
        }
        else if(RecordTable.getValueAt(bookTable.getSelectedRow(), 6).toString().equals("Old")){
            oldRadioBtn.setSelected(true);
        }
        
        addBtn.setEnabled(true);
        updateBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
    }//GEN-LAST:event_bookTableMouseClicked

    private void showBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBtnActionPerformed
        
        //will display data from the database when "Show Records" button was clicked 
        try(Connection conn = DriverManager.getConnection(dataConn, username, password);
        Statement stmt = conn.createStatement())
        {
            ResultSet result = stmt.executeQuery("SELECT * FROM book_data;");
            RecordTable = (DefaultTableModel)bookTable.getModel();
            RecordTable.setRowCount(0);
                    
                    while(result.next())
                    {
                        String id = result.getString("id");
                        title = result.getString("title");
                        author = result.getString("author");
                        category = result.getString("category");
                        language = result.getString("lang");
                        edition = result.getString("edition");
                        condition = result.getString("cond"); 
                        
                        
                        RecordTable.addRow(new Object[]{id, title, author, category, language, edition, condition});
                    }
            JOptionPane.showMessageDialog(this, "Records Displayed");
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error Connecting to Server");
        }
    }//GEN-LAST:event_showBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BookInformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel authorLbl;
    private javax.swing.JTextField authorTextfield;
    private javax.swing.JLabel bgPhoto;
    private javax.swing.JTable bookTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> categCombo;
    private javax.swing.JLabel categoryLbl;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel conditionLbl;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel editionLbl;
    private javax.swing.JTextField editionTextfield;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel languageLbl;
    private javax.swing.JTextField languageTextfield;
    private javax.swing.JRadioButton newRadioBtn;
    private javax.swing.JRadioButton oldRadioBtn;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JPanel panel7;
    private javax.swing.JButton showBtn;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JTextField titleTextfield;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

    private void executeUpdate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
