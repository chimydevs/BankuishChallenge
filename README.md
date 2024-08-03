# Bankuish Challenge

**Bankuish Challenge** es una aplicación Android desarrollada en Kotlin y Jetpack Compose que permite buscar y visualizar repositorios de GitHub. Esta aplicación utiliza arquitectura MVVM y está equipada con funcionalidades como Pull-to-Refresh y navegación entre pantallas.

### Estructura del Proyecto

**bankuishchallenge**

<details>
  <summary><strong>data</strong> <em>(click aquí para desplegar)</em></summary>
  <span>&emsp;» model</span></br>
  <span>&emsp;&emsp;» RepositoryModel</span></br>
  <span>&emsp;&emsp;» SearchResponse</span></br>
  <span>&emsp;» network</span></br>
  <span>&emsp;&emsp;» GitHubApiService</span></br>
  <span>&emsp;&emsp;» RetrofitClient</span></br>
  <span>&emsp;» repository</span></br>
  <span>&emsp;&emsp;» Repository</span></br>
</details>

<details>
  <summary><strong>di</strong> <em>(click aquí para desplegar)</em></summary>
  <span>&emsp;» KoinModule</span></br>
</details>

<details>
  <summary><strong>ui</strong> <em>(click aquí para desplegar)</em></summary>
  <span>&emsp;» theme</span></br>
  <span>&emsp;&emsp;» Color</span></br>
  <span>&emsp;&emsp;» Theme</span></br>
  <span>&emsp;&emsp;» Type</span></br>
  <span>&emsp;» DetailScreen</span></br>
  <span>&emsp;» MainActivity</span></br>
  <span>&emsp;» MainScreen</span></br>
  <span>&emsp;» Navigation</span></br>
  <span>&emsp;» PullToRefresh</span></br>
</details>

<details>
  <summary><strong>viewmodel</strong> <em>(click aquí para desplegar)</em></summary>
  <span>&emsp;» MainViewModel</span></br>
</details>

### Imágenes

Aquí puedes ver algunas capturas de pantalla de la aplicación:

- **Pantalla 1 y Pantalla 2:**

  <div style="display: flex; justify-content: space-around;">
    <img width="188" alt="screen1" src="https://github.com/user-attachments/assets/8f69353f-e2a4-495d-857b-ba04864bf40d" style="margin-right: 10px;">
    <img width="188" alt="screen2" src="https://github.com/user-attachments/assets/7a8a8e8b-d71f-4ee7-914c-b772e3b4fb43">
  </div>

### Funcionalidades

- **Arquitectura MVVM:** La aplicación está estructurada siguiendo el patrón MVVM para una separación clara de responsabilidades.
- **Pull-to-Refresh:** Implementada en la pantalla principal para actualizar los datos de repositorios.
- **Navegación:** Configurada para permitir la transición entre pantallas de detalle y principal.
- **Inyección de Dependencias:** Utiliza Koin para la gestión de dependencias.


