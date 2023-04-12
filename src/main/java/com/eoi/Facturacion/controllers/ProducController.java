package com.eoi.Facturacion.controllers;


import com.eoi.Facturacion.entities.Product;
import com.eoi.Facturacion.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products") //Al ponerlo antes de la clase, cualquier métdodo que tenga esta clase,
                            // va a tener este prefijo
public class ProducController {
    @Autowired //No necesitamos crear una instancia de ProductService porque Spring lo hace automáticamente
    private ProductService productService; //Para acceder a los métodos avanzados del servicio

    @GetMapping("/") //Model es el objeto que Spring usa para pasar a la vista (html) las variables que queremos
    public String showProducts(Model model){//Creamos el atributo "products" que contiene todos los productos mediante el método findAll del servicio
        model.addAttribute("products",productService.findAll());//Devuelve el nombre de la plantilla/vista (html) que queremos mostrar
                                                                            //La combinación de Springboot, Thymeleaf y Web nos permite usar el nombre de la vista sin poner la extensión
        return "product-list";
    }

    @GetMapping("/new") //Haces una petición en la que esperas que te devuelvan datos
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form"; //Te devuelven un nuevo objeto tipo Product ya rellenado y para que lo guardes en la BBDD
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/products/";
    }
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product-form"; //La plantilla de form para editar datos
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/products/";
    }
}


