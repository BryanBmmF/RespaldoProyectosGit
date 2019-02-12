package empresarial.gui.frames.recursoshumanos;

import empresarial.backend.modelos.Empleado;
import empresarial.backend.recursoshumanos.ManejadorRH;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class NuevoEmpleadoDialog extends javax.swing.JDialog {

	private ManejadorRH manejador;
	private Empleado nuevoEmpleado;

	/**
	 * Creates new form NuevoEmpleadoDialog
	 */
	public NuevoEmpleadoDialog(boolean modal, ManejadorRH manejador) {
		this.manejador = manejador;
		initComponents();
		this.setModal(modal);
	}

	public Empleado getNuevoEmpleado() {
		return nuevoEmpleado;
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING:
	 * Do NOT modify this code. The content of this method is always regenerated by the
	 * Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CUILabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        fechaNacimientoLabel = new javax.swing.JLabel();
        salarioLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        horasLaboralesSpinner = new javax.swing.JSpinner();
        salarioText = new javax.swing.JFormattedTextField();
        fechaNacimientoText = new javax.swing.JFormattedTextField();
        nombreText = new javax.swing.JTextField();
        crearButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        limpiarButton = new javax.swing.JButton();
        CUIText = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        validacionLabel = new javax.swing.JLabel();

        setTitle("Crear empleado");
        setAlwaysOnTop(true);
        setResizable(false);

        CUILabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CUILabel.setText("CUI:*");

        nombreLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombreLabel.setText("Nombre completo:*");

        fechaNacimientoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fechaNacimientoLabel.setText("Fecha nacimiento:");

        salarioLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        salarioLabel.setText("Salario mensual:* Q.");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Horas laborales diarias:");

        horasLaboralesSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 12, 1));

        salarioText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        salarioText.setPreferredSize(new java.awt.Dimension(14, 23));

        try {
            fechaNacimientoText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fechaNacimientoText.setPreferredSize(new java.awt.Dimension(14, 23));

        crearButton.setText("Crear");
        crearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        limpiarButton.setText("Limpiar");
        limpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarButtonActionPerformed(evt);
            }
        });

        try {
            CUIText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CUIText.setPreferredSize(new java.awt.Dimension(14, 23));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel2.setText("(e.j. 31/02/1980)");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel3.setText("(e.j. 5896 4587 3654 2157)");

        validacionLabel.setForeground(new java.awt.Color(255, 0, 0));
        validacionLabel.setText("Todos los campos marcados con * son requeridos.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(validacionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(limpiarButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarButton)
                        .addGap(18, 18, 18)
                        .addComponent(crearButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salarioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(horasLaboralesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(salarioText, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaNacimientoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(nombreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CUILabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreText)
                            .addComponent(CUIText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(fechaNacimientoText, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CUILabel)
                    .addComponent(CUIText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaNacimientoLabel)
                    .addComponent(fechaNacimientoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salarioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salarioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(horasLaboralesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(validacionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearButton)
                    .addComponent(cancelarButton)
                    .addComponent(limpiarButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
		this.setVisible(false);
     }//GEN-LAST:event_cancelarButtonActionPerformed

     private void limpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarButtonActionPerformed
		limpiar();
     }//GEN-LAST:event_limpiarButtonActionPerformed

     private void crearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearButtonActionPerformed
		if (CUIText.getText().isEmpty() || nombreText.getText().isEmpty()) {
			this.validacionLabel.setVisible(true);
		} else {
			try {
				this.nuevoEmpleado = manejador.agregarEmpleado(CUIText.getText(), nombreText.getText(),
					   fechaNacimientoText.getText(), salarioText.getText(),
					   horasLaboralesSpinner.getValue().toString());
				limpiar();
				setVisible(false);
			} catch (DateTimeParseException e) {
				JOptionPane.showMessageDialog(this, "La fecha es incorrecta",
					   "error", JOptionPane.ERROR_MESSAGE);
			
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "El salaario es incorrecto",
					   "error", JOptionPane.ERROR_MESSAGE);
			}

		}
     }//GEN-LAST:event_crearButtonActionPerformed

	private void limpiar() {
		/*int algo = 4;
		double otro = 9;
		otro = algo;*/
		CUIText.setText("");
		nombreText.setText("");
		fechaNacimientoText.setText("");
		salarioText.setText("");
		horasLaboralesSpinner.setValue(0);
	}

	public void setVisible(boolean flag) {
		this.validacionLabel.setVisible(false);
		super.setVisible(flag);
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CUILabel;
    private javax.swing.JFormattedTextField CUIText;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton crearButton;
    private javax.swing.JLabel fechaNacimientoLabel;
    private javax.swing.JFormattedTextField fechaNacimientoText;
    private javax.swing.JSpinner horasLaboralesSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton limpiarButton;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreText;
    private javax.swing.JLabel salarioLabel;
    private javax.swing.JFormattedTextField salarioText;
    private javax.swing.JLabel validacionLabel;
    // End of variables declaration//GEN-END:variables
}