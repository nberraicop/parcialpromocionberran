# parcialpromocionberran

Proyecto base para el Parcial de Promoción - Programación 2 (ICOP), Parte 1.

## Requisitos
- Java 17 o superior compatible.
- Maven 3.6.3 o superior (o Maven integrado en VS Code).

## Ejecutar desde VS Code
1. Abrir esta carpeta en Visual Studio Code.
2. Verificar que `.env` esté en la raíz, junto a `pom.xml`.
3. Abrir una terminal en la carpeta del proyecto.
4. Ejecutar:

   ```bash
   ./mvnw spring-boot:run
   ```

   Si no tenés Maven Wrapper, ejecutar `mvn spring-boot:run`.

## Verificar H2
Abrir http://localhost:8080/h2-console y conectarse con:
- JDBC URL: `jdbc:h2:file:./data/biblioteca`
- User Name: `sa`
- Password: (vacía)

Ejecutar:

```sql
SELECT * FROM socio;
```

Deben aparecer Carla Mendez y Diego Torres.

## Importante para GitHub
`.env`, `data/` y `target/` están excluidos por `.gitignore`.
Subir `.env.example`, no subir `.env`.
