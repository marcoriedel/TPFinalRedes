# TpFinalRedes
Trabajo Final Redes

1) CLonar repositorio
2) Importar proyecto Maven
3) Correr la clase Server y seleccionar puerto. Por defecto correra en el puerto 3000
4) Correr la clase Client y seleccionar host y puerto. Por defecto sera localhost y puerto 3000
5) Si se envía el mensaje X la conexion sera cerrada.

-- Cuestionario

1. ¿Que es un puerto? 

 Los puertos virtuales son utilizados como puntos de conexión para el intercambio de información y transmisión de datos. Es un número entero de 16 bits diseñado específicamente para contener el protocolo utilizado para la transferencia. Dado que los puertos de red se utilizan para identificar la aplicación o el proceso en el dispositivo, se asigna un conjunto de números de puerto a diferentes tipos de servicios o programas de red.
  * 0-1023 - Estos números de puerto están reservados para puertos conocidos o de uso común. Asignados por la Autoridad de Números Asignados de Internet (IANA), la mayoría de estos puertos soportan servicios de servidor necesarios para las conexiones de red.
  * 1024-49151 - Estos números de puerto están registrados o semi reservados. Las empresas, organizaciones e incluso individuos pueden registrarse para utilizar estos números de puerto para proporcionar servicios de red con IANA.
  *49152 - 65535 - Estos números de puerto se refieren a puertos efímeros que son utilizados por los programas cliente.

2. ¿Como estan formados los endpoints?

Los endPoints estan formados por:

  *Address: Una dirección única que identifica al endPoint e indica a los consumidores del servicio donde está alojado. Esto está representado en el WCF object por la EndPointAdress class.Esta clase contiene: 
  
      *Una propiedad URI que representa la dirección del servicio.
      *Una propiedad Identidad que representa la seguridad del servicio y una colección de mensajes optionales utilizados en el header. Estos son usados para proveer información adicional y detallada para identificar e interactuar con el endPoint.

  *Binding: El binding especifica cómo comunicarse con el endPoint, esto incluye:
  
      *El protocolo de transporte ( por ejemplo, TCP o HTTP).
      *La codificación usada para el mensaje (por ejemplo, texto o binario).
      *Los requisitos de seguridad necesarios (por ejemplo, SSL o SOAP).

  *Contrato: El contrato describe qué funcionalidad expone el endPöint al cliente. Un contrato especifica: 
  
      *Qué operaciones pueden ser llamadas por el usuario.
      *La forma del mensaje.
      *El tipo de los parámetros de entrada o la información requerida para llamar a la operación..
      *Que tipo de procesamiento o mensaje de respuesta debe esperar el cliente. 

  *Comportamiento:  
  
Puede usar comportamientos del endPoint para personalizar el comportamiento del servicio utilizado. Un ejemplo de comportamiento es la propiedad ListenUri, que le permite especificar una dirección de escucha diferente que la dirección SOAP o WSDL. 
 

3. ¿Que es un socket? 

Un socket es un proceso o hilo existente en la máquina cliente y en la máquina servidora, que sirve en última instancia para que el programa servidor y el cliente lean y escriban la información. Esta información será la transmitida por las diferentes capas de red.

4. ¿A qué capa del modelo TPC/IP pertenecen los sockets? ¿Porque? 

Los sockets pertenecen a la 3 capa del modelo TCP/IP llamada transporte, pertenecen a esta capa dado que un socket es una interfaz de comunicación entre un proceso de aplicación y la capa de transporte. Permiten enviar y recibir los datos de la red a los procesos 
5. ¿Cómo funciona el modelo cliente-servidor con TCP/IP Sockets? 

La comunicación entre entidades abstractas (PCs) se logra utilizando diferentes técnicas, una de ellas es utilizando sockets, que consiste en configurar una red cliente servidor para establecer el flujo de información entre transmisor y receptor.. Para que dos aplicaciones puedan intercambiar información entre sí se necesita:

  •Un protocolo de comunicación común a nivel de red y a nivel de transporte. 
  •Una dirección del protocolo de red que identifique a cada uno de los computadores. 
  •Un número de puerto que identifique la aplicación dentro del computador. 
  
Los socket se utilizan para poder enviar órdenes a un servidor que está atendiendo nuestras peticiones. Por lo tanto, un socket queda definido por una dirección IP (La del equipo que actúa como servidor), un protocolo y un número de puerto (El utilizado para acceder a un servicio determinado). A su vez, los sockets están basados en el protocolo de comunicaciones utilizado en Internet: TCP (Transmisión Control Protocol). La función del protocolo TCP es, ni más ni menos que la de traer y llevar información desde un servidor a un cliente y viceversa utilizando los diferentes protocolos utilizados por cada servicio.

6. ¿Cuales son las causas comunes por la que la conexión entre cliente/servidor falle?
 
  *Accidente en el lugar donde se encuentran los equipos.
  *Fallo del suministro eléctrico.
  *Fallo en la conexión a Internet.
  *Fallo en el hardware o en el software. El problema más común del hardware es una sobrecarga o un recalentamiento, en el software la caída de la base de datos.
  *Error humano.
  *Virus o troyano.

7. Diferencias entre sockets UDP y TCP 

 La principal diferencia entre ambos es que el UDP necesita que le entreguemos paquetes de datos que el usuario debe construir, mientras el TCP admite bloques de datos que serán empaquetados de forma transparente antes de ser transmitidos.
Si un paquete se pierde el UDP no hace nada. Por el contrario, si un segmento se pierde el TCP lo retransmitirá, y este proceso durará hasta que el segmento ha sido correctamente entregado al host receptor, o se produzca un número máximo de retransmisiones.
 En el UDP controlamos qué datos viajan en cada paquete. En el TCP esto no es posible porque el empaquetamiento es automático. De hecho, el TCP espera un tiempo prudencial a tener bastantes datos que transmitir antes de enviar un segmento ya que esto ahorra ancho de banda. Si es importante que los datos tarden el mínimo tiempo posible en llegar al receptor el UDP es la mejor opción. En este sentido se dice que el UDP tiene una menor latencia que el TCP.
 
8. Diferencia entre sync & async sockets? 

Una aplicación se comunica realizando entrada y salida de datos. Pueden ser comunicaciones de red (socket), lectura o escritura en un archivo, etc. Esta entrada/salida de información se puede realizar de dos maneras sincrónica y asincrónica. 
Cuando se usa la manera síncrona, la persona que llama se bloquea hasta que la llamada se realiza correctamente. 
Este modelo está bien cuando tiene una comunicación ocurriendo. El problema es cuando su aplicación se distribuye masivamente y se comunica con muchos pares. En ese caso, debe tener N tareas (también llamadas subprocesos) y cada una se encargará de comunicarse con un par.
Por otro lado si utilizamos la manera asincrónica, verifica periódicamente si hay algo recibido.
Esta comunicación no es secuencial en absoluto. De hecho, envía información y luego, hay un bucle principal que recibe respuestas y vuelve a escribir de acuerdo con un protocolo.
No hay necesidad de tareas adicionales en ese modelo, puede manejarlas todas en la tarea principal. La parte difícil es seguir el estado de cada operación.

