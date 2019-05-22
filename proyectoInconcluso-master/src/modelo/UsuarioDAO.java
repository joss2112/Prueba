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
public class UsuarioDAO {
    Conexion con;

    public UsuarioDAO(Conexion con) {
        this.con = con;
    }

    public UsuarioDAO() {
    }
    
     public ArrayList<Usuario> getUsuarios(){
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM usuario ";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                int idUsuario = Integer.parseInt(resultados.getString("id_usuario"));
                String nombre = resultados.getString("nombre");
                usuarios.add(new Usuario(idUsuario,nombre));
            }
            accesoBD.close();
            return usuarios;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
        
    }
     public ArrayList<Usuario> getUsuario(int idU){
        
        ArrayList<Usuario> Usuario = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM usuario WHERE id_usuario='"+idU+"'";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                int idUsuario1 = Integer.parseInt(resultados.getString("id_usuario"));
                String nombre1 = resultados.getString("nombre");
                Usuario.add(new Usuario(idUsuario1,nombre1));
            }
            accesoBD.close();
            return Usuario;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
    }
}
