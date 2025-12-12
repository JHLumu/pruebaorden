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

