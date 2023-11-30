package org.uv.TPCS_Practica05.service;

import java.util.List;
import org.uv.TPCS_Practica05.data.Empleado;

/* @author miran */
public interface ServiceEmpleado {
    //save
    Empleado save(Empleado empleado);
    
    //find
    List<Empleado> EmpleadoList();
    
    //update
    Empleado update (Empleado empleado, Long id);
    
    //delete
    void deleteById(Long id);

    Empleado getUserById(Long id);
}
