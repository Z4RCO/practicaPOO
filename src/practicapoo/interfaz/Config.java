package practicapoo.interfaz;

import practicapoo.Configuracion;
import practicapoo.jugador.AlmacenDeJugadores;
import practicapoo.jugador.Jugador;
import practicapoo.partida.AlmacenDePartidas;

import javax.swing.*;

/**
 * Interfaz para permitir al administrador tratar toda la información del programa
 * Contiene varios botones para cada una de las acciones necesarias
 */
public class Config extends javax.swing.JPanel {
    /**
     * Creates new form Config
     */
    public Config() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        verInfoPartidas = new javax.swing.JButton();
        editarConfig = new javax.swing.JButton();
        alta = new javax.swing.JButton();
        baja = new javax.swing.JButton();
        cerrarSesion = new javax.swing.JButton();

        verInfoPartidas.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        verInfoPartidas.setText("Ver información de las partidas");
        verInfoPartidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInfoPartidasActionPerformed(evt);
            }
        });

        editarConfig.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        editarConfig.setText("Cambiar Configuración");
        editarConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarConfigActionPerformed(evt);
            }
        });

        alta.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        alta.setText("Dar de alta un jugador");
        alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaActionPerformed(evt);
            }
        });

        baja.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        baja.setText("Dar de baja un jugador");
        baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaActionPerformed(evt);
            }
        });

        cerrarSesion.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        cerrarSesion.setText("Cerrar sesión");
        cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(verInfoPartidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editarConfig, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(baja)))
                .addGap(173, 173, 173))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(editarConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(verInfoPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alta, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(baja, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editarConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarConfigActionPerformed
        Configuracion.setter(JOptionPane.showInputDialog("Introduce la ruta del nuevo archivo de donfiguración"));
    }//GEN-LAST:event_editarConfigActionPerformed

    private void verInfoPartidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInfoPartidasActionPerformed
        AlmacenDePartidas partidas = Main.getPartidas();
        JScrollPane sp = new JScrollPane();
        JTextArea t = new JTextArea(partidas.infoPartidas());
        t.setColumns(30);
        t.setRows(10);
        sp.setViewportView(t);

        JOptionPane.showMessageDialog(Main.getLienzo(), sp, "Información de todas las partidas.", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_verInfoPartidasActionPerformed

    private void altaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaActionPerformed
        AlmacenDeJugadores j = Main.getJugadores();

        JPanel popup = new JPanel();
        JTextField user = new JTextField(20);
        JPasswordField pass = new JPasswordField(20);

        popup.setLayout(new BoxLayout(popup, BoxLayout.Y_AXIS));
        popup.add(new JLabel("Usuario"));
        popup.add(user);
        popup.add(new JLabel("Contraseña"));
        popup.add(pass);
        int i = JOptionPane.showConfirmDialog(
                Main.getLienzo(), popup, "Iniciar sesión",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon("resources/Usuario.png")
        );

        //si le has dado a OK y has puesto texto en los TextFields
        if (i == JOptionPane.OK_OPTION && !user.getText().equals("") && !(new String(pass.getPassword())).equals("")) {
            Jugador jugador = new Jugador(user.getText(), new String(pass.getPassword()));
            j.alta(jugador);
        }


    }//GEN-LAST:event_altaActionPerformed

    private void bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaActionPerformed
        AlmacenDeJugadores j = Main.getJugadores();

        JPanel popup = new JPanel();
        JTextField user = new JTextField(20);
        JPasswordField pass = new JPasswordField(20);

        popup.setLayout(new BoxLayout(popup, BoxLayout.Y_AXIS));
        popup.add(new JLabel("Usuario"));
        popup.add(user);
        int i = JOptionPane.showConfirmDialog(
                Main.getLienzo(),
                popup,
                "Iniciar sesión",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon("resources/Usuario.png")
        );

        //si le has dado a OK y has puesto texto en los TextFields
        if (i != JOptionPane.OK_OPTION || user.getText().equals("") || (new String(pass.getPassword())).equals("")) {
            return;
        }
        Jugador jugador = new Jugador(user.getText(), new String(pass.getPassword()));
        j.baja(jugador);

    }//GEN-LAST:event_bajaActionPerformed

    private void cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionActionPerformed
        Main.cambiarContenido(new Menu());
    }//GEN-LAST:event_cerrarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alta;
    private javax.swing.JButton baja;
    private javax.swing.JButton cerrarSesion;
    private javax.swing.JButton editarConfig;
    private javax.swing.JButton verInfoPartidas;
    // End of variables declaration//GEN-END:variables
}
