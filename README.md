# ProgII_obligatorio
structuras de Datos Utilizadas:
Hash: Utilizado para almacenar y acceder rápidamente a instancias de Top50.
MyList: Lista personalizada para almacenar artistas.
MyHeap: Heap personalizado para almacenar y ordenar datos de manera eficiente para generar los tops.


Manejo de Excepciones
El código lanza las siguientes excepciones personalizadas para manejar errores:
DatoInvalido: Lanzada cuando uno o más parámetros son nulos o inválidos.
DatoNoEXiste: Lanzada cuando no existen datos para un país y fecha específicos.

En la funcion 4 asumimos que como decia "un top50 especifico"entones era para un pais que tambien se ibaa ingresar por pantalla.
Cuando generamos el Hash con los datos del DataSet, hay datos que despereciamos ya que no eran necesarios para las funciones.


El consumo de memoria total es de 5,85 GB
5,592 GB son usado en generar un hash con los daos, y arreglar el tema de cuando una cancion tiene mas de un artista y separa por comillas.
27,35 MB cuando instacio una canciòn y la agrego al Hash.
21,51MB asociar un artista a una cancion y crearlo (verfificcar que no lo tiene).
98,86MB crear y agregar a Top50
4,18MB newHeap


