# **Clase bajo prueba (CUT):** `OrdenadorInscripcionesDomainService`

## Roles

Jesús  --->    Tester  
Jiahui   --->    Dev

## Identificación de Dobles de Prueba (Mocks y Stubs)

Para aislar completamente la lógica del caso de uso, se han identificado las siguientes dependencias que deben ser suplantadas durante los tests:

| Dependencia | Tipo de Doble | Justificación |
| :--- | :--- | :--- |
| **`IInscripcion`** | **Stub** | Es necesario consultar sus datos para la ordenación, por ello se debe definir la respuesta en sus getters. |

## Iteraciones de TDD

**Clase Test**: `OrdenadorInscripcionesDomainServiceTest`
**Clase Dev**: `OrdenadorInscripcionesDomainService`

### Iteracion 1 

#### TEST 1 ([Ver commit](https://github.com/asuliitoh/Calso2526_P6-grupo07/commit/8efe884d4c3e6c0445ace0652d29e853827147dc))
  
  **TEST 1.1 (Necesario debido a no incluir dependencias)** ([Ver commit](https://github.com/asuliitoh/Calso2526_P6-grupo07/commit/b3a06173662e26176e87d1cf1fb06b6ae4b0a1a1))
  
  **TEST 1.2 (Se ha comprendido de manera errónea la especificación: Se ordena de manera descendente, no ascendente)** ([Ver commit]( https://github.com/asuliitoh/Calso2526_P6-grupo07/commit/3596123e687e2fa5a00155d854591f6d92026cf6))

  Se añade un caso de prueba que verifica si el método `ordenar()` de 'OrdenadorInscripcionesDomainService' ordena inscripciones con diferente crédito.


  ```java
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
  
   List<IInscripcion> ordenada = List.of(inscripcionStub3, inscripcionStub1, inscripcionStub2);
   List<IInscripcion> resultado = ordenadorService.ordenar(lista);
  
   assertEquals(ordenada, resultado, "ERROR: ordenar() debe ordenar las inscripciones por créditos si no hay empate.");
 
  
 }

}
  ```


#### DEV1 ([Ver commit](https://github.com/asuliitoh/Calso2526_P6-grupo07/commit/8804e0ea8e56a1e7c2852fa49a9275ceb1183239))

**DEV1.2 Correccion añadida para satisfacer 1.2** ([VerCommit](https://github.com/asuliitoh/Calso2526_P6-grupo07/commit/cf4aee1387bbf081923015f4b0d6623d69f1b1ef))

Se implementa la lógica de ordenación creando una copia de la lista y utilizando un comparador por crédito en orden inverso (descendente), tal como exigen los requisitos.
```java
public List<IInscripcion> ordenar(List<IInscripcion> ins) {
    	List<IInscripcion> resultado = new ArrayList<>(ins);
        resultado.sort(Comparator.comparingDouble(IInscripcion::getCredito).reversed());
        
        return resultado;
    }
```

### Iteracion 2

#### TEST 2 ([Ver commit](https://github.com/asuliitoh/Calso2526_P6-grupo07/commit/299ae3ac58b69b03d1c160649e69864548454484))

Se añade un nuevo test para que, en caso de que las inscripciones tengan el mismo crédito, compruebe que se haya ordenado según el número de cursos de temática, de manera descendente.

```java

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
	

```