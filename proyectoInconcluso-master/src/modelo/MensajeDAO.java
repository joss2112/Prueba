/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author joseph
 */
public class MensajeDAO {
    Conexion con;
    UsuarioDAO usr1= new UsuarioDAO();
    UsuarioDAO usr2= new UsuarioDAO();
    public MensajeDAO(Conexion con) {
        this.con = con;
    }
    
  public ArrayList<Mensaje> getMensaje(){
        
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM mensaje ";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                int idMensaje = Integer.parseInt(resultados.getString("id_mensaje"));
                int emisor = Integer.parseInt(resultados.getString("id_usr_emisor"));
                int receptor = Integer.parseInt(resultados.getString("id_usr_receptor"));
                String contenido = resultados.getString("contenido");
                usr1.getUsuario(emisor);
                usr2.getUsuario(receptor);
                     
                mensajes.add(new Mensaje(idMensaje,usr1,usr2,contenido));
            }
            accesoBD.close();
            return mensajes;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
    }
}
