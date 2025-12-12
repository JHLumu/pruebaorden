package app.domain.services;

import app.domain.model.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class OrdenadorInscripcionesDomainServiceTest {

  
	@InjectMocks
	OrdenadorInscripcionesDomainService ordenadorService;
	
	@Test
	void test_GivenInscripcionesConDistintoCredito_WhenOrdenar_ThenReturnListaOrdenadaPorCreditos() {
	
		IInscripcion inscripcionStub1 = mock(IInscripcion.class);
		IInscripcion inscripcionStub2 = mock(IInscripcion.class);
		IInscripcion inscripcionStub3 = mock(IInscripcion.class);
		
		when(inscripcionStub1.getCredito()).thenReturn(20.0);
		when(inscripcionStub2.getCredito()).thenReturn(30.0);
		when(inscripcionStub3.getCredito()).thenReturn(10.0);
		
	  List<IInscripcion> lista =List.of(inscripcionStub1, inscripcionStub2, inscripcionStub3);
		
	  List<IInscripcion> ordenada = List.of(inscripcionStub3, inscripcionStub1, inscripcionStub2);
	  List<IInscripcion> resultado = ordenadorService.ordenar(lista);
	 
	  assertEquals(ordenada, resultado, "ERROR: ordenar() debe ordenar las inscripciones por créditos si no hay empate.");
		
		
	}
	
	



  //TEST2



  //TEST3



  //TEST4



  //TEST5



  //...

}
