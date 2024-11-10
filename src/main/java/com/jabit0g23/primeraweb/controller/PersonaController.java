package com.jabit0g23.primeraweb.controller;

import com.jabit0g23.primeraweb.entities.Persona;
import com.jabit0g23.primeraweb.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    //La clase model se utiliza para transferir objetos del controller a la vista
    @GetMapping
    public String listarPersonas(Model model){
        List<Persona> personas = personaService.obtenerTodas();
        model.addAttribute("listaPersonas", personas); //key-valor
        return "listar";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevaPersona(Model model){
        model.addAttribute("persona" , new Persona());
        model.addAttribute("accion", "/personas/nueva");
        return "formulario";
    }

    @PostMapping("/nueva")
    public String guardarNuevaPersona(@ModelAttribute Persona persona){
        personaService.crearPersona(persona);
        return "redirect:/personas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id,@ModelAttribute Persona persona, Model model){
        model.addAttribute("persona" , persona);
        model.addAttribute("accion", "/personas/editar/"+id);
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String actualizarPersona(@PathVariable Long id, @ModelAttribute Persona persona){
        personaService.actualizarPersona(id, persona);
        return "redirect:/personas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersonas(@PathVariable Long id){
        personaService.eliminarPersona(id);
        return "redirect:/personas";
    }

}
