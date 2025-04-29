# 💱 Conversor de Monedas en Java

![Java](https://img.shields.io/badge/Java-20-blue)
![Maven](https://img.shields.io/badge/Maven-3.9.9-orange)

> Aplicación CLI para conversión de monedas usando tasas actualizadas de ExchangeRate-API

## 🚀 Comenzar

### Requisitos
- JDK 20+
- Maven 3.9.9+
- API Key de [ExchangeRate-API](https://www.exchangerate-api.com/)

### Instalación
1. Clonar repositorio:
```bash
git clone https://github.com/Rai5559/Alura-Challenge-Currency-Converter.git
cd Alura-Challenge-Currency-Converter
```
2. Crear archivo `.env`:
```plaintext
API_KEY=tu_api_key_aqui
```
3. Compilar y ejecutar:
```bash
mvn clean install
mvn exec:java -Dexec.mainClass="org.rai5569.Main"
```

## 🧮 Monedas Soportadas

| Código | Moneda                 |
|--------|-------------------------|
| USD    | Dólar Estadounidense   |
| ARS    | Peso Argentino         |
| BRL    | Real Brasileño         |
| COP    | Peso Colombiano        |


## 🌟 Features
✅ Conversión en tiempo real

✅ Manejo de errores robusto

✅ Formateo de salida profesional

✅ Configuración mediante .env

## 📦 Dependencias
```
<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.13.1</version>
    </dependency>
    <dependency>
        <groupId>io.github.cdimascio</groupId>
        <artifactId>java-dotenv</artifactId>
        <version>5.2.2</version>
    </dependency>
</dependencies>
```

## 📅 Roadmap
- [ ] Añadir más monedas
- [ ] Mejorar manejo de errores
- [ ] Crear interfaz gráfica
- [ ] Añadir tests unitarios
- [ ] Documentación completa

## 🤝 Cómo Contribuir
- Haz un fork del repositorio
- Crea una nueva rama (`git checkout -b feature/nueva-feature`)
- Realiza tus cambios y haz commit (`git commit -m 'Añadir nueva feature'`)
- Haz push a la rama (`git push origin feature/nueva-feature`)
- Crea un Pull Request
- Espera revisión y feedback