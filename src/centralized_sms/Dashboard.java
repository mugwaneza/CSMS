/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centralized_sms;

import static centralized_sms.Login.conn;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultRowSorter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Bernard.Ndaruhutse
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
        static Connection conn = null;   // initialize connection, Prepared statement and Resultset
        private PreparedStatement pst, pst2, pst3;
        private   ResultSet rs,rs2, rs3 = null;
        private     DefaultTableCellRenderer centerRenderer;
  Color OnHoverColor, OnClickedColor, updatebtn,trashbtn,editbtn;
    public Dashboard() {
        
        
         this.setResizable(false);
         this.setTitle("Dashboard") ;  
         this.setIcon();

         initComponents();
        
           
        Date date = new Date();  
        String currentDate =  new SimpleDateFormat("dd MMMM Y H:mm ss").format(date);
        current_date_label.setText(currentDate)  ;
        
        String currentTime =  new SimpleDateFormat("H:mm aa").format(date);

        jLabel_Time.setText(currentTime)  ;
        jTable_senior_admin.setDefaultEditor(Object.class, null);
        jTable_store.setDefaultEditor(Object.class, null);
        jTable_store_requests.setDefaultEditor(Object.class, null);
         
        OnHoverColor = new Color(0,102,153);
        OnClickedColor = new Color(255,255,102);
        updatebtn = new Color(0,102,153);
        trashbtn = new Color(204,51,0);
        editbtn = new Color(0,102,102);
        
        jLabel_deptid .setVisible(false);  // Hod' department id
        jLabeldeptid_hod .setVisible(false);  // Hod' department id2
         conn = Db_Connection.connectDb();   // invoke connection class
     
         
    
           
                 
                 try {// Populate staff info on all  comboboxes that list staff information from database 
                String un ="select id, first_name, last_name from staff_info";   
                 pst2 = this.conn.prepareStatement(un);
                 rs2 = pst2.executeQuery();
                 
                while(rs2.next()){
                    String fname = rs2.getString("first_name");
                    String lname = rs2.getString("last_name");
                    staffcombobox.insertItemAt(fname+" " +lname,1 );  
                }
               } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
              }
                 
                 try {// Populate departments on combobox from database
                String un ="select id, dept_name from department_info";   
                 pst2 = this.conn.prepareStatement(un);
                 rs2 = pst2.executeQuery();
                 
                while(rs2.next()){
                    String dept = rs2.getString("dept_name");
                    jComboBox_department.insertItemAt(dept,1 );
                }
               } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
              }
                 
                 
               try {  // Populate ranks on combobox from database
                String un ="select id, rank_name from ranks";   
                 pst2 = this.conn.prepareStatement(un);
                 rs2 = pst2.executeQuery();
                 
                while(rs2.next()){
                    String rank = rs2.getString("rank_name");
                    jComboBox_ranks.insertItemAt(rank,1 );
                }
               } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
              }
               
               
               try {  // Populate supplier on combobox from database
                String sup ="select * from supplier_info ";   
                 pst2 = this.conn.prepareStatement(sup);
                 rs2 = pst2.executeQuery();
                 
                while(rs2.next()){
                    String fname = rs2.getString("first_name");
                    String lname = rs2.getString("last_name");
                    Jcombobox_sto_suplier.insertItemAt(fname +" "+lname,1 );
                }
               } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel_main_background = new javax.swing.JPanel();
        rnp_logo_home = new javax.swing.JLabel();
        top_menu = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        role_portal_txt = new javax.swing.JLabel();
        jLabel_Time = new javax.swing.JLabel();
        current_date_label = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        names_text_label1 = new javax.swing.JLabel();
        left_menu_admin = new javax.swing.JPanel();
        home_btn = new javax.swing.JLabel();
        store_btn = new javax.swing.JLabel();
        users_btn = new javax.swing.JLabel();
        settings_btn = new javax.swing.JLabel();
        left_menu_storekeeper = new javax.swing.JPanel();
        store_homebtn = new javax.swing.JLabel();
        store_btn_btn = new javax.swing.JLabel();
        store_request_btn = new javax.swing.JLabel();
        store_panel_requests = new javax.swing.JPanel();
        store_top_menu1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField_storeRequestProduct = new javax.swing.JTextField();
        jTextField_StoreDepartment = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_Strorecomment = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_store_requests = new javax.swing.JTable();
        jButton2_StoreHandoutBtn = new javax.swing.JButton();
        jTextField_storeQuantity = new javax.swing.JTextField();
        store_panel = new javax.swing.JPanel();
        store_top_menu = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pductname = new javax.swing.JTextField();
        proquantity = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Jcombobox_sto_suplier = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_desc = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_store = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1_addItemToStore = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_store_history = new javax.swing.JTable();
        admin_panel_users = new javax.swing.JPanel();
        store_top_menu2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_staff_users = new javax.swing.JTable();
        jButton6_addUser = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable_admin_users_logins = new javax.swing.JTable();
        jButton8_addSataff = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jtextf_fname = new javax.swing.JTextField();
        jtextlname_lname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_ranks = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        username1 = new javax.swing.JTextField();
        rolecombobox = new javax.swing.JComboBox<>();
        passwordtextfld = new javax.swing.JPasswordField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_department = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        staffcombobox = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        admin_panel_store = new javax.swing.JPanel();
        store_top_menu3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable_admin_storep = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        admin_panel_settings = new javax.swing.JPanel();
        store_top_menu4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable_department_admin = new javax.swing.JTable();
        jButton_addRank = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable_admin_ranks = new javax.swing.JTable();
        jButton_addDepartment = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        canvas1 = new java.awt.Canvas();
        jTextField16_department = new javax.swing.JTextField();
        jTextField17_description = new javax.swing.JTextField();
        jTextField15_address = new javax.swing.JTextField();
        jTextField_fname = new javax.swing.JTextField();
        jTextField19_phone = new javax.swing.JTextField();
        jTextField20_lname = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40_ = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jButton19_addsupplier = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable_supplier_admin = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField14_rankname = new javax.swing.JTextField();
        jTextField14_desc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        hod_panel_store = new javax.swing.JPanel();
        store_top_menu5 = new javax.swing.JPanel();
        jLabel_departmentname = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel_deptid = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable_hod_store_requests = new javax.swing.JTable();
        jLabel45 = new javax.swing.JLabel();
        desc_hod = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        quantinty_hod = new javax.swing.JTextField();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable_hod_requests = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        jButton_SendRequest_departmentbtn = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jComboBox_productname_hod_store = new javax.swing.JComboBox<>();
        jLabel64 = new javax.swing.JLabel();
        hod_panel_items_distribution = new javax.swing.JPanel();
        store_top_menu6 = new javax.swing.JPanel();
        jLabel_hod_department = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabeldeptid_hod = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        quantinty_hod_distrib = new javax.swing.JTextField();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTable_hod_distrib = new javax.swing.JTable();
        jButton_assignItems = new javax.swing.JButton();
        jComboBox_hod_product_distribu = new javax.swing.JComboBox<>();
        jComboBox_hod_staff_distribu = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        left_menu_hod = new javax.swing.JPanel();
        hod_hod_homebtn1 = new javax.swing.JLabel();
        hod_store_btn = new javax.swing.JLabel();
        hodstaffitems_btn = new javax.swing.JLabel();
        senioradmin_panel_dash = new javax.swing.JPanel();
        store_top_menu7 = new javax.swing.JPanel();
        jTextField16 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel_deprname_senior = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        senior_productname = new javax.swing.JTextField();
        jScrollPane22 = new javax.swing.JScrollPane();
        jTable_senior_admin = new javax.swing.JTable();
        jButton11_senior_approve = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        senior_desc = new javax.swing.JTextField();
        senior_quantinty = new javax.swing.JTextField();
        senior_deptname = new javax.swing.JTextField();
        left_menu_senioradmin = new javax.swing.JPanel();
        senior_homebtn2 = new javax.swing.JLabel();
        seniorRequest_store_btn1 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_main_background.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_main_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rnp_logo_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/RNP_LOGO.png"))); // NOI18N
        rnp_logo_home.setAlignmentX(8.0F);
        rnp_logo_home.setAlignmentY(8.0F);
        rnp_logo_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rnp_logo_homeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rnp_logo_homeMouseReleased(evt);
            }
        });
        jPanel_main_background.add(rnp_logo_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 410, 380));

        top_menu.setBackground(new java.awt.Color(0, 102, 153));
        top_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/user.png"))); // NOI18N
        top_menu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        role_portal_txt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        role_portal_txt.setForeground(new java.awt.Color(255, 255, 255));
        role_portal_txt.setText("Admin Portal");
        top_menu.add(role_portal_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jLabel_Time.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Time.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Time.setText("11:20 AM");
        jLabel_Time.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_TimeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_TimeMouseExited(evt);
            }
        });
        top_menu.add(jLabel_Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        current_date_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        current_date_label.setForeground(new java.awt.Color(255, 255, 255));
        current_date_label.setText("28 June 2022");
        top_menu.add(current_date_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, 31));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 102));
        jLabel5.setText("Logout");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        top_menu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 30, -1, 31));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/menu.png"))); // NOI18N
        top_menu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 30, -1));

        names_text_label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        names_text_label1.setForeground(new java.awt.Color(255, 255, 255));
        names_text_label1.setText("Alexis M. ");
        top_menu.add(names_text_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, -1, -1));

        jPanel_main_background.add(top_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 100));

        left_menu_admin.setBackground(new java.awt.Color(0, 0, 51));

        home_btn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        home_btn.setForeground(new java.awt.Color(255, 255, 255));
        home_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/home.png"))); // NOI18N
        home_btn.setText("    HOME");
        home_btn.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                home_btnMouseWheelMoved(evt);
            }
        });
        home_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home_btnMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                home_btnMouseReleased(evt);
            }
        });
        home_btn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                home_btnPropertyChange(evt);
            }
        });

        store_btn.setBackground(new java.awt.Color(255, 255, 255));
        store_btn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        store_btn.setForeground(new java.awt.Color(255, 255, 255));
        store_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/store.png"))); // NOI18N
        store_btn.setText("   STORE");
        store_btn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                store_btnFocusGained(evt);
            }
        });
        store_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                store_btnMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                store_btnMouseReleased(evt);
            }
        });

        users_btn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        users_btn.setForeground(new java.awt.Color(255, 255, 255));
        users_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/users_group.png"))); // NOI18N
        users_btn.setText("   USERS");
        users_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                users_btnMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                users_btnMouseReleased(evt);
            }
        });

        settings_btn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        settings_btn.setForeground(new java.awt.Color(255, 255, 255));
        settings_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/settings.png"))); // NOI18N
        settings_btn.setText("   SETTINGS");
        settings_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settings_btnMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settings_btnMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                settings_btnMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout left_menu_adminLayout = new javax.swing.GroupLayout(left_menu_admin);
        left_menu_admin.setLayout(left_menu_adminLayout);
        left_menu_adminLayout.setHorizontalGroup(
            left_menu_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_menu_adminLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(left_menu_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(settings_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(store_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(left_menu_adminLayout.createSequentialGroup()
                        .addGroup(left_menu_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(users_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(home_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        left_menu_adminLayout.setVerticalGroup(
            left_menu_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_menu_adminLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(home_btn)
                .addGap(42, 42, 42)
                .addComponent(store_btn)
                .addGap(37, 37, 37)
                .addComponent(users_btn)
                .addGap(46, 46, 46)
                .addComponent(settings_btn)
                .addContainerGap(237, Short.MAX_VALUE))
        );

        jPanel_main_background.add(left_menu_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 220, 640));

        left_menu_storekeeper.setBackground(new java.awt.Color(0, 0, 51));

        store_homebtn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        store_homebtn.setForeground(new java.awt.Color(255, 255, 255));
        store_homebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/home.png"))); // NOI18N
        store_homebtn.setText("    HOME");
        store_homebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                store_homebtnMouseClicked(evt);
            }
        });

        store_btn_btn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        store_btn_btn.setForeground(new java.awt.Color(255, 255, 255));
        store_btn_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/store.png"))); // NOI18N
        store_btn_btn.setText("   STORE");
        store_btn_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                store_btn_btnMouseClicked(evt);
            }
        });
        store_btn_btn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                store_btn_btnKeyPressed(evt);
            }
        });

        store_request_btn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        store_request_btn.setForeground(new java.awt.Color(255, 255, 255));
        store_request_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/request.png"))); // NOI18N
        store_request_btn.setText("  REQUESTS");
        store_request_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                store_request_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout left_menu_storekeeperLayout = new javax.swing.GroupLayout(left_menu_storekeeper);
        left_menu_storekeeper.setLayout(left_menu_storekeeperLayout);
        left_menu_storekeeperLayout.setHorizontalGroup(
            left_menu_storekeeperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_menu_storekeeperLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(left_menu_storekeeperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(left_menu_storekeeperLayout.createSequentialGroup()
                        .addComponent(store_homebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(store_btn_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(store_request_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                .addContainerGap())
        );
        left_menu_storekeeperLayout.setVerticalGroup(
            left_menu_storekeeperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_menu_storekeeperLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(store_homebtn)
                .addGap(42, 42, 42)
                .addComponent(store_btn_btn)
                .addGap(37, 37, 37)
                .addComponent(store_request_btn)
                .addContainerGap(323, Short.MAX_VALUE))
        );

        jPanel_main_background.add(left_menu_storekeeper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 220, 640));

        store_panel_requests.setBackground(new java.awt.Color(255, 255, 255));

        store_top_menu1.setBackground(new java.awt.Color(102, 0, 0));

        jLabel18.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Departments,Regions and Schools Requests Information ");

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/search.png"))); // NOI18N

        javax.swing.GroupLayout store_top_menu1Layout = new javax.swing.GroupLayout(store_top_menu1);
        store_top_menu1.setLayout(store_top_menu1Layout);
        store_top_menu1Layout.setHorizontalGroup(
            store_top_menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_top_menu1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(37, 37, 37))
        );
        store_top_menu1Layout.setVerticalGroup(
            store_top_menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, store_top_menu1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(store_top_menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(store_top_menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel18)))
                .addGap(22, 22, 22))
        );

        jTextField_storeRequestProduct.setEditable(false);
        jTextField_storeRequestProduct.setText("  ");

        jTextField_StoreDepartment.setEditable(false);
        jTextField_StoreDepartment.setText("  ");

        jLabel20.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 0, 0));
        jLabel20.setText("Product ");

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 51, 0));
        jLabel21.setText("Comment");

        jLabel22.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 0, 51));
        jLabel22.setText("Quantity");

        jTextArea_Strorecomment.setEditable(false);
        jTextArea_Strorecomment.setColumns(20);
        jTextArea_Strorecomment.setRows(5);
        jScrollPane3.setViewportView(jTextArea_Strorecomment);

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 0, 0));
        jLabel23.setText("Department");

        jTable_store_requests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
            }
        ));
        jTable_store_requests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_store_requestsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable_store_requests);

        jButton2_StoreHandoutBtn.setBackground(new java.awt.Color(0, 0, 51));
        jButton2_StoreHandoutBtn.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jButton2_StoreHandoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        jButton2_StoreHandoutBtn.setText("HAND OUT MATERIALS");
        jButton2_StoreHandoutBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton2_StoreHandoutBtnMouseMoved(evt);
            }
        });
        jButton2_StoreHandoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2_StoreHandoutBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2_StoreHandoutBtnMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2_StoreHandoutBtnMouseReleased(evt);
            }
        });
        jButton2_StoreHandoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_StoreHandoutBtnActionPerformed(evt);
            }
        });

        jTextField_storeQuantity.setEditable(false);
        jTextField_storeQuantity.setText("  ");

        javax.swing.GroupLayout store_panel_requestsLayout = new javax.swing.GroupLayout(store_panel_requests);
        store_panel_requests.setLayout(store_panel_requestsLayout);
        store_panel_requestsLayout.setHorizontalGroup(
            store_panel_requestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_panel_requestsLayout.createSequentialGroup()
                .addGroup(store_panel_requestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(store_panel_requestsLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(store_panel_requestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(store_panel_requestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel22)
                                .addGroup(store_panel_requestsLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel20))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(store_panel_requestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField_storeQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2_StoreHandoutBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_StoreDepartment, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_storeRequestProduct))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(store_panel_requestsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(store_top_menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        store_panel_requestsLayout.setVerticalGroup(
            store_panel_requestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_panel_requestsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(store_top_menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(store_panel_requestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(store_panel_requestsLayout.createSequentialGroup()
                        .addGroup(store_panel_requestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_storeRequestProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(store_panel_requestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jTextField_storeQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(store_panel_requestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jTextField_StoreDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(store_panel_requestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, store_panel_requestsLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(21, 21, 21))))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2_StoreHandoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jPanel_main_background.add(store_panel_requests, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 1060, 560));

        store_panel.setBackground(new java.awt.Color(255, 255, 255));

        store_top_menu.setBackground(new java.awt.Color(0, 0, 51));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Store details");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/search.png"))); // NOI18N

        javax.swing.GroupLayout store_top_menuLayout = new javax.swing.GroupLayout(store_top_menu);
        store_top_menu.setLayout(store_top_menuLayout);
        store_top_menuLayout.setHorizontalGroup(
            store_top_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, store_top_menuLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(54, 54, 54))
        );
        store_top_menuLayout.setVerticalGroup(
            store_top_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(store_top_menuLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(store_top_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        pductname.setText("  ");

        proquantity.setText("  ");

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel11.setText("Product ");

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel12.setText("Description");

        Jcombobox_sto_suplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- select supplier --" }));
        Jcombobox_sto_suplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcombobox_sto_suplierActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel13.setText("Quantity");

        jTextArea_desc.setColumns(20);
        jTextArea_desc.setRows(5);
        jScrollPane1.setViewportView(jTextArea_desc);

        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel17.setText("Supplier");

        jTable_store.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable_store);

        jButton1_addItemToStore.setBackground(new java.awt.Color(0, 0, 51));
        jButton1_addItemToStore.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jButton1_addItemToStore.setForeground(new java.awt.Color(255, 255, 255));
        jButton1_addItemToStore.setText("ADD");
        jButton1_addItemToStore.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton1_addItemToStoreMouseMoved(evt);
            }
        });
        jButton1_addItemToStore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1_addItemToStoreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1_addItemToStoreMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1_addItemToStoreMouseReleased(evt);
            }
        });
        jButton1_addItemToStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_addItemToStoreActionPerformed(evt);
            }
        });

        Update.setBackground(new java.awt.Color(0, 0, 51));
        Update.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("UPDATE");
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateMouseReleased(evt);
            }
        });
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 14)); // NOI18N
        jLabel16.setText("Store report history");

        jTable_store_history.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(jTable_store_history);

        javax.swing.GroupLayout store_panelLayout = new javax.swing.GroupLayout(store_panel);
        store_panel.setLayout(store_panelLayout);
        store_panelLayout.setHorizontalGroup(
            store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(store_panelLayout.createSequentialGroup()
                        .addGroup(store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(store_top_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1013, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addGroup(store_panelLayout.createSequentialGroup()
                        .addGroup(store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(store_panelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(proquantity)
                            .addComponent(pductname)
                            .addComponent(Jcombobox_sto_suplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(store_panelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1_addItemToStore, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, store_panelLayout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(204, 204, 204))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, store_panelLayout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))))))
        );
        store_panelLayout.setVerticalGroup(
            store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_panelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(store_top_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(store_panelLayout.createSequentialGroup()
                        .addGroup(store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pductname, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(proquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Jcombobox_sto_suplier, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGroup(store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(store_panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(store_panelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel12))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(store_panelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                    .addGroup(store_panelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(store_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1_addItemToStore, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel_main_background.add(store_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 1060, 560));

        admin_panel_users.setBackground(new java.awt.Color(255, 255, 255));

        store_top_menu2.setBackground(new java.awt.Color(0, 0, 51));

        jLabel24.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Staff information");

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/search.png"))); // NOI18N

        javax.swing.GroupLayout store_top_menu2Layout = new javax.swing.GroupLayout(store_top_menu2);
        store_top_menu2.setLayout(store_top_menu2Layout);
        store_top_menu2Layout.setHorizontalGroup(
            store_top_menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_top_menu2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel25)
                .addContainerGap())
        );
        store_top_menu2Layout.setVerticalGroup(
            store_top_menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_top_menu2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(store_top_menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(store_top_menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24))
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jTable_staff_users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(jTable_staff_users);

        jButton6_addUser.setBackground(new java.awt.Color(0, 102, 102));
        jButton6_addUser.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jButton6_addUser.setForeground(new java.awt.Color(255, 255, 255));
        jButton6_addUser.setText("Add user");
        jButton6_addUser.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton6_addUserMouseMoved(evt);
            }
        });
        jButton6_addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6_addUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6_addUserMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6_addUserMouseReleased(evt);
            }
        });
        jButton6_addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6_addUserActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(51, 0, 153));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Update");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(0, 51, 102));
        jSeparator4.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jTable_admin_users_logins.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(jTable_admin_users_logins);

        jButton8_addSataff.setBackground(new java.awt.Color(0, 0, 51));
        jButton8_addSataff.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jButton8_addSataff.setForeground(new java.awt.Color(255, 255, 255));
        jButton8_addSataff.setText("Add staff");
        jButton8_addSataff.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton8_addSataffMouseMoved(evt);
            }
        });
        jButton8_addSataff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8_addSataffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8_addSataffMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton8_addSataffMouseReleased(evt);
            }
        });
        jButton8_addSataff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8_addSataffActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 102, 51));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Update");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jtextf_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextf_fnameActionPerformed(evt);
            }
        });

        jLabel6.setText("First name");

        jComboBox_ranks.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select rank--" }));

        jLabel31.setText("Ranks");

        username1.setMargin(new java.awt.Insets(1, 2, 1, 2));

        rolecombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select role--","Administrator","Storekeeper", "HOD", "Senior Admin"}));

        passwordtextfld.setMargin(new java.awt.Insets(1, 2, 2, 2));

        jLabel32.setText("Role");

        jLabel33.setText("Username");

        jLabel34.setFont(new java.awt.Font("Tempus Sans ITC", 1, 21)); // NOI18N
        jLabel34.setText("Rwanda National Police Staff Login Credentials");

        jLabel35.setText("Password");

        jLabel2.setText("Last name");

        jComboBox_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select department--" }));

        jLabel4.setText("Department");

        staffcombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select Staff --"}));

        jLabel37.setText("Staff name");

        jLabel62.setFont(new java.awt.Font("Tempus Sans ITC", 1, 21)); // NOI18N
        jLabel62.setText("Staff and Their Respective Departments and Ranks");

        javax.swing.GroupLayout admin_panel_usersLayout = new javax.swing.GroupLayout(admin_panel_users);
        admin_panel_users.setLayout(admin_panel_usersLayout);
        admin_panel_usersLayout.setHorizontalGroup(
            admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_panel_usersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(admin_panel_usersLayout.createSequentialGroup()
                        .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel35)
                            .addComponent(jLabel32)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel37))
                        .addGap(32, 32, 32)
                        .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(admin_panel_usersLayout.createSequentialGroup()
                                .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtextf_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtextlname_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox_ranks, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox_department, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(admin_panel_usersLayout.createSequentialGroup()
                                        .addComponent(jButton8_addSataff, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 131, Short.MAX_VALUE))
                                    .addGroup(admin_panel_usersLayout.createSequentialGroup()
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admin_panel_usersLayout.createSequentialGroup()
                                .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(rolecombobox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(username1)
                                    .addComponent(passwordtextfld, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(staffcombobox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6_addUser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(admin_panel_usersLayout.createSequentialGroup()
                        .addComponent(store_top_menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        admin_panel_usersLayout.setVerticalGroup(
            admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_panel_usersLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(store_top_menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(admin_panel_usersLayout.createSequentialGroup()
                        .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(admin_panel_usersLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtextf_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(25, 25, 25)
                                .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtextlname_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox_department, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(admin_panel_usersLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8_addSataff, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox_ranks, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(admin_panel_usersLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(33, 33, 33)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(admin_panel_usersLayout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(admin_panel_usersLayout.createSequentialGroup()
                        .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(admin_panel_usersLayout.createSequentialGroup()
                                .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(staffcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37))
                                .addGap(2, 2, 2)
                                .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33))
                                .addGap(3, 3, 3)
                                .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(passwordtextfld, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35))
                                .addGap(2, 2, 2)
                                .addGroup(admin_panel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rolecombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32)))
                            .addGroup(admin_panel_usersLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jButton6_addUser, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))))
        );

        jPanel_main_background.add(admin_panel_users, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 1060, 560));

        admin_panel_store.setBackground(new java.awt.Color(255, 255, 255));

        store_top_menu3.setBackground(new java.awt.Color(0, 0, 51));

        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Store information");

        jTextField9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 51)));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/search.png"))); // NOI18N

        javax.swing.GroupLayout store_top_menu3Layout = new javax.swing.GroupLayout(store_top_menu3);
        store_top_menu3.setLayout(store_top_menu3Layout);
        store_top_menu3Layout.setHorizontalGroup(
            store_top_menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_top_menu3Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(46, 46, 46))
        );
        store_top_menu3Layout.setVerticalGroup(
            store_top_menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_top_menu3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(store_top_menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(store_top_menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTable_admin_storep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(jTable_admin_storep);

        javax.swing.GroupLayout admin_panel_storeLayout = new javax.swing.GroupLayout(admin_panel_store);
        admin_panel_store.setLayout(admin_panel_storeLayout);
        admin_panel_storeLayout.setHorizontalGroup(
            admin_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_panel_storeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(admin_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admin_panel_storeLayout.createSequentialGroup()
                        .addComponent(jSeparator3)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admin_panel_storeLayout.createSequentialGroup()
                        .addGroup(admin_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(store_top_menu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane8))
                        .addGap(43, 43, 43))))
        );
        admin_panel_storeLayout.setVerticalGroup(
            admin_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_panel_storeLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(store_top_menu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        jPanel_main_background.add(admin_panel_store, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 1060, 560));

        admin_panel_settings.setBackground(new java.awt.Color(255, 255, 255));
        admin_panel_settings.setForeground(new java.awt.Color(255, 204, 0));

        store_top_menu4.setBackground(new java.awt.Color(0, 0, 51));

        jLabel29.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Admin settings");

        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/search.png"))); // NOI18N

        javax.swing.GroupLayout store_top_menu4Layout = new javax.swing.GroupLayout(store_top_menu4);
        store_top_menu4.setLayout(store_top_menu4Layout);
        store_top_menu4Layout.setHorizontalGroup(
            store_top_menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_top_menu4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 390, Short.MAX_VALUE)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addGap(34, 34, 34))
        );
        store_top_menu4Layout.setVerticalGroup(
            store_top_menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_top_menu4Layout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addGroup(store_top_menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(store_top_menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29))
                    .addComponent(jLabel30))
                .addGap(29, 29, 29))
        );

        jTable_department_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane9.setViewportView(jTable_department_admin);

        jButton_addRank.setBackground(new java.awt.Color(0, 0, 51));
        jButton_addRank.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jButton_addRank.setForeground(new java.awt.Color(255, 255, 255));
        jButton_addRank.setText("Add rank");
        jButton_addRank.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton_addRankMouseMoved(evt);
            }
        });
        jButton_addRank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_addRankMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_addRankMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton_addRankMouseReleased(evt);
            }
        });
        jButton_addRank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addRankActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(0, 0, 51));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Update");
        jButton13.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jTable_admin_ranks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane11.setViewportView(jTable_admin_ranks);

        jButton_addDepartment.setBackground(new java.awt.Color(0, 0, 51));
        jButton_addDepartment.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jButton_addDepartment.setForeground(new java.awt.Color(255, 255, 255));
        jButton_addDepartment.setText("Add department");
        jButton_addDepartment.setMargin(new java.awt.Insets(2, 14, 2, 0));
        jButton_addDepartment.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton_addDepartmentMouseMoved(evt);
            }
        });
        jButton_addDepartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_addDepartmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_addDepartmentMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton_addDepartmentMouseReleased(evt);
            }
        });
        jButton_addDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addDepartmentActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(0, 0, 51));
        jButton15.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Update rank");
        jButton15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton15MouseMoved(evt);
            }
        });
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton15MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton15MouseReleased(evt);
            }
        });
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(0, 102, 102));
        jButton18.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Update supplier");
        jButton18.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton18MouseMoved(evt);
            }
        });
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton18MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton18MouseReleased(evt);
            }
        });
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTextField16_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16_departmentActionPerformed(evt);
            }
        });

        jTextField17_description.setMargin(new java.awt.Insets(1, 2, 2, 2));

        jLabel38.setText("First name");

        jLabel39.setText("Last name");

        jLabel40_.setText("Address");

        jLabel41.setText("Telephone");

        jButton19_addsupplier.setBackground(new java.awt.Color(0, 102, 102));
        jButton19_addsupplier.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jButton19_addsupplier.setForeground(new java.awt.Color(255, 255, 255));
        jButton19_addsupplier.setText("Add supplier");
        jButton19_addsupplier.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton19_addsupplierMouseMoved(evt);
            }
        });
        jButton19_addsupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton19_addsupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton19_addsupplierMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton19_addsupplierMouseReleased(evt);
            }
        });
        jButton19_addsupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19_addsupplierActionPerformed(evt);
            }
        });
        jButton19_addsupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton19_addsupplierKeyPressed(evt);
            }
        });

        jTable_supplier_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fname", "LName", "Address", "Tel", "created at"
            }
        ));
        jScrollPane13.setViewportView(jTable_supplier_admin);

        jTextField14_desc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14_descActionPerformed(evt);
            }
        });

        jLabel1.setText("Rank name");

        jLabel42.setText("Description");

        jLabel40.setText("Description");

        jLabel49.setText("Department / Unit");

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/product.png"))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Tempus Sans ITC", 1, 21)); // NOI18N
        jLabel36.setText("All Suppliers of Rwanda National Police");

        javax.swing.GroupLayout admin_panel_settingsLayout = new javax.swing.GroupLayout(admin_panel_settings);
        admin_panel_settings.setLayout(admin_panel_settingsLayout);
        admin_panel_settingsLayout.setHorizontalGroup(
            admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admin_panel_settingsLayout.createSequentialGroup()
                        .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton_addDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel40))
                                            .addComponent(jTextField16_department, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField17_description, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 5, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admin_panel_settingsLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel49)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admin_panel_settingsLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admin_panel_settingsLayout.createSequentialGroup()
                                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(159, 159, 159))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admin_panel_settingsLayout.createSequentialGroup()
                                        .addComponent(jLabel55)
                                        .addGap(124, 124, 124)))))
                        .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(jButton19_addsupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                                        .addComponent(jButton_addRank, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton15)
                                                        .addGap(18, 18, 18))
                                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField14_rankname, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jTextField14_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel42)))
                                            .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                                    .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel38)
                                                        .addComponent(jLabel40_, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField15_address, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(9, 9, 9)
                                                    .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                                            .addComponent(jLabel41)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jTextField19_phone))
                                                        .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                                            .addComponent(jLabel39)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jTextField20_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                    .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(48, Short.MAX_VALUE))
                    .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                        .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, admin_panel_settingsLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jSeparator5))
                            .addComponent(store_top_menu4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        admin_panel_settingsLayout.setVerticalGroup(
            admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(store_top_menu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                        .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(3, 3, 3)
                                        .addComponent(jTextField14_rankname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel42)
                                        .addGap(2, 2, 2)
                                        .addComponent(jTextField14_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton_addRank, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField16_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel40)
                                .addGap(3, 3, 3)
                                .addComponent(jTextField17_description, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton_addDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(admin_panel_settingsLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38)
                                    .addComponent(jTextField20_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39))
                                .addGap(3, 3, 3)
                                .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel40_)
                                    .addComponent(jTextField15_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField19_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(admin_panel_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton19_addsupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jSeparator6))
                .addGap(18, 18, 18)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel_main_background.add(admin_panel_settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 1060, 560));

        hod_panel_store.setBackground(new java.awt.Color(255, 255, 255));

        store_top_menu5.setBackground(new java.awt.Color(102, 51, 0));

        jLabel_departmentname.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel_departmentname.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_departmentname.setText("Department");

        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/search.png"))); // NOI18N

        jLabel48.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Items request and Department store status");

        jLabel_deptid.setText("deptid");

        javax.swing.GroupLayout store_top_menu5Layout = new javax.swing.GroupLayout(store_top_menu5);
        store_top_menu5.setLayout(store_top_menu5Layout);
        store_top_menu5Layout.setHorizontalGroup(
            store_top_menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_top_menu5Layout.createSequentialGroup()
                .addGroup(store_top_menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(store_top_menu5Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(store_top_menu5Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel_departmentname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addComponent(jLabel_deptid)
                        .addGap(184, 184, 184)))
                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43)
                .addGap(37, 37, 37))
        );
        store_top_menu5Layout.setVerticalGroup(
            store_top_menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_top_menu5Layout.createSequentialGroup()
                .addGroup(store_top_menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(store_top_menu5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(store_top_menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_deptid)
                            .addComponent(jLabel_departmentname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48))
                    .addGroup(store_top_menu5Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(store_top_menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel44.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel44.setText("Product name ");

        jTable_hod_store_requests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane14.setViewportView(jTable_hod_store_requests);

        jLabel45.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel45.setText("Description");

        jLabel46.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel46.setText("Quantity");

        jTable_hod_requests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product", "Quantity", "Requ status", "Description", "Requested on"
            }
        ));
        jScrollPane16.setViewportView(jTable_hod_requests);

        jLabel47.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel47.setText("Department Store Status");

        jButton_SendRequest_departmentbtn.setBackground(new java.awt.Color(0, 153, 153));
        jButton_SendRequest_departmentbtn.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jButton_SendRequest_departmentbtn.setForeground(new java.awt.Color(255, 255, 255));
        jButton_SendRequest_departmentbtn.setText("Send Request");
        jButton_SendRequest_departmentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SendRequest_departmentbtnActionPerformed(evt);
            }
        });

        jComboBox_productname_hod_store.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel64.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel64.setText("Department pending requests");

        javax.swing.GroupLayout hod_panel_storeLayout = new javax.swing.GroupLayout(hod_panel_store);
        hod_panel_store.setLayout(hod_panel_storeLayout);
        hod_panel_storeLayout.setHorizontalGroup(
            hod_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hod_panel_storeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(store_top_menu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hod_panel_storeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(431, 431, 431))
            .addGroup(hod_panel_storeLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(hod_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hod_panel_storeLayout.createSequentialGroup()
                        .addGroup(hod_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, hod_panel_storeLayout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_productname_hod_store, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, hod_panel_storeLayout.createSequentialGroup()
                                .addGroup(hod_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel46))
                                .addGap(33, 33, 33)
                                .addGroup(hod_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(quantinty_hod, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                    .addComponent(desc_hod)))
                            .addComponent(jButton_SendRequest_departmentbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                        .addGroup(hod_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hod_panel_storeLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(hod_panel_storeLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(hod_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        hod_panel_storeLayout.setVerticalGroup(
            hod_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hod_panel_storeLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(store_top_menu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(hod_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(hod_panel_storeLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(hod_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44)
                            .addComponent(jComboBox_productname_hod_store, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(hod_panel_storeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hod_panel_storeLayout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel45))
                            .addGroup(hod_panel_storeLayout.createSequentialGroup()
                                .addComponent(quantinty_hod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(desc_hod, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_SendRequest_departmentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hod_panel_storeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel_main_background.add(hod_panel_store, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 1060, 560));

        hod_panel_items_distribution.setBackground(new java.awt.Color(255, 255, 255));

        store_top_menu6.setBackground(new java.awt.Color(0, 0, 51));

        jLabel_hod_department.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel_hod_department.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hod_department.setText("Department");

        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/search.png"))); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Items Distribution to the staff");

        jLabeldeptid_hod.setForeground(new java.awt.Color(255, 255, 255));
        jLabeldeptid_hod.setText("iddepartment");

        javax.swing.GroupLayout store_top_menu6Layout = new javax.swing.GroupLayout(store_top_menu6);
        store_top_menu6.setLayout(store_top_menu6Layout);
        store_top_menu6Layout.setHorizontalGroup(
            store_top_menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_top_menu6Layout.createSequentialGroup()
                .addGroup(store_top_menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(store_top_menu6Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel51))
                    .addGroup(store_top_menu6Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel_hod_department)
                        .addGap(38, 38, 38)
                        .addComponent(jLabeldeptid_hod)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50)
                .addGap(37, 37, 37))
        );
        store_top_menu6Layout.setVerticalGroup(
            store_top_menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_top_menu6Layout.createSequentialGroup()
                .addGroup(store_top_menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(store_top_menu6Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(store_top_menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_hod_department)
                            .addComponent(jLabeldeptid_hod))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel51))
                    .addGroup(store_top_menu6Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(store_top_menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel53.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel53.setText("Staff name");

        jLabel54.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel54.setText("Quantity");

        quantinty_hod_distrib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantinty_hod_distribActionPerformed(evt);
            }
        });

        jTable_hod_distrib.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane19.setViewportView(jTable_hod_distrib);

        jButton_assignItems.setBackground(new java.awt.Color(0, 153, 153));
        jButton_assignItems.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jButton_assignItems.setForeground(new java.awt.Color(255, 255, 255));
        jButton_assignItems.setText("Assign Product  To  The Staff");
        jButton_assignItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_assignItemsActionPerformed(evt);
            }
        });

        jComboBox_hod_product_distribu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        jComboBox_hod_staff_distribu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jComboBox_hod_staff_distribu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_hod_staff_distribuActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 21)); // NOI18N
        jLabel63.setText("All staff records history of IT materials");

        jLabel65.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel65.setText("Product name ");

        javax.swing.GroupLayout hod_panel_items_distributionLayout = new javax.swing.GroupLayout(hod_panel_items_distribution);
        hod_panel_items_distribution.setLayout(hod_panel_items_distributionLayout);
        hod_panel_items_distributionLayout.setHorizontalGroup(
            hod_panel_items_distributionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hod_panel_items_distributionLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(hod_panel_items_distributionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane19)
                    .addGroup(hod_panel_items_distributionLayout.createSequentialGroup()
                        .addGroup(hod_panel_items_distributionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hod_panel_items_distributionLayout.createSequentialGroup()
                                .addGap(308, 308, 308)
                                .addGroup(hod_panel_items_distributionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_assignItems, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(hod_panel_items_distributionLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(hod_panel_items_distributionLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(hod_panel_items_distributionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel65))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hod_panel_items_distributionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox_hod_staff_distribu, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(hod_panel_items_distributionLayout.createSequentialGroup()
                                        .addComponent(jComboBox_hod_product_distribu, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(118, 118, 118)
                                        .addComponent(jLabel54)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quantinty_hod_distrib, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(37, 37, 37)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(hod_panel_items_distributionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(store_top_menu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hod_panel_items_distributionLayout.setVerticalGroup(
            hod_panel_items_distributionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hod_panel_items_distributionLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(store_top_menu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hod_panel_items_distributionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_hod_product_distribu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantinty_hod_distrib)
                    .addComponent(jLabel54)
                    .addComponent(jLabel65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hod_panel_items_distributionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_hod_staff_distribu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addGap(2, 2, 2)
                .addComponent(jButton_assignItems, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel63)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel_main_background.add(hod_panel_items_distribution, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 1060, 560));

        left_menu_hod.setBackground(new java.awt.Color(0, 0, 51));
        left_menu_hod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                left_menu_hodMouseClicked(evt);
            }
        });

        hod_hod_homebtn1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        hod_hod_homebtn1.setForeground(new java.awt.Color(255, 255, 255));
        hod_hod_homebtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/home.png"))); // NOI18N
        hod_hod_homebtn1.setText("    HOME");
        hod_hod_homebtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hod_hod_homebtn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hod_hod_homebtn1MouseEntered(evt);
            }
        });

        hod_store_btn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        hod_store_btn.setForeground(new java.awt.Color(255, 255, 255));
        hod_store_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/store.png"))); // NOI18N
        hod_store_btn.setText("   HOD STORE");
        hod_store_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hod_store_btnMouseClicked(evt);
            }
        });
        hod_store_btn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hod_store_btnKeyPressed(evt);
            }
        });

        hodstaffitems_btn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        hodstaffitems_btn.setForeground(new java.awt.Color(255, 255, 255));
        hodstaffitems_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/users_group.png"))); // NOI18N
        hodstaffitems_btn.setText("   STAFF ITEMS");
        hodstaffitems_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hodstaffitems_btnMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                hodstaffitems_btnMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout left_menu_hodLayout = new javax.swing.GroupLayout(left_menu_hod);
        left_menu_hod.setLayout(left_menu_hodLayout);
        left_menu_hodLayout.setHorizontalGroup(
            left_menu_hodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_menu_hodLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(left_menu_hodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(left_menu_hodLayout.createSequentialGroup()
                        .addComponent(hod_hod_homebtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(hod_store_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hodstaffitems_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        left_menu_hodLayout.setVerticalGroup(
            left_menu_hodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_menu_hodLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(hod_hod_homebtn1)
                .addGap(42, 42, 42)
                .addComponent(hod_store_btn)
                .addGap(37, 37, 37)
                .addComponent(hodstaffitems_btn)
                .addContainerGap(323, Short.MAX_VALUE))
        );

        jPanel_main_background.add(left_menu_hod, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 220, 640));

        senioradmin_panel_dash.setBackground(new java.awt.Color(255, 255, 255));

        store_top_menu7.setBackground(new java.awt.Color(0, 0, 51));

        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/search.png"))); // NOI18N

        jLabel57.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("High level Items Requests Approval");

        jLabel_deprname_senior.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel_deprname_senior.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout store_top_menu7Layout = new javax.swing.GroupLayout(store_top_menu7);
        store_top_menu7.setLayout(store_top_menu7Layout);
        store_top_menu7Layout.setHorizontalGroup(
            store_top_menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_top_menu7Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(store_top_menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57)
                    .addComponent(jLabel_deprname_senior, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel56)
                .addGap(37, 37, 37))
        );
        store_top_menu7Layout.setVerticalGroup(
            store_top_menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(store_top_menu7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_deprname_senior, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(store_top_menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel56)
                    .addGroup(store_top_menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel57)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel58.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel58.setText("Product name ");

        jLabel59.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel59.setText("Description");

        jLabel60.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel60.setText("Quantity");

        senior_productname.setEditable(false);

        jTable_senior_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
            }
        ));
        jTable_senior_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_senior_adminMouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(jTable_senior_admin);

        jButton11_senior_approve.setBackground(new java.awt.Color(0, 51, 51));
        jButton11_senior_approve.setForeground(new java.awt.Color(255, 255, 255));
        jButton11_senior_approve.setText("Approve This Request");
        jButton11_senior_approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11_senior_approveActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel61.setText("Department name");

        senior_desc.setEditable(false);

        senior_quantinty.setEditable(false);

        senior_deptname.setEditable(false);
        senior_deptname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senior_deptnameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout senioradmin_panel_dashLayout = new javax.swing.GroupLayout(senioradmin_panel_dash);
        senioradmin_panel_dash.setLayout(senioradmin_panel_dashLayout);
        senioradmin_panel_dashLayout.setHorizontalGroup(
            senioradmin_panel_dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(senioradmin_panel_dashLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(senioradmin_panel_dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(senioradmin_panel_dashLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senior_productname, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(senioradmin_panel_dashLayout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(senior_quantinty, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(senioradmin_panel_dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(senioradmin_panel_dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(senior_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senior_deptname, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(329, 329, 329))
            .addGroup(senioradmin_panel_dashLayout.createSequentialGroup()
                .addGroup(senioradmin_panel_dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(senioradmin_panel_dashLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(store_top_menu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(senioradmin_panel_dashLayout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(jButton11_senior_approve, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        senioradmin_panel_dashLayout.setVerticalGroup(
            senioradmin_panel_dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(senioradmin_panel_dashLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(store_top_menu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(senioradmin_panel_dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel61)
                    .addComponent(senior_productname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senior_deptname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(senioradmin_panel_dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(senior_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(senioradmin_panel_dashLayout.createSequentialGroup()
                        .addGroup(senioradmin_panel_dashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(senior_quantinty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60))
                        .addGap(11, 11, 11)))
                .addGap(18, 18, 18)
                .addComponent(jButton11_senior_approve, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel_main_background.add(senioradmin_panel_dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, 560));

        left_menu_senioradmin.setBackground(new java.awt.Color(0, 0, 51));

        senior_homebtn2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        senior_homebtn2.setForeground(new java.awt.Color(255, 255, 255));
        senior_homebtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/home.png"))); // NOI18N
        senior_homebtn2.setText("    HOME");
        senior_homebtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                senior_homebtn2MouseClicked(evt);
            }
        });

        seniorRequest_store_btn1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        seniorRequest_store_btn1.setForeground(new java.awt.Color(255, 255, 255));
        seniorRequest_store_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/centralized_sms/imgs/request.png"))); // NOI18N
        seniorRequest_store_btn1.setText("   REQUESTS");
        seniorRequest_store_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seniorRequest_store_btn1MouseClicked(evt);
            }
        });
        seniorRequest_store_btn1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                seniorRequest_store_btn1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout left_menu_senioradminLayout = new javax.swing.GroupLayout(left_menu_senioradmin);
        left_menu_senioradmin.setLayout(left_menu_senioradminLayout);
        left_menu_senioradminLayout.setHorizontalGroup(
            left_menu_senioradminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_menu_senioradminLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(left_menu_senioradminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(left_menu_senioradminLayout.createSequentialGroup()
                        .addComponent(senior_homebtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(seniorRequest_store_btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        left_menu_senioradminLayout.setVerticalGroup(
            left_menu_senioradminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_menu_senioradminLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(senior_homebtn2)
                .addGap(42, 42, 42)
                .addComponent(seniorRequest_store_btn1)
                .addContainerGap(400, Short.MAX_VALUE))
        );

        jPanel_main_background.add(left_menu_senioradmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 220, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_main_background, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_main_background, javax.swing.GroupLayout.PREFERRED_SIZE, 658, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void home_btnPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_home_btnPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_home_btnPropertyChange

    private void home_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseReleased
        // TODO add your handling code here:
         home_btn.setForeground(OnClickedColor);
    }//GEN-LAST:event_home_btnMouseReleased

    private void home_btnMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_home_btnMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_home_btnMouseWheelMoved

    private void store_btnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_store_btnFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_store_btnFocusGained

    private void users_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_users_btnMouseClicked
        // TODO add your handling code here:
               this.admin_panel_store.setVisible(false);
               this.admin_panel_users.setVisible(true);
               this.rnp_logo_home.setVisible(false); 
               this.admin_panel_settings.setVisible(false);
               this.senioradmin_panel_dash.setVisible(false);  
               this.left_menu_senioradmin.setVisible(false);
             FetchUsersAdmin();
             FetchUsersAdmin2();
    }//GEN-LAST:event_users_btnMouseClicked

    private void users_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_users_btnMouseReleased
        // TODO add your handling code here:
                 users_btn.setForeground(OnClickedColor);
    }//GEN-LAST:event_users_btnMouseReleased

    private void store_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_store_btnMouseReleased
        // TODO add your handling code here:
             store_btn.setForeground(OnClickedColor);
             
             
    }//GEN-LAST:event_store_btnMouseReleased

    private void settings_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settings_btnMouseReleased
        // TODO add your handling code here:
            settings_btn.setForeground(OnClickedColor);

    }//GEN-LAST:event_settings_btnMouseReleased

    private void settings_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settings_btnMouseExited
        // TODO add your handling code here:
                		

    }//GEN-LAST:event_settings_btnMouseExited

    private void jLabel_TimeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TimeMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel_TimeMouseEntered

    private void jLabel_TimeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_TimeMouseExited

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_TimeMouseExited

    private void rnp_logo_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rnp_logo_homeMouseExited
        rnp_logo_home.setBackground(Color.gray);
    }//GEN-LAST:event_rnp_logo_homeMouseExited

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void Jcombobox_sto_suplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcombobox_sto_suplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jcombobox_sto_suplierActionPerformed

    private void jButton1_addItemToStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_addItemToStoreActionPerformed
        // TODO add your handling code here:
        jButton1_addItemToStore.setBackground(trashbtn);
        this.CreateStoreProductBtnClicked();
    }//GEN-LAST:event_jButton1_addItemToStoreActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateActionPerformed

    private void jButton1_addItemToStoreMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1_addItemToStoreMouseMoved
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButton1_addItemToStoreMouseMoved

    private void rnp_logo_homeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rnp_logo_homeMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_rnp_logo_homeMouseReleased

    private void UpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_UpdateMouseReleased

    private void jButton1_addItemToStoreMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1_addItemToStoreMouseReleased
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jButton1_addItemToStoreMouseReleased

    private void UpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseExited
        // TODO add your handling code here:
      
    }//GEN-LAST:event_UpdateMouseExited

    private void jButton1_addItemToStoreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1_addItemToStoreMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1_addItemToStoreMouseExited

    private void jButton1_addItemToStoreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1_addItemToStoreMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1_addItemToStoreMouseEntered

    private void UpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateMouseEntered

    private void UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseClicked
        // TODO add your handling code here:
       Update.setBackground(updatebtn);   
    }//GEN-LAST:event_UpdateMouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton2_StoreHandoutBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2_StoreHandoutBtnMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2_StoreHandoutBtnMouseMoved

    private void jButton2_StoreHandoutBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2_StoreHandoutBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2_StoreHandoutBtnMouseEntered

    private void jButton2_StoreHandoutBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2_StoreHandoutBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2_StoreHandoutBtnMouseExited

    private void jButton2_StoreHandoutBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2_StoreHandoutBtnMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2_StoreHandoutBtnMouseReleased

    private void jButton2_StoreHandoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_StoreHandoutBtnActionPerformed
        // TODO add your handling code here:
        this.StoreHandoutBtnClicked();
    }//GEN-LAST:event_jButton2_StoreHandoutBtnActionPerformed

    private void home_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseClicked
        // TODO add your handling code here:
        this.Btn_homeclicked(evt);
    }//GEN-LAST:event_home_btnMouseClicked

    private void store_btn_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_store_btn_btnMouseClicked
        // TODO add your handling code here:
        
        this.btn_storeClicked();
     
    }//GEN-LAST:event_store_btn_btnMouseClicked

    private void store_homebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_store_homebtnMouseClicked
        // TODO add your handling code here:
        this.Btn_Store_homeclicked(evt);
    }//GEN-LAST:event_store_homebtnMouseClicked

    private void store_request_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_store_request_btnMouseClicked
        // TODO add your handling code here:
                this.Btn_Storerequest_homeclicked(evt);
                  
    }//GEN-LAST:event_store_request_btnMouseClicked

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton6_addUserMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6_addUserMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6_addUserMouseMoved

    private void jButton6_addUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6_addUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6_addUserMouseEntered

    private void jButton6_addUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6_addUserMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6_addUserMouseExited

    private void jButton6_addUserMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6_addUserMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6_addUserMouseReleased

    private void jButton6_addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6_addUserActionPerformed
        // TODO add your handling code here:
        
        String staffname = staffcombobox.getSelectedItem().toString();
        String username = username1.getText();
        String pass = passwordtextfld.getText();
        String role = rolecombobox.getSelectedItem().toString();
        
        if(staffname.equals("--select role--") || username.isEmpty()|| pass.isEmpty()|| role.equals("--select role--")){
            
        JOptionPane.showMessageDialog(null,"Fileds can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
         
         }else{

             try{  
            String sql = "select UPPER(username) from users_info where UPPER(username) = '"+username+"' ";
            this.pst = this.conn.prepareStatement(sql);
            this.rs = pst.executeQuery();
                         
            if(this.rs.next()){          
          JOptionPane.showMessageDialog(null, "Sorry Username Already Exists");
            }else{
                
              String fname = staffname.substring(0, staffname.indexOf(" "));  //get first name from combobox
             
             String lname = (staffname.substring(staffname.lastIndexOf(" "))).trim();  //get last name from combobox
             
            String user = "select id  from staff_info where first_name= '"+fname+"' and last_name= '"+lname+"' ";
            this.pst2 = this.conn.prepareStatement(user);
            this.rs2 = pst2.executeQuery(); 
                    
             String staffid = null;
            if(rs2.next()){
              staffid = rs2.getString("id");

               }
            
            String sql_staffinfo = "insert into users_info(staff_id,username,password,role_name)values ('"+staffid+"','"+username+"','"+pass+"','"+role+"')";
            this.pst3 = this.conn.prepareStatement(sql_staffinfo);
            this.pst3.execute();
            JOptionPane.showMessageDialog(null, "User is successfully created");
            
            FetchUsersAdmin2(); //Reload data after save user
            
             staffcombobox.setSelectedItem(0);
             username1.setText("");
             passwordtextfld.setText("");
             rolecombobox.setSelectedItem(0);
               
           }          
                   
               }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
         }
        
        }
    }//GEN-LAST:event_jButton6_addUserActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8_addSataffMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8_addSataffMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8_addSataffMouseMoved

    private void jButton8_addSataffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8_addSataffMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8_addSataffMouseEntered

    private void jButton8_addSataffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8_addSataffMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8_addSataffMouseExited

    private void jButton8_addSataffMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8_addSataffMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8_addSataffMouseReleased

    private void jButton8_addSataffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8_addSataffActionPerformed

        // TODO add your handling code here:
           // TODO add your handling code here:
        String fname = jtextf_fname.getText();
        String lname = jtextlname_lname.getText();
        String dpt = jComboBox_department.getSelectedItem().toString();
        String rank = jComboBox_ranks.getSelectedItem().toString();
        if(fname.isEmpty() || lname.isEmpty() || dpt.equals("--select department--") || rank.equals("--select rank--")  ){
            
        JOptionPane.showMessageDialog(null,"Fields can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
         
         }else{

            try{  
            String sql = "select first_name, last_name from staff_info where first_name like '%"+fname+"%' and last_name like '%"+lname+"%' ";
            this.pst = this.conn.prepareStatement(sql);
            this.rs = pst.executeQuery();

            if(this.rs.next()){          
            JOptionPane.showMessageDialog(null, "Sorry the staff s already Exists");
            }else{
            
             String  dept_id  = null;
             String rank_id = null;   
            String sql_dept = "select id from department_info where dept_name = '"+dpt+"' ";
            this.pst2 = this.conn.prepareStatement(sql_dept);
            this.rs2 = pst2.executeQuery(); 
            
            if(rs2.next()){
            dept_id = rs2.getString("id");
            }
            
            String sql_rank = "select id from ranks where rank_name = '"+rank+"' ";
            this.pst3 = this.conn.prepareStatement(sql_rank);
            this.rs3 = pst3.executeQuery();
            if(rs3.next()){
            rank_id = rs3.getString("id");
            }

            String sql2 = "insert into staff_info(dept_id,rank_id,first_name,last_name) values ('"+dept_id+"','"+rank_id+"','" +fname+ "','"+lname+"')";
            this.pst = this.conn.prepareStatement(sql2);
            this.pst.execute();
            JOptionPane.showMessageDialog(null, "Staff is successfully added");
            FetchUsersAdmin(); //Fetch and reload after insert 
            this.jtextf_fname.setText("");
            this.jtextlname_lname.setText("");
            this.jComboBox_department.setSelectedItem(0);
            this.jComboBox_ranks.setSelectedItem(0);
               
           }             
               }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
         }
    }//GEN-LAST:event_jButton8_addSataffActionPerformed
    }                                                  

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void store_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_store_btnMouseClicked
        // TODO add your handling code here:
      this.admin_panel_store.setVisible(true);
      this.admin_panel_users.setVisible(false);
      this.rnp_logo_home.setVisible(false);  
      this.admin_panel_settings.setVisible(false);
    
      this.senioradmin_panel_dash.setVisible(false);  
      this.left_menu_senioradmin.setVisible(false);   
      
      
              

        try {   // populate store data on  jtable

        String sqldata ="select  b.product_name AS Product,b.quantity AS Quantity, b.description AS Description, to_char(b.created_at, 'YYYY-MM-DD HH24:MI') as Date  from supplier_info a left join store_items b on a.id = b.supplier_id order by b.id desc";   
           pst2 = this.conn.prepareStatement(sqldata);
         rs2 = pst2.executeQuery();

      this.jTable_admin_storep.setModel(DbUtils.resultSetToTableModel((ResultSet)this.rs2));
         centerRenderer = new DefaultTableCellRenderer();           
          centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                 this.jTable_admin_storep.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                 this.jTable_admin_storep.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                  this.jTable_admin_storep.setShowGrid(true); 

           } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex);
          }          

    }//GEN-LAST:event_store_btnMouseClicked

    private void settings_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settings_btnMouseClicked
        // TODO add your handling code here:
               this.admin_panel_store.setVisible(false);
               this.admin_panel_users.setVisible(false);
               this.rnp_logo_home.setVisible(false); 
               this.admin_panel_settings.setVisible(true);
               this.hod_panel_items_distribution.setVisible(false);  
               this.left_menu_hod.setVisible(false); 
               this.senioradmin_panel_dash.setVisible(false);  
               this.left_menu_senioradmin.setVisible(false);
               
               FetchSettingsAdmin_Department();
               FetchSettingsAdmin_Ranks();
               FetchSettingsAdmin_Suppliers();
    }//GEN-LAST:event_settings_btnMouseClicked

    private void jtextf_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextf_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextf_fnameActionPerformed

    private void store_btn_btnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_store_btn_btnKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_store_btn_btnKeyPressed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton18MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18MouseReleased

    private void jButton18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18MouseExited

    private void jButton18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18MouseEntered

    private void jButton18MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18MouseMoved
                                           

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15MouseReleased

    private void jButton15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15MouseExited

    private void jButton15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15MouseEntered

    private void jButton15MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15MouseMoved

    private void jButton_addDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addDepartmentActionPerformed
        // TODO add your handling code here:
        String dept = jTextField16_department.getText();
        String desc = jTextField17_description.getText();
        if(dept.equals("Department")  || desc.equals("Description")|| desc.equals("") ||  dept.equals("")){
            
        JOptionPane.showMessageDialog(null,"Some fields info must be filled", "Error", JOptionPane.ERROR_MESSAGE);
         
         }else{
            
            try {
 
                String de ="select dept_name from department_info where UPPER(dept_name) = UPPER('"+dept+"')";                
                this.pst = this.conn.prepareStatement(de);
                rs = this.pst.executeQuery();
                if(rs.next()){
                    
                JOptionPane.showMessageDialog(null,"Department already exists ", "Error", JOptionPane.ERROR_MESSAGE); 
                }
                else{
          
            
            String sql2 = "insert into department_info(dept_name,description) values ('" + dept + "','" + desc + "')";
            this.pst = this.conn.prepareStatement(sql2);
            this.pst.execute();
            JOptionPane.showMessageDialog(null, "Department is successfully Added");
            FetchSettingsAdmin_Department()   ;// Reflesh after saving
            this.jTextField16_department.setText("");
            this.jTextField17_description.setText("") ;
                }

            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        
        }  
        
    }//GEN-LAST:event_jButton_addDepartmentActionPerformed

    private void jButton_addDepartmentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addDepartmentMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_addDepartmentMouseReleased

    private void jButton_addDepartmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addDepartmentMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_addDepartmentMouseExited

    private void jButton_addDepartmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addDepartmentMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_addDepartmentMouseEntered

    private void jButton_addDepartmentMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addDepartmentMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_addDepartmentMouseMoved

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13MouseClicked

    private void jButton_addRankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addRankActionPerformed
        // TODO add your handling code here:
        
        String rank = jTextField14_rankname.getText();
        String desc = jTextField14_desc.getText();
        
        if(rank.isEmpty() || desc.isEmpty()){
            
        JOptionPane.showMessageDialog(null,"Fields can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
         
         }else{
        
             try{
                
            String user ="select rank_name from ranks where UPPER(rank_name) = UPPER('"+rank+"')";                
             this.pst = this.conn.prepareStatement(user);
             rs = this.pst.executeQuery();
             if(rs.next()){
            JOptionPane.showMessageDialog(null, "Rank already exists");
             }else{
                 
            String sql = "insert into ranks (rank_name, description) values ('"+rank+"','"+desc+"') ";
            this.pst = this.conn.prepareStatement(sql);
            this.pst.execute();
            JOptionPane.showMessageDialog(null, "Rank is successfully Added");
            FetchSettingsAdmin_Ranks(); // Reflesh the page after saving the page
            this.jTextField14_rankname.setText("");
            this.jTextField14_desc.setText("") ;

             }
             
            }
           catch(Exception e){
       JOptionPane.showMessageDialog(null,e);
           }
        }
    }//GEN-LAST:event_jButton_addRankActionPerformed

    private void jButton_addRankMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addRankMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_addRankMouseReleased

    private void jButton_addRankMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addRankMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_addRankMouseExited

    private void jButton_addRankMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addRankMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_addRankMouseEntered

    private void jButton_addRankMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_addRankMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_addRankMouseMoved

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jButton19_addsupplierMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19_addsupplierMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19_addsupplierMouseMoved

    private void jButton19_addsupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19_addsupplierMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19_addsupplierMouseEntered

    private void jButton19_addsupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19_addsupplierMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19_addsupplierMouseExited

    private void jButton19_addsupplierMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19_addsupplierMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19_addsupplierMouseReleased

    private void jButton19_addsupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19_addsupplierActionPerformed
        // TODO add your handling code here:
        String fname = jTextField_fname.getText();
        String address = jTextField15_address.getText();
        String lname = jTextField20_lname.getText();
        String phone = jTextField19_phone.getText();
        if(fname.isEmpty() || address.isEmpty() || lname.isEmpty()|| phone.isEmpty()){
            
        JOptionPane.showMessageDialog(null,"Supplier fields can not be empty", "Error", JOptionPane.ERROR_MESSAGE);
         
         }else{
       
            try{
                
            String user ="select first_name, last_name from supplier_info where first_name like '%"+fname+"%' and last_name like '%"+lname+"%' ";                
             this.pst = this.conn.prepareStatement(user);
             rs = this.pst.executeQuery();
             if(rs.next()){
//                 String firstname = rs.getString("first_name");
//            if(firstname.equalsIgnoreCase(fname)&& rs.getString("last_name").equalsIgnoreCase(lname)  ){
            JOptionPane.showMessageDialog(null, "Supplier already exists");
//              }
             }else{
                 
            String sql = "insert into supplier_info (first_name, last_name, phone_number, address) values ('"+fname+"','"+lname+"','"+phone+"','"+address+"') ";
            this.pst = this.conn.prepareStatement(sql);
            this.pst.execute();
            JOptionPane.showMessageDialog(null, "Supplier is successfully Added");
            FetchSettingsAdmin_Suppliers();
            this.jTextField_fname.setText("");
            this.jTextField15_address.setText("") ;
            this.jTextField20_lname.setText("") ;
            this.jTextField19_phone.setText("") ;
            
             }
             
            }
           catch(Exception e){
       JOptionPane.showMessageDialog(null,e);
           }
        
        }
        
    }//GEN-LAST:event_jButton19_addsupplierActionPerformed

    private void jTextField16_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16_departmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16_departmentActionPerformed

    private void jButton19_addsupplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton19_addsupplierKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton19_addsupplierKeyPressed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void hod_hod_homebtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hod_hod_homebtn1MouseClicked
        // TODO add your handling code here:
        this.hodHomeClicked(evt);
    }//GEN-LAST:event_hod_hod_homebtn1MouseClicked

    private void hod_store_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hod_store_btnMouseClicked
        // TODO add your handling code here:
        this.hod_storebtnClicked(evt);
         
        
    }//GEN-LAST:event_hod_store_btnMouseClicked

    private void hod_store_btnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hod_store_btnKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_hod_store_btnKeyPressed

    private void hodstaffitems_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hodstaffitems_btnMouseClicked
        // TODO add your handling code here:
        
        
        this.hodstafffBtnClicked();
        
        
    }//GEN-LAST:event_hodstaffitems_btnMouseClicked

    
    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void senior_homebtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_senior_homebtn2MouseClicked
        // TODO add your handling code here:
        this.SeniorAdminstorehomebtn(evt);
    }//GEN-LAST:event_senior_homebtn2MouseClicked

    private void seniorRequest_store_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seniorRequest_store_btn1MouseClicked
        // TODO add your handling code here:
        this.SeniorAdminRequest();
    }//GEN-LAST:event_seniorRequest_store_btn1MouseClicked

    private void seniorRequest_store_btn1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seniorRequest_store_btn1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_seniorRequest_store_btn1KeyPressed

    private void hod_hod_homebtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hod_hod_homebtn1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_hod_hod_homebtn1MouseEntered

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        
       Login log = new Login();
        log.setVisible(true);
         this.dispose(); 
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton_SendRequest_departmentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SendRequest_departmentbtnActionPerformed
        // TODO add your handling code here:
        this.jButton_SendRequest_departmentbtnClicked(evt);
    }//GEN-LAST:event_jButton_SendRequest_departmentbtnActionPerformed

    private void jButton11_senior_approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11_senior_approveActionPerformed
        // TODO add your handling code here:
           
           
             try {  
           
                if(senior_productname.getText().isEmpty()){ 
                }else{
              String sqldata ="select b.id AS product_id,a.quantity_requested AS Quantity, a.request_status AS Status, c.dept_name  AS Department, a.description AS Description  from department_items a left join store_items b on a.product_id=b.id left join department_info c on a.dept_id = c.id where b.product_name ='"+senior_productname.getText()+"'";   
                 pst2 = this.conn.prepareStatement(sqldata);
              rs2 = pst2.executeQuery();
              if(rs2.next()){
              String productid  =rs2.getString("product_id");
             
               String updatesql = "update department_items set request_status='Approved' where product_id = '"+productid+"' ";
               this.pst2 = this.conn.prepareStatement(updatesql);
              this.pst2.execute();
                senior_productname.setText("");
                senior_quantinty.setText("");
                senior_deptname.setText("");
                senior_desc.setText("");
          
            JOptionPane.showMessageDialog(null, "Request is successfully Approved");

              }
                }
             }
             catch(Exception e)
              {
          JOptionPane.showMessageDialog(null, e);
           }
         
    }//GEN-LAST:event_jButton11_senior_approveActionPerformed

    private void jTable_senior_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_senior_adminMouseClicked
        // TODO add your handling code here:
          int row1 = this.jTable_senior_admin.getSelectedRow();
          String Table_Click = this.jTable_senior_admin.getModel().getValueAt(row1, 0).toString();
          
               try {   // populate requests on senior Administrator jtable
           
            String sqldata ="select  b.product_name AS Product,a.quantity_requested AS Quantity, a.request_status AS Status, c.dept_name  AS Department, a.description AS Description  from department_items a left join store_items b on a.product_id=b.id left join department_info c on a.dept_id = c.id where b.product_name ='"+Table_Click+"' and a.request_status= 'Pending' order by a.id desc ";   
               pst2 = this.conn.prepareStatement(sqldata);
             rs2 = pst2.executeQuery();
            
             if(rs2.next()){
              String productname = rs2.getString("Product");
              senior_productname.setText(productname);
              String quant = rs2.getString("Quantity");
              senior_quantinty.setText(quant);

              String dept = rs2.getString("Department");
                senior_deptname.setText(dept);

              String desc = rs2.getString("Description");
              senior_desc.setText(desc);
             }
      
               } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
              }
               
          
    }//GEN-LAST:event_jTable_senior_adminMouseClicked

    private void senior_deptnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senior_deptnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senior_deptnameActionPerformed

    private void jTable_store_requestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_store_requestsMouseClicked
        // TODO add your handling code here:
        
          int row1 = this.jTable_store_requests.getSelectedRow();
          String Table_Click = this.jTable_store_requests.getModel().getValueAt(row1, 0).toString();
          
               try {   // populate requests on senior Administrator jtable
           
            String sqldata ="select  b.product_name AS Product,a.quantity_requested AS Quantity, a.request_status AS Status, c.dept_name  AS Department, a.description AS Description,to_char(b.created_at, 'YYYY-MM-DD HH24:MI') as Date  from department_items a left join store_items b on a.product_id=b.id left join department_info c on a.dept_id = c.id where b.product_name ='"+Table_Click+"' and a.request_status= 'Approved' order by a.id desc ";   
               pst2 = this.conn.prepareStatement(sqldata);
             rs2 = pst2.executeQuery();
            
             if(rs2.next()){
              String productname = rs2.getString("Product");
              jTextField_storeRequestProduct.setText(productname);
              String quant = rs2.getString("Quantity");
              jTextField_storeQuantity.setText(quant);

              String dept = rs2.getString("Department");
                jTextField_StoreDepartment.setText(dept);

              String desc = rs2.getString("Description");
              jTextArea_Strorecomment.setText(desc);
             }
      
               } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
              }
    }//GEN-LAST:event_jTable_store_requestsMouseClicked

    private void left_menu_hodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_left_menu_hodMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_left_menu_hodMouseClicked

    private void jTextField14_descActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14_descActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14_descActionPerformed

    private void jButton_assignItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_assignItemsActionPerformed
        // TODO add your handling code here:
        jButton_assignItems.setBackground(updatebtn);
        
         try {  
           
                if(quantinty_hod_distrib.getText().isEmpty()){ 
                }else{

             String sqldata ="select  b.product_name AS Product,a.quantity AS deptQuantity , a.id as dept_rowid from department_items a left join store_items b on a.product_id=b.id left join department_info c on a.dept_id = c.id where b.product_name ='"+jComboBox_hod_product_distribu.getSelectedItem().toString()+"' and a.request_status= 'Handed out' ";  
                 pst2 = this.conn.prepareStatement(sqldata);
              rs2 = pst2.executeQuery();
             
              if(rs2.next()){
                  
              int depquant  =rs2.getInt("deptQuantity");
              String dept_rowid  =rs2.getString("dept_rowid");
//              String productid  =rs2.getString("product_id");
            
             
              
              int inputquant = Integer.parseInt(quantinty_hod_distrib.getText());
              
              if(inputquant > depquant){
          JOptionPane.showMessageDialog(null,"You don't have enough Items on this product , request the new ones", "Error", JOptionPane.ERROR_MESSAGE);
              }else{
          
             String staffname = jComboBox_hod_staff_distribu.getSelectedItem().toString();
             String fname = staffname.substring(0, staffname.indexOf(" "));  //get first name from combobox
             String lname = (staffname.substring(staffname.lastIndexOf(" "))).trim();  //get last name from combobox
             
            String user = "select id  from staff_info where first_name= '"+fname+"' and last_name= '"+lname+"' ";
            this.pst2 = this.conn.prepareStatement(user);
            this.rs2 = pst2.executeQuery(); 
                    
            if(rs2.next()){
                          String  staffid = rs2.getString("id");


                  
              
               String insertsqldata = "insert into staff_items(item_id,staff_id,quantity_given)values ('"+dept_rowid+"','"+staffid+"','"+quantinty_hod_distrib.getText()+"')";
               this.pst = this.conn.prepareStatement(insertsqldata);
               this.pst.execute();
               
               int difference = (depquant - inputquant);
               

               
               String updatesql = "update department_items set quantity='"+difference+"' where id = '"+dept_rowid+"' and request_status='Handed out' ";
               this.pst3 = this.conn.prepareStatement(updatesql);
               this.pst3.execute();
//               
                quantinty_hod_distrib.setText("");
               FetchRequestsHod();
            JOptionPane.showMessageDialog(null, "Item is successfully given");
            
              }
              }
              }
                }
             }
             catch(SQLException e)
              {
          JOptionPane.showMessageDialog(null, e);
           }
        
    }//GEN-LAST:event_jButton_assignItemsActionPerformed

    private void quantinty_hod_distribActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantinty_hod_distribActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantinty_hod_distribActionPerformed

    private void hodstaffitems_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hodstaffitems_btnMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_hodstaffitems_btnMouseReleased

    private void jComboBox_hod_staff_distribuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_hod_staff_distribuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_hod_staff_distribuActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
        
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Jcombobox_sto_suplier;
    private javax.swing.JButton Update;
    public javax.swing.JPanel admin_panel_settings;
    public javax.swing.JPanel admin_panel_store;
    public javax.swing.JPanel admin_panel_users;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel current_date_label;
    private javax.swing.JTextField desc_hod;
    private javax.swing.JLabel hod_hod_homebtn1;
    public javax.swing.JPanel hod_panel_items_distribution;
    public javax.swing.JPanel hod_panel_store;
    private javax.swing.JLabel hod_store_btn;
    private javax.swing.JLabel hodstaffitems_btn;
    private javax.swing.JLabel home_btn;
    private javax.swing.JButton jButton11_senior_approve;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19_addsupplier;
    private javax.swing.JButton jButton1_addItemToStore;
    private javax.swing.JButton jButton2_StoreHandoutBtn;
    private javax.swing.JButton jButton6_addUser;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8_addSataff;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton_SendRequest_departmentbtn;
    private javax.swing.JButton jButton_addDepartment;
    private javax.swing.JButton jButton_addRank;
    private javax.swing.JButton jButton_assignItems;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox_department;
    private javax.swing.JComboBox<String> jComboBox_hod_product_distribu;
    private javax.swing.JComboBox<String> jComboBox_hod_staff_distribu;
    private javax.swing.JComboBox<String> jComboBox_productname_hod_store;
    private javax.swing.JComboBox<String> jComboBox_ranks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel40_;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Time;
    public javax.swing.JLabel jLabel_departmentname;
    public javax.swing.JLabel jLabel_deprname_senior;
    public javax.swing.JLabel jLabel_deptid;
    public javax.swing.JLabel jLabel_hod_department;
    public javax.swing.JLabel jLabeldeptid_hod;
    private javax.swing.JPanel jPanel_main_background;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTable_admin_ranks;
    private javax.swing.JTable jTable_admin_storep;
    private javax.swing.JTable jTable_admin_users_logins;
    private javax.swing.JTable jTable_department_admin;
    private javax.swing.JTable jTable_hod_distrib;
    private javax.swing.JTable jTable_hod_requests;
    private javax.swing.JTable jTable_hod_store_requests;
    public javax.swing.JTable jTable_senior_admin;
    private javax.swing.JTable jTable_staff_users;
    private javax.swing.JTable jTable_store;
    private javax.swing.JTable jTable_store_history;
    private javax.swing.JTable jTable_store_requests;
    private javax.swing.JTable jTable_supplier_admin;
    private javax.swing.JTextArea jTextArea_Strorecomment;
    private javax.swing.JTextArea jTextArea_desc;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField14_desc;
    private javax.swing.JTextField jTextField14_rankname;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField15_address;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField16_department;
    private javax.swing.JTextField jTextField17_description;
    private javax.swing.JTextField jTextField19_phone;
    private javax.swing.JTextField jTextField20_lname;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextField_StoreDepartment;
    private javax.swing.JTextField jTextField_fname;
    private javax.swing.JTextField jTextField_storeQuantity;
    private javax.swing.JTextField jTextField_storeRequestProduct;
    private javax.swing.JTextField jtextf_fname;
    private javax.swing.JTextField jtextlname_lname;
    public javax.swing.JPanel left_menu_admin;
    public javax.swing.JPanel left_menu_hod;
    public javax.swing.JPanel left_menu_senioradmin;
    public javax.swing.JPanel left_menu_storekeeper;
    public javax.swing.JLabel names_text_label1;
    private javax.swing.JPasswordField passwordtextfld;
    private javax.swing.JTextField pductname;
    private javax.swing.JTextField proquantity;
    private javax.swing.JTextField quantinty_hod;
    private javax.swing.JTextField quantinty_hod_distrib;
    public javax.swing.JLabel rnp_logo_home;
    public javax.swing.JLabel role_portal_txt;
    private javax.swing.JComboBox<String> rolecombobox;
    private javax.swing.JLabel seniorRequest_store_btn1;
    private javax.swing.JTextField senior_deptname;
    private javax.swing.JTextField senior_desc;
    private javax.swing.JLabel senior_homebtn2;
    private javax.swing.JTextField senior_productname;
    private javax.swing.JTextField senior_quantinty;
    public javax.swing.JPanel senioradmin_panel_dash;
    private javax.swing.JLabel settings_btn;
    private javax.swing.JComboBox<String> staffcombobox;
    private javax.swing.JLabel store_btn;
    private javax.swing.JLabel store_btn_btn;
    private javax.swing.JLabel store_homebtn;
    public javax.swing.JPanel store_panel;
    public javax.swing.JPanel store_panel_requests;
    private javax.swing.JLabel store_request_btn;
    private javax.swing.JPanel store_top_menu;
    private javax.swing.JPanel store_top_menu1;
    private javax.swing.JPanel store_top_menu2;
    private javax.swing.JPanel store_top_menu3;
    private javax.swing.JPanel store_top_menu4;
    private javax.swing.JPanel store_top_menu5;
    private javax.swing.JPanel store_top_menu6;
    private javax.swing.JPanel store_top_menu7;
    public javax.swing.JPanel top_menu;
    private javax.swing.JTextField username1;
    private javax.swing.JLabel users_btn;
    // End of variables declaration//GEN-END:variables

    
    
    
    private void Btn_homeclicked(MouseEvent evt) {

            this.admin_panel_store.setVisible(false);
            this.admin_panel_users.setVisible(false);
            this.rnp_logo_home.setVisible(true); 
            this.admin_panel_settings.setVisible(false);
           
            this.senioradmin_panel_dash.setVisible(false);  
            this.left_menu_senioradmin.setVisible(false);

    }

    private void btn_storeClicked() {
    
               this.store_panel.setVisible(true);
               this.store_panel_requests.setVisible(false);
               this.rnp_logo_home.setVisible(false);  
          
               this.senioradmin_panel_dash.setVisible(false);  
               this.left_menu_senioradmin.setVisible(false);
                
            try {   // populate store data on  jtable
           
            String sqldata ="select  b.product_name AS Product,b.quantity AS Quantity, b.description AS Description, to_char(b.created_at, 'YYYY-MM-DD HH24:MI') as Date  from supplier_info a left join store_items b on a.id = b.supplier_id order by b.id desc";   
                pst2 = this.conn.prepareStatement(sqldata);
                rs2 = pst2.executeQuery();
                this.jTable_store.setModel(DbUtils.resultSetToTableModel((ResultSet)this.rs2));
                centerRenderer = new DefaultTableCellRenderer();           
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                this.jTable_store.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                this.jTable_store.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                this.jTable_store.setShowGrid(true); 
              
                
                
      String datau ="select b.product_name AS Product,a.quantity_requested AS Given, c.dept_name  AS Department, a.request_status AS Status, to_char(a.created_on::date, 'YYYY-MM-DD HH24:MI') as time from department_items_history a left join store_items b on a.product_id=b.id left join department_info c on a.dept_id = c.id where a.request_status='Handed out' order by a.created_on::date desc";   
      pst2 = this.conn.prepareStatement(datau);
      rs2 = pst2.executeQuery();
      this.jTable_store_history.setModel(DbUtils.resultSetToTableModel((ResultSet)this.rs2));
      centerRenderer = new DefaultTableCellRenderer();           
      this.jTable_store_history.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
      this.jTable_store_history.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.gray, 1));
      this.jTable_store_history.setShowGrid(true);     
                
               } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
              }       
    }

    private void Btn_Store_homeclicked(MouseEvent evt) {
         
           this.store_panel.setVisible(false);
           this.store_panel_requests.setVisible(false);
           this.rnp_logo_home.setVisible(true); 
           this.senioradmin_panel_dash.setVisible(false);  
           this.left_menu_senioradmin.setVisible(false);
         }

    private void Btn_Storerequest_homeclicked(MouseEvent evt) {
        
              this.store_panel.setVisible(false);
              this.store_panel_requests.setVisible(true);
              this.rnp_logo_home.setVisible(false);  
              
              this.senioradmin_panel_dash.setVisible(false);  
              this.left_menu_senioradmin.setVisible(false);
               this.FetchStoreData();
    }
    
    
     private void setIcon() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("csms_store.png")));
    }

    private void hodHomeClicked(MouseEvent evt) {

  
              this.rnp_logo_home.setVisible(true);  
              this.hod_panel_store.setVisible(false);  
              this.hod_panel_items_distribution.setVisible(false);  
            
    }

    private void hod_storebtnClicked(MouseEvent evt) {
        
           
              this.rnp_logo_home.setVisible(false);  
              this.hod_panel_store.setVisible(true);  
              this.hod_panel_items_distribution.setVisible(false); 
             
               this.FetchRequestsHod();         

           
    }

    private void hodstafffBtnClicked( ) {
         
            
              this.rnp_logo_home.setVisible(false);     
              this.hod_panel_store.setVisible(false);  
              this.hod_panel_items_distribution.setVisible(true);  
              
                 jComboBox_hod_product_distribu.removeAllItems();

                    try {  // Populate product name on combobox distribution in HOD from database when a product is handed out to department
                
                 String dpid2 = jLabeldeptid_hod.getText();
                 int dpthodid2 =Integer.parseInt(dpid2);

                 String sqld =" select a.id as dept_proid, b.product_name AS Product from department_items a left join store_items b on b.id = a.product_id left join department_info c on c.id = a.dept_id where a.request_status ='Handed out' and c.id='"+dpthodid2+"' ";   
                 pst2 = this.conn.prepareStatement(sqld);
                 rs2 = pst2.executeQuery();
                while(rs2.next()){
                    String pname = rs2.getString("Product");
                    String dept_proid = rs2.getString("dept_proid");
                     
                    jComboBox_hod_product_distribu.insertItemAt(pname,0 );
                 }
               } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
              }
                    
              FetchSHod_StaffDistributions() ;   // Fetch distributed Items to staff
               
 
    }

    private void SeniorAdminstorehomebtn(MouseEvent evt) {

              this.rnp_logo_home.setVisible(true);     
              this.senioradmin_panel_dash.setVisible(false);  
    }

   private void SeniorAdminRequest() {
         this.rnp_logo_home.setVisible(false);     
          this.senioradmin_panel_dash.setVisible(true);       
         
                    try {   // populate requests on  jtable
           
            String sqldata ="select  b.product_name AS Product,a.quantity_requested AS Quantity, a.request_status AS Status, c.dept_name  AS Department, a.description AS Description, to_char(a.created_at, 'YYYY-MM-DD HH24:MI') as Date  from department_items a left join store_items b on a.product_id=b.id left join department_info c on a.dept_id = c.id order by a.id desc";   
               pst2 = this.conn.prepareStatement(sqldata);
             rs2 = pst2.executeQuery();
            
            
       this.jTable_senior_admin.setModel(DbUtils.resultSetToTableModel((ResultSet)this.rs2));
             centerRenderer = new DefaultTableCellRenderer();           
              centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                     this.jTable_senior_admin.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
                     this.jTable_senior_admin.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.gray, 2));
                             this.jTable_senior_admin.setShowGrid(true);      
               } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
              }
                      
                    // display Request status
                    
         
                    
    }

    private void CreateStoreProductBtnClicked() {
       
        String supl = Jcombobox_sto_suplier.getSelectedItem().toString();
        String quantity = proquantity.getText();
        String product = pductname.getText();

        String desc = jTextArea_desc.getText();
        if(product.isEmpty() || quantity.isEmpty() || supl.equals("-- select supplier --") || desc.isEmpty()  ){
        
       JOptionPane.showMessageDialog(null," Fields can not be empty", "Error", JOptionPane.ERROR_MESSAGE);

        }else{
            
            try{  
            String sql = "select  product_name from store_items where product_name ILIKE '%"+product+"%' ";
            this.pst = this.conn.prepareStatement(sql);
            this.rs = pst.executeQuery();
                        
            if(this.rs.next()){          
          JOptionPane.showMessageDialog(null, "Sorry Product Already Exists");
            }else{
                
              String fname = supl.substring(0, supl.indexOf(" "));  //get first name from combobox
             
             String lname = (supl.substring(supl.lastIndexOf(" "))).trim();  //get last name from combobox 
             
            String supplierSql = "select id  from supplier_info where first_name= '"+fname+"' and last_name='"+lname+"' " ;
            this.pst2 = this.conn.prepareStatement(supplierSql);
            this.rs2 = pst2.executeQuery(); 
                    
             String suplierid = null;
            if(rs2.next()){
              suplierid = rs2.getString("id");

               }
            
        String storesql = "insert into store_items (supplier_id, quantity, product_name, description) values ('"+suplierid+"','"+quantity+"','"+product+"','"+desc+"') ";
        this.pst = this.conn.prepareStatement(storesql);
        this.pst.execute();
       
        String storesql_history = "insert into store_items_history (supplier_id, quantity, product_name, description) values ('"+suplierid+"','"+quantity+"','"+product+"','"+desc+"') ";
        this.pst2 = this.conn.prepareStatement(storesql_history);
        this.pst2.execute();

        JOptionPane.showMessageDialog(null, "Product is successfully Added");
        
        btn_storeClicked();   // reload the page after insert
 
        this.Jcombobox_sto_suplier.setSelectedItem(0);
        this.proquantity.setText("") ;
        this.pductname.setText("") ;
        this.jTextArea_desc.setText("") ;
                
             }   
              }
               catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
      
                }

    }
 }

    private void jButton_SendRequest_departmentbtnClicked(ActionEvent evt) {
        
        
        String IntPutquantity = quantinty_hod.getText();
        String product = jComboBox_productname_hod_store.getSelectedItem().toString();
        String hoddesc = desc_hod.getText();
        if(IntPutquantity.isEmpty()  || hoddesc.isEmpty()){
        
       JOptionPane.showMessageDialog(null," Fields can not be empty", "Error", JOptionPane.ERROR_MESSAGE);

        }
        else{
        try{
         String storesql = "select id, quantity  from store_items where product_name= '"+product+"' " ;
         this.pst2 = this.conn.prepareStatement(storesql);
         this.rs2 = pst2.executeQuery();
         if(rs2.next()){
         
         String quant = rs2.getString("quantity");
            int quant2 =0;
           if(quant !=""){
           quant2 = Integer.parseInt(quant);
           }
         int pid = rs2.getInt("id");
         int inpuQuant =Integer.parseInt(IntPutquantity);
         if( quant2 < inpuQuant || quant2 == 0){
      JOptionPane.showMessageDialog(null," Quantity you are requesting is not available", "Error", JOptionPane.ERROR_MESSAGE);
         }else{
        
      String hod_dept_id = jLabel_deptid.getText();
    
      String deptche = "select product_id, dept_id, quantity  from department_items where product_id= '"+pid+"' and dept_id ='"+hod_dept_id+"'" ;
      this.pst3 = this.conn.prepareStatement(deptche);
       this.rs3 = pst3.executeQuery();
       if(rs3.next()){
           
       int quant3 = rs3.getInt("quantity");
       
        //update  requestted quantity quantity  when the product exist already 
           
     String depthist = "update department_items set quantity_requested = '"+IntPutquantity+"',description='"+hoddesc+"',request_status='Pending' where dept_id = '"+hod_dept_id+"' and product_id ='"+pid+"' ";
     this.pst = this.conn.prepareStatement(depthist);
     this.pst.execute();
     
     // copy data to department_items_history for changes track
    String depthist2 = "insert into department_items_history (product_id, dept_id, quantity_requested,quantity, description, request_status) values ('"+pid+"','"+hod_dept_id+"','"+IntPutquantity+"','"+quant3+"','"+hoddesc+"','Pending') ";
    this.pst2 = this.conn.prepareStatement(depthist2);
    this.pst2.execute();
    
     JOptionPane.showMessageDialog(null, "Request is Successfuly sent");
     this.jComboBox_productname_hod_store.setSelectedItem(0);
     this.quantinty_hod.setText("") ;
     this.desc_hod.setText("") ;  
    
       }else{
       
           // Insert request into department items once senior level approves it becomes departments items       
    String dept = "insert into department_items (product_id, dept_id,quantity_requested, description, request_status) values ('"+pid+"','"+hod_dept_id+"','"+IntPutquantity+"','"+hoddesc+"','Pending') ";
    this.pst2 = this.conn.prepareStatement(dept);
    this.pst2.execute();
    
    // copy data to department_items_history for changes track
    String depthist = "insert into department_items_history (product_id, dept_id, quantity_requested, description, request_status) values ('"+pid+"','"+hod_dept_id+"','"+IntPutquantity+"','"+hoddesc+"','Pending') ";
    this.pst = this.conn.prepareStatement(depthist);
    this.pst.execute();
    
      

    JOptionPane.showMessageDialog(null, "Request is Successfuly sent");
    this.jComboBox_productname_hod_store.setSelectedItem(0);
    this.quantinty_hod.setText("") ;
    this.desc_hod.setText("") ;     
       }

         }    
         }
        }catch(SQLException e){
  JOptionPane.showMessageDialog(null, e);
   
         }
        
        }

      }

    private void FetchStoreData() {

             
         try {   // populate requests on Storekeeper jtable
           
               String sqldata ="select  b.product_name AS Product,a.quantity_requested AS Quantity, a.request_status AS Status, c.dept_name  AS Department, a.description AS Description, to_char(b.created_at, 'YYYY-MM-DD HH24:MI') as Date from department_items a left join store_items b on a.product_id=b.id left join department_info c on a.dept_id = c.id where  a.request_status= 'Approved' order by a.id desc ";   
               pst2 = this.conn.prepareStatement(sqldata);
               rs2 = pst2.executeQuery();
               this.jTable_store_requests.setModel(DbUtils.resultSetToTableModel((ResultSet)this.rs2));
               centerRenderer = new DefaultTableCellRenderer();           
                     this.jTable_store_requests.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                     this.jTable_store_requests.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                     this.jTable_store_requests.setShowGrid(true); 
           
                     
                     
               } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
              }
              

    }

    private void StoreHandoutBtnClicked() {

         try{
            if(jTextField_storeRequestProduct.getText().isEmpty()){ 
                }else{

              String sqldata_req ="select  b.id AS productid, a.dept_id, a.quantity_requested AS reqQuantity, a.quantity as deptquantity, b.quantity AS storequantity, a.request_status AS Status, c.dept_name  AS Department, a.description AS Description  from department_items a left join store_items b on a.product_id=b.id left join department_info c on a.dept_id = c.id where b.product_name ='"+jTextField_storeRequestProduct.getText()+"'";   
              pst2 = this.conn.prepareStatement(sqldata_req);
              rs2 = pst2.executeQuery();
              if(rs2.next()){
              
               String productid  =rs2.getString("productid");
               String requested_deptquantity  =rs2.getString("reqQuantity");
               int deptquantity  =rs2.getInt("deptquantity");
               String stoquantity  =rs2.getString("storequantity");
               String dept_id  =rs2.getString("dept_id");
               String desc  =rs2.getString("Description");
               
                 int finaldeptquantity = 0;
                  
                 int balance = 0;
                 
               if(deptquantity !=0){
                   
                    finaldeptquantity = deptquantity +  Integer.parseInt(requested_deptquantity) ;
                    balance = Integer.parseInt(stoquantity) - Integer.parseInt(requested_deptquantity);
                  
                 }else{
               
          
                   finaldeptquantity = 0 +  Integer.parseInt(requested_deptquantity) ;
                   balance = Integer.parseInt(stoquantity) - Integer.parseInt(requested_deptquantity);
                 }
               
               String updatesql_hod = "update department_items set request_status='Handed out' , quantity ='"+finaldeptquantity+"' where product_id = '"+productid+"' and request_status ='Approved' and  dept_id= '"+dept_id+"' ";
               this.pst2 = this.conn.prepareStatement(updatesql_hod);
               this.pst2.execute();
                       
               
               String updatesql_store = "update store_items set quantity='"+balance+"' where id = '"+productid+"' ";
               this.pst2 = this.conn.prepareStatement(updatesql_store);
               this.pst2.execute();
               
               
                // copy data to department_items_history for changes track
              String depthist = "insert into department_items_history (product_id, dept_id,quantity, quantity_requested, description, request_status) values ('"+productid+"','"+dept_id+"','"+deptquantity+"','"+requested_deptquantity+"','"+desc+"','Handed out') ";
              this.pst = this.conn.prepareStatement(depthist);
              this.pst.execute();
    
               
               
                jTextField_storeRequestProduct.setText("");
                jTextField_storeQuantity.setText("");
                jTextField_StoreDepartment.setText("");
                jTextArea_Strorecomment.setText("");
          
            JOptionPane.showMessageDialog(null, "Request is successfully Handed out");
            this.FetchStoreData();

               
              }
                }
             }
             catch(Exception e)
              {
          JOptionPane.showMessageDialog(null, e);
           }
              
     }

    private void FetchRequestsHod() {
        
              jComboBox_productname_hod_store.removeAllItems();

                try {   

          // Populate store items  on combobox from database
            String un ="select id, product_name from store_items";   
             pst2 = this.conn.prepareStatement(un);
             rs2 = pst2.executeQuery();

            while(rs2.next()){
                String product = rs2.getString("product_name");
                jComboBox_productname_hod_store.insertItemAt(product,0);
            }
                
                        
           // populate requests on  Hod pending requests  jtables 
            String sqldata ="select  b.product_name AS Product,a.quantity_requested AS Quantity, a.request_status AS Status, c.dept_name  AS Department, a.description AS Description, to_char(a.created_at, 'YYYY-MM-DD HH24:MI') as Date  from department_items a left join store_items b on a.product_id=b.id left join department_info c on a.dept_id = c.id where a.request_status !='Handed out'  order by a.id desc";   
               pst2 = this.conn.prepareStatement(sqldata);
             rs2 = pst2.executeQuery();

          this.jTable_hod_requests.setModel(DbUtils.resultSetToTableModel((ResultSet)this.rs2));
             centerRenderer = new DefaultTableCellRenderer();           
              centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                     this.jTable_hod_requests.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
                     this.jTable_hod_requests.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.gray, 2));
                             this.jTable_hod_requests.setShowGrid(true); 
            
                               
            // populate requests on  Hod handed out requests  jtables 
        String sqldata2 = "select b.product_name AS Product, a.quantity AS quantity, c.dept_name  AS Department, to_char(a.created_at, 'YYYY-MM-DD HH24:MI') AS Date from department_items a left join store_items b on a.product_id=b.id left join department_info c on a.dept_id = c.id where a.dept_id ='"+jLabel_deptid.getText()+"'";
         pst3 = this.conn.prepareStatement(sqldata2);
         rs3 = pst3.executeQuery();
         this.jTable_hod_store_requests.setModel(DbUtils.resultSetToTableModel((ResultSet)this.rs3));
         centerRenderer = new DefaultTableCellRenderer();           
         centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                this.jTable_hod_store_requests.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
                this.jTable_hod_store_requests.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.gray, 2));
                        this.jTable_hod_store_requests.setShowGrid(true); 
                        
                
                } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
              }
                    
          
                
    }

    private void FetchUsersAdmin() {
 
                    try {   // staff information to  jtable
           
            String sqldata ="SELECT a.dept_name as Department, b.rank_name as Rank,c.first_name As Fname, c.last_name as Lname, to_char(c.created_at, 'YYYY-MM-DD HH24:MI') as Date FROM staff_info c left join ranks b on b.id=c.rank_id left join department_info a on a.id=c.dept_id";   
               pst2 = this.conn.prepareStatement(sqldata);
             rs2 = pst2.executeQuery();
            
            
            this.jTable_staff_users.setModel(DbUtils.resultSetToTableModel((ResultSet)this.rs2));
             centerRenderer = new DefaultTableCellRenderer();           
              centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                     this.jTable_staff_users.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
                     this.jTable_staff_users.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.gray, 2));
                             this.jTable_staff_users.setShowGrid(true); 
               } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
              }
                
    }
    private void FetchUsersAdmin2() {
 
                    try {   // staff information to  jtable
           
            String sqldata ="SELECT a.first_name as Fname,a.last_name as Lname, b.username, b.role_name as role, b.password FROM users_info b left join staff_info a on a.id=b.staff_id";   
               pst2 = this.conn.prepareStatement(sqldata);
             rs2 = pst2.executeQuery();
            
            
            this.jTable_admin_users_logins.setModel(DbUtils.resultSetToTableModel((ResultSet)this.rs2));
             centerRenderer = new DefaultTableCellRenderer();           
              centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                     this.jTable_admin_users_logins.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
                     this.jTable_admin_users_logins.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.gray, 2));
                             this.jTable_admin_users_logins.setShowGrid(true); 
               } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
              }
                
    }

    private void FetchSettingsAdmin_Department() {
        
            try {   // staff information to  jtable
           
               String sqldata ="SELECT dept_name as Department,description, to_char(created_at, 'YYYY-MM-DD HH24:MI') as Date FROM department_info";   
               pst2 = this.conn.prepareStatement(sqldata);
               rs2 = pst2.executeQuery();
            
            
            this.jTable_department_admin.setModel(DbUtils.resultSetToTableModel((ResultSet)this.rs2));
             centerRenderer = new DefaultTableCellRenderer();           
              centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                     this.jTable_department_admin.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                     this.jTable_department_admin.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                             this.jTable_department_admin.setShowGrid(true); 
               } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
              }
    }
    
    
    private void FetchSettingsAdmin_Ranks() {
        
            try {   // staff information to  jtable
           
               String sqldata;   
                sqldata = "SELECT rank_name as Rank,description, to_char(created_at, 'YYYY-MM-DD HH24:MI') as Date FROM ranks";
               pst2 = this.conn.prepareStatement(sqldata);
               rs2 = pst2.executeQuery();
            
            
            this.jTable_admin_ranks.setModel(DbUtils.resultSetToTableModel((ResultSet)this.rs2));
             centerRenderer = new DefaultTableCellRenderer();           
              centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                     this.jTable_admin_ranks.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                     this.jTable_admin_ranks.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                             this.jTable_admin_ranks.setShowGrid(true); 
               } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
              }
    }
    
    private void FetchSettingsAdmin_Suppliers() {
        
            try {   // supplier information to  jtable
           
               String sqldata;   
                sqldata = "SELECT first_name as Fname ,last_name as Lname, phone_number as Phone,address, to_char(created_at, 'YYYY-MM-DD HH24:MI') as Date FROM supplier_info";
               pst2 = this.conn.prepareStatement(sqldata);
               rs2 = pst2.executeQuery();
            
            
            this.jTable_supplier_admin.setModel(DbUtils.resultSetToTableModel((ResultSet)this.rs2));
             centerRenderer = new DefaultTableCellRenderer();           
              centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                     this.jTable_supplier_admin.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                     this.jTable_supplier_admin.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                             this.jTable_supplier_admin.setShowGrid(true); 
               } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
              }
    }
    
    private void FetchSHod_StaffDistributions() {

            try {   // Staff distribution of Items  information to  jtable
           
               String sqldata = "select a.product_name , b.first_name as Fname, b.last_name, c.quantity_given, e.dept_name as Department, to_char(c.created_at, 'YYYY-MM-DD HH24:MI') as Date  from staff_items c left join department_items d on d.id=c.item_id left join store_items a on a.id=d.product_id left join staff_info b on b.id=c.staff_id left join department_info e on e.id = b.dept_id where b.dept_id ='"+jLabeldeptid_hod.getText()+"'";   
               pst2 = this.conn.prepareStatement(sqldata);
               rs2 = pst2.executeQuery();
            
            
            this.jTable_hod_distrib.setModel(DbUtils.resultSetToTableModel((ResultSet)this.rs2));
             centerRenderer = new DefaultTableCellRenderer();           
              centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                     this.jTable_hod_distrib.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                     this.jTable_hod_distrib.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                             this.jTable_hod_distrib.setShowGrid(true); 
               } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
              }
            
               jComboBox_hod_staff_distribu.removeAllItems();

              try {// Populate staff for hod info on   combobox hat list staff information from database 
                String un ="select id, first_name, last_name from staff_info where dept_id='"+jLabeldeptid_hod.getText()+"'";   
                 pst2 = this.conn.prepareStatement(un);
                 rs2 = pst2.executeQuery();
                 

                while(rs2.next()){
                    String fname = rs2.getString("first_name");
                    String lname = rs2.getString("last_name");
                    staffcombobox.insertItemAt(fname+" " +lname,1 );  
                    jComboBox_hod_staff_distribu.insertItemAt(fname+" " +lname,0 );
                }
               } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
              }
    }
    
    
     
}
