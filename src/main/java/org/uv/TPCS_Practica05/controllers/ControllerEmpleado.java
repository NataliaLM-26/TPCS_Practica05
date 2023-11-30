package org.uv.TPCS_Practica05.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.uv.TPCS_Practica05.data.Empleado;
import org.uv.TPCS_Practica05.data.RepositoryEmpleado;
import org.uv.TPCS_Practica05.service.ServiceEmpleado;

/* @author miran */
@RestController
@RequestMapping("/api/empleado")
public class ControllerEmpleado {
    @Autowired
    private ServiceEmpleado serviceEmpleado;

    public ControllerEmpleado(ServiceEmpleado serviceEmpleado) {
        this.serviceEmpleado = serviceEmpleado;
    }
    
    
    
    @GetMapping()
    public List<Empleado> list() {
        return serviceEmpleado.EmpleadoList();
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable Long id) {
//        return repositoryEmpleado.findById(id);
        return serviceEmpleado.getUserById(id);
    }
    
    //update
    @PutMapping("/{id}")
    public Empleado put(@RequestBody Empleado empleado, Long id) {
        return serviceEmpleado.update(empleado,id);
    }
    
    //save
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Empleado empleado) {
        Empleado emple=serviceEmpleado.save(empleado);
        return ResponseEntity.ok(emple);
    }
//    @PostMapping
//    public Empleado save(@RequestBody Empleado empleado) {
//        return serviceEmpleado.save(empleado);
//    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceEmpleado.deleteById(id);
    }
    
}
