package com.example.laboratorio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun UserProfileScreen(navController: NavController) {
    // Scaffold proporciona una estructura básica para la pantalla, incluyendo una barra superior y una barra inferior
    Scaffold(
        topBar = { CustomTopBar(onProfileClick = { /* No-op */ }) }, // Barra superior
        bottomBar = { CustomBottomBar(navController) } // Agrega la barra inferior aquí
    ) { paddingValues -> // Padding para evitar superposiciones con la barra superior
        Column(
            modifier = Modifier
                .padding(paddingValues) // Aplica el padding definido por Scaffold
                .fillMaxSize() // Ocupa todo el espacio disponible
                .padding(16.dp), // Padding adicional alrededor del contenido
            horizontalAlignment = Alignment.CenterHorizontally // Alinea el contenido horizontalmente al centro
        ) {
            // Nombre de usuario
            Text(
                text = "Juan Pérez", // Texto del nombre de usuario
                style = MaterialTheme.typography.headlineMedium, // Estilo del texto
                modifier = Modifier.padding(vertical = 8.dp) // Padding vertical alrededor del texto
            )

            // Correo electrónico
            Text(
                text = "juan.perez@example.com", // Texto del correo electrónico
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp), // Estilo del texto
                color = Color.Gray // Color del texto
            )

            // Espaciador para separar el botón del contenido anterior
            Spacer(modifier = Modifier.height(20.dp))

            // Botón de editar perfil
            Button(
                onClick = { /* Acción para editar perfil */ }, // Acción a ejecutar al hacer clic (aún no implementada)
                modifier = Modifier.fillMaxWidth() // El botón ocupa todo el ancho disponible
            ) {
                Text(text = "Editar Perfil") // Texto dentro del botón
            }
        }
    }
}
