package com.eoi.petstay.controllers;

import com.eoi.petstay.service.ImgFileSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ImgFileCtrl {

    @Autowired
    private ImgFileSrvc imgFsSrvc;

    @GetMapping("/subirimagen")
    String subirImg(){
        return "subirImagen";
    }

    /*
        Aquí recibimos el archivo que se desea subir
     */
    @PostMapping("/subirimagen")
    Long grabaImg(@RequestParam MultipartFile imagen) throws IOException {
        return imgFsSrvc.grabar(imagen.getBytes(), imagen.getOriginalFilename());
    }

}
