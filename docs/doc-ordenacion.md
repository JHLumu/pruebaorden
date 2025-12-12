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

# Iteracion 1 

### DEV1 ([Ver commit](https://github.com/asuliitoh/Calso2526_P6-grupo07/commit/8804e0ea8e56a1e7c2852fa49a9275ceb1183239))

Se implementa la lógica mínima en el servicio para ordenar la lista copiándola y usando un comparador por crédito.

```java
public List<IInscripcion> ordenar(List<IInscripcion> ins) {
    // 1. Creamos una nueva lista para no modificar la original
    List<IInscripcion> resultado = new ArrayList<>(ins);
    
    // 2. Ordenamos usando un comparador por crédito
    resultado.sort(Comparator.comparingDouble(IInscripcion::getCredito));
    
    return resultado;
}

