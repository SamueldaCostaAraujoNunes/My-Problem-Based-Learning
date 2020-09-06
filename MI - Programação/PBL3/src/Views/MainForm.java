/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Control.Controll;
import Models.Aresta;
import Models.Grafo;
import Models.Vertice;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Samuel da Costa Araujo Nunes
 */
public class MainForm extends javax.swing.JFrame {

    private static Grafo grafo;

    public MainForm() {
        this.grafo = Controll.gerarGrafo();
        jPGrafo = new DesenhaGrafos(this);
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jPGrafo.setBorder(
                BorderFactory.createTitledBorder("Rede de Computadores")
        );
        jPEmbaixo.setBorder(
                BorderFactory.createTitledBorder("Informações")
        );
        jPLadoDireito.setBorder(
                BorderFactory.createTitledBorder("Menor caminho")
        );

    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPGrafo = new DesenhaGrafos(this);
        jPEmbaixo = new javax.swing.JPanel();
        jLabelInfo = new javax.swing.JLabel();
        jPLadoDireito = new javax.swing.JPanel();
        jLabelEuclidiana = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        btnImport = new javax.swing.JMenuItem();
        btnExport = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        addVertice = new javax.swing.JMenuItem();
        addAresta = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        removeVertice = new javax.swing.JMenuItem();
        removeAresta = new javax.swing.JMenuItem();
        jMCalcular = new javax.swing.JMenu();
        jMCalcularDistEuclideana = new javax.swing.JMenuItem();

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        jMenu9.setText("jMenu9");

        jMenuItem7.setText("jMenuItem7");

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("File");
        jMenuBar3.add(jMenu1);

        jMenu4.setText("Edit");
        jMenuBar3.add(jMenu4);

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PBL3 ");
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPGrafo.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPGrafo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPEmbaixoLayout = new javax.swing.GroupLayout(jPEmbaixo);
        jPEmbaixo.setLayout(jPEmbaixoLayout);
        jPEmbaixoLayout.setHorizontalGroup(
            jPEmbaixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEmbaixoLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabelInfo)
                .addContainerGap(1524, Short.MAX_VALUE))
        );
        jPEmbaixoLayout.setVerticalGroup(
            jPEmbaixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEmbaixoLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabelInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelEuclidiana.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEuclidiana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPLadoDireitoLayout = new javax.swing.GroupLayout(jPLadoDireito);
        jPLadoDireito.setLayout(jPLadoDireitoLayout);
        jPLadoDireitoLayout.setHorizontalGroup(
            jPLadoDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLadoDireitoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEuclidiana, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPLadoDireitoLayout.setVerticalGroup(
            jPLadoDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLadoDireitoLayout.createSequentialGroup()
                .addComponent(jLabelEuclidiana, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                .addGap(1293, 1293, 1293))
        );

        jMenu7.setText("Arquivos");

        btnImport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        btnImport.setText("Importar");
        btnImport.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
                btnImportMenuKeyReleased(evt);
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        btnImport.addMenuDragMouseListener(new javax.swing.event.MenuDragMouseListener() {
            public void menuDragMouseDragged(javax.swing.event.MenuDragMouseEvent evt) {
            }
            public void menuDragMouseEntered(javax.swing.event.MenuDragMouseEvent evt) {
            }
            public void menuDragMouseExited(javax.swing.event.MenuDragMouseEvent evt) {
            }
            public void menuDragMouseReleased(javax.swing.event.MenuDragMouseEvent evt) {
                btnImportMenuDragMouseReleased(evt);
            }
        });
        btnImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnImportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnImportMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnImportMouseReleased(evt);
            }
        });
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });
        jMenu7.add(btnImport);

        btnExport.setText("Exportar");
        btnExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExportMouseExited(evt);
            }
        });
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        jMenu7.add(btnExport);

        jMenuBar1.add(jMenu7);

        jMenu2.setText("Adicionar");

        addVertice.setText("Vertice");
        addVertice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addVerticeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addVerticeMouseExited(evt);
            }
        });
        addVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVerticeActionPerformed(evt);
            }
        });
        jMenu2.add(addVertice);

        addAresta.setText("Aresta");
        addAresta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addArestaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addArestaMouseExited(evt);
            }
        });
        addAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addArestaActionPerformed(evt);
            }
        });
        jMenu2.add(addAresta);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Remover");

        removeVertice.setText("Vertice");
        removeVertice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeVerticeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeVerticeMouseExited(evt);
            }
        });
        removeVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeVerticeActionPerformed(evt);
            }
        });
        jMenu3.add(removeVertice);

        removeAresta.setText("Aresta");
        removeAresta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeArestaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeArestaMouseExited(evt);
            }
        });
        removeAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeArestaActionPerformed(evt);
            }
        });
        jMenu3.add(removeAresta);

        jMenuBar1.add(jMenu3);

        jMCalcular.setText("Calcular");
        jMCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCalcularActionPerformed(evt);
            }
        });

        jMCalcularDistEuclideana.setText("Distancia Euclideana");
        jMCalcularDistEuclideana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMCalcularDistEuclideanaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMCalcularDistEuclideanaMouseExited(evt);
            }
        });
        jMCalcularDistEuclideana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCalcularDistEuclideanaActionPerformed(evt);
            }
        });
        jMCalcular.add(jMCalcularDistEuclideana);

        jMenuBar1.add(jMCalcular);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPEmbaixo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPLadoDireito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPLadoDireito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPEmbaixo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVerticeActionPerformed
        Controll.addVertice(this);
    }//GEN-LAST:event_addVerticeActionPerformed

    public void gerarVertice(Vertice v) {
        if (grafo.get(v.getNomeTerminal()) == null) {
            grafo.add(v);
            jPGrafo.updateUI();
        }
    }

    public void gerarAresta(Aresta a) {
        grafo.getListAresta().add(a);
        jPGrafo.updateUI();
    }


    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        Grafo grafoRetornado = Controll.buscarArquivos();

        if (grafoRetornado != null) {
            grafo = grafoRetornado;
            jPGrafo.updateUI();
        }

    }//GEN-LAST:event_btnImportActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        Controll.salvarArquivos(grafo);
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnImportMenuKeyReleased(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_btnImportMenuKeyReleased

    }//GEN-LAST:event_btnImportMenuKeyReleased

    private void addArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addArestaActionPerformed
        Controll.addAresta(this);
    }//GEN-LAST:event_addArestaActionPerformed

    private void removeArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeArestaActionPerformed
        Controll.removeAresta(this);
    }//GEN-LAST:event_removeArestaActionPerformed

    private void removeVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeVerticeActionPerformed
        Controll.removeVertice(this);
    }//GEN-LAST:event_removeVerticeActionPerformed

    private void btnImportMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportMouseReleased

    }//GEN-LAST:event_btnImportMouseReleased

    private void btnImportMenuDragMouseReleased(javax.swing.event.MenuDragMouseEvent evt) {//GEN-FIRST:event_btnImportMenuDragMouseReleased

    }//GEN-LAST:event_btnImportMenuDragMouseReleased

    private void btnImportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportMouseEntered
        jLabelInfo.setText("Para importar um Grafo, selecione uma Pasta contendo dois Arquivos SVG, Vertices.txt e Arestas.txt");
        jLabelInfo.updateUI();
    }//GEN-LAST:event_btnImportMouseEntered

    private void btnExportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseEntered
        jLabelInfo.setText("Para exportar um Grafo, selecione a Pasta destino!!");
        jLabelInfo.updateUI();
    }//GEN-LAST:event_btnExportMouseEntered

    private void btnExportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseExited
        clearInfo();
    }//GEN-LAST:event_btnExportMouseExited

    private void clearInfo() {
        jLabelInfo.setText("");
        jLabelInfo.updateUI();
    }
    private void btnImportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportMouseExited
        clearInfo();
    }//GEN-LAST:event_btnImportMouseExited

    private void addVerticeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addVerticeMouseEntered
        jLabelInfo.setText("Para adicionar um Vértice, informe seu nome e dois valores inteiros correspondentes as sua coordenadas no plano cartesiano!!");
        jLabelInfo.updateUI();
    }//GEN-LAST:event_addVerticeMouseEntered

    private void addArestaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addArestaMouseEntered
        jLabelInfo.setText("Para adicionar uma Aresta, informe os nomes dos dois Vertices, e um valor inteiro correspondente ao seu peso!!");
        jLabelInfo.updateUI();
    }//GEN-LAST:event_addArestaMouseEntered

    private void addVerticeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addVerticeMouseExited
        clearInfo();
    }//GEN-LAST:event_addVerticeMouseExited

    private void addArestaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addArestaMouseExited
        clearInfo();
    }//GEN-LAST:event_addArestaMouseExited

    private void removeVerticeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeVerticeMouseEntered
        jLabelInfo.setText("Para remover um Vertice, é necessario apenas, informar o seu nome!!");
        jLabelInfo.updateUI();
    }//GEN-LAST:event_removeVerticeMouseEntered

    private void removeVerticeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeVerticeMouseExited
        clearInfo();
    }//GEN-LAST:event_removeVerticeMouseExited

    private void removeArestaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeArestaMouseEntered
        jLabelInfo.setText("Para remover uma Aresta, informe os nomes dos dois Vertices eu compartilham a aresta desejada!!");
        jLabelInfo.updateUI();
    }//GEN-LAST:event_removeArestaMouseEntered

    private void removeArestaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeArestaMouseExited
        clearInfo();
    }//GEN-LAST:event_removeArestaMouseExited

    private void jMCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCalcularActionPerformed

    }//GEN-LAST:event_jMCalcularActionPerformed

    private void jMCalcularDistEuclideanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCalcularDistEuclideanaActionPerformed
        Controll.gerarDistanciaEuclideana(this);
    }//GEN-LAST:event_jMCalcularDistEuclideanaActionPerformed

    private void jMCalcularDistEuclideanaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMCalcularDistEuclideanaMouseEntered
       jLabelInfo.setText("Para calcular a Distancia Euclidiana, informe os nomes dos dois Vertices!!");
        jLabelInfo.updateUI();
    }//GEN-LAST:event_jMCalcularDistEuclideanaMouseEntered

    private void jMCalcularDistEuclideanaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMCalcularDistEuclideanaMouseExited
        clearInfo(); 
    }//GEN-LAST:event_jMCalcularDistEuclideanaMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addAresta;
    private javax.swing.JMenuItem addVertice;
    private javax.swing.JMenuItem btnExport;
    private javax.swing.JMenuItem btnImport;
    public javax.swing.JLabel jLabelEuclidiana;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JMenu jMCalcular;
    private javax.swing.JMenuItem jMCalcularDistEuclideana;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPEmbaixo;
    public javax.swing.JPanel jPGrafo;
    private javax.swing.JPanel jPLadoDireito;
    private javax.swing.JMenuItem removeAresta;
    private javax.swing.JMenuItem removeVertice;
    // End of variables declaration//GEN-END:variables
}
