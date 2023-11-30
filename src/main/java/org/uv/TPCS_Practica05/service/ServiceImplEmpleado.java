package org.uv.TPCS_Practica05.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.TPCS_Practica05.data.Empleado;
import org.uv.TPCS_Practica05.data.RepositoryEmpleado;

/* @author miran */

@Service
public class ServiceImplEmpleado implements ServiceEmpleado{

    @Autowired
    private RepositoryEmpleado repositoryEmpleado;
    
    public ServiceImplEmpleado(RepositoryEmpleado repositoryEmpleado){
        this.repositoryEmpleado=repositoryEmpleado;
    }
    
    @Override
    public Empleado save(Empleado empleado) {
        return repositoryEmpleado.save(empleado);
    }

    @Override
    public List<Empleado> EmpleadoList() {
        return (List<Empleado>) repositoryEmpleado.findAll();
    }
    
    @Override
    public Empleado update(Empleado empleado, Long id) {
         
        return repositoryEmpleado.save(empleado);
    }

    @Override
    public void deleteById(Long id) {
        repositoryEmpleado.deleteById(id);
    }

    @Override
    public Empleado getUserById(Long id) {
        return repositoryEmpleado.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    
    
}
