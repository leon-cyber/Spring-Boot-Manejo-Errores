package com.bolsadeideas.springboot.app.springbooterror.controllers;

import com.bolsadeideas.springboot.app.springbooterror.errors.UsuarioNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler({ArithmeticException.class})
    public String aritmeticaError(Exception ex, Model model){
        model.addAttribute("error","Error de aritmetica");
        model.addAttribute("message",ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp",new Date());
        return "error/generica";
    }
    @ExceptionHandler(NumberFormatException.class)
    public String numeroFormatoError(NumberFormatException ex,Model model){
        model.addAttribute("error","Error:Formato numero invalido");
        model.addAttribute("message",ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp",new Date());
        return "error/numero-formato";
    }
    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public String UsuarioNoEncontrado(UsuarioNoEncontradoException ex, Model model){
        model.addAttribute("error","Error:Usuario no existe");
        model.addAttribute("message",ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp",new Date());
        return "error/usuario";
    }
}
