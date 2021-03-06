package Game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebSiteController {
    public static void main(String[] args) {
        SpringApplication.run(WebSiteController.class, args);
        PicasyFijas.getInstance();
    }

    /**
     *  Metodo get para saber la cadena oculta que debe encontrar el jugador
     * @return
     */
    @GetMapping("/index")
    public String cadenaFinal(){
        String cadenaReal = "";
        for(int i = 0; i< PicasyFijas.getInstance().getNumeroR().size(); i++){
            cadenaReal += PicasyFijas.getInstance().getNumeroR().get(i);
        }
        return cadenaReal;
    }
    /**
     * Metodo POST para la lectura del usuario y además decir cuantas picas y fijas 
     *  a encontrado dependiendo de la lista enviada
     * @param lista
     * @return
     */
    @PostMapping("/index")
    public String lecturaDeEntrada(@RequestParam(value = "lista", defaultValue = "0,0,0,0") String lista){
        PicasyFijas.getInstance().convertir(lista);
        return String.format("El numero de picas que tiene el jugador es de %s", PicasyFijas.getInstance().getPicas() + "\n " + "El numero de fijas que tiene el jugador es de " + PicasyFijas.getInstance().getFijas());
    }


}
