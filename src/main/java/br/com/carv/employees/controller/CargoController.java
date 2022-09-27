package br.com.carv.employees.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.carv.employees.domain.Cargo;
import br.com.carv.employees.domain.Departamento;
import br.com.carv.employees.service.CargoService;
import br.com.carv.employees.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

    private final CargoService cargoService; 

    private final DepartamentoService departamentoService;

    @Autowired
    public CargoController(CargoService cargoService, DepartamentoService departamentoService) {
        this.cargoService = cargoService;
        this.departamentoService = departamentoService;
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Cargo cargo) {
        return "/cargo/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("cargos", cargoService.buscarTodos());
        return "/cargo/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "/cargo/cadastro";
        }

        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", "Cargo salvo com sucesso!");
        return "redirect:/cargos/cadastrar";
    }

    @ModelAttribute("departamentos")    
    public List<Departamento> listaDepartamentos() {
        return departamentoService.buscarTodos();
    }

    @GetMapping("/editar/{id}")
    public String preEditar (@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cargo", cargoService.buscarPorId(id));
        return "cargo/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
        
        if(result.hasErrors()) {
            return "/cargo/cadastro";
        }
        
        cargoService.atualizar(cargo);
        attr.addFlashAttribute("success", "Cargo editado com sucesso."); 
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        if (cargoService.cargoTemFuncionarios(id)) {
            attr.addFlashAttribute("fail", "Cargo não excluído. Possui funcionário(s) vinculado(s).");  
        } else {
            cargoService.excluirPorId(id);
            attr.addFlashAttribute("success", "Cargo excluído com sucesso!");
        }

        return "redirect:/cargos/listar";
    }


    
}