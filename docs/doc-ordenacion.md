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

Se implementa la lógica mínima en el servicio para ordenar la lista copiándola y usando un comparador por crédito.

```java
public List<IInscripcion> ordenar(List<IInscripcion> ins) {
    // 1. Creamos una nueva lista para no modificar la original
    List<IInscripcion> resultado = new ArrayList<>(ins);
    
    // 2. Ordenamos usando un comparador por crédito
    resultado.sort(Comparator.comparingDouble(IInscripcion::getCredito));
    
    return resultado;
}
```
