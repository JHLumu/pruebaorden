package app.domain.services;

import app.domain.model.IInscripcion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenadorInscripcionesDomainService {

    public List<IInscripcion> ordenar(List<IInscripcion> ins) {
    	List<IInscripcion> resultado = new ArrayList<>(ins);
        resultado.sort(Comparator.comparingDouble(IInscripcion::getCredito));
        
        return resultado;
    }
}


