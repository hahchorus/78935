package mx.uv.t4is.Saludos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BorrarSaludoRequest;
import https.t4is_uv_mx.saludos.BorrarSaludoResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse;
import https.t4is_uv_mx.saludos.ModificarSaludoRequest;
import https.t4is_uv_mx.saludos.ModificarSaludoResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse.Saludos;

@Endpoint
public class SaludosEndPoint {

    int contId = 1;
    //ArrayList del primer metodo
    //List<Saludo> saludos = new ArrayList<>();
    //ArrayList del metodo del Profesor
    List<Saludos> lista = new ArrayList<>();
    
    //localPart = Tipo de saludo del xsd y namespace = targetNamespace de saludos.xsd
    @PayloadRoot(localPart = "SaludarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload

    //SaludarResponce y SaludarRequest fueron creadas en target/generated-sources\jaxb\https\t4is_uv_mx\saludos
    //Se crea como una clase java pero manda parametros del xsd y se convierte con el @
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion) {
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola " + peticion.getNombre());
        //Primer metodo para mandar saludo
        /*
        Saludo saludo = new Saludo();
        saludo.setNombre(peticion.getNombre());
        saludo.setId(contId);
        saludos.add(saludo);
        contId ++;
        */
        
        //Metodo para saludo del Profesor
        Saludos e = new Saludos();
        e.setNombre(peticion.getNombre());
        e.setId(contId++);
        lista.add(e);

        return respuesta;
    }

    //Se manda el mismo namespace de la funcion que se va a recuperar
    @PayloadRoot(localPart = "BuscarSaludosRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarSaludosResponse buscarSaludos() {
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();
        //Primer metodo para buscar todos los saludos
        /*
        for (Saludo saludo : saludos) {
            BuscarSaludosResponse.Saludos buscaSaludox = new BuscarSaludosResponse.Saludos();
            buscaSaludox.setId(saludo.getId());
            buscaSaludox.setNombre(saludo.getNombre());
            respuesta.getSaludos().add(buscaSaludox);
        }
        */

        //Metodo para buscar todos los saludos del Profesor
        //Recorre la lista
        for (Saludos o : lista) {
            System.out.println(o);
            Saludos e = new Saludos();
            e.setNombre(o.getNombre());
            e.setId(o.getId());
            respuesta.getSaludos().add(o);
        }

        return respuesta;
    
    }

    @PayloadRoot(localPart = "ModificarSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ModificarSaludoResponse modificarSaludos(@RequestPayload ModificarSaludoRequest peticion) {
        ModificarSaludoResponse respuesta = new ModificarSaludoResponse();
        Saludos e = new Saludos();
        e.setId(peticion.getId());
        e.setNombre(peticion.getNombre());
        lista.set(peticion.getId()-1, e);
        respuesta.setRespuesta(true);

        return respuesta;

    }

    @PayloadRoot(localPart = "BorrarSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BorrarSaludoResponse borrarSaludo(@RequestPayload BorrarSaludoRequest peticion) {
        BorrarSaludoResponse respuesta = new BorrarSaludoResponse();

        //Eliminar de la lista
        //lista.remove(peticion.getId()-1);
        
        for (Saludos o : lista) {
            if (o.getId() == peticion.getId() ){
                lista.remove(o);
                break;
            }
        }
        
        //Saludos o = new Saludos();
        //o.setId(peticion.getId());
        //o.setNombre(lista.get(peticion.getId()).getNombre());
        //lista.remove(lista.indexOf(o));

        respuesta.setRespuesta(true);
        return respuesta;
    
    }

}
