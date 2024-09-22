package com.example.laboratorio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SettingsScreen(navController: NavController) {
    // Scaffold proporciona una estructura básica para la pantalla, incluyendo una barra superior y una barra inferior
    Scaffold(
        topBar = { CustomTopBar(onProfileClick = { /* No-op */ }) }, // Barra superior
        bottomBar = { CustomBottomBar(navController) } // Barra inferior
    ) { paddingValues -> // Padding para evitar superposiciones con la barra superior
        Column(
            modifier = Modifier
                .padding(paddingValues) // Aplica el padding definido por Scaffold
                .fillMaxSize() // Ocupa todo el espacio disponible
                .padding(16.dp), // Padding adicional alrededor del contenido
            horizontalAlignment = Alignment.CenterHorizontally, // Alinea el contenido horizontalmente al centro
            verticalArrangement = Arrangement.Center // Centra verticalmente el contenido
        ) {
            // Título de la pantalla
            Text(
                text = "Pantalla de Configuración",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Breve descripción o contenido adicional
            Text(
                text = "Aquí puedes ajustar tus preferencias y configuraciones de la aplicación.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Botón para acceder a las configuraciones avanzadas
            Button(
                onClick = { /* Acción para acceder a configuraciones avanzadas */ },
                modifier = Modifier.fillMaxWidth() // Botón ocupa todo el ancho
            ) {
                Text(text = "Acceder a Configuraciones Avanzadas")
            }

            Spacer(modifier = Modifier.height(20.dp)) // Espaciador para separar contenido
        }
    }
}
