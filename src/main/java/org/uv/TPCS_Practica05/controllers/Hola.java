package org.uv.TPCS_Practica05.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/*@author miran */
@RestController
@RequestMapping("/api/hola")
public class Hola {
    
    @GetMapping
    public DTOUsuario msg(){
        DTOUsuario usr= new DTOUsuario("Natalia", "calle 1",1355028);
        return usr;
    }
    
    @GetMapping("{id}")
    public DTOUsuario msg2(@PathVariable("id")Long id){
        DTOUsuario usr= new DTOUsuario("Natalia" + id, "calle 1" + id, 1355028);
        return usr;
    }
    
//    @PostMapping
//    public String mg2(){
//        return "Hola mundo con post";
//    }
    
    @PostMapping
    public String mg2(@RequestBody DTOUsuario usr){
        String msg= "Se recibió" + usr.getNombre() + "--"+usr.getDireccion()+"--"+usr.getTelefono();
        return "{msg:"+msg+"}";
    }
}

