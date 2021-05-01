# java-configuration-engine

![](https://img.shields.io/github/issues/evilelliot/java-configuration-engine) ![](https://img.shields.io/github/license/evilelliot/java-configuration-engine) ![](https://img.shields.io/badge/status-development-brightgreen)
## Descripción.
Java-Configuration-Engine (JCE) es un motor para manejar configuraciones sencillo y liviano que le permite al usuario cargar datos de configuración desde archivos JSON de una forma rápida y sencilla.

*Nota: este es un proyecto escolar, no se recomienda su uso en ambientes de producción debido a que continua en fase de desarrollo.*

## Features.
- Carga rápida de archivos.
- Carga de archivos de configuración directo a un proyecto.
- Verificación de la integridad de un archivo de configuración según modelo establecido.
- Carga mediante templates de configuración básicos.
- Implementación minimalista.
- Librería de bajo peso.

## Implementación.

*config.json*
```json
{
	"author": "Alberto Ocaranza",
	"version": "2.31",
	"description": "Motor simple para manejar archivos de configuración en 	formato JSON",
	"license": "GPL"
}
```
```java
import com.jce.Engine;
import com.jce.Templates;

// Usando un custom model
String[] ConfigData = {"author", "license"};
Engine config = new Engine(ConfigData);

// Usando models desde templates
Engine config = new Engine(Templates.BASIC_TEMPLATE);

// Integridad del archivo
config.probeIntegrity();

// Obteniendo el valor del item
config.getItem("auuthor");
```

## TODO
- Creación de archivos config desde modelos.
- Carga de archivos config custom (nombre y dirección).
- Conversión de archivos config a objetos.
- Manejo de items con datos anidados.
