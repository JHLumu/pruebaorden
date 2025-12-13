package app.domain.services;

import app.domain.model.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith; 
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
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
		
	  List<IInscripcion> ordenada = List.of(inscripcionStub2, inscripcionStub1, inscripcionStub3);
	  List<IInscripcion> resultado = ordenadorService.ordenar(lista);
	 
	  assertEquals(ordenada, resultado, "ERROR: ordenar() debe ordenar las inscripciones por créditos si no hay empate.");
	
	}
	
	
	@Test
	void test_GivenInscripcionesConMismoCredito_WhenOrdenar_ThenReturnListaOrdenadaPorCreditos() {
		
		IInscripcion inscripcionStub1 = mock(IInscripcion.class);
		IInscripcion inscripcionStub2 = mock(IInscripcion.class);
		IInscripcion inscripcionStub3 = mock(IInscripcion.class);
		
		when(inscripcionStub1.getCredito()).thenReturn(10.0);
		when(inscripcionStub2.getCredito()).thenReturn(10.0);
		when(inscripcionStub3.getCredito()).thenReturn(10.0);
		
		when(inscripcionStub1.getCursosEnTematica()).thenReturn(4);
		when(inscripcionStub2.getCursosEnTematica()).thenReturn(5);
		when(inscripcionStub3.getCursosEnTematica()).thenReturn(3);
		
	    List<IInscripcion> lista =List.of(inscripcionStub1, inscripcionStub2, inscripcionStub3);
	    List<IInscripcion> ordenada = List.of(inscripcionStub2, inscripcionStub1, inscripcionStub3);
	    
	    
		List<IInscripcion> resultado = ordenadorService.ordenar(lista);
		
		assertEquals(ordenada, resultado, "ERROR: ordenar() debe ordenar las inscripciones por número de cursos en la temática en caso de que haya empate en crédito");
		
	}
	



  //TEST2



  //TEST3



  //TEST4



  //TEST5



  //...

}
