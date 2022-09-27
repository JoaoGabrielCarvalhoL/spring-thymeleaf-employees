package br.com.carv.employees.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import br.com.carv.employees.domain.Cargo;
import br.com.carv.employees.service.CargoService;

public class StringToCargoConversor implements Converter<String, Cargo>{

    @Autowired
    private CargoService cargoService;

    @Override
    public Cargo convert(String text) {
        if (text.isEmpty()) {
            return null;
        } 
        return cargoService.buscarPorId(Long.parseLong(text));
        
    }
    
}
