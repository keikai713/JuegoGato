package juegogato;

/* Autor: Alejandro Pérez Durán.
 * Fecha de creación: 26 de Febrero de 2015.
 * Descripción del programa: Este programa realiza el juego del gato.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class VentanaGato extends javax.swing.JFrame {

    Timer t = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (segundos != 0) {
                segundos--;
            }

            if (segundos == 0 && minutos > 0) {
                minutos--;
                segundos = 59;
                jLabel4.setText(minutos + "");
            }
            jLabel7.setText(segundos + "");

            if (minutos == 0 && segundos == 0) {
                t.stop(); //Detener el tiempo del juego de gato.
                tInicio.stop();//Detener el tiempo de números random.
                //Deshabilitar todos los botones restantes
                deshabilitarBotones();
                jLabel2.setText("NADIE GANA");
            }
        }
    });
    byte segundosI = 0;
    Timer tInicio = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            segundosI++;

            if (segundosI == 15) {
                jButton1.setEnabled(false);
                jTextField1.setEnabled(false);
                jTextField2.setEnabled(false);
                minutos = (byte) (Math.random() * (3 - 0) + 0);//Generar número de 0 a 3.
                segundos = (byte) ((Math.random() * (59 - 15)) + 15);//Generar número de 15 a 59.
                jLabel4.setText(minutos + "");
                jLabel7.setText(segundos + "");
                jButton2.setEnabled(true);//Habilitar botón "JUGAR" para poder dar clic sobre él.
                jButton2.doClick();//Hacer click en el botón jugar.
            }
        }
    });
    //String [][]matriz = new String[3][3];Esta es otra forma de crear una matriz.
    String matriz[][] = new String[3][3];
    int contador = 0;

    /**
     * Creates new form VentanaGato
     */
    public VentanaGato() {
        initComponents();
        this.setSize(460, 400);//Se establece el tamaño de la ventana.
        this.setLocationRelativeTo(null);//Esta línea hace que la ventana salga centrada.
        //Deshabilitar todos los botones
        B00.setEnabled(false);
        B01.setEnabled(false);
        B02.setEnabled(false);
        B10.setEnabled(false);
        B11.setEnabled(false);
        B12.setEnabled(false);
        B20.setEnabled(false);
        B21.setEnabled(false);
        B22.setEnabled(false);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
    }

    void deshabilitarBotones() {
        B00.setEnabled(false);
        B01.setEnabled(false);
        B02.setEnabled(false);
        B10.setEnabled(false);
        B11.setEnabled(false);
        B12.setEnabled(false);
        B20.setEnabled(false);
        B21.setEnabled(false);
        B22.setEnabled(false);
    }

    //El siguiente método muestra los valores que van adquiriendo los botones del gato, ya sean "X" u "O".
    public void imprimirMatriz() {
        B00.setText(matriz[0][0]);
        B01.setText(matriz[0][1]);
        B02.setText(matriz[0][2]);

        B10.setText(matriz[1][0]);
        B11.setText(matriz[1][1]);
        B12.setText(matriz[1][2]);

        B20.setText(matriz[2][0]);
        B21.setText(matriz[2][1]);
        B22.setText(matriz[2][2]);

        System.out.println("********************");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(matriz[i][j] + "");
            }
            System.out.println("********************");
        }
    }
    boolean empate = true;

    void revisarEmpate() {
        if (empate == true && contador == 9) {
            jLabel2.setText("EMPATE");
            t.stop(); //Detener el tiempo del juego de gato.
        }
    }

    void revisarGanarVerticales(String valor) {
        for (int i = 0; i < 3; i++) {
            if (matriz[0][i] != null && matriz[1][i] != null && matriz[2][i] != null) {
                if (matriz[0][i].equals(valor) && matriz[1][i].equals(valor) && matriz[2][i].equals(valor)) {
                    empate = false;
                    jLabel2.setText(valor);
                    //Deshabilitar todos los botones restantes
                    deshabilitarBotones();
                    t.stop(); //Detener el tiempo del juego de gato.
                    //Cuando un jugador gane el tiempo se pone en ceros
                    jLabel4.setText(0 + "");
                    jLabel7.setText(0 + "");
                    jTextField1.setEnabled(false);
                    jTextField2.setEnabled(false);
                    jButton1.setEnabled(false);
                }
            }
        }
    }

    void revisarGanarHorizontales(String valor) {
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] != null && matriz[i][1] != null && matriz[i][2] != null) {
                if (matriz[i][0].equals(valor) && matriz[i][1].equals(valor) && matriz[i][2].equals(valor)) {
                    empate = false;
                    jLabel2.setText(valor);
                    //Deshabilitar todos los botones restantes
                    deshabilitarBotones();
                    t.stop(); //Detener el tiempo del juego de gato.
                    //Cuando un jugador gane el tiempo se pone en ceros
                    jLabel4.setText(0 + "");
                    jLabel7.setText(0 + "");
                    jTextField1.setEnabled(false);
                    jTextField2.setEnabled(false);
                    jButton1.setEnabled(false);
                }
            }
        }
    }

    void revisarGanarDiagonales(String valor) {
        //Diagonal 1
        if (matriz[0][0] != null && matriz[1][1] != null && matriz[2][2] != null) {
            if (matriz[0][0].equals(valor) && matriz[1][1].equals(valor) && matriz[2][2].equals(valor)) {
                empate = false;
                jLabel2.setText(valor);
                //Deshabilitar todos los botones restantes
                deshabilitarBotones();
                t.stop(); //Detener el tiempo del juego de gato.
                //Cuando un jugador gane el tiempo se pone en ceros
                jLabel4.setText(0 + "");
                jLabel7.setText(0 + "");
                jTextField1.setEnabled(false);
                jTextField2.setEnabled(false);
                jButton1.setEnabled(false);
            }
        }
        //Diagonal 2
        if (matriz[0][2] != null && matriz[1][1] != null && matriz[2][0] != null) {
            if (matriz[0][2].equals(valor) && matriz[1][1].equals(valor) && matriz[2][0].equals(valor)) {
                empate = false;
                jLabel2.setText(valor);
                //Deshabilitar todos los botones restantes
                deshabilitarBotones();
                t.stop(); //Detener el tiempo del juego de gato.
                //Cuando un jugador gane el tiempo se pone en ceros
                jLabel4.setText(0 + "");
                jLabel7.setText(0 + "");
                jTextField1.setEnabled(false);
                jTextField2.setEnabled(false);
                jButton1.setEnabled(false);
            }
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

        B00 = new javax.swing.JButton();
        B01 = new javax.swing.JButton();
        B02 = new javax.swing.JButton();
        B10 = new javax.swing.JButton();
        B11 = new javax.swing.JButton();
        B12 = new javax.swing.JButton();
        B20 = new javax.swing.JButton();
        B21 = new javax.swing.JButton();
        B22 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        B00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B00ActionPerformed(evt);
            }
        });
        getContentPane().add(B00);
        B00.setBounds(20, 20, 70, 51);

        B01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B01ActionPerformed(evt);
            }
        });
        getContentPane().add(B01);
        B01.setBounds(110, 20, 70, 50);

        B02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B02ActionPerformed(evt);
            }
        });
        getContentPane().add(B02);
        B02.setBounds(200, 20, 70, 52);

        B10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B10ActionPerformed(evt);
            }
        });
        getContentPane().add(B10);
        B10.setBounds(20, 90, 70, 50);

        B11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B11ActionPerformed(evt);
            }
        });
        getContentPane().add(B11);
        B11.setBounds(110, 90, 70, 50);

        B12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B12ActionPerformed(evt);
            }
        });
        getContentPane().add(B12);
        B12.setBounds(200, 90, 70, 50);

        B20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B20ActionPerformed(evt);
            }
        });
        getContentPane().add(B20);
        B20.setBounds(20, 160, 70, 50);

        B21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B21ActionPerformed(evt);
            }
        });
        getContentPane().add(B21);
        B21.setBounds(110, 160, 70, 50);

        B22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B22ActionPerformed(evt);
            }
        });
        getContentPane().add(B22);
        B22.setBounds(200, 160, 70, 50);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 80, 250, 2);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(20, 150, 250, 10);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(100, 20, 10, 190);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(190, 20, 10, 190);

        jLabel1.setText("EL GANADOR ES:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 236, 100, 20);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 230, 80, 30);

        jLabel3.setText("TIEMPO:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(320, 20, 50, 16);

        jLabel4.setText("00");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(310, 40, 20, 16);

        jLabel5.setText(":");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(340, 40, 10, 16);

        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Timepo para jugar:");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(280, 140, 120, 20);

        jLabel7.setText("00");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(360, 40, 20, 16);

        jButton1.setText("ACEPTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 190, 100, 25);

        jButton2.setText("JUGAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(300, 60, 80, 25);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(340, 160, 30, 20);

        jLabel8.setText(":");
        jLabel8.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(330, 160, 5, 16);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(300, 160, 30, 20);

        jButton3.setText("JUEGO NUEVO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(280, 220, 120, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B00ActionPerformed
        if (contador % 2 == 0) {
            matriz[0][0] = "X";
        } else {
            matriz[0][0] = "O";
        }
        contador++;
        imprimirMatriz();
        B00.setEnabled(false);//Con esta línea se desactiva este este mismo botón.
        //Verificar si algun jugador ha ganado el juego.
        revisarGanarVerticales(B00.getText());
        revisarGanarHorizontales(B00.getText());
        revisarGanarDiagonales(B00.getText());
        revisarEmpate();//Verificar si exite un empate en el juego
    }//GEN-LAST:event_B00ActionPerformed

    private void B01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B01ActionPerformed
        if (contador % 2 == 0) {
            matriz[0][1] = "X";
        } else {
            matriz[0][1] = "O";
        }
        contador++;
        imprimirMatriz();
        B01.setEnabled(false);//Con esta línea se desactiva este este mismo botón.
        //Verificar si algun jugador ha ganado el juego.
        revisarGanarVerticales(B01.getText());
        revisarGanarHorizontales(B01.getText());
        revisarGanarDiagonales(B01.getText());
        revisarEmpate();//Verificar si exite un empate en el juego
    }//GEN-LAST:event_B01ActionPerformed

    private void B02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B02ActionPerformed
        if (contador % 2 == 0) {
            matriz[0][2] = "X";
        } else {
            matriz[0][2] = "O";
        }
        contador++;
        imprimirMatriz();
        B02.setEnabled(false);//Con esta línea se desactiva este este mismo botón.
        //Verificar si algun jugador ha ganado el juego.
        revisarGanarVerticales(B02.getText());
        revisarGanarHorizontales(B02.getText());
        revisarGanarDiagonales(B02.getText());
        revisarEmpate();//Verificar si exite un empate en el juego
    }//GEN-LAST:event_B02ActionPerformed

    private void B10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B10ActionPerformed
        if (contador % 2 == 0) {
            matriz[1][0] = "X";
        } else {
            matriz[1][0] = "O";
        }
        contador++;
        imprimirMatriz();
        B10.setEnabled(false);//Con esta línea se desactiva este este mismo botón.
        //Verificar si algun jugador ha ganado el juego.
        revisarGanarVerticales(B10.getText());
        revisarGanarHorizontales(B10.getText());
        revisarGanarDiagonales(B10.getText());
        revisarEmpate();//Verificar si exite un empate en el juego
    }//GEN-LAST:event_B10ActionPerformed

    private void B11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B11ActionPerformed
        if (contador % 2 == 0) {
            matriz[1][1] = "X";
        } else {
            matriz[1][1] = "O";
        }
        contador++;
        imprimirMatriz();
        B11.setEnabled(false);//Con esta línea se desactiva este este mismo botón.
        //Verificar si algun jugador ha ganado el juego.
        revisarGanarVerticales(B11.getText());
        revisarGanarHorizontales(B11.getText());
        revisarGanarDiagonales(B11.getText());
        revisarEmpate();//Verificar si exite un empate en el juego
    }//GEN-LAST:event_B11ActionPerformed

    private void B12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B12ActionPerformed
        if (contador % 2 == 0) {
            matriz[1][2] = "X";
        } else {
            matriz[1][2] = "O";
        }
        contador++;
        imprimirMatriz();
        B12.setEnabled(false);//Con esta línea se desactiva este este mismo botón.
        //Verificar si algun jugador ha ganado el juego.
        revisarGanarVerticales(B12.getText());
        revisarGanarHorizontales(B12.getText());
        revisarGanarDiagonales(B12.getText());
        revisarEmpate();//Verificar si exite un empate en el juego
    }//GEN-LAST:event_B12ActionPerformed

    private void B20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B20ActionPerformed
        if (contador % 2 == 0) {
            matriz[2][0] = "X";
        } else {
            matriz[2][0] = "O";
        }
        contador++;
        imprimirMatriz();
        B20.setEnabled(false);//Con esta línea se desactiva este este mismo botón.
        //Verificar si algun jugador ha ganado el juego.
        revisarGanarVerticales(B20.getText());
        revisarGanarHorizontales(B20.getText());
        revisarGanarDiagonales(B20.getText());
        revisarEmpate();//Verificar si exite un empate en el juego
    }//GEN-LAST:event_B20ActionPerformed

    private void B21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B21ActionPerformed
        if (contador % 2 == 0) {
            matriz[2][1] = "X";
        } else {
            matriz[2][1] = "O";
        }
        contador++;
        imprimirMatriz();
        B21.setEnabled(false);//Con esta línea se desactiva este este mismo botón.
        //Verificar si algun jugador ha ganado el juego.
        revisarGanarVerticales(B21.getText());
        revisarGanarHorizontales(B21.getText());
        revisarGanarDiagonales(B21.getText());
        revisarEmpate();//Verificar si exite un empate en el juego
    }//GEN-LAST:event_B21ActionPerformed

    private void B22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B22ActionPerformed
        if (contador % 2 == 0) {
            matriz[2][2] = "X";
        } else {
            matriz[2][2] = "O";
        }
        contador++;
        imprimirMatriz();
        B22.setEnabled(false);//Con esta línea se desactiva este este mismo botón.
        //Verificar si algun jugador ha ganado el juego.
        revisarGanarVerticales(B22.getText());
        revisarGanarHorizontales(B22.getText());
        revisarGanarDiagonales(B22.getText());
        revisarEmpate();//Verificar si exite un empate en el juego
    }//GEN-LAST:event_B22ActionPerformed
    ////////////////////////////////////MÉTODO DEL BOTÓN "ACEPTAR".
    byte minutos;
    byte segundos;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            minutos = Byte.parseByte(jTextField1.getText());
            segundos = Byte.parseByte(jTextField2.getText());
            jTextField1.setText("");
            jTextField2.setText("");
            jLabel4.setText(minutos + "");
            jLabel7.setText(segundos + "");
            jButton2.setEnabled(true);
        } catch (Exception e) {
            System.out.println("\nESCRIBA SÓLO NÚMEROS");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tInicio.stop();//Detener timepo random porque ya se ha introducido minutos y segundos.
        t.start(); //Iniciar el tiempo del juego de gato.
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        //Habilitar todos los botones
        B00.setEnabled(true);
        B01.setEnabled(true);
        B02.setEnabled(true);
        B10.setEnabled(true);
        B11.setEnabled(true);
        B12.setEnabled(true);
        B20.setEnabled(true);
        B21.setEnabled(true);
        B22.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        segundosI = 0;
        tInicio.start();//Iniciar tiempo random.
        //Habilitar botón "ACEPTAR"
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        jLabel2.setText("");
        //Habilitar campos de texto
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField1.setText("");
        jTextField2.setText("");
        t.stop(); //Detener el tiempo del juego de gato.
        jLabel4.setText("00");
        jLabel7.setText("00");
        //Deshabilitar todos los botones restantes
        deshabilitarBotones();
        B00.setText("");
        B01.setText("");
        B02.setText("");
        B10.setText("");
        B11.setText("");
        B12.setText("");
        B20.setText("");
        B21.setText("");
        B22.setText("");
        matriz[0][0] = "";
        matriz[0][1] = "";
        matriz[0][2] = "";
        matriz[1][0] = "";
        matriz[1][1] = "";
        matriz[1][2] = "";
        matriz[2][0] = "";
        matriz[2][1] = "";
        matriz[2][2] = "";
        contador = 0;
        empate = true;
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaGato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaGato().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B00;
    private javax.swing.JButton B01;
    private javax.swing.JButton B02;
    private javax.swing.JButton B10;
    private javax.swing.JButton B11;
    private javax.swing.JButton B12;
    private javax.swing.JButton B20;
    private javax.swing.JButton B21;
    private javax.swing.JButton B22;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}