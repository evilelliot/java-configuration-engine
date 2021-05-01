/**
 * Autor: Alberto Ocaranza
 * Descripción: Clase test para probar el Configuration Engine.
 * Proyecto: ConfigEngine es un motor sencillo para cargar datos de configuración directo de un
 * archivo JSON.
 */
import com.jce.Engine;
import com.jce.Templates;

class Main{
    public static void main(String[] args){
      // Ejemplo de uso desde un método extra
      loadConfig();
    }
    // Contener todo el proceso en una función aparte para evitar el desorden
    static private void loadConfig(){
      // Dado que los métodos lanzan exceptions necesitamos encerrar el proceso en un try-catch
      try {
        // Creamos un arreglo con los items que contiene nuestro archivo de configuración
        String[] cnf = {"author", "version", "license", "lang"};
        // Creamos una instancia del configengine, le pasamos el array 
        Engine config = new Engine(Templates.BASIC_TEMPLATE);
        // Mostramos algunos datos sobre el archivo de configuración
        System.out.println("Integridad del archivo: " + config.probeIntegrity());
        System.out.println("Description: " + config.getItem("description"));
        
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
}