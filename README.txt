Descripción de capas y responsabilidades:
	*Vistas: MainActivity (Es la interfaz gráfica que interactua directamente con el usuario, nos muestra
		una grilla con las imagenes de las peliculas, adicionalemente nos presenta un menú que nos sirve como filtro por categoria)
		DetallesActivity (Carga la información especifica de una pelicula seleccionada desde el ActivityMain, incluyendo la imagen de portada)
	*Red: Conexión (Se definieron 3 funciones dentro de esta clase, la primera hace la petición HTTP y la envia a la API, la segunda toma la respuesta
		de la API y le da un tratamiento, convirtendo los objetos JSON en una lista de la clase Pelicula)
	*Modelo: Pelicula (Define la estructura que tendrán los objetos Pelicula para java, solo se utilizaron los atributos que se consideraron necesarios)
	*Negocio: PeliculaAdapter (Maneja la cuadricula de las peliculas, nos permite saber las caracteristicas de la misma y darle un tratamiento a condiciones 
		como un touch)

Responsabilidad única:
	Consiste en asignarle a cada clase del desarrollo una actividades especifica, haciendo que este sea lo más modular y organizado posible y así en futuro
	facilite las labores de expansión o escalabilidad

Buen código:
	*Un codigo que este bien documentado
	*Que tenga buena estructura y buena separación entre responsabilidades
	*Que la definición de nombres de variables y de clases sean representativas
	*En los casos en los que sea necesario comentar la logica del DLLO