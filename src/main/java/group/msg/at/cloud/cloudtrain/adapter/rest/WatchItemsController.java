package group.msg.at.cloud.cloudtrain.adapter.rest;

import group.msg.at.cloud.cloudtrain.core.boundary.WatchedItemHistory;
import group.msg.at.cloud.cloudtrain.core.entity.WatchedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/watchedItems")
@CrossOrigin
public class WatchItemsController {

    @Autowired
    WatchedItemHistory boundary;

    @GetMapping("{userId}")
    public ResponseEntity<List<WatchedItem>> getWatchedItems(
            @PathVariable(name = "userId") String userId) {
        return ResponseEntity.ok(boundary.getWatchedItems(userId));
    }
}
