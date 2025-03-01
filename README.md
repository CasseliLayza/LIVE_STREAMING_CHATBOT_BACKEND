# 🤖 Backend

## 📜 Descripción
Este es un 🖥️ backend para gestionar funcionalidades de un 🤖. Utiliza 🪵 Spring Boot y 🎙️ MaryTTS para 🔊 texto a voz. Implementa 📩 colas y 🎭 hilos para procesar las solicitudes de 🗣️ en orden secuencial.

## 📂 Estructura del Proyecto

El 📂 principal del 🏗️ es `D:\PROJECTS\BACKEND\CASSE\botBackend` y contiene la siguiente 📑:

```
/💡 - Configuraciones de 🏗️ IntelliJ IDEA
/🛠️ - Configuración de Maven Wrapper
/📜 - Archivos de 🔍
/💾 - Código fuente y 📚
/🎯 - Archivos 🔨 y 📦
/.🚫 - Archivo para excluir 📄 en el control de 📜
📖.md - 📚 de ayuda
🛠️, 🛠️.cmd - Scripts de 🏗️
📜.xml - Configuración de 🏗️
📖.md - 📚 del 🏗️
```

### 📂 `src`

El 📂 `src` contiene el 💾 fuente organizado en:

```
/src/main/java/com/backend/boot         - 🖥️ principal del 🤖
/src/main/java/com/backend/boot/function - 🤖 lógico (ej. 🎭 VoiceQueue.java)
/src/main/java/marytts/tools            - 🤝 con 🎙️
/src/main/resources                     - 🔧
/src/main/resources/img                  - 🖼️ utilizadas en el 🏗️
/src/test/java/com/backend/boot         - 🧪
```

## 📌 Requisitos

- ☕ Java 17+
- 🏗️ Maven
- 🪵 Spring Boot
- 🎙️ MaryTTS

## 📥 Instalación

1. 📥 el 📜:
   ```sh
   git clone https://github.com/CasseliLayza/LIVE_STREAMING_CHATBOT_BACKEND
   ```
2. 📂 al 📜:
   ```sh
   cd botBackend
   ```
3. 🏗️ el 🏗️:
   ```sh
   ./mvnw clean install
   ```

## ▶️ Ejecución
Para 🚀 la aplicación, usar:
```sh
./mvnw spring-boot:run
```

## ⚙️ Configuración
El 📄 `application.properties` en `src/main/resources` contiene 🔑 para la aplicación.

## 📜 Logs
Los 🔍 se generan en el 📂 `/log`, incluyendo `server.log`.

## ✍️ Autor
🏗️ por Casse

