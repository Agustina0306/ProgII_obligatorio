# ProgII_obligatorio
Estructuras de Datos Utilizadas:
Hash: Utilizado para almacenar y acceder rápidamente a instancias de Top50.
Hash: utilizado para almacenar artistas y acceer a ellos rápidamente.
Hash: utilizado para almacenar y acceder de forma rápida a las canciones (cada cancion tiene un id que las identifica)
MyHeap: Heap personalizado para almacenar y ordenar datos de manera eficiente para generar los tops.


Manejo de Excepciones
El código lanza las siguientes excepciones personalizadas para manejar errores:
DatoInvalido: Lanzada cuando uno o más parámetros son nulos o inválidos.
DatoNoEXiste: Lanzada cuando no existen datos para un país y fecha específicos.

En la funcion 4 asumimos que como decia "un top50 especifico"entones era para un pais que tambien se iba ingresar por pantalla.
Cuando generamos el Hash con los datos del DataSet, hay datos que despereciamos ya que no eran necesarios para las funciones.


El consumo de memoria total es de 5,96 GB
5,73 GB son usado en generar un hash con los datos, y arreglar el tema de cuando una cancion tiene mas de un artista y separa por comillas.
33,07 MB cuando instacio una canciòn y la agrego al Hash.
10,31MB asociar un artista a una cancion y crearlo (verfificcar que no lo tiene).
167,72MB crear y agregar a Top50
6,29MB newHeap

El tiempo promedio de ejecucion depende de la computadora, en una nos dio 5,6 seundos y en otra nos dio 20,7 seundos. asi que esta en ese intervalo.


