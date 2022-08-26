package group.msg.at.cloud.cloudtrain.adapter.rest;

import group.msg.at.cloud.cloudtrain.core.boundary.UnexpectedBehaviour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sabotage")
@CrossOrigin
public class SabotageController {

    @Autowired
    private UnexpectedBehaviour boundary;

    @GetMapping
    public void sabotageBehaviour(
            @RequestParam(value = "noResponse", required = false, defaultValue = "false") boolean noResponse,
            @RequestParam(value = "slowResponse", required = false, defaultValue = "false") boolean slowResponse,
            @RequestParam(value = "alwaysFail", required = false, defaultValue = "false") boolean alwaysFail) {
        boundary.setUnexpectedBevaviour(noResponse, slowResponse, alwaysFail);
    }
}
