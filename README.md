# Sistema de Locação de Veículos - Rota Segura

## Aluno

**Nome:** WELINTON EDUARDO PEREIRA DA SILVA

**Matrícula:** 1301392611038

---

# Resumo da Arquitetura

O sistema foi desenvolvido em Java utilizando os principais conceitos da Programação Orientada a Objetos (POO).

A aplicação está organizada em dois pacotes principais:

## Pacote `dados`

Contém as classes responsáveis pelas entidades do sistema:

- Marca
- Veiculo (classe abstrata)
- Popular
- Sedan
- SUV
- Cliente
- Locacao

## Pacote `ui`

Contém a interface principal da aplicação:

- Principal

---

# Diagrama Simplificado de Classes

```text
                    Veiculo
                        ▲
        ┌───────────────┼───────────────┐
        │               │               │
     Popular         Sedan            SUV

Marca ─────────────► Veiculo ◄──────────── Locacao ──────────── Cliente
```

---

# Conceitos de POO Aplicados

## Encapsulamento

Os atributos das classes foram declarados como `private`, impedindo o acesso direto aos dados.

Exemplos:

- nome
- cpf
- marca
- modelo
- ano
- cor

O acesso aos dados é realizado por meio de getters e setters com validações.

Exemplos de validações implementadas:

- Nome não pode ser vazio
- CPF não pode ser vazio
- Modelo não pode ser vazio
- Cor não pode ser vazia
- Ano deve estar dentro
