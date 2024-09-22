package com.example.laboratorio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// Clase principal de la actividad de la aplicación
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen() // Establece el contenido de la actividad a MainScreen
        }
    }
}

// Composable principal que maneja la navegación y el estado
@Composable
fun MainScreen() {
    val navController = rememberNavController() // Controlador de navegación
    var clickCount by remember { mutableStateOf(0) } // Contador de clics inicializado en 0

    // Estructura de Scaffold que define la barra superior, la barra inferior y el botón flotante
    Scaffold(
        topBar = { CustomTopBar(onProfileClick = { navController.navigate("profile") }) }, // Barra superior
        bottomBar = { CustomBottomBar(navController) }, // Barra inferior
        floatingActionButton = { CustomFAB { clickCount++ } } // Botón flotante que incrementa el contador
    ) { paddingValues ->
        // Navegación entre pantallas
        NavHost(navController, startDestination = "home") {
            composable("home") {
                HomeScreen(clickCount = clickCount, paddingValues = paddingValues) // Pantalla de inicio
            }
            // Otras pantallas de la aplicación
            composable("profile") { UserProfileScreen(navController) }
            composable("info") { InfoScreen(navController) }
            composable("edit") { EditScreen(navController) }
            composable("settings") { SettingsScreen(navController) }
        }
    }
}

// Composable para el botón flotante
@Composable
fun CustomFAB(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) { // Se ejecuta la acción al hacer clic
        Text(
            fontSize = 24.sp, // Tamaño de la fuente
            text = "+" // Texto del botón
        )
    }
}

// Pantalla de inicio que muestra el contador de clics
@Composable
fun HomeScreen(clickCount: Int, paddingValues: PaddingValues) {
    CustomContent(padding = paddingValues, clickCount = clickCount) // Muestra el contenido personalizado
}

// Composable que define el contenido de la pantalla de inicio
@Composable
fun CustomContent(padding: PaddingValues, clickCount: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupar todo el espacio disponible
            .padding(padding), // Aplicar el padding recibido
        horizontalAlignment = Alignment.CenterHorizontally, // Centrar horizontalmente
        verticalArrangement = Arrangement.Center // Centrar verticalmente
    ) {
        Text(text = "My app content") // Texto del contenido de la aplicación
        Text(text = "Botón presionado: $clickCount veces") // Mostrar cuántas veces se ha presionado el botón
    }
}

// Composable para la barra superior de la aplicación
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(onProfileClick: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO: Open drawer*/ }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null) // Icono de menú
            }
        },
        title = { Text(text = "Sample Title") }, // Título de la barra
        actions = {
            IconButton(onClick = { /*TODO: Open search*/ }) {
                Icon(imageVector = Icons.Rounded.Search, contentDescription = null) // Icono de búsqueda
            }
            IconButton(onClick = onProfileClick) {
                Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = null) // Icono de perfil
            }
        }
    )
}

// Composable para la barra inferior de la aplicación
@Composable
fun CustomBottomBar(navController: NavController) {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(), // Ocupar todo el ancho
            horizontalArrangement = Arrangement.SpaceAround // Distribuir íconos con espacio alrededor
        ) {
            // Íconos de navegación que redirigen a diferentes pantallas
            IconButton(onClick = { navController.navigate("home") }) {
                Icon(Icons.Filled.Home, contentDescription = "Home") // Ícono de inicio
            }
            IconButton(onClick = { navController.navigate("info") }) {
                Icon(Icons.Filled.Info, contentDescription = "Info") // Ícono de información
            }
            IconButton(onClick = { navController.navigate("edit") }) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit") // Ícono de edición
            }
            IconButton(onClick = { navController.navigate("settings") }) {
                Icon(Icons.Filled.Settings, contentDescription = "Settings") // Ícono de configuración
            }
        }
    }
}
