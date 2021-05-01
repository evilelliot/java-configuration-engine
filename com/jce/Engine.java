package com.jce;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.io.FileReader;



public class Engine{
     // Ruta de archivo por defecto
     protected final String CONFIG_FILE = "./config.json";
    // Para los archivos config personalizados
    public String[] configModel;
    // Constructor de un archivo custom: recibe un array de strings con los items que debe de contener
    public Engine(String[] data){
        this.configModel = data;
    }
    // Checar si existe el archivo de configuración
    public boolean checkConfigFile() throws Exception{
        try{
            File f = new File(this.CONFIG_FILE);
            if(f.exists()){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            throw new Exception("Error fatal: el archivo de configuración no existe.");
        }
    }
    // Checar la integridad de un archivo de configuración custom
    public boolean probeIntegrity(){
        try{
            if(this.checkConfigFile()){
                // Configurar el parser JSON para extraer los datos del archivo
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(this.CONFIG_FILE));
                JSONObject jsonObject = (JSONObject) obj;
                // Revisar index por index si el dato existe dentro del archivo
                for(int i = 0; i <= this.configModel.length - 1; i++){
                    String configItem = (String) jsonObject.get(this.configModel[i]);
                    if(configItem == null){
                        return false;
                    }
                }
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    // Getter de los item de un archivo custom
    public String getItem(String item) throws Exception{
        // Configurar un parser y regresar el dato requerido una vez que sabemos que existe
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(this.CONFIG_FILE));
            JSONObject jsonObject = (JSONObject) obj;
            String it = (String) jsonObject.get(item);
            
            return it;
        }catch(Exception e){
            throw new Exception("Item de configuracion: no se pudo cargar el item " + item);
        }
    }
}
