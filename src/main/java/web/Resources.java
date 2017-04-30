package web;

import domain.Cords;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import services.FireService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
public class Resources {

    @RequestMapping(value= "/{id:(?!link).*}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<JSONObject> Resources(HttpServletRequest request){
        FireService service = new FireService();
        ArrayList<Cords> fires = service.extractFires();
        System.out.println("Estoy aqui adentro");
        JSONObject obj= new JSONObject();
        obj.put("fuegos",fires);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }
}

