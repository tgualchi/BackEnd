/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.tob.Controller;

import com.porfolio.tob.Dto.dtoProyectos;
import com.porfolio.tob.Entity.Proyectos;
import com.porfolio.tob.Security.Controller.Mensaje;
import com.porfolio.tob.Service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/proyectos")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"https://frontendtg.web.app","http://localhost:4200"})
//@CrossOrigin(origins = "*")
public class CProyectos {

    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
  
@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyect){
        if(StringUtils.isBlank(dtoproyect.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
          if(sProyectos.existsByNombreP(dtoproyect.getNombreP()))
            return new ResponseEntity(new Mensaje("Este proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
     
        
         Proyectos proyectos = new Proyectos (dtoproyect.getNombreP(), dtoproyect.getDescripcionP(), dtoproyect.getImgP());
        sProyectos.save(proyectos);
         
        return new ResponseEntity(new Mensaje("Proyecto creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyect){
        //Validamos si existe el ID
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sProyectos.existsByNombreP(dtoproyect.getNombreP()) && sProyectos.getByNombreP(dtoproyect.getNombreP()).get().getId() != id)
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoproyect.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
     Proyectos proyectos = sProyectos.getOne(id).get();
     
     proyectos.setNombreP(dtoproyect.getNombreP());
     proyectos.setDescripcionP((dtoproyect.getDescripcionP()));
     proyectos.setImgP(dtoproyect.getImgP());
        
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);
             
    }
    
      @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no ID existe"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
      @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("no ID existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
}