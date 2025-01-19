# JAVA I/O 
Java I/O (Input and Output), se utiliza para procesar la entrada y salida de información ya sea archivos o la conexión a una red. Las clases necesarias para trabajar se encuentran en el paquete `java.io`.

## Conceptos
### Stream
Un *Stream*, es una secuencuia o flujo (en ingles *stream*) de datos, ya sea de entrada o salida (para leer o escribir).


### Tipos de Stream
Los flujos pueden almacenar bytes o caracteres, los flujos que almacenar *bytes* se conocen como **flujos basados en bytes** (Byte Stream) y los flujos que almacenan caracteres se conocen como **flujos basados en caracteres** (Character Stream).

#### Byte Stream
Para trabajar con archivos binarios (imagenes, PDF, videos etc.). Byte Streams no manejan caracteres ni codificaciones. Para texto, usa Character Streams.

- `InputStream`: **Clase Abstracta** para la lectura.
- `FileInputStream`: Para leer bytes desde un archivo.
- `DataInputStream`
- `BufferedInputStream`: Para leer bytes con un búfer, mejorando el rendimiento.
- `PrintStream`
- `ObjectInputStream`: Para leer objetos serializados.
- `OutputStream`: **Clase Abstracta** para la escritura.
- `FileOutputStream`
- `DataOutputStream`
- `BufferedOutputStream`
- `ObjectOutputStream`: Para escribir objetos serializados.

#### Character Stream
Pensado para leer y escribir datos basados en texto.

- `Reader`: **Clase Abstracta** para la lectura (es la clase base).
- `FileReader`
- `BufferedReader`
- `InputStreamReader` Convierte un InputStream (bytes) en Reader (caracteres).
- `OutputStreamReader`: Convertir un OutputStream (bytes) en Writer (caracteres).
- `Writer`: **Clase Abstracta** para la escritura (es la clase base).
- `FileWriter` Para escribir caracteres en un archivo.
- `BufferedWriter`
- `PrintWriter`
