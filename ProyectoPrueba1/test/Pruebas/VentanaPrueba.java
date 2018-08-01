/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.awt.Color;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JComboBox;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author Adrián
 */
public class VentanaPrueba extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrueba
     */
    PanamaHitek_Arduino Arduino = new PanamaHitek_Arduino();
    PanamaHitek_Arduino ArduinoSensor = new PanamaHitek_Arduino();
    PanamaHitek_Arduino ArduinoMotor = new PanamaHitek_Arduino();
    ControlVentanas cv = new ControlVentanas();
    InterpreteMensaje im = new InterpreteMensaje();
    
    SerialPortEventListener escuchar = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
                try {
                    if (ArduinoSensor.isMessageAvailable()){
                        im.desfragmentador(ArduinoSensor.printMessage());
                        LuzValor.setText(im.luz + "%");
                        TInternaValor.setText(im.temp + " *C");
                        HInternaValor.setText(im.hum + "%"); 
                        verificar();
                    }
                }catch(SerialPortException | ArduinoException ex){
                    Logger.getLogger(VentanaPrueba.class.getName()).log(Level.SEVERE,null, ex);
                }
        }
    };

    private void verificar() throws ArduinoException {
       
        int valor_Luz = Integer.parseInt(im.luz);
           if(80 <= valor_Luz){
               try {
                   ArduinoMotor.sendData("1");
               } catch (SerialPortException ex) {
                   Logger.getLogger(VentanaPrueba.class.getName()).log(Level.SEVERE, null, ex);
               }
           }else{
               try {
                   ArduinoMotor.sendData("0");
               } catch (SerialPortException ex) {
                   Logger.getLogger(VentanaPrueba.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
    }
    

    public VentanaPrueba() {
        initComponents();
        getPorts();
        String luz = "";
        String temp = "";
        String hum = "";
    }
    
    public void getPorts() {
        PuertoSensores.removeAllItems();
        PuertoMotor.removeAllItems();
        if (Arduino.getPortsAvailable() > 0) {
            Arduino.getSerialPorts().forEach(i -> PuertoSensores.addItem(i));
            Arduino.getSerialPorts().forEach(i -> PuertoMotor.addItem(i));
            Conexion.setEnabled(true);
            Conexion.setBackground(new Color(255, 255, 255));
        } else {
            Conexion.setEnabled(false);
            Conexion.setBackground(new Color(204, 204, 204));
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Datos = new javax.swing.JPanel();
        Automatico = new javax.swing.JButton();
        Manual = new javax.swing.JButton();
        TemperarutaTexto = new javax.swing.JLabel();
        HumedadTexto = new javax.swing.JLabel();
        LuminocidadTexto = new javax.swing.JLabel();
        VientoTexto = new javax.swing.JLabel();
        TInternaTexto = new javax.swing.JLabel();
        TExternaTexto = new javax.swing.JLabel();
        TExternaValor = new javax.swing.JTextField();
        TInternaValor = new javax.swing.JTextField();
        HInternaTexto = new javax.swing.JLabel();
        HExternaTexto = new javax.swing.JLabel();
        HInternaValor = new javax.swing.JTextField();
        HExternaValor = new javax.swing.JTextField();
        LuzValor = new javax.swing.JTextField();
        VelocidadTexto = new javax.swing.JLabel();
        DireccionTexto = new javax.swing.JLabel();
        VelocidadValor = new javax.swing.JTextField();
        DireccionValor = new javax.swing.JTextField();
        ConexionArduino = new javax.swing.JPanel();
        PuertoSensores = new javax.swing.JComboBox<>();
        SensoresTexto = new javax.swing.JLabel();
        MotoresTexto = new javax.swing.JLabel();
        PuertoMotor = new javax.swing.JComboBox<>();
        Actualizar = new javax.swing.JButton();
        Conexion = new javax.swing.JButton();
        Luz = new javax.swing.JLabel();
        Temp = new javax.swing.JLabel();
        Configuracion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Motores = new javax.swing.JPanel();
        Mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Automatico.setText("Automático");
        Automatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutomaticoActionPerformed(evt);
            }
        });

        Manual.setText("Manual");
        Manual.setPreferredSize(new java.awt.Dimension(87, 23));
        Manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManualActionPerformed(evt);
            }
        });

        TemperarutaTexto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TemperarutaTexto.setText("Temperatura");

        HumedadTexto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        HumedadTexto.setText("Húmedad");

        LuminocidadTexto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LuminocidadTexto.setText("Intensidad Lumínica");

        VientoTexto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        VientoTexto.setText("Viento");

        TInternaTexto.setText("Interna");

        TExternaTexto.setText("Externa");

        TExternaValor.setEditable(false);
        TExternaValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TExternaValorActionPerformed(evt);
            }
        });

        TInternaValor.setEditable(false);
        TInternaValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TInternaValorActionPerformed(evt);
            }
        });

        HInternaTexto.setText("Interna");

        HExternaTexto.setText("Externa");

        HInternaValor.setEditable(false);
        HInternaValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HInternaValorActionPerformed(evt);
            }
        });

        HExternaValor.setEditable(false);
        HExternaValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HExternaValorActionPerformed(evt);
            }
        });

        LuzValor.setEditable(false);
        LuzValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LuzValorActionPerformed(evt);
            }
        });

        VelocidadTexto.setText("Velocidad");

        DireccionTexto.setText("Dirección");

        VelocidadValor.setEditable(false);
        VelocidadValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VelocidadValorActionPerformed(evt);
            }
        });

        DireccionValor.setEditable(false);
        DireccionValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DireccionValorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DatosLayout = new javax.swing.GroupLayout(Datos);
        Datos.setLayout(DatosLayout);
        DatosLayout.setHorizontalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addComponent(Manual, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 409, Short.MAX_VALUE)
                        .addComponent(Automatico, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HInternaTexto)
                            .addComponent(HInternaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VientoTexto)
                            .addComponent(TemperarutaTexto)
                            .addComponent(LuzValor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LuminocidadTexto)
                            .addGroup(DatosLayout.createSequentialGroup()
                                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(VelocidadTexto)
                                    .addComponent(VelocidadValor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TInternaTexto)
                                    .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TInternaValor)
                                        .addComponent(HumedadTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(37, 37, 37)
                                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TExternaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TExternaTexto)
                                    .addComponent(DireccionValor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DireccionTexto)
                                    .addComponent(HExternaTexto)
                                    .addComponent(HExternaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        DatosLayout.setVerticalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(TemperarutaTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addComponent(TInternaTexto)
                        .addGap(8, 8, 8)
                        .addComponent(TInternaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HumedadTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HInternaTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HInternaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addComponent(TExternaTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TExternaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HExternaTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HExternaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(VientoTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VelocidadTexto)
                    .addComponent(DireccionTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VelocidadValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DireccionValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LuminocidadTexto)
                .addGap(5, 5, 5)
                .addComponent(LuzValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Manual, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Automatico, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(123, 123, 123))
        );

        jTabbedPane1.addTab("Datos", Datos);
        Datos.getAccessibleContext().setAccessibleName("");

        PuertoSensores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        PuertoSensores.setSelectedIndex(-1);
        PuertoSensores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PuertoSensoresActionPerformed(evt);
            }
        });

        SensoresTexto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SensoresTexto.setText("Arduino Sensores");

        MotoresTexto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MotoresTexto.setText("Arduino Motores");

        PuertoMotor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        PuertoMotor.setSelectedIndex(-1);
        PuertoMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PuertoMotorActionPerformed(evt);
            }
        });

        Actualizar.setText("Actualizar Puertos");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Conexion.setText("Establecer Conexión");
        Conexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConexionActionPerformed(evt);
            }
        });

        Luz.setName("luz"); // NOI18N

        javax.swing.GroupLayout ConexionArduinoLayout = new javax.swing.GroupLayout(ConexionArduino);
        ConexionArduino.setLayout(ConexionArduinoLayout);
        ConexionArduinoLayout.setHorizontalGroup(
            ConexionArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConexionArduinoLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(ConexionArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SensoresTexto)
                    .addComponent(PuertoSensores, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ConexionArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Actualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Conexion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(128, 128, 128)
                .addGroup(ConexionArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MotoresTexto)
                    .addComponent(PuertoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Temp)
                    .addComponent(Luz, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        ConexionArduinoLayout.setVerticalGroup(
            ConexionArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConexionArduinoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(ConexionArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SensoresTexto)
                    .addComponent(MotoresTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ConexionArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PuertoSensores)
                    .addComponent(PuertoMotor, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(74, 74, 74)
                .addGroup(ConexionArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Luz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ConexionArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Conexion)
                    .addComponent(Temp))
                .addContainerGap(339, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Conexión Arduino", ConexionArduino);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Valores predeterminados:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Temperatura (*C):");

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("28");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Húmedad (%):");

        jTextField2.setEditable(false);
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("40");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Intensidad Luminica (%):");

        jTextField3.setEditable(false);
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("80");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Configuración de motores:");

        jButton1.setText("Guardar");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConfiguracionLayout = new javax.swing.GroupLayout(Configuracion);
        Configuracion.setLayout(ConfiguracionLayout);
        ConfiguracionLayout.setHorizontalGroup(
            ConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfiguracionLayout.createSequentialGroup()
                .addGroup(ConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConfiguracionLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(ConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)))
                    .addGroup(ConfiguracionLayout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addGroup(ConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ConfiguracionLayout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(ConfiguracionLayout.createSequentialGroup()
                                .addGroup(ConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(29, 29, 29)
                                .addGroup(ConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))))))
                .addContainerGap(310, Short.MAX_VALUE))
        );
        ConfiguracionLayout.setVerticalGroup(
            ConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfiguracionLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(ConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(ConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(207, 207, 207))
        );

        jTabbedPane1.addTab("Configuración", Configuracion);

        javax.swing.GroupLayout MotoresLayout = new javax.swing.GroupLayout(Motores);
        Motores.setLayout(MotoresLayout);
        MotoresLayout.setHorizontalGroup(
            MotoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 797, Short.MAX_VALUE)
        );
        MotoresLayout.setVerticalGroup(
            MotoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Motores", Motores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Mensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Mensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Principal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManualActionPerformed

    private void HExternaValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HExternaValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HExternaValorActionPerformed

    private void VelocidadValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VelocidadValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VelocidadValorActionPerformed

    private void ConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConexionActionPerformed
        if (Conexion.getText().equals("Desconectar")) {
            try {
                ArduinoMotor.killArduinoConnection();
                ArduinoSensor.killArduinoConnection();
                Conexion.setText("Conectar");
                cv.disableButton(Manual);
                cv.disableButton(Automatico);
                cv.enableConnectionPanel(Actualizar, PuertoMotor, PuertoSensores);
            } catch (Exception ex) {
                Logger.getLogger(VentanaPrueba.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            try {
                ArduinoSensor.arduinoRXTX(PuertoSensores.getSelectedItem().toString(), 9600, escuchar);
                ArduinoMotor.arduinoTX(PuertoMotor.getSelectedItem().toString(), 9600);
                Conexion.setText("Desconectar");
                cv.enableButton(Manual); // enable automatico
                cv.disableConnectionPanel(Actualizar, PuertoMotor, PuertoSensores);
            } catch (Exception ex) {
                Logger.getLogger(VentanaPrueba.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ConexionActionPerformed

    private void AutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutomaticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AutomaticoActionPerformed

    private void TInternaValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TInternaValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TInternaValorActionPerformed

    private void TExternaValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TExternaValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TExternaValorActionPerformed

    private void HInternaValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HInternaValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HInternaValorActionPerformed

    private void DireccionValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DireccionValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DireccionValorActionPerformed

    private void LuzValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LuzValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LuzValorActionPerformed

    private void PuertoSensoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PuertoSensoresActionPerformed
        
    }//GEN-LAST:event_PuertoSensoresActionPerformed

    private void PuertoMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PuertoMotorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PuertoMotorActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        getPorts();
    }//GEN-LAST:event_ActualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrueba().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Automatico;
    private javax.swing.JButton Conexion;
    private javax.swing.JPanel ConexionArduino;
    private javax.swing.JPanel Configuracion;
    private javax.swing.JPanel Datos;
    private javax.swing.JLabel DireccionTexto;
    private javax.swing.JTextField DireccionValor;
    private javax.swing.JLabel HExternaTexto;
    private javax.swing.JTextField HExternaValor;
    private javax.swing.JLabel HInternaTexto;
    private javax.swing.JTextField HInternaValor;
    private javax.swing.JLabel HumedadTexto;
    private javax.swing.JLabel LuminocidadTexto;
    private javax.swing.JLabel Luz;
    private javax.swing.JTextField LuzValor;
    private javax.swing.JButton Manual;
    private javax.swing.JLabel Mensaje;
    private javax.swing.JPanel Motores;
    private javax.swing.JLabel MotoresTexto;
    private javax.swing.JComboBox<String> PuertoMotor;
    private javax.swing.JComboBox<String> PuertoSensores;
    private javax.swing.JLabel SensoresTexto;
    private javax.swing.JLabel TExternaTexto;
    private javax.swing.JTextField TExternaValor;
    private javax.swing.JLabel TInternaTexto;
    private javax.swing.JTextField TInternaValor;
    private javax.swing.JLabel Temp;
    private javax.swing.JLabel TemperarutaTexto;
    private javax.swing.JLabel VelocidadTexto;
    private javax.swing.JTextField VelocidadValor;
    private javax.swing.JLabel VientoTexto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}