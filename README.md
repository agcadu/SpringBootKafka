![Encabezado del Proyecto](./header.png)

# SpringBootKafka
SpringBootKafka es una aplicación construida con Java 17, Spring Boot 3 y empaquetada con Maven. Contiene dos microservicios interconectados a través de Kafka para manejar datos de personas.
## Requisitos del PC

- Java: Java Development Kit (JDK) versión 17.
- Maven: La última versión disponible es recomendada.
- Docker: Asegúrate de tener Docker y Docker Compose instalados. La última versión disponible es recomendada.
- Postman: La última versión disponible es recomendada.
- IDE: IntelliJ IDEA o Eclipse.
- DBeaver: La última versión disponible es recomendada.
## Beneficios de Usar Kafka
- Alta Durabilidad y Disponibilidad: Kafka garantiza cero pérdidas de datos y estará disponible para procesar mensajes incluso si varios nodos (brokers) fallan.

- Escalar Horizontalmente: Kafka se puede escalar sin inactividad. Puedes añadir más nodos (brokers) a tu cluster Kafka en cualquier momento para aumentar la capacidad y el rendimiento.

- Procesamiento en Tiempo Real: Con Kafka, los mensajes se procesan en tiempo real, lo que es excelente para aplicaciones orientadas a eventos.

- Desacoplamiento de Procesos: Los productores y los consumidores son completamente independientes y desconocidos entre sí. Esto permite que las aplicaciones se desarrollen, escalen y desplieguen de forma independiente.

## Microservicios
### SpringBootProvider:

Recibe una petición POST con datos de una persona: name, lastName, age, email, phone.
Serializa estos datos en un objeto Person.
Produce un mensaje en formato JSON al topic Kafka "test-topic".
### SpringBootConsumer:

Consume mensajes del topic Kafka "test-topic".
Deserializa el mensaje JSON.
Guarda el registro deserializado en una base de datos PostgreSQL usando JPA.
## Dockerización
La aplicación se encuentra dockerizada y consta de:

- Servidor ZooKeeper.
- Servidor Kafka.
- Base de datos PostgreSQL.
- Dos contenedores para los microservicios: SpringBootProvider y SpringBootConsumer.
## Cómo Comenzar
1. Clonar el repositorio:

```bash
git clone https://github.com/agcadu/SpringBootKafka.git
```
```bash
cd SpringBootKafka
```

2. Construir los .jar de los microservicios. Dependiendo de tu configuración, puedes necesitar Maven instalado en tu máquina.

```bash
mvn clean install
```
```bash
mvn clean package -DskipTests 
```
3. Ejecutar docker-compose para montar la red de contenedores:

```bash
docker compose up
```


4. Herramientas de Prueba: 
Una vez que todos los contenedores estén en funcionamiento, puedes utilizar la colección Postman adjunta para realizar las pruebas: `AplicationKafka.postman_collection.json`.

5. URL de la Base de Datos: `jdbc:postgresql://localhost:5432/postgres`.
