# Taxi-Manager

El proyecto consistió en diseñar una arquitectura distribuida para una aplicación de manejo de viajes en taxi. La arquitectura incluyó componentes como una interfaz de usuario, servicios de ubicación, servicios de asignación, servicios de pago y servicios de monitoreo. Estos componentes fueron distribuidos en múltiples servidores para mejorar el rendimiento, la escalabilidad y la disponibilidad. La comunicación entre los componentes se realizó a través de APIs REST o mensajería. Este diseño permitirá a la aplicación manejar eficientemente viajes de taxi y proporcionar una experiencia de usuario satisfactoria.

## Estructura del Proyecto

- **Servicios**: Contiene los servicios tanto para la app móvil como para la app web. Los servicios están desarrollados en PHP.
- **Movil_Taxi**: Contiene la aplicación móvil desarrollada en Android Studio.
- **Web_Taxi**: Contiene la aplicación web desarrollada en Laravel.

## Configuración e Instalación

### Servicios

Para inicializar los servicios en PHP, sigue estos pasos:

1. Clona el repositorio:
    ```bash
    git clone https://github.com/karenlizbeth03/Taxi-Manager.git
    ```

2. Navega a la carpeta de servicios:
    ```bash
    cd taxi-manager/Servicios
    ```

3. Instala las dependencias utilizando Composer:
    ```bash
    composer install
    ```

4. Configura el archivo `.env` con los detalles de la base de datos y otros parámetros necesarios.

5. Inicia el servidor:
    ```bash
    php -S localhost:8000 -t public
    ```

### Aplicación Móvil (Movil_Taxi)

Para inicializar la aplicación móvil en Android Studio, sigue estos pasos:

1. Abre Android Studio y selecciona "Open an existing Android Studio project".

2. Navega a la carpeta `taxi-manager/Movil_Taxi` y ábrela.

3. Instala las dependencias necesarias utilizando Gradle.

4. Conecta tu dispositivo Android o utiliza un emulador.

5. Corre la aplicación haciendo clic en el botón "Run".

### Aplicación Web (Web_Taxi)

Para inicializar la aplicación web en Laravel, sigue estos pasos:

1. Navega a la carpeta de la aplicación web:
    ```bash
    cd taxi-manager/Web_Taxi
    ```

2. Instala las dependencias utilizando Composer:
    ```bash
    composer install
    ```

3. Copia el archivo `.env.example` a `.env` y configura los detalles de la base de datos y otros parámetros necesarios:
    ```bash
    cp .env.example .env
    ```

4. Genera la clave de la aplicación:
    ```bash
    php artisan key:generate
    ```

5. Corre las migraciones y seedea la base de datos:
    ```bash
    php artisan migrate --seed
    ```

6. Inicia el servidor de desarrollo:
    ```bash
    php artisan serve
    ```
