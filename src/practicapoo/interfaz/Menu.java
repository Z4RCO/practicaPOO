package practicapoo.interfaz;

import practicapoo.Configuracion;
import practicapoo.enums.Letras;
import practicapoo.jugador.Jugador;
import practicapoo.palabra.Entrenamiento;

import javax.swing.*;

/**
 *
 * @author z3rc0
 */
public class Menu extends JPanel {
    /**
     * Crea un nuevo menú
     */
    public Menu() {
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

        iniciarSesion = new javax.swing.JButton();
        practicar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        iniciarSesion.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        iniciarSesion.setText("Iniciar Sesión");
        iniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSesionActionPerformed(evt);
            }
        });

        practicar.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        practicar.setText("Practicar");
        practicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                practicarActionPerformed(evt);
            }
        });

        salir.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        jLabel1.setText("Lingo");

        jLabel2.setIcon(new ImageIcon("resources/Logo.png"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(iniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(practicar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(270, 270, 270))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(343, 343, 343))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(iniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(practicar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void practicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_practicarActionPerformed
        Entrenamiento ent;
        Object[] opciones = {"Cinco", "Seis"};
        int n = JOptionPane.showOptionDialog(Main.getLienzo(),
                "Selecciona las letras de las palabras:",
                "Entrenamiento",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon("resources/LogIn.png"),
                opciones,
                opciones[0]);
        switch(n){
            case JOptionPane.YES_OPTION -> Configuracion.setLetras(Letras.CINCO);
            case JOptionPane.NO_OPTION -> Configuracion.setLetras(Letras.SEIS);
        }
        ent = new Entrenamiento();




    }//GEN-LAST:event_practicarActionPerformed

    private void iniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSesionActionPerformed
        pintarInicioSesion();

    }//GEN-LAST:event_iniciarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton iniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton practicar;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables

    private void pintarInicioSesion(){
        JPanel popup = new JPanel();
        JTextField user = new JTextField(20);
        JPasswordField pass = new JPasswordField(20);

        popup.setLayout(new BoxLayout(popup, BoxLayout.Y_AXIS));
        popup.add(new JLabel("Usuario"));
        popup.add(user);
        popup.add(new JLabel("Contraseña"));
        popup.add(pass);

        int i = JOptionPane.showConfirmDialog(
                Main.getLienzo(),
                popup,
                "Iniciar sesión",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon("resources/LogIn.png")
        );

        //si le has dado a OK y has puesto texto en los TextFields
        if (i != JOptionPane.OK_OPTION || user.getText().equals("") || (new String(pass.getPassword())).equals("")) {
            return;
        }

        Jugador j = new Jugador(user.getText(),new String( pass.getPassword()));
        if (!Main.getJugadores().autenticar(j)) {
            return;
        }
        if(j.equals(new Jugador("admin","admin")))Main.cambiarContenido(new Config());
        else{
            j = Main.getJugadores().getJugador(j);
            Main.cambiarContenido(new Sesion(j));
        }
    }
}
