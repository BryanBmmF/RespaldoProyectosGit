/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoriaejemplo.ui;

import javax.swing.JOptionPane;
import memoriaejemplo.backend.GameCore;
import memoriaejemplo.backend.cards.Card;
import memoriaejemplo.backend.cards.CardsManager;
import memoriaejemplo.backend.cards.Pair;
import memoriaejemplo.backend.players.Player;
import memoriaejemplo.backend.players.TurnController;

/**
 *
 * @author jose
 */
public class GameFrame extends javax.swing.JFrame {

	private static final String TURN_TEXT = "Jugador en turno: ";
	private static final String PLAYER_SCORE_TEXT = "Puntos jugador {name}: ";
	private static final String END_GAME_TEXT = "El jugador {name} ha ganado con {pts} puntos.";

	GameCore gameCore;
	
	/**
	 * Creates new form GameFrame
	 */
	public GameFrame() {
		initComponents();
		playersInfoDialog = new PlayersInfoDialog(this);
		gameCore = new GameCore();
		matchResultsDialog = new MatchResultsDialog(this, gameCore.getRegister());
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING:
	 * Do NOT modify this code. The content of this method is always regenerated by the
	 * Form Editor.
	 */
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          infoPanel = new javax.swing.JPanel();
          turnLabel = new javax.swing.JLabel();
          scorePlayer1Label = new javax.swing.JLabel();
          scorePlayer2Label = new javax.swing.JLabel();
          scroll = new javax.swing.JScrollPane();
          panelContainer = new javax.swing.JPanel();
          mainMenubar = new javax.swing.JMenuBar();
          jMenu1 = new javax.swing.JMenu();
          easyMenuItem = new javax.swing.JMenuItem();
          nomalMenuItem = new javax.swing.JMenuItem();
          hardMenuItem = new javax.swing.JMenuItem();
          jMenu2 = new javax.swing.JMenu();
          registriesMenuItem = new javax.swing.JMenuItem();
          jMenuItem5 = new javax.swing.JMenuItem();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

          infoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

          turnLabel.setText("Jugador en turno: ");
          turnLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

          scorePlayer1Label.setText("Puntos jugador 1:");

          scorePlayer2Label.setText("Puntos jugador 2:");

          javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
          infoPanel.setLayout(infoPanelLayout);
          infoPanelLayout.setHorizontalGroup(
               infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(infoPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(turnLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                         .addComponent(scorePlayer1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(scorePlayer2Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
          );
          infoPanelLayout.setVerticalGroup(
               infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(infoPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(turnLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scorePlayer1Label)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scorePlayer2Label)
                    .addContainerGap())
          );

          scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

          panelContainer.setLayout(new java.awt.GridLayout(0, 5, 10, 10));
          scroll.setViewportView(panelContainer);

          jMenu1.setText("Matches");

          easyMenuItem.setText("Easy");
          easyMenuItem.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    easyMenuItemActionPerformed(evt);
               }
          });
          jMenu1.add(easyMenuItem);

          nomalMenuItem.setText("Normal");
          nomalMenuItem.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nomalMenuItemActionPerformed(evt);
               }
          });
          jMenu1.add(nomalMenuItem);

          hardMenuItem.setText("Hard");
          hardMenuItem.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    hardMenuItemActionPerformed(evt);
               }
          });
          jMenu1.add(hardMenuItem);

          mainMenubar.add(jMenu1);

          jMenu2.setText("Reports");

          registriesMenuItem.setText("Winners History");
          registriesMenuItem.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    registriesMenuItemActionPerformed(evt);
               }
          });
          jMenu2.add(registriesMenuItem);

          jMenuItem5.setText("Best Score");
          jMenu2.add(jMenuItem5);

          mainMenubar.add(jMenu2);

          setJMenuBar(mainMenubar);

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addComponent(scroll)
                         .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                    .addContainerGap())
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void easyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_easyMenuItemActionPerformed
		askForPlayers();
		startGame(GameCore.EASY_GAME);
     }//GEN-LAST:event_easyMenuItemActionPerformed

     private void nomalMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomalMenuItemActionPerformed
		askForPlayers();
		startGame(GameCore.NORMAL_GAME);
     }//GEN-LAST:event_nomalMenuItemActionPerformed

     private void hardMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardMenuItemActionPerformed
		askForPlayers();
		startGame(GameCore.HARD_GAME);
     }//GEN-LAST:event_hardMenuItemActionPerformed

     private void registriesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registriesMenuItemActionPerformed
		matchResultsDialog.setVisible(true);
     }//GEN-LAST:event_registriesMenuItemActionPerformed

	//Metodos para el funcionamiento de la UI
	private Player[] askForPlayers() {
		playersInfoDialog.setVisible(true);
		return playersInfoDialog.getPlayers();
	}

	private void startGame(int pairNumber) {
		if (playersInfoDialog.getPlayers() != null) {
			Player currentPlayer = gameCore.startGame(pairNumber,
				   playersInfoDialog.getPlayers()[0],
				   playersInfoDialog.getPlayers()[1]);
			showPlayersData(currentPlayer);
			addCardsToPanel(CardsManager.generateCards(pairNumber));
		}
	}

	private void showPlayersData(Player currentPlayer) {
		turnLabel.setText(TURN_TEXT + currentPlayer.getName());
		scorePlayer1Label.setText(
			   PLAYER_SCORE_TEXT.replace("{name}", gameCore.getFirstPlayer().getName())
			   + gameCore.getFirstPlayer().getScore());
		scorePlayer2Label.setText(
			   PLAYER_SCORE_TEXT.replace("{name}", gameCore.getSecondPlayer().getName())
			   + gameCore.getSecondPlayer().getScore());
	}

	private void addCardsToPanel(Card[] cards) {
		panelContainer.removeAll();
		for (Card card : cards) {
			card.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					selectCard(card);
				}
			});
			panelContainer.add(card);
		}
		scroll.validate();
		scroll.repaint();
	}

	private void selectCard(Card selectedCard) {
		if (!selectedCard.isDisplayed()) {
			String message = gameCore.selectCard(selectedCard);
			if (gameCore.isPairFull()) {
				showPlayersData(gameCore.getPlayerInTurn());
				JOptionPane.showMessageDialog(this, message);
				if (!gameCore.isPair()) {
					gameCore.getSelectedPair().getFirstCard().showCover();
					gameCore.getSelectedPair().getSecondCard().showCover();
				}
				gameCore.cleanSelectedPari();
			}
			if (gameCore.hasGameEnded()) {
				String result = END_GAME_TEXT.replace("{name}", gameCore.getWinner().getName())
					   .replace("{pts}", String.valueOf(gameCore.getWinner().getScore()));
				gameCore.recordMatchResult();
				JOptionPane.showMessageDialog(this, result);
			}
		}
	}

	private PlayersInfoDialog playersInfoDialog;
	private MatchResultsDialog matchResultsDialog;
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JMenuItem easyMenuItem;
     private javax.swing.JMenuItem hardMenuItem;
     private javax.swing.JPanel infoPanel;
     private javax.swing.JMenu jMenu1;
     private javax.swing.JMenu jMenu2;
     private javax.swing.JMenuItem jMenuItem5;
     private javax.swing.JMenuBar mainMenubar;
     private javax.swing.JMenuItem nomalMenuItem;
     private javax.swing.JPanel panelContainer;
     private javax.swing.JMenuItem registriesMenuItem;
     private javax.swing.JLabel scorePlayer1Label;
     private javax.swing.JLabel scorePlayer2Label;
     private javax.swing.JScrollPane scroll;
     private javax.swing.JLabel turnLabel;
     // End of variables declaration//GEN-END:variables
}
