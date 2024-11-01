# Parcial: API Mutant Detection - Desarrollo de Software (UTN) 🧬 

¡Bienvenido al repositorio del proyecto de detección de mutantes! Este trabajo práctico está basado en una prueba técnica y tiene como objetivo construir una API que identifique mutantes mediante secuencias de ADN utilizando principlamente Java y Spring Boot.

## DESAFIO

El desafío cuenta con 3 niveles:

✔️ **Nivel 1:**

Programa en java spring boot que cumpla con el método pedido por Magneto utilizando una arquitectura en capas de controladores, servicios y repositorios.

- Tecnologías: Java

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
      1) 200-OK cuando es un mutante
      2) 403-Forbidden cuando no mutante.

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

DEPLOY:
**LINK:** https://mercadolibre-mutant.onrender.com

