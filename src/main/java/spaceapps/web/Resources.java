package spaceapps.web;

import spaceapps.domain.Cords;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spaceapps.services.FireService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
public class Resources {

    @RequestMapping(value= "/fires", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> fires(HttpServletRequest request){
        FireService service = new FireService();
        ArrayList<Cords> fuego_agua = service.extractFull_Data();
        JSONObject obj= new JSONObject();
        obj.put("fuego_agua",fuego_agua);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }
}

