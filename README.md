# Entorno de evaluación

Trabaje dentro de `/home/coder/project`. Los repositorios clonados deben quedar como subcarpetas de este directorio.

## Python

Ejecutar un script básico:

```bash
python archivo.py
```

Crear un entorno virtual para instalar paquetes:

```bash
python -m venv .venv
. .venv/bin/activate
python -m pip install nombre-paquete
```

## Java

Compilar y ejecutar una clase:

```bash
javac Archivo.java
java Archivo
```

Proyecto Maven:

```bash
mvn test
mvn package
```

## Spring Boot

Con Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Con Maven instalado:

```bash
mvn spring-boot:run
```

Con Gradle Wrapper:

```bash
./gradlew bootRun
```

Spring Boot puede usar el puerto `8080` dentro del contenedor. Cuando se publica con `-p 127.0.0.1:8081:8080`, la aplicación se abre en `http://localhost:8081`.

## Git y GitHub

Clonar un repositorio:

```bash
git clone https://github.com/usuario/repositorio.git
cd repositorio
```

Guardar y subir cambios:

```bash
git add .
git commit -m "Entrega"
git push
```

Verificar la identidad configurada:

```bash
git config --global user.name
git config --global user.email
```

Para subir por HTTPS, GitHub requiere autenticación válida. Puede utilizar un token personal o un mecanismo institucional previamente configurado.

## Copiar y pegar

- Editor: `Ctrl + V`.
- Alternativa en el editor: `Shift + Insert`.
- Terminal: `Ctrl + Shift + V` o `Shift + Insert`.
- Vista previa de Markdown: `Ctrl + Shift + V` sobre un archivo `.md`.

## Accesos sin barra lateral

- Explorador: `Ctrl + Shift + E`.
- Búsqueda: `Ctrl + Shift + F`.
- Control de versiones: `Ctrl + Shift + G`.
- Ejecución y depuración: `Ctrl + Shift + D`.
# icc-est-u2-ComparatorDocker
