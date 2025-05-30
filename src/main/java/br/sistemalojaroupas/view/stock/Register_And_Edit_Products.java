package br.sistemalojaroupas.view.stock;

import br.sistemalojaroupas.model.dao.BrandDao;
import br.sistemalojaroupas.model.dao.CategoryDao;
import br.sistemalojaroupas.model.dao.ColorDao;
import br.sistemalojaroupas.model.dao.ProductDao;
import br.sistemalojaroupas.model.entities.Brand;
import br.sistemalojaroupas.model.entities.Category;
import br.sistemalojaroupas.model.entities.Product;
import br.sistemalojaroupas.view.util.ComboBoxRenderer;
import br.sistemalojaroupas.model.entities.Color;
import br.sistemalojaroupas.view.listeners.DataChangeListener;
import br.sistemalojaroupas.view.util.Utils;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Register_And_Edit_Products extends javax.swing.JDialog {
    
    private Product product;
    private List<DataChangeListener> listeners = new ArrayList<>();
    /**
     * Creates new form Register_Products
     */
    
    public Register_And_Edit_Products(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();   
        
        this.setBackground(new java.awt.Color(0,0,0,0));
        pnl_Background.setBackground(new java.awt.Color(0,0,0,0));
        
        initializeAllComboBox();
        setAllComboBoxRenderer();
    }
    
    public Register_And_Edit_Products(java.awt.Dialog owner, boolean modal, Product product) {
        super(owner, modal);
        initComponents();
        
        this.setBackground(new java.awt.Color(0,0,0,0));
        pnl_Background.setBackground(new java.awt.Color(0,0,0,0));
        
        this.product = product;
        
        txt_description.setText(product.getDescription());
        txtf_costPrice.setValue(product.getCostPrice());
        txtf_salePrice.setValue(product.getSalePrice());
        txtf_quantity.setValue(product.getQuantity());
        title.setText("Editar produto");
        
        setAllComboBoxRenderer();
        
        initializeAllComboBox();
        
        cbColor.setSelectedItem(product.getColor());
        cbCategory.setSelectedItem(product.getCategory());
        cbSize.setSelectedItem(product.getSize());
        cbBrand.setSelectedItem(product.getBrand());
    }
    
    public void subscribeDataChangeListener(DataChangeListener listener) {
        listeners.add(listener);
    }
    
    private void notifyDataChangeListeners() {
        listeners.forEach(listener ->{
            listener.onDataChanged();
        });
    }
    
    private void setAllComboBoxRenderer() {
        for (Component c : pnl_Background.getComponents()) {
            if (c instanceof JComboBox) ((JComboBox)c).setRenderer(new ComboBoxRenderer());
        }
    }
    
    private void initializeAllComboBox() {
        Utils.updateComboBox(ColorDao.findAll(), cbColor);
        Utils.updateComboBox(CategoryDao.findAll(), cbCategory);
        Utils.updateComboBox(BrandDao.findAll(), cbBrand);
    }

    public JComboBox<Object> getCbCategory() {
        return cbCategory;
    }

    public JComboBox<Object> getCbColor() {
        return cbColor;
    }
    
    public JComboBox<Object> getCbBrand() {
        return cbBrand;
    }
    
    private Product instantiateProduct(Product p) {
        Double costPrice = Utils.tryParseToDouble(txtf_costPrice.getText().replace(',', '.'));
        Double salePrice = Utils.tryParseToDouble(txtf_salePrice.getText().replace(',', '.'));
        
        p.setDescription(txt_description.getText().toUpperCase());
        p.setCategory((Category) cbCategory.getSelectedItem());
        p.setColor((Color) cbColor.getSelectedItem());
        p.setQuantity(Utils.tryParseToInt(txtf_quantity.getText()));
        p.setCostPrice(costPrice);
        p.setSalePrice(salePrice);
        p.setSize((String) cbSize.getSelectedItem());
        p.setBrand((Brand) cbBrand.getSelectedItem());
        
        return p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_Background = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_description = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbSize = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtf_salePrice = new javax.swing.JFormattedTextField();
        txtf_costPrice = new javax.swing.JFormattedTextField();
        txtf_quantity = new javax.swing.JFormattedTextField();
        bnt_save = new javax.swing.JLabel();
        btn_clear = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JLabel();
        cbColor = new javax.swing.JComboBox<>();
        cbCategory = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btn_addCategory = new javax.swing.JLabel();
        btn_addColor = new javax.swing.JLabel();
        btn_editCategory = new javax.swing.JLabel();
        btn_editColor = new javax.swing.JLabel();
        btn_addBrand = new javax.swing.JLabel();
        btn_editBrand = new javax.swing.JLabel();
        cbBrand = new javax.swing.JComboBox<>();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pnl_Background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_BackgroundMouseClicked(evt);
            }
        });
        pnl_Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 51));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Cadastrar novo produto");
        pnl_Background.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 613, 40));

        jLabel8.setBackground(new java.awt.Color(59, 44, 150));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Descrição:");
        jLabel8.setOpaque(true);
        pnl_Background.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, 30));

        txt_description.setBackground(new java.awt.Color(0, 0, 51));
        txt_description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_description.setForeground(new java.awt.Color(255, 255, 255));
        txt_description.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_description.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        txt_description.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_description.setOpaque(false);
        pnl_Background.add(txt_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 460, 30));

        jLabel9.setBackground(new java.awt.Color(59, 44, 150));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Cor:");
        jLabel9.setOpaque(true);
        pnl_Background.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 90, 30));

        jLabel6.setBackground(new java.awt.Color(59, 44, 150));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Marca:");
        jLabel6.setOpaque(true);
        pnl_Background.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 70, 30));

        cbSize.setBackground(new java.awt.Color(0, 0, 51));
        cbSize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbSize.setForeground(new java.awt.Color(255, 255, 255));
        cbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "PP", "P", "M", "G", "GG", "XG", "XGG", "XGGG", "U", "1", "2", "3", "4", "5", "6", "7", "8", "10", "12", "14", "16", "32", "34", "36", "38", "40", "42", "44", "46", "48", "50", "52", "54", "56", "58", "60" }));
        pnl_Background.add(cbSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 140, 30));

        jLabel2.setBackground(new java.awt.Color(59, 44, 150));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Categoria:");
        jLabel2.setOpaque(true);
        pnl_Background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 90, 30));

        jLabel4.setBackground(new java.awt.Color(59, 44, 150));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("P. de custo:");
        jLabel4.setOpaque(true);
        pnl_Background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 90, 30));

        jLabel7.setBackground(new java.awt.Color(59, 44, 150));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("P. de venda:");
        jLabel7.setOpaque(true);
        pnl_Background.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 90, 30));

        jLabel5.setBackground(new java.awt.Color(59, 44, 150));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Qtd.:");
        jLabel5.setOpaque(true);
        pnl_Background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 50, 30));

        txtf_salePrice.setBackground(new java.awt.Color(0, 0, 51));
        txtf_salePrice.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        txtf_salePrice.setForeground(new java.awt.Color(255, 255, 255));
        txtf_salePrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtf_salePrice.setOpaque(false);
        pnl_Background.add(txtf_salePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 100, 30));

        txtf_costPrice.setBackground(new java.awt.Color(0, 0, 51));
        txtf_costPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        txtf_costPrice.setForeground(new java.awt.Color(255, 255, 255));
        txtf_costPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtf_costPrice.setOpaque(false);
        pnl_Background.add(txtf_costPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 100, 30));

        txtf_quantity.setBackground(new java.awt.Color(0, 0, 51));
        txtf_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(108, 81, 233)));
        txtf_quantity.setForeground(new java.awt.Color(255, 255, 255));
        txtf_quantity.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtf_quantity.setOpaque(false);
        pnl_Background.add(txtf_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 80, 30));

        bnt_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvarClaro.png"))); // NOI18N
        bnt_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnt_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bnt_saveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bnt_saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bnt_saveMouseExited(evt);
            }
        });
        pnl_Background.add(bnt_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, 30));

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_limparClaro.png"))); // NOI18N
        btn_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_clearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_clearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_clearMouseExited(evt);
            }
        });
        pnl_Background.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, -1));

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_cancelarClaro.png"))); // NOI18N
        btn_cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelMouseExited(evt);
            }
        });
        pnl_Background.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));

        cbColor.setBackground(new java.awt.Color(0, 0, 51));
        cbColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbColor.setForeground(new java.awt.Color(255, 255, 255));
        pnl_Background.add(cbColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 120, 30));

        cbCategory.setBackground(new java.awt.Color(0, 0, 51));
        cbCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbCategory.setForeground(new java.awt.Color(255, 255, 255));
        cbCategory.setToolTipText("");
        pnl_Background.add(cbCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 120, 30));

        jLabel10.setBackground(new java.awt.Color(59, 44, 150));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Tamanho:");
        jLabel10.setOpaque(true);
        pnl_Background.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 70, 30));

        btn_addCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_addCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_mais.png"))); // NOI18N
        btn_addCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_addCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addCategoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addCategoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addCategoryMouseExited(evt);
            }
        });
        pnl_Background.add(btn_addCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 30, 30));

        btn_addColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_addColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_mais.png"))); // NOI18N
        btn_addColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_addColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addColorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addColorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addColorMouseExited(evt);
            }
        });
        pnl_Background.add(btn_addColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 30, 30));

        btn_editCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_editCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_19px.png"))); // NOI18N
        btn_editCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_editCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editCategoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editCategoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editCategoryMouseExited(evt);
            }
        });
        pnl_Background.add(btn_editCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 30, 30));

        btn_editColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_editColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_19px.png"))); // NOI18N
        btn_editColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_editColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editColorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editColorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editColorMouseExited(evt);
            }
        });
        pnl_Background.add(btn_editColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 30, 30));

        btn_addBrand.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_addBrand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_mais.png"))); // NOI18N
        btn_addBrand.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_addBrand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addBrandMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addBrandMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addBrandMouseExited(evt);
            }
        });
        pnl_Background.add(btn_addBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 30, 30));

        btn_editBrand.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_editBrand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_19px.png"))); // NOI18N
        btn_editBrand.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_editBrand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editBrandMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editBrandMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editBrandMouseExited(evt);
            }
        });
        pnl_Background.add(btn_editBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 30, 30));

        cbBrand.setBackground(new java.awt.Color(0, 0, 51));
        cbBrand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbBrand.setForeground(new java.awt.Color(255, 255, 255));
        cbBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "PP", "P", "M", "G", "GG" }));
        pnl_Background.add(cbBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 140, 30));

        Background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tela_cadastro_dark.png"))); // NOI18N
        pnl_Background.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, -1));

        getContentPane().add(pnl_Background, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bnt_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bnt_saveMouseClicked
        //verificar se todos campos foram preenchidos
        bnt_save.requestFocusInWindow();

        if (Utils.isAllFieldsFilled(pnl_Background)) {
            
            if (product == null) {
                
                product = instantiateProduct(new Product());
                
                ProductDao.insert(product);
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);

                Utils.clearFields(pnl_Background);
                product = null;
            }
            else {
                instantiateProduct(product);
                ProductDao.update(product);
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_bnt_saveMouseClicked

    private void bnt_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bnt_saveMouseEntered
        // Trocar para ícone escuro
        bnt_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvar.png")));
    }//GEN-LAST:event_bnt_saveMouseEntered

    private void bnt_saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bnt_saveMouseExited
        // Voltar para ícone original
        bnt_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_salvarClaro.png")));
    }//GEN-LAST:event_bnt_saveMouseExited

    private void btn_clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMouseClicked
        // Limpar todos os campos (criar método depois)
        Utils.clearFields(pnl_Background);
    }//GEN-LAST:event_btn_clearMouseClicked

    private void btn_clearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMouseEntered
        // Trocar para ícone escuro
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_limpar.png")));
    }//GEN-LAST:event_btn_clearMouseEntered

    private void btn_clearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMouseExited
        // Voltar para ícone original
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_limparClaro.png")));
    }//GEN-LAST:event_btn_clearMouseExited

    private void btn_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_cancelMouseClicked

    private void btn_cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseEntered
        // Trocar para ícone escuro
        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_cancelar.png")));
    }//GEN-LAST:event_btn_cancelMouseEntered

    private void btn_cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseExited
        // Voltar para ícone original
        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_cancelarClaro.png")));
    }//GEN-LAST:event_btn_cancelMouseExited

    private void btn_addColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addColorMouseClicked
        // Chamar tela de cadastrar CORES
        new New_Color(this, true).setVisible(true);
    }//GEN-LAST:event_btn_addColorMouseClicked

    private void btn_addCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addCategoryMouseClicked
        // Chamar tela de cadastrar CATEGORIAS
        new New_Category(this, true).setVisible(true);
    }//GEN-LAST:event_btn_addCategoryMouseClicked

    private void btn_addColorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addColorMouseEntered
        btn_addColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_mais_claro.png")));
    }//GEN-LAST:event_btn_addColorMouseEntered

    private void btn_addColorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addColorMouseExited
        btn_addColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_mais.png")));
    }//GEN-LAST:event_btn_addColorMouseExited

    private void btn_addCategoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addCategoryMouseEntered
        btn_addCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_mais_claro.png")));
    }//GEN-LAST:event_btn_addCategoryMouseEntered

    private void btn_addCategoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addCategoryMouseExited
        btn_addCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_mais.png")));
    }//GEN-LAST:event_btn_addCategoryMouseExited

    private void btn_editColorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editColorMouseEntered
        btn_editColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_19px_claro.png")));
    }//GEN-LAST:event_btn_editColorMouseEntered

    private void btn_editColorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editColorMouseExited
        btn_editColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_19px.png")));
    }//GEN-LAST:event_btn_editColorMouseExited

    private void btn_editCategoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editCategoryMouseEntered
        btn_editCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_19px_claro.png")));
    }//GEN-LAST:event_btn_editCategoryMouseEntered

    private void btn_editCategoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editCategoryMouseExited
        btn_editCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_19px.png")));
    }//GEN-LAST:event_btn_editCategoryMouseExited

    private void btn_editColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editColorMouseClicked
        
        if (cbColor.getSelectedIndex() != 0) {
            Color c = (Color) cbColor.getSelectedItem();
            new Edit_Color(this, true, c).setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar uma cor para poder editar.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_editColorMouseClicked

    private void btn_editCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editCategoryMouseClicked
        if (cbCategory.getSelectedIndex() != 0) {
            Category c = (Category) cbCategory.getSelectedItem();
            new Edit_Category(this, true, c).setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar uma categoria para poder editar.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_editCategoryMouseClicked

    private void btn_addBrandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addBrandMouseClicked
        new New_Brand(this, true).setVisible(true);
    }//GEN-LAST:event_btn_addBrandMouseClicked

    private void btn_addBrandMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addBrandMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addBrandMouseEntered

    private void btn_addBrandMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addBrandMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addBrandMouseExited

    private void btn_editBrandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editBrandMouseClicked
        if (cbBrand.getSelectedIndex() != 0) {
            Brand b = (Brand) cbBrand.getSelectedItem();
            new Edit_Brand(this, true, b).setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar uma marca para poder editar.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_editBrandMouseClicked

    private void btn_editBrandMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editBrandMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editBrandMouseEntered

    private void btn_editBrandMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editBrandMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editBrandMouseExited

    private void pnl_BackgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_BackgroundMouseClicked
        pnl_Background.requestFocusInWindow();
    }//GEN-LAST:event_pnl_BackgroundMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel bnt_save;
    private javax.swing.JLabel btn_addBrand;
    private javax.swing.JLabel btn_addCategory;
    private javax.swing.JLabel btn_addColor;
    private javax.swing.JLabel btn_cancel;
    private javax.swing.JLabel btn_clear;
    private javax.swing.JLabel btn_editBrand;
    private javax.swing.JLabel btn_editCategory;
    private javax.swing.JLabel btn_editColor;
    private javax.swing.JComboBox<Object> cbBrand;
    private javax.swing.JComboBox<Object> cbCategory;
    private javax.swing.JComboBox<Object> cbColor;
    private javax.swing.JComboBox<String> cbSize;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnl_Background;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txt_description;
    private javax.swing.JFormattedTextField txtf_costPrice;
    private javax.swing.JFormattedTextField txtf_quantity;
    private javax.swing.JFormattedTextField txtf_salePrice;
    // End of variables declaration//GEN-END:variables
}
