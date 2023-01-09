/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package practicapoo.interfaz;

import practicapoo.Configuracion;
import practicapoo.enums.Letras;
import practicapoo.palabra.Intento;
import practicapoo.palabra.PistaDeLetra;
import practicapoo.partida.Partida;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;

/**
 * @author Sergio
 */
public class Palabra extends javax.swing.JPanel implements Externalizable {

    private char[] palabra;
    private Intento[] intentos;
    private int intentosRealizados;
    private Letras numLetras;
    private boolean regaloDeLetra;

    private PistaDeLetra pistaDeLetra;
    boolean esPartida;
    Partida partida;


    /**
     * Creates new form Palabra
     */
    public Palabra() {
        initComponents();
        numLetras = Configuracion.getNumLetras();
        regaloDeLetra = true;
        pistaDeLetra = new PistaDeLetra(this);
        intentos = new Intento[5];


    }

    public Palabra(Partida partida){
        initComponents();
        numLetras = Configuracion.getNumLetras();
        regaloDeLetra = true;
        pistaDeLetra = new PistaDeLetra(this);
        intentos = new Intento[5];
        this.partida = partida;
        this.esPartida = true;
        menuPrincipal.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        turno = new javax.swing.JLabel();
        numPuntos = new javax.swing.JLabel();
        confirmar = new javax.swing.JButton();
        ventana = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();
        pistaLetra = new javax.swing.JButton();
        pistaPalabra = new javax.swing.JButton();
        textPuntos = new javax.swing.JLabel();
        menuPrincipal = new javax.swing.JButton();

        turno.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        turno.setText("Turno de: ");

        numPuntos.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        numPuntos.setText("0");

        confirmar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });

        ventana.setToolTipText("Introduce una palabra");

        jScrollPane1.setViewportView(textPane);

        pistaLetra.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pistaLetra.setText("Usar pista de letra");
        pistaLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pistaLetraActionPerformed(evt);
            }
        });

        pistaPalabra.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pistaPalabra.setText("Regalo de palabra");
        pistaPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pistaPalabraActionPerformed(evt);
            }
        });

        textPuntos.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        textPuntos.setText("Puntos obtenidos:");

        menuPrincipal.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        menuPrincipal.setText("Menú Principal");
        menuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(126, 126, 126)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(42, 42, 42)
                                                                .addComponent(ventana, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(54, 54, 54)
                                                                .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(menuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(287, 287, 287)
                                                                                .addComponent(textPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(numPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addGap(0, 35, Short.MAX_VALUE)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(pistaPalabra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(pistaLetra, javax.swing.GroupLayout.Alignment.TRAILING))
                                                                                .addGap(21, 21, 21)))))))
                                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(textPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(numPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(pistaLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(pistaPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(ventana, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(36, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(menuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        if(ventana.getText().length() == numLetras.getSize()){
            jugar();
        }
    }//GEN-LAST:event_confirmarActionPerformed

    private void pistaLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pistaLetraActionPerformed
        if(!pistaDeLetra.regalarLetra()){
            appendToPane("Error. No puedes usar una pista de letra en este momento\n",Color.RED);
        }
        else{
            regaloDeLetra = false;
        }
    }//GEN-LAST:event_pistaLetraActionPerformed

    private void pistaPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pistaPalabraActionPerformed

    }//GEN-LAST:event_pistaPalabraActionPerformed

    private void menuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPrincipalActionPerformed
        Main.cambiarContenido(new Menu());
    }//GEN-LAST:event_menuPrincipalActionPerformed

    public void jugar() {
        String intento = ventana.getText();
        ventana.setText(null);
        appendToPane("Intento " + (intentosRealizados + 1) +": " + intento +"\n",Color.BLACK);
        intentos[intentosRealizados] = new Intento(intento.toCharArray());
        boolean victoria = comprobarColocadas();
        comprobarDistintaPosicion();
        ++intentosRealizados;
        if(victoria){
            if(esPartida){
                partida.actualizarMarcador(turno.getText(),puntosObtenidos());
                partida.cambiarTurno();

            }else{
                int puntos = Integer.parseInt(numPuntos.getText());
                puntos += puntosObtenidos();
                this.removeAll();
                initComponents();
                turno.setText("Entrenamiento");
                numPuntos.setText(String.valueOf(puntos));
                sacarPalabraAleatoria();
                appendToPane("Muy bien! Has adivinado la palabra en " + intentosRealizados + " intentos!\n",Color.BLACK);
                intentosRealizados = 0;
            }
        }
        if(intentosRealizados == 5){
            if (esPartida){
                partida.cambiarTurno();
            }
            else{
                int puntos = Integer.parseInt(numPuntos.getText());
                puntos += puntosObtenidos();
                this.removeAll();
                initComponents();
                turno.setText("Entrenamiento");
                numPuntos.setText(String.valueOf(puntos));
                String pal = new String(palabra);
                sacarPalabraAleatoria();
                appendToPane("La palabra era: " + pal.toUpperCase() +". Más suerte la próxima vez!\n",Color.BLACK);
                intentosRealizados = 0;
            }
        }


    }


    private boolean comprobarColocadas() {
        int correctas = 0;
        for (int i = 0; i < numLetras.getSize(); i++) {
            if (palabra[i] == intentos[intentosRealizados].recogerIntento()[i]) {
                ++correctas;
                appendToPane("La letra " + palabra[i] + " está en la posición correcta!\n",Color.GREEN);
            }
        }
        if(correctas == Configuracion.getNumLetras().getSize())return true;
        return false;
    }

    private int numApariciones(char c) {
        int res = 0;
        String s1 = new String(this.palabra);
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == c) {
                res++;
            }
        }
        return res;
    }

    private void comprobarDistintaPosicion() {
        for (int i = 0; i < numLetras.getSize(); i++) {
            char c = intentos[intentosRealizados].recogerIntento()[i];
            if (numApariciones(c) > 0 && palabra[i] != c) {
                appendToPane("La letra " + c + " está en otra posición\n",Color.ORANGE);
            } else if (numApariciones(c) == 0) {
                appendToPane("La letra " + c + " no está en la palabra\n",Color.GRAY);
            }
        }
    }


    public int puntosObtenidos() {
        return (6 - intentosRealizados);
    }

    public void sacarPalabraAleatoria() {
        if (numLetras == Letras.CINCO) {
            Palabra[] palabras = Main.getPalabras().getPalabrasDeCinco();
            int rnd = (int) (Math.random() * palabras.length);
            this.palabra = palabras[rnd].palabra;
        } else if (numLetras == Letras.SEIS) {
            Palabra[] palabras = Main.getPalabras().getPalabrasDeSeis();
            int rnd = (int) (Math.random() * palabras.length);
            this.palabra = palabras[rnd].palabra;
        }
    }

    public void mostrarIntentoResuelto() {

    }

    public void secuenciaResultados() {
    }

    public char[] getPalabra() {
        return palabra;
    }

    public void setPalabra(char[] palabra) {
        this.palabra = palabra;
    }

    public boolean isRegaloDeLetra() {
        return regaloDeLetra;
    }

    public JTextPane getTextArea() {
        return textPane;
    }

    public Intento[] getIntentos() {
        return intentos;
    }

    public void setTurno(String jugador){
        this.turno.setText(jugador);
    }


    /**
     * Método para cambiar el contenido del panel, permitiendo usar colores
     * Modificado de https://stackoverflow.com/questions/9650992/how-to-change-text-color-in-the-jtextarea
     * @param msg  String para escribir en el Pane
     * @param c  Color para pintar el texto
     */
    public void appendToPane(String msg, Color c)
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = textPane.getDocument().getLength();
        textPane.setCaretPosition(len);
        textPane.setCharacterAttributes(aset, false);
        textPane.replaceSelection(msg);
    }

    public String getTurno(){
        return this.turno.getText();
    }

    public void setPuntos(int puntos){
        numPuntos.setText(String.valueOf(puntos));
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menuPrincipal;
    private javax.swing.JLabel numPuntos;
    private javax.swing.JButton pistaLetra;
    private javax.swing.JButton pistaPalabra;
    private javax.swing.JTextPane textPane;
    private javax.swing.JLabel textPuntos;
    private javax.swing.JLabel turno;
    private javax.swing.JTextField ventana;

    @Override
    public String toString() {
        return "Palabra:" + Arrays.toString(palabra) + "\n";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        int size = palabra.length;
        out.write(size);
        for (int i = 0; i < size; i++) {
            out.writeChar(palabra[i]);
        }
        for (Intento i : intentos){
            out.writeObject(i);
        }
        out.write(this.intentosRealizados);
        out.writeObject(this.numLetras);
        out.writeBoolean(this.regaloDeLetra);
        out.writeObject(pistaDeLetra);
        out.writeBoolean(esPartida);
        out.writeObject(partida);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int size = in.read();
        palabra = new char[size];
        for (int i = 0; i < size; i++) {
            palabra[i] = in.readChar();
        }
        for (int i = 0; i < 5; i++) {
            intentos[i] = (Intento) in.readObject();
        }
        intentosRealizados = in.read();
        numLetras = (Letras) in.readObject();
        regaloDeLetra = in.readBoolean();
        pistaDeLetra = (PistaDeLetra) in.readObject();
        esPartida = in.readBoolean();
        partida = (Partida) in.readObject();
    }
    // End of variables declaration//GEN-END:variables
}
