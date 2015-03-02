/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciowebcine.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Usuario0301
 */
@javax.ws.rs.ApplicationPath("webcine")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(serviciowebcine.service.ClientesFacadeREST.class);
        resources.add(serviciowebcine.service.EntradasFacadeREST.class);
        resources.add(serviciowebcine.service.PeliculasFacadeREST.class);
        resources.add(serviciowebcine.service.PreciosFacadeREST.class);
        resources.add(serviciowebcine.service.ReservasFacadeREST.class);
    }
    
}
