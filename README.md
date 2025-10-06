# Laboratorio 9

### Reflexiones

Reflexión 1: ¿Por qué el estado no persiste al rotar? Relacionar con ciclo de vida, recreación de actividad y recomposición.
  Al rotar el dispositivo, la actividad se destruye y vuelve a crearse por cambio de configuración. Eso implica que el árbol de 
  Composables también se descarta y se construye uno nuevo; por tanto, cualquier estado guardado con "remember mutableStateOf" se 
  pierde porque solo está mientras exista esa composición. Ahora bien, la recomposición no es lo misma que la recreación, ya que 
  la primera actualiza una Interfaz de Usuario existente, mientras que la segunda, una desde cero.


Reflexión 2:¿Por qué el ViewModel resuelve el problema de la Parte 1? Conecta con “única fuente de la verdad” y manejo del ciclo de vida.
  Un ViewModel está anclado al ciclo de vida del grafo y sobrevive a cambios de configuración, por lo que mantiene el
  estado aunque la UI se destruya. Si expone un StateFlow<UiState> inmutable y muta internamente con MutableStateFlow, se obtiene una
  “única fuente de la verdad” que la pantalla observa con collectAsStateWithLifecycle(), de forma segura y consciente del ciclo de vida.

Reflexión 3: ¿Qué ventajas ofrece compartir un ViewModel entre destinos frente a pasar argumentos de navegación?
  Compartir un ViewModel entre destinos del mismo nav graph es superior a pasar argumentos porque ambos destinos leen y actualizan exactamente
  el mismo UiState en tiempo real; no hay copias ni “snapshots” que se desincronicen. Se reduce boilerplate y errores, la navegación es más 
  robusta y las pantallas quedan desacopladas, por lo que cada una emite intenciones al mismo ViewModel.

### Explicación de la arquitectura
Los Composables solo muestran datos y disparan intenciones y el ViewModel actúa como única fuente de verdad, manteniendo el estado 
entre rotaciones; los modelos son data classes simples. El ViewModel encapsula un MutableStateFlow privado y expone un StateFlow<UiState> inmutable; 
las mutaciones se hacen con copy() mediante funciones como loadProducts() y toggleWishlist(id), manteniendo un flujo de datos unidireccional VM → UI, 
que la UI observa con collectAsStateWithLifecycle() para respetar el ciclo de vida. La navegación se organiza con un NavHost y un nav graph raíz que scopea 
el mismo ViewModel para destinos como wishlist y profile, evitando pasar listas por argumentos y garantizando sincronía inmediata del estado. 
Decisiones clave: estado en ViewModel, UiState inmutable, StateFlow por su integración con corrutinas y emisiones confladas, y ViewModel compartido por graph 
para tener una coherencia, testabilidad y persistencia.


### Imágenes del funcionamiento
<img width="200" height="500" alt="image" src="https://github.com/user-attachments/assets/adbf5653-f305-465b-9827-659cf78324fa" />
<img width="200" height="500" alt="image" src="https://github.com/user-attachments/assets/f3504df6-4e54-449b-afa4-29ee4b59157d" />
