/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.BandejaEntrada;

/**
 *
 * @author joseph
 */
public class ControladorBandeja implements ActionListener {
    BandejaEntrada bE;

    public ControladorBandeja(BandejaEntrada bE) {
        this.bE = bE;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("NuevM")){
            bE.setVisible(false);
            bE.nV.setVisible(true);
        }
    }
    
}
