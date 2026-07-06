# DevHub - #7DaysOfCode

Aplicativo Android desenvolvido em **Kotlin** utilizando **Jetpack
Compose** para consumir a **REST API** do **GitHub**, permitindo consultar
informações públicas de usuários, visualizar seus repositórios e
acompanhar o consumo da API através do Rate Limit.

O projeto surgiu a partir do desafio **#7DaysOfCode**, mas continuou
evoluindo após sua conclusão.

---

## Funcionalidades

-   Pesquisa de usuários do GitHub
-   Exibição de:
    -   Avatar
    -   Nome
    -   Login
    -   Bio
    -   Lista de repositórios
-   Carregamento assíncrono de imagens com Coil
-   Navegação entre telas utilizando Navigation Compose
-   Tela de configurações
-   Alternância entre tema claro e escuro
-   Persistência da preferência de tema utilizando DataStore
-   Exibição das informações de Rate Limit da GitHub API:
    -   Limite de requisições
    -   Requisições restantes
    -   Requisições utilizadas
    -   Tempo de reset
-   Tratamento de diferentes cenários de erro:
    -   Usuário não encontrado
    -   Limite da API atingido
    -   Falha na conexão com a API

---

## Tecnologias utilizadas

-   Kotlin
-   Jetpack Compose
-   Material 3
-   Navigation Compose
-   Retrofit
-   Kotlin Coroutines
-   Kotlin Flow / StateFlow
-   Coil
-   Android DataStore
-   Android ViewModel
-   Android Studio

---

## Arquitetura

O projeto busca seguir a arquitetura **MVVM**, separando responsabilidades entre interface, gerenciamento de estado e acesso aos dados.

Estrutura atual do projeto:

```text
devhub
├── data
│   ├── local
│   │   └── datastore
│   │       └── SettingsDataStore.kt
│   │
│   ├── remote
│   │   ├── model
│   │   │   ├── GitHubError.kt
│   │   │   ├── GitHubProfileWeb.kt
│   │   │   ├── GitHubRateLimit.kt
│   │   │   ├── GitHubRepository.kt
│   │   │   └── GitHubResponse.kt
│   │   │
│   │   ├── service
│   │   │   └── GitHubService.kt
│   │   │
│   │   ├── webclient
│   │   │   └── GitHubWebClient.kt
│   │   │
│   │   └── GitHubResponseRepository.kt
│   │
│   └── RetrofitInitializer.kt
│
├── ui
│   ├── components
│   │   ├── common
│   │   ├── search
│   │   ├── settings
│   │   └── user
│   │
│   ├── screen
│   │   ├── SearchScreen.kt
│   │   ├── SettingsScreen.kt
│   │   └── UserScreen.kt
│   │
│   ├── state
│   │   ├── UserProfileUiState.kt
│   │   └── UserRepositoryUiState.kt
│   │
│   └── theme
│
├── viewmodel
│   ├── UserViewModel.kt
│   ├── UserViewModelFactory.kt
│   ├── SettingsViewModel.kt
│   ├── SettingsViewModelFactory.kt
│   ├── SelectedUserViewModel.kt
│   └── SelectedUserViewModelFactory.kt
│
└── MainActivity.kt
```

A comunicação entre as camadas utiliza:

- ViewModels
- ViewModelFactory
- GitHubResponseRepository como cache compartilhado da última resposta da API
- `StateFlow` para compartilhamento de estado entre telas
- `mutableStateOf` para gerenciamento do estado da interface

---

## Conceitos praticados

-   Consumo de API REST
-   Arquitetura MVVM
-   Organização em camadas
-   Gerenciamento de estado com `mutableStateOf`
-   Compartilhamento de estado com `StateFlow`
-   Recomposição no Jetpack Compose
-   State Hoisting
-   Side Effects com `LaunchedEffect`
-   Injeção manual de dependências utilizando `ViewModelFactory`
-   Tratamento de erros utilizando `enum class`
-   Conversão entre Models e UiState
-   Persistência de preferências com DataStore
-   Tratamento de valores nullable

---

## Desafio #7DaysOfCode

-   Dia 1 --- Criando uma aplicação com dados estáticos
-   Dia 2 --- Modificando o visual da exibição do app
-   Dia 3 --- Obtendo a imagem a partir de uma URL
-   Dia 4 --- Fazendo uma requisição HTTP à API do GitHub
-   Dia 5 --- Exibindo na tela as informações da API
-   Dia 6 --- Refatorando e melhorando a organização do projeto
-   Dia 7 --- Obtendo e exibindo os repositórios dos usuários

Após a conclusão do desafio, o projeto continuou evoluindo com melhorias
estruturais e novas funcionalidades.

---

## API utilizada

**GitHub REST API**

https://api.github.com/

---
