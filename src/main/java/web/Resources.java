package web;

import domain.Cords;
import net.minidev.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.FireService;
import java.util.ArrayList;

@RestController
@RequestMapping(value= "/getFires", method = RequestMethod.GET, produces = "application/json")
public class Resources {
    public JSONArray Resources(){
        FireService service = new FireService();
        ArrayList<Cords> fires = service.extractFires();
        //JSONArray jsonArray = new JSONArray(fires);
        //System.out.println(jsonArray);
//        return jsonArray;
        return null;
    }


}

