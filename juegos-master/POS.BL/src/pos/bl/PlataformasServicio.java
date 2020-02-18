/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.bl;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PlataformasServicio {
    private final ArrayList<Plataforma> listadePlataformas;

    public PlataformasServicio() {
        listadePlataformas = new ArrayList<>();
        
        crearDatosdePrueba();
    }
    
    public ArrayList<Plataforma> obtenerPlataformas() {
        return listadePlataformas;
    }

    private void crearDatosdePrueba() {
        Plataforma plataforma1 = new Plataforma("Nintendo Switch");
        plataforma1.setId(1);
        
        Plataforma plataforma2 = new Plataforma("PlayStation 4");
        plataforma2.setId(2);
        Plataforma plataforma3 = new Plataforma("XBOX One");
        plataforma2.setId(3);
        listadePlataformas.add(plataforma1);
        listadePlataformas.add(plataforma2);
        listadePlataformas.add(plataforma3);
    }
    
    
}
