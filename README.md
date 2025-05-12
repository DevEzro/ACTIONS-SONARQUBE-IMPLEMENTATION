#### _ESP_ 🇪🇸
# 🕵🏻 GITHUB ACTIONS W/ SONARQUBE SETUP
>[!NOTE] 
🗒️ Este respositorio es público y de prueba para comprender y prácticar el uso de workflows con SonarQube 📚🧪. Eres libre de forkearlo y hacer tus propias pruebas🤝🏻. Si te ha servido, una estrella estaría genial⭐😊. Si aplicarías mejoras, abre una issue con la palabra 'MEJORA' al principio del título y crearé una rama nueva con TODAS las mejoras que se propongan💡.

## ⚙️ PASO 1 - DOCKER
### docker-compose.yml
- Postgres como DB de SonarQube
- SonarQube
- Ejecutar: `docker-compose up -d`

<br>

## 💭 PASO 2 - ALOJAMIENTO (NGROK, PINGGY, SERVIDOR...)
### NGROK
- [Ngrok download](https://download.ngrok.com/downloads/windows)
- [Autenticarse en CMD](https://dashboard.ngrok.com/get-started/your-authtoken)
- Alojar la dirección de SoanrQube: `ngrok http 9000`
### PINGGY
- [Pinggy (Instrucciones en la página)](https://pinggy.io)
<br>

## 🔐 PASO 3 - SONARQUBE TOKEN
- `localhost:9000`
-  user: `admin` pass: `admin`
-  New pass / My Account / Security / Generate Tokens:

### PASO 3.1 - GitHub repo secret
- Repo Settings / Secrets and variables -> Actions / New repository secret
  - Name: `SONAR_TOKEN` 
  - Value: `SONARQUBE TOKEN`
- Update secret

<br>

### 📚 PASO 4 - CONFIGURAR YML
- El fichero `workflow.yml` en `.github/workflows` define las tareas a realizar
- Para que funcione correctamente con SonarQube y se ejecute el análisis, modificar en `workflow.yml` el parámetro `-Dsonar.host.url=<URL SONARQUBE> \`

>[!CAUTION]
Tanto para Pinggy como Ngrok, el enlace generado se debe escribir tanto en el apartado de `Verificar SonarQube` como en el `host.url` del `workflow.yml`

<br>

### ▶️ PASO 5 - EJECUTAR JOBS
- `git add .` 
- `git commit -m "Jobs"`
- `git push -u origin main` 

>[!NOTE]
Para comprobar el funcionamiento de SonarQube respecto a este repositorio, se especifica a continuación los pasos para visualizar los efectos que tiene:

1. Asegurarse de tener el codigo del fichero `examples/Main.java.txt` en `src/com/example/sqlinjection/Main.java`.
2. Hacemos `git add .`, `git commit -m "init"` y `git push -u origin main`
3. El workflow lo detectará y comenzará el analisis.
4. Al finalizar accedemos a la URL donde tenemos sonar y vemos el analisis (el estado será `✅Passed`)
5. Copiamos el contenido de `examples/Vuln.java.txt` en `src/com/example/sqlinjection/Main.java` y repetimos el proceso.
6. Se ven el análisis con el estado `❌Failed`
7. Para corregir esos errores copiamos el contenido de `examples/VulnSolved2.java.txt` en el fichero `src/com/example/sqlinjection/Main.java`
8. Volvemos a realizar el proceso de git y visualizar sonar

<br>

>[!WARNING]
Es posible que aparezca como `❌Failed` debido a que habrá cosas por cubrir como tests o pruebas en el código. Puede ocurrir que no interese mostrar esos error por lo que se debe crear una `Quality Gate` en SonarQube, estableciendo todo a 0% excepto los `Security Hotspots Review`

<br>

#### _ENG_ 🇬🇧
# 🕵🏻 GITHUB ACTIONS W/ SONARQUBE SETUP
>[!NOTE] 
🗒️ This repository is public for making custom tests and for understanding and practicing the usage of workflows with SonarQube integrated 📚🧪. You're free to fork it and make your own tests🤝🏻. If this served you, I will be grateful for the repo to be starred⭐😊. If you would apply improvements please open an issue with the word 'UPGRADE' in the title field and I will create a new branch with ALL the proposed improvements💡.

## ⚙️ STEP 1 - DOCKER
### docker-compose.yml
- Postgres as a DB for SonarQube
- SonarQube
- Run: `docker-compose up -d`

<br>

## 💭 STEP 2 - HOSTING (NGROK, PINGGY, SERVIDOR...)
### NGROK
- [Ngrok download](https://download.ngrok.com/downloads/windows)
- [Authenticate with CMD](https://dashboard.ngrok.com/get-started/your-authtoken)
- Host the SoanrQube route: `ngrok http 9000`
### PINGGY
- [Pinggy (Instructions on the web)](https://pinggy.io)
<br>

## 🔐 STEP 3 - SONARQUBE TOKEN
- `localhost:9000`
-  user: `admin` pass: `admin`
-  New pass / My Account / Security / Generate Tokens:

### PASO 3.1 - GitHub repo secret
- Repo Settings / Secrets and variables -> Actions / New repository secret
  - Name: `SONAR_TOKEN` 
  - Value: `SONARQUBE TOKEN`
- Update secret

<br>

### 📚 STEP 4 - YML FILE CONFIGURATION
- The file `workflow.yml` in `.github/workflows` defines the tasks to run
- To make this work correctly with SonarQube and run the analysis, modify in `workflow.yml` the `-Dsonar.host.url=<URL SONARQUBE> \` parameter

>[!CAUTION]
For both Pinggy and Ngrok generated links, it must be in both `Verificar SonarQube` and `host.url` sections from `workflow.yml`

<br>

### ▶️ STEP 5 - RUN JOBS
- `git add .` 
- `git commit -m "Jobs"`
- `git push -u origin main`

>[!NOTE]
To check SonarQube behavior, follow the next steps to watch the results:

1. Ensure having the code from `examples/Main.java.txt` in `src/com/example/sqlinjection/Main.java`.
2. Make `git add .`, `git commit -m "init"` and `git push -u origin main`
3. The workflow will detect it and start the analysis.
4. At the end, enter the URL where we have SonarQube to view the analysis (the status will be `✅Passed`)
5. Copy the content from the `examples/Vuln.java.txt` file in `src/com/example/sqlinjection/Main.java` and repeat the process.
6. The analysis status will be `❌Failed`
7. To amend these errors copy the content from the `examples/VulnSolved2.java.txt` file in the `src/com/example/sqlinjection/Main.java` file
8. Repeat the git process and watch SonarQube results.

<br>

>[!WARNING]
Is probably that it would appear `❌Failed` again due some errors that should be solved like adding tests in the code. If you're not interested in SonarQube to show these errors, you may create a `Quality Gate` in SonarQube, setting every parameter to 0% except the `Security Hotspots Review` parameter.
