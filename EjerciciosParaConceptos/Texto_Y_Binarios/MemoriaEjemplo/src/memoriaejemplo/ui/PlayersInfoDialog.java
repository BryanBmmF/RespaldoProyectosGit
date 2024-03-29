/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoriaejemplo.ui;

import memoriaejemplo.backend.players.Player;

/**
 *
 * @author jose
 */
public class PlayersInfoDialog extends javax.swing.JDialog {
	private Player[] players;

	/**
	 * Creates new form PlayersInfoDialog
	 */
	public PlayersInfoDialog(java.awt.Frame parent) {
		super(parent, true);
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING:
	 * Do NOT modify this code. The content of this method is always regenerated by the
	 * Form Editor.
	 */
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          saveButton = new javax.swing.JButton();
          mainPanel = new javax.swing.JPanel();
          name1Label = new javax.swing.JLabel();
          name1Text = new javax.swing.JTextField();
          name2Label = new javax.swing.JLabel();
          name2Text = new javax.swing.JTextField();
          errorLabel = new javax.swing.JLabel();
          cancelButton = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

          saveButton.setText("Save");
          saveButton.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    saveButtonActionPerformed(evt);
               }
          });

          name1Label.setText("Player 1 name:*");

          name2Label.setText("Player 2 name:*");

          errorLabel.setText("The names are required!");

          javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
          mainPanel.setLayout(mainPanelLayout);
          mainPanelLayout.setHorizontalGroup(
               mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addGroup(mainPanelLayout.createSequentialGroup()
                              .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addComponent(name1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(name2Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(name1Text, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                   .addComponent(name2Text))))
                    .addContainerGap())
          );
          mainPanelLayout.setVerticalGroup(
               mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(name1Text)
                         .addComponent(name1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(name2Text)
                         .addComponent(name2Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(errorLabel)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          cancelButton.setText("Cancel");
          cancelButton.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cancelButtonActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                              .addGap(0, 0, Short.MAX_VALUE)
                              .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(18, 18, 18)
                              .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(cancelButton)
                         .addComponent(saveButton))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
          if (name1Text.getText().isEmpty() || name2Text.getText().isEmpty()) {
			errorLabel.setVisible(true);
		} else {
			players = new Player[2];
			players[0] = new Player(name1Text.getText());
			players[1] = new Player(name2Text.getText());
			setVisible(false);
		}
     }//GEN-LAST:event_saveButtonActionPerformed

     private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
          setVisible(false);
     }//GEN-LAST:event_cancelButtonActionPerformed

	public Player[] getPlayers() {
		return players;
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			players = null;
			name1Text.setText("");
			name2Text.setText("");
			errorLabel.setVisible(false);
		}
		super.setVisible(visible);
	}

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton cancelButton;
     private javax.swing.JLabel errorLabel;
     private javax.swing.JPanel mainPanel;
     private javax.swing.JLabel name1Label;
     private javax.swing.JTextField name1Text;
     private javax.swing.JLabel name2Label;
     private javax.swing.JTextField name2Text;
     private javax.swing.JButton saveButton;
     // End of variables declaration//GEN-END:variables
}
