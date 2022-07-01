/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package restaurant.management.system;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import dao.BillDao;
import dao.CategoryDao;
import dao.ProductDao;
import common.OpenPdf;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Product;
import model.Category;
import model.Bill;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author mohamedkhaled
 */
public class PlaceOrder extends javax.swing.JFrame {

    public String email;
    public String balance1;

    public String userEmail;
    public int billId = 1;
    public int grandTotal = 0;
    public int productPrice = 0;
    public int productTotal = 0;

    /**
     * Creates new form PlaceOrder
     */
    public PlaceOrder() {
        initComponents();
    }

    public PlaceOrder(String email) {
        initComponents();
        txtProName.setEditable(false);
        txtProTotal.setEditable(false);
        txtProPrice.setEditable(false);
        btnAddToCart.setEnabled(false);
        btnGenerateBillPrint.setEnabled(false);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) jSpinner1.getEditor()).getTextField();
        tf.setEditable(false);
        userEmail = email;
    }

    public PlaceOrder(String email, String balance) {
        initComponents();
        this.email = email;
        this.balance1 = balance;
        balanceTxt.setText(balance1);
    }

    public void productNameByCategory(String category) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);

        //ArrayList<Product>list;
        //=ProductDao.getAllRecordsByCategory(category);
        final String HOST = LoginClient.HOST;
        final int PORT = 4040;
        JSONObject obj = new JSONObject();
        obj.put("type", "getProductByCategory");
        obj.put("category", category);

        try (
                 Socket socket = new Socket(HOST, PORT);  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  Scanner in = new Scanner(socket.getInputStream());) {
            out.println(obj.toString());
            System.out.println(obj.toString());

            String input = in.nextLine();
            input = input.substring(1, input.length() - 1);
            System.out.println("hi: " + input);

            ArrayList<String> list = new ArrayList<String>(Arrays.asList(input.split(", ")));
            System.out.println("List: " + list);

            // Iterator <String>itr=list.iterator();
            //while(itr.hasNext()){
            //    //Product productObj=itr.next();
            //    dtm.addRow(new Object[]{productObj.getName()});
            // }
            for (String i : list) {
                // Printing the elements of ArrayList
                dtm.addRow(new Object[]{i});
                System.out.println(i + " ");
            }

        } catch (IOException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearProductFields() {

        txtProName.setText("");
        txtProPrice.setText("");
        jSpinner1.setValue(1);
        txtProTotal.setText("");
        btnAddToCart.setEnabled(false);

    }

    public void validateField() {
        String customerName = txtCusName.getText();
        String customerMobileNumber = txtCusMobileNo.getText();
        String customerEmail = txtCusMobileNo.getText();
        if (!customerEmail.equals("") && !(customerMobileNumber == "") && customerMobileNumber.length() == 11 && !(customerEmail == "") && grandTotal > 0) {
            btnGenerateBillPrint.setEnabled(true);
        } else {
            btnGenerateBillPrint.setEnabled(false);
        }

    }

    public void filterProductByname(String name, String category) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);

        final String HOST = LoginClient.HOST;
        final int PORT = 4040;
        JSONObject obj = new JSONObject();
        obj.put("type", "filterProductByname");
        obj.put("category", category);
        obj.put("name", name);

        try (
                 Socket socket = new Socket(HOST, PORT);  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  Scanner in = new Scanner(socket.getInputStream());) {
            out.println(obj.toString());
            System.out.println(obj.toString());

            String input = in.nextLine();
            input = input.substring(1, input.length() - 1);
            ArrayList<String> list = new ArrayList<String>(Arrays.asList(input.split(",")));
            System.out.println("List: " + list);

            // Iterator <String>itr=list.iterator();
            //while(itr.hasNext()){
            //    //Product productObj=itr.next();
            //    dtm.addRow(new Object[]{productObj.getName()});
            // }
            for (String i : list) {
                // Printing the elements of ArrayList
                dtm.addRow(new Object[]{i});
                System.out.println(i + " ");
            }

        } catch (IOException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* ArrayList<Product>list=ProductDao.filterProductByname(name,category);
        Iterator <Product>itr=list.iterator();
        while(itr.hasNext()){
            Product productObj=itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCusName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCusMobileNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCusEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtProName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtProPrice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        txtProTotal = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnAddToCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        lblGrandTotal = new javax.swing.JLabel();
        btnGenerateBillPrint = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        balanceTxt = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        PlaceOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Place Order");

        jButton1.setText("close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Bill ID :");

        jLabel3.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel3.setText("Customer Details");

        jLabel4.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel4.setText("Name");

        txtCusName.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        txtCusName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCusNameKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel5.setText("Mobile No.");

        txtCusMobileNo.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        txtCusMobileNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCusMobileNoActionPerformed(evt);
            }
        });
        txtCusMobileNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCusMobileNoKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel6.setText("Email Address");

        txtCusEmail.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        txtCusEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCusEmailKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel7.setText("Category");

        jComboBox1.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel8.setText("Search");

        txtSearch.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Name");

        txtProName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProNameActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Price");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Quantity");

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Total");

        btnClear.setText("clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnAddToCart.setText("add to cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "price", "quantity", "total price"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("grand total");

        lblGrandTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGrandTotal.setText("000");

        btnGenerateBillPrint.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGenerateBillPrint.setText("generate bill");
        btnGenerateBillPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBillPrintActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("--");

        balanceTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel15.setText("Balance :");

        PlaceOrder.setText("Place Order");
        PlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaceOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCusName, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtCusMobileNo)
                            .addComponent(txtCusEmail))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel15)
                        .addGap(26, 26, 26)
                        .addComponent(balanceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerateBillPrint)
                        .addGap(29, 29, 29)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtProName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtProPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(121, 121, 121))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(btnClear)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(32, 32, 32)
                                .addComponent(lblGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(PlaceOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtProTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addComponent(btnAddToCart, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton1)))
                .addGap(2, 2, 2)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel33)
                            .addComponent(txtProName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel11)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnClear)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txtProTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddToCart))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCusMobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtCusEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(179, 179, 179)
                                .addComponent(balanceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(244, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblGrandTotal)
                            .addComponent(PlaceOrder)
                            .addComponent(btnGenerateBillPrint))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCusMobileNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCusMobileNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCusMobileNoActionPerformed

    private void txtProNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Home(email, balance1).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        
        final String HOST = "192.168.1.104";
        final int PORT = 4040;
        JSONObject obj = new JSONObject();
        obj.put("type", "categoryfill");

        try (
                 Socket socket = new Socket(HOST, PORT);  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  Scanner in = new Scanner(socket.getInputStream());) {
            out.println(obj.toString());
            System.out.println(obj.toString());

            String input = in.nextLine();
            input = input.substring(1, input.length() - 1);
            System.out.println("hi: " + input);

            ArrayList<String> list = new ArrayList<>(Arrays.asList(input.split(", ")));
            System.out.println("List: " + list);

            // Iterator <String>itr=list.iterator();
            //while(itr.hasNext()){
            //    //Product productObj=itr.next();
            //    dtm.addRow(new Object[]{productObj.getName()});
            // }
            for (String i : list) {
                // Printing the elements of ArrayList
                jComboBox1.addItem(i);
                System.out.println(i + " ");
            }

        } catch (IOException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //ArrayList<Category> list = CategoryDao.getAllRecords();
        //Iterator<Category> itr = list.iterator();
        //while (itr.hasNext()) {
        //    Category categoryObj = itr.next();
        //    jComboBox1.addItem(categoryObj.getName());

       // }
        
        
        
        
             
        
        
        
        /*billId = Integer.parseInt(BillDao.getId());
        jLabel33.setText(BillDao.getId());// in video it was jlabel13 but here its name is jlabel33
        ArrayList<Category> list = CategoryDao.getAllRecords();
        Iterator<Category> itr = list.iterator();
        while (itr.hasNext()) {
            Category categoryObj = itr.next();
            jComboBox1.addItem(categoryObj.getName());

        }*/
        String category = (String) jComboBox1.getSelectedItem(); //at minute 1:02:25
        while(category==null){
            category = (String) jComboBox1.getSelectedItem();
        }
        productNameByCategory(category);
        
        
        
        
        
    }//GEN-LAST:event_formComponentShown

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String name = txtSearch.getText();
        String category = (String) jComboBox1.getSelectedItem();
        filterProductByname(name, category);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String productName = model.getValueAt(index, 0).toString();

        final String HOST = LoginClient.HOST;
        final int PORT = 4040;
        JSONObject obj = new JSONObject();
        JSONObject obj1 = new JSONObject();
        obj.put("type", "getProductByname");
        obj.put("productname", productName);
        System.out.println(obj.toString() + "hi");

        try (
                 Socket socket = new Socket(HOST, PORT);  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  Scanner in = new Scanner(socket.getInputStream());) {
            out.println(obj.toString());
            System.out.println(obj.toString());

            String input = in.nextLine();
            System.out.println(input);

            JSONParser parser = new JSONParser();
            try {
                obj1 = (JSONObject) parser.parse(input);
                String name1 = (String) obj1.get("name");
                String price1 = (String) obj1.get("price");

                txtProName.setText(name1);
                txtProPrice.setText(price1);
                jSpinner1.setValue(1);
                txtProTotal.setText(price1);
                productPrice = Integer.parseInt(price1);
                productTotal = Integer.parseInt(price1);
                btnAddToCart.setEnabled(true);
            } catch (ParseException ex) {
                Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Product product = ProductDao.getProductByname(productName);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        int quantity = (Integer) jSpinner1.getValue();
        if (quantity <= 1) {
            jSpinner1.setValue(1);
            quantity = 1;
        }
        productTotal = productPrice * quantity;
        txtProTotal.setText(String.valueOf(productTotal)); //go to login and run


    }//GEN-LAST:event_jSpinner1StateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        String name = txtProName.getText();
        String price = txtProPrice.getText();
        String quantity = String.valueOf(jSpinner1.getValue());
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.addRow(new Object[]{name, price, quantity, productTotal});
        grandTotal = grandTotal + productTotal;
        lblGrandTotal.setText(String.valueOf(grandTotal));
        clearProductFields();
        validateField();

    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearProductFields();

    }//GEN-LAST:event_btnClearActionPerformed

    private void txtCusNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusNameKeyReleased
        // TODO add your handling code here:
        validateField();

    }//GEN-LAST:event_txtCusNameKeyReleased

    private void txtCusMobileNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusMobileNoKeyReleased
        // TODO add your handling code here:
        validateField();

    }//GEN-LAST:event_txtCusMobileNoKeyReleased

    private void txtCusEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusEmailKeyReleased
        // TODO add your handling code here:
        validateField();

    }//GEN-LAST:event_txtCusEmailKeyReleased

    private void btnGenerateBillPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBillPrintActionPerformed
        // TODO add your handling code here:
        String customerName = txtCusName.getText();
        String customerMobileNumber = txtCusMobileNo.getText();
        String customerEmail = txtCusEmail.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String todaydate = dFormat.format(date);
        String total = String.valueOf(grandTotal);
        String createdBy = userEmail;
        Bill bill = new Bill();
        bill.setId(billId);
        bill.setName(customerName);
        bill.setMobileNumber(customerMobileNumber);
        bill.setEmail(customerEmail);
        bill.setDate(todaydate);
        bill.setTotal(total);
        bill.setCreatedBy(createdBy);
        BillDao.save(bill);
        //Creating documnet
        String path = "C:\\Users\\khaled\\Desktop\\New folder (8)";      //path
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "" + billId + ".pdf"));
            doc.open();
            Paragraph cafeName = new Paragraph("                                                                    Market Place Mangment System\n");
            doc.add(cafeName);
            Paragraph starLine = new Paragraph("****************************************************************************************************************");
            doc.add(starLine);
            Paragraph paragraph3 = new Paragraph("\tBill ID" + billId + "\nCustomer Name: " + customerName + "\nTotal Paid: " + grandTotal);
            doc.add(paragraph3);
            doc.add(starLine);
            PdfPTable tb1 = new PdfPTable(4);
            tb1.addCell("Name");
            tb1.addCell("Price");
            tb1.addCell("Quantity");
            tb1.addCell("Total");
            for (int i = 0; i < jTable2.getRowCount(); i++) {  //i changed it
                String n = jTable2.getValueAt(i, 0).toString();//name
                String d = jTable2.getValueAt(i, 1).toString();//price
                String r = jTable2.getValueAt(i, 2).toString();//quantity              
                String q = jTable2.getValueAt(i, 3).toString();//total price
                tb1.addCell(n);
                tb1.addCell(d);
                tb1.addCell(r);
                tb1.addCell(q);

            }
            doc.add(tb1);
            doc.add(starLine);
            Paragraph thanksMsg = new Paragraph("Thank you, Please visit Again");
            doc.add(thanksMsg);
            OpenPdf.openById(String.valueOf(billId));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        doc.close();
        setVisible(false);
        new PlaceOrder(createdBy).setVisible(true);


    }//GEN-LAST:event_btnGenerateBillPrintActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int index = jTable2.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this product", "select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = jTable2.getModel();
            String total = model.getValueAt(index, 3).toString();
            grandTotal = grandTotal - Integer.parseInt(total);
            lblGrandTotal.setText(String.valueOf(grandTotal));
            ((DefaultTableModel) jTable2.getModel()).removeRow(index);

        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void PlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaceOrderActionPerformed
        // TODO add your handling code here:      
        String total = String.valueOf(grandTotal);
        if (Integer.parseInt(total) < Integer.parseInt(balance1)) {

            final String HOST = LoginClient.HOST;
            final int PORT = 4040;
            JSONObject obj = new JSONObject();          
            obj.put("type", "placeorder");
            obj.put("total", total);
            obj.put("email", email);
           

            try (
                 Socket socket = new Socket(HOST, PORT);  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  Scanner in = new Scanner(socket.getInputStream());) {
                out.println(obj.toString());
                System.out.println(obj.toString());

                

                

            } catch (IOException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_PlaceOrderActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PlaceOrder;
    private javax.swing.JLabel balanceTxt;
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGenerateBillPrint;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JTextField txtCusEmail;
    private javax.swing.JTextField txtCusMobileNo;
    private javax.swing.JTextField txtCusName;
    private javax.swing.JTextField txtProName;
    private javax.swing.JTextField txtProPrice;
    private javax.swing.JTextField txtProTotal;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
