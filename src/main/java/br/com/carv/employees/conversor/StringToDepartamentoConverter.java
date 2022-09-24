package br.com.carv.employees.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.carv.employees.domain.Departamento;
import br.com.carv.employees.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

    @Autowired
    private DepartamentoService departamentoService;

    @Override
    public Departamento convert(String source) {
        if (source.isEmpty()) {
            return null;
        }
        return departamentoService.buscarPorId(Long.parseLong(source));

    }
    
}
