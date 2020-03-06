package GUI;

import Analizadores.Cup.parser;
import Analizadores.Flex.Lexer;
import Objetos.Logica;
import Tablas.TablaSimbolos.TablaSimbolos;
import java.io.StringReader;
import CErrores.*;
import Tablas.TablaTipos.TablaTipos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.BadLocationException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jpmazate
 */
public class EditorTexto extends javax.swing.JFrame {

    /**
     * Creates new form EditorTexto
     */
    Logica logica;
    TablaSimbolos tablaSimbolos;
    TablaTipos tablaTipos;

    public EditorTexto() {
        initComponents();
        logica = new Logica();
    }

    public void validar() {
        try {
            reiniciarTodo();
            String h = areaTexto.getText();
            StringReader reader = new StringReader(h);
            Lexer lex = new Lexer(reader, areaTexto, null);
            parser par = new parser(lex, tablaSimbolos, tablaTipos, areaTexto);
            par.parse();

        } catch (Exception e) {
            e.printStackTrace();
        }
        List<CError> list = CErrores.getListaErrores();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setColumna(list.get(i).getColumna()-1);
            System.out.println(list.get(i).getMensaje()+", FIla: "+list.get(i).getFila()+",Columna: "+list.get(i).getColumna());

        }
    }

    public void reiniciarTodo() {
        tablaTipos = Logica.crearTabla();
        tablaSimbolos = new TablaSimbolos();
        CErrores.reiniciar();

    }
    
    public void areaTextoActualCaretUpdate(javax.swing.event.CaretEvent evt) {
        int pos = evt.getDot();
        try {
            int fila = areaTexto.getLineOfOffset(pos) + 1;
            int columna = pos - areaTexto.getLineStartOffset(fila - 1);
            textoPosicion.setText("Línea: " + fila + " Columna: " + columna);
            textoPosicion.setVisible(true);
        } catch (BadLocationException exc) {
            exc.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        textoPosicion = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        areaTexto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                areaTextoCaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(areaTexto);

        desktopPane.add(jScrollPane1);
        jScrollPane1.setBounds(140, 120, 510, 340);

        jButton1.setText("validar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton1);
        jButton1.setBounds(690, 140, 190, 30);

        textoPosicion.setText("Fila: 1 Columna: 1");
        desktopPane.add(textoPosicion);
        textoPosicion.setBounds(680, 60, 200, 18);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        validar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void areaTextoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_areaTextoCaretUpdate
        areaTextoActualCaretUpdate(evt);
    }//GEN-LAST:event_areaTextoCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JLabel textoPosicion;
    // End of variables declaration//GEN-END:variables

}
