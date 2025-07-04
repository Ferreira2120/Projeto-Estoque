# 📦 Projeto Estoque - Sistema de Controle de Produtos

Este projeto é um sistema de **controle de estoque** desenvolvido em **Java** com entrada via **console**, usando **Spring Boot** e **Jackson** para persistência de dados em JSON.

---

## 🚀 Funcionalidades

- ✅ Cadastrar novos produtos
- 🔍 Pesquisar produtos por nome
- ❌ Excluir produtos do estoque
- 📋 Listar todos os produtos cadastrados
- 💾 Persistência automática dos dados no arquivo `produtos.json`

---

## 🧱 Tecnologias utilizadas

- **Java 17**
- **Spring Boot**
- **Jackson (ObjectMapper)** para leitura e escrita em JSON
- **Orientado a Objetos**
- **Maven** como gerenciador de dependências

---
## 📂 Estrutura do Projeto
src/

├── main/

│ ├── java/

│ │ └── br/com/example/ferreira/

│ │ ├── ProjetoEstoqueApplication.java ← Classe principal (main)

│ │ ├── estoqueProduto/

│ │ │ └── TiposProdutos.java ← Classe modelo de produto

│ │ └── function/

│ │ ├── ProdutosReceber.java ← Cadastro

│ │ ├── ProdutoPesquisa.java ← Busca

│ │ └── ProdutoExcluir.java ← Exclusão

└── resources/

└── application.properties

---

## 🗃️ Arquivo de dados

Todos os produtos cadastrados são armazenados automaticamente no arquivo: 

 - 'produtos.json'

Ao reiniciar o sistema, o conteúdo do arquivo é carregado automaticamente.

---

## 👨‍💻 Autor

Desenvolvido por **Pedro Ferreira Gomes**

🔗 [Meu Linkedin](www.linkedin.com/in/pedro-ferreira-a762532bb)

📧 pedroferreira.gomes03@gmail.com

---
