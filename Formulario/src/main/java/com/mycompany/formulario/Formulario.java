
package com.mycompany.formulario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Formulario extends JFrame{
    JPanel p = new JPanel();
    JScrollPane sc = new JScrollPane();
    JTable tabla = new JTable();
    Object filas [][]= new Object[50][3];
    int X = 0;
    


    
    
    public void Crear(){
        setTitle("Registro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(750,500);
        setVisible(true);
        p.setBackground(Color.YELLOW);
        p.setLayout(null);
        add(p);
        
        JLabel J1 = new JLabel("Nombre");
        J1.setBounds(20, 30, 75, 25);
        J1.setForeground(Color.BLUE);
        p.add(J1);
        
        JLabel J2 = new JLabel("Apellidos");
        J2.setBounds(20, 90, 75, 25);
        J2.setForeground(Color.BLUE);
        p.add(J2);
        
        JLabel J3 = new JLabel("Grado");
        J3.setBounds(20, 155, 75, 25);
        J3.setForeground(Color.BLUE);
        p.add(J3); 
        
        JTextField T1 = new JTextField();
        T1.setBounds(20, 50, 120, 20);
        p.add(T1);
        
        JTextField T2 = new JTextField();
        T2.setBounds(20, 110, 120, 20);
        p.add(T2);
        
        JTextField T3 = new JTextField();
        T3.setBounds(20, 175, 120, 20);
        p.add(T3);
        
        JButton B1 = new JButton("Nuevo");
        B1.setBounds(200, 375, 100, 30);
        p.add(B1);
        
        JButton B2 = new JButton("Actualizar");
        B2.setBounds(320, 375, 100, 30);
        p.add(B2);
        
        JButton B3 = new JButton("Borrar");
        B3.setBounds(440, 375, 100, 30);
        p.add(B3);
        
        ActionListener nuevo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(T1.getText().equals("")) && !(T2.getText().equals("")) && !(T3.getText().equals(""))){
                agregar(T1.getText(), T2.getText(), T3.getText());
                    T1.setText(null);
                    T2.setText(null);
                    T3.setText(null);
                    T1.requestFocus();
                    
            
                        } else{
                                JOptionPane.showMessageDialog(null,"Completa los Datos");
                                }
            }
        };
       B1.addActionListener(nuevo);
    }
    
    private void agregar(String nombre, String apellidos, String grado){
        if (X == 50){
            JOptionPane.showMessageDialog(null,"No se Acptan Mas Datos");
        }else {
            filas[X][0] = nombre;
            filas[X][1] = apellidos;
            filas[X][2] = grado;
            X++;
            sc.setVisible(false);
            tabla();
            
            
        }
    }
    
    public void tabla(){
        String columnas[] = {"Nombre", "Apellidos", "Grado"};
        tabla = new JTable(filas, columnas);
        sc = new JScrollPane(tabla);
        sc.setBounds(175, 30, 500, 300);
        p.add(sc);
        sc.setVisible(true);
                
        
    }
    
    
    public static void main(String[] args) {
        Formulario a = new Formulario();
        a.Crear();
        a.tabla();
        
        
        
    }
    
}
