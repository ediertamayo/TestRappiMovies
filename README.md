# TestRappiMovies

Descripción de las capas y responsabilidades:
  *Vista: MainActivity (Se visualiza la grilla con las imagenes de cartelera de las peliculas, adicionalmente despliega el menú que sirve de filtro), 
  DetallesActivity (Muestra la información especifica de una de las peliculas seleccionadas desde el MainActivity)
  
  *Red: Conexión (Se definieron 3 metodos, uno que envia la petición http a la API para solicitar las peliculas, otro que procesa el JSON de respuesta que es la respuesta de la API y otro que finalmente valida la conexión a la red)
  
  *Modelo: Pelicula (Clase que describe el objeto a procesar, no se utilizaron todos los campos que retorna la API sino unicamente los necesarios)
  
  *Negocio: PeliculaAdapter (Pasa los objetos a la grilla y le de la funcionalidad a cada cuadricula, de forma general describe la forma y el comportamiento de la grilla)

Concepto de Responsabilidad única:
  Se trata de individualizar cada función de un software de la manera más eficiente posible, haciendo que sea fácil su posterior escalabilidad, o incluso permite el reciclaje del codigo. 
  De manera general se busca un desarrollo modular seguro y ordenado.


¿Qué características tiene, según su opinión, un “buen” código o código limpio?
  *Funciones y lineas de código documentadas
  *Buen manejo de encapsulamiento
  *Definición adecuada y representativa de las variables y nombres de clases
  *Descripción de las funciones lógicas cuando sea necesario
  
