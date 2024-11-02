# Parcial: API Mutant Detection - Desarrollo de Software (UTN) 🧬 

¡Bienvenido al repositorio del proyecto de detección de mutantes! Este trabajo práctico está basado en una prueba técnica y tiene como objetivo construir una API que identifique mutantes mediante secuencias de ADN utilizando principlamente Java y Spring Boot.

## ENUNCIADO

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Mens. Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN. Para eso te ha pedido crear un programa con un método o función con la siguiente firma:

En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representa cada base nitrogenada del ADN.

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical.

## DESAFIO

El desafío cuenta con 3 niveles:

✔️ **Nivel 1:**

Programar en java spring boot que cumpla con el método pedido por Magneto utilizando una arquitectura en capas de controladores, servicios y repositorios.

- Tecnologías: Java, Spring Boot.

✔️ **Nivel 2:**

- Hosting: Se desplegó la API-REST en la aplicación Render. 
- API REST: Se desarrolló una API REST con el servicio "/mutant/" que detecte mutantes a partir de una secuencia de ADN en formato JSON enviada por una solicitud HTTP con el método POST.

```
POST: https://mercadolibre-mutant.onrender.com/mutant/
{
"dna": ["AAAA", "CCCC", "TCAT", "AGGA"]
}

Response: 200-OK Es un mutante
```
- Respuesta del servicio:
      - 200-OK cuando es un mutante.
      - 403-Forbidden cuando no mutante.

✔️ **Nivel 3:**

- Base de Datos H2: Se implementa una base de datos H2, para almacenar las secuencias de ADN.
- JMeter: Se utiliza JMeter para probar fluctuaciones agresivas de tráfico.
- Estadísticas: Se expone un servicio "/stats" que como respuesta retorna un JSON con estadísticas de las secuencias de ADN guardadas:

```
GET: https://mercadolibre-mutant.onrender.com/stats

Response:
{
    “count_mutant_dna”:40, 
    “count_human_dna”:100, 
    “ratio”:0.4
}
```

## CÓMO EJECUTAR LA API MUTANT ?

-- LOCAL --

1) Descargar o clonar el repositorio
2) Abir IDE favorito y correr el programa main (ValentinoIsgroApplication)
3) Abrir POSTMAN
4) Copiar la url: http://localhost:8080
5) Probar:
   
   5.1) **POST** --> http://localhost:8080/mutant/
   
   5.2) **GET**  --> http://localhost:8080/stats



-- REMOTO --

1) Abrir POSTMAN
2) Copiar la url: https://mercadolibre-mutant.onrender.com
3) Probar:
   
   3.1) **POST** --> https://mercadolibre-mutant.onrender.com/mutant/

   3.2) **GET**  --> https://mercadolibre-mutant.onrender.com/stats


## DEPLOY (RENDER)

**LINK:**  https://mercadolibre-mutant.onrender.com

