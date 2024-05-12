package com.example.ProyectoMusica.controller;

import com.example.ProyectoMusica.service.ServicioCancion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Roxana
 * @date 18/04/2024
 */

@Controller
@RequestMapping("/musicmatch/home")
public class HomeController {
    ServicioCancion servicioCancion = new ServicioCancion();

    @GetMapping("/")
    public String crud(Model model) {
        String valorfinal = "./musicmatch/home";
        try {
            model.addAttribute("canciones", servicioCancion.listarAllCanciones());
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal = "error";
        }
        return valorfinal;
    }

}

