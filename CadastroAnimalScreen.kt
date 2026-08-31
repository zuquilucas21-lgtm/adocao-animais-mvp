package com.example.adocaoanimais

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroAnimalScreen() {
    var nomeAnimal by remember { mutableStateOf("") }
    var especieAnimal by remember { mutableStateOf("") }
    var idadeAnimal by remember { mutableStateOf("") }
    var mensagemSucesso by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cadastrar Animal - Tema 13") }
            )
        }
    ) { paddingValores ->
        CadastroAnimalContent(
            modifier = Modifier.padding(paddingValores),
            nome = nomeAnimal,
            onNomeChange = { nomeAnimal = it },
            especie = especieAnimal,
            onEspecieChange = { especieAnimal = it },
            idade = idadeAnimal,
            onIdadeChange = { idadeAnimal = it },
            mensagemSucesso = mensagemSucesso,
            onSalvarClick = {
                if (nomeAnimal.isNotBlank() && especieAnimal.isNotBlank()) {
                    mensagemSucesso = "Animal '$nomeAnimal' cadastrado com sucesso!"
                } else {
                    mensagemSucesso = "Preencha o nome e a espécie do animal."
                }
            }
        )
    }
}

@Composable
fun CadastroAnimalContent(
    modifier: Modifier = Modifier,
    nome: String,
    onNomeChange: (String) -> Unit,
    especie: String,
    onEspecieChange: (String) -> Unit,
    idade: String,
    onIdadeChange: (String) -> Unit,
    mensagemSucesso: String,
    onSalvarClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Formulário de Cadastro do MVP",
            style = MaterialTheme.typography.titleMedium
        )

        OutlinedTextField(
            value = nome,
            onValueChange = onNomeChange,
            label = { Text("Nome do Animal") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = especie,
            onValueChange = onEspecieChange,
            label = { Text("Espécie (ex: Cachorro, Gato)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = idade,
            onValueChange = onIdadeChange,
            label = { Text("Idade (ex: 2 anos)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Button(
            onClick = onSalvarClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cadastrar Animal")
        }

        if (mensagemSucesso.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = mensagemSucesso,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
