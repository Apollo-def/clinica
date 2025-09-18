# Consulta Fácil - Serviços Médicos ⚕️

Uma aplicação web simples e intuitiva para gerenciamento de pacientes e consultas médicas. Desenvolvida com HTML, CSS (Tailwind) e JavaScript puro, focada em facilidade de uso e responsividade.

## 📋 Descrição

O **Consulta Fácil** é um sistema de gerenciamento médico que permite cadastrar pacientes, agendar consultas e acompanhar o status das mesmas. A interface é limpa, moderna e suporta temas claro e escuro. Ideal para clínicas pequenas ou profissionais de saúde que precisam de uma solução rápida e sem complicações.

## ✨ Funcionalidades

- **Gerenciamento de Pacientes**:
  - Adicionar, editar e remover pacientes
  - Campos: Nome, CPF, Data de Nascimento, Telefone, E-mail
  - Validação básica de formulários

- **Gerenciamento de Consultas**:
  - Agendar novas consultas
  - Editar e cancelar consultas existentes
  - Status: Agendada, Realizada, Cancelada
  - Vinculação automática com pacientes cadastrados

- **Interface Responsiva**:
  - Layout adaptável para desktop e mobile
  - Suporte a tema claro e escuro
  - Navegação intuitiva com modais

- **Integração com API**:
  - Comunicação com backend RESTful
  - Operações CRUD completas (Create, Read, Update, Delete)

## 🛠️ Tecnologias Utilizadas

- **Frontend**:
  - HTML5
  - CSS3 com [Tailwind CSS](https://tailwindcss.com/)
  - JavaScript (ES6+)
  - Fetch API para requisições HTTP

- **Backend** (não incluído):
  - Qualquer servidor que suporte REST API
  - Endpoints esperados: `/api/pacientes` e `/api/consultas`

## 🚀 Instalação e Uso

### Pré-requisitos

- Navegador web moderno (Chrome, Firefox, Edge, etc.)
- Servidor backend com API REST (veja seção API abaixo)

### Passos para Executar

1. **Clone ou baixe os arquivos**:
   - Baixe o arquivo `index.html` para o seu computador.

2. **Configure o Backend**:
   - Certifique-se de que o backend esteja rodando e acessível.
   - Ajuste a variável `API_BASE` no JavaScript se necessário (padrão: `/api`).

3. **Abra no Navegador**:
   - Abra o arquivo `index.html` diretamente no navegador.
   - Ou sirva via um servidor local (ex: `python -m http.server` ou Apache).

4. **Uso Básico**:
   - Adicione pacientes clicando em "Novo Paciente".
   - Agende consultas selecionando um paciente e preenchendo os detalhes.
   - Use os botões "Editar" e "Remover" para gerenciar registros.
   - Alterne entre temas claro e escuro com o botão no cabeçalho.

## 🔌 API Backend

A aplicação espera um backend RESTful com os seguintes endpoints:

### Pacientes (`/api/pacientes`)

- `GET /api/pacientes` - Lista todos os pacientes
- `POST /api/pacientes` - Cria um novo paciente
- `PUT /api/pacientes/{id}` - Atualiza um paciente existente
- `DELETE /api/pacientes/{id}` - Remove um paciente

**Exemplo de Payload (JSON)**:
```json
{
  "nome": "João Silva",
  "cpf": "12345678900",
  "data_nascimento": "1990-01-01",
  "telefone": "(11) 99999-9999",
  "email": "joao@email.com"
}
```

### Consultas (`/api/consultas`)

- `GET /api/consultas` - Lista todas as consultas
- `POST /api/consultas` - Cria uma nova consulta
- `PUT /api/consultas/{id}` - Atualiza uma consulta existente
- `DELETE /api/consultas/{id}` - Remove uma consulta

**Exemplo de Payload (JSON)**:
```json
{
  "paciente_id": 1,
  "medico": "Dr. Maria Santos",
  "data": "2023-12-01",
  "horario": "14:30",
  "status": "agendada"
}
```

**Nota**: O backend deve retornar dados no formato JSON e suportar CORS se servido em domínio diferente.

## 🎨 Personalização

- **Tema**: O tema é salvo no `localStorage` e detecta preferência do sistema.
- **Estilos**: Modifique as classes Tailwind diretamente no HTML ou crie um arquivo CSS separado.
- **Funcionalidades**: Adicione novas features editando o JavaScript inline.

## 📱 Responsividade

- **Mobile**: Layout em coluna única, botões otimizados.
- **Desktop**: Grid de 2 colunas, melhor aproveitamento de espaço.
- **Tablet**: Transições suaves entre layouts.

## 🤝 Contribuição

Contribuições são bem-vindas! Para sugestões ou melhorias:

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

## 📄 Licença

Este projeto é de código aberto e está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 🆘 Suporte

Se encontrar problemas:

- Verifique se o backend está rodando e acessível.
- Abra o console do navegador (F12) para ver erros JavaScript.
- Certifique-se de que o navegador suporta ES6+ e Fetch API.

---

Desenvolvido com ❤️ para facilitar a gestão médica.
