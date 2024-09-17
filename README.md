# Claro Space Launch Program API

## Introduction

This project was developed as part of the final bootcamp on the DIO platform and is now live in production, hosted on Railway. The API is designed to handle space launch registrations for Claro, integrating external APIs to facilitate data handling. Full documentation is available via Swagger at [Swagger Documentation](https://claro-space-launch-program-api.up.railway.app/swagger-ui/index.html).
<img width="1420" alt="Screen Shot 2024-09-17 at 10 33 12" src="https://github.com/user-attachments/assets/2c4e959c-c15a-4468-9dbc-9ac69de421c1">

## Project Overview

### Features

- **Manager Registration**: Managers are registered with their full address details using a postal code (CEP), fetched from the ViaCep API.
- **Payload Registration**: The system allows the registration of payloads using a real payload ID from the SpaceX API.
- **Mission Creation**: To create a mission, you need a manager ID, a payload ID, and a rocket ID. The rocket ID is also retrieved using the SpaceX API, ensuring the use of real-world rocket data.

### External API Integrations

The project integrates with the following external APIs to enhance functionality:

- **ViaCep API**: Used to fetch address details by postal code (CEP), allowing for automatic population of address fields.
- **SpaceX API**: Payloads and rockets are registered in the system using real-time data from the [SpaceX API](https://github.com/r-spacex/SpaceX-API). This ensures that all missions use valid payloads and rockets currently available through SpaceX.
<img width="695" alt="Screen Shot 2024-09-17 at 10 30 17" src="https://github.com/user-attachments/assets/ba5e4256-206d-4ae9-8df8-9e6495401958">

### Database

- **Production Database**: The system is deployed with a PostgreSQL database in production via Railway, ensuring robust and scalable data management.

## Objective

The Claro Space Launch Program API was created to manage the registration of space launches for Claro. The system requires:
1. A **Manager** with a valid postal code (CEP) for address registration.
2. A **Payload**, registered by using a real payload ID from the SpaceX API.
3. A **Mission**, which links a manager, a payload, and a rocket (the latter two also sourced from the SpaceX API).


<img width="1346" alt="Screen Shot 2024-09-17 at 10 29 20" src="https://github.com/user-attachments/assets/f1b18798-44f2-4f4d-8006-ecc15a434f1b">

## Usage

- The full API documentation, including all endpoints and models, is available at the [Swagger Documentation](https://claro-space-launch-program-api.up.railway.app/swagger-ui/index.html).
- You can explore all the functionalities of the system and test the API directly through the provided Swagger UI interface.

## Conclusion

This project demonstrates the integration of external APIs to streamline complex data entry, and the deployment of a Spring Boot application in a production environment using Railway. Feel free to explore the code and the live API, and take advantage of the documentation to interact with the endpoints.

# API do Programa de Lançamento Espacial Claro

## Introdução

Este projeto foi desenvolvido como parte da conclusão de um bootcamp na plataforma DIO e está agora em produção, hospedado no Railway. A API foi projetada para gerenciar o cadastro de lançamentos espaciais para a Claro, integrando APIs externas para facilitar o gerenciamento de dados. A documentação completa está disponível via Swagger em [Documentação Swagger](https://claro-space-launch-program-api.up.railway.app/swagger-ui/index.html).

## Visão Geral do Projeto

### Funcionalidades

- **Cadastro de Gerente**: Gerentes são cadastrados com todos os detalhes do endereço utilizando o código postal (CEP), que é obtido pela API ViaCep.
- **Cadastro de Payload**: O sistema permite o cadastro de cargas úteis (payloads) usando um ID de carga real disponível na API da SpaceX.
- **Criação de Missão**: Para criar uma missão, é necessário um ID de gerente, um ID de payload e um ID de foguete. O ID do foguete também é obtido usando a API da SpaceX, garantindo o uso de dados reais de foguetes.

### Integrações com APIs Externas

O projeto integra as seguintes APIs externas para aprimorar suas funcionalidades:

- **API ViaCep**: Usada para buscar detalhes de endereço por código postal (CEP), permitindo o preenchimento automático dos campos de endereço.
- **API SpaceX**: Cargas úteis e foguetes são registrados no sistema usando dados em tempo real da [API da SpaceX](https://github.com/r-spacex/SpaceX-API). Isso garante que todas as missões usem cargas e foguetes válidos e disponíveis pela SpaceX.

### Banco de Dados

- **Banco de Dados em Produção**: O sistema é implantado com um banco de dados PostgreSQL em produção, via Railway, garantindo um gerenciamento de dados robusto e escalável.

## Objetivo

A API do Programa de Lançamento Espacial Claro foi criada para gerenciar o cadastro de lançamentos espaciais para a Claro. O sistema requer:
1. Um **Gerente** com um CEP válido para o registro do endereço.
2. Uma **Carga Útil (Payload)**, cadastrada usando um ID real de payload da API da SpaceX.
3. Uma **Missão**, que vincula um gerente, uma carga útil e um foguete (sendo que os dois últimos são obtidos da API da SpaceX).

## Uso

- A documentação completa da API, incluindo todos os endpoints e modelos, está disponível em [Documentação Swagger](https://claro-space-launch-program-api.up.railway.app/swagger-ui/index.html).
- Você pode explorar todas as funcionalidades do sistema e testar a API diretamente através da interface do Swagger UI fornecida.

## Conclusão

Este projeto demonstra a integração de APIs externas para agilizar a entrada de dados complexos e a implantação de uma aplicação Spring Boot em um ambiente de produção usando Railway. Sinta-se à vontade para explorar o código e a API ativa e aproveite a documentação para interagir com os endpoints.
