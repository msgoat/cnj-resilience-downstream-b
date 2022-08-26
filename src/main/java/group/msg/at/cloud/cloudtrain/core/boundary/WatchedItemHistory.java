package group.msg.at.cloud.cloudtrain.core.boundary;

import group.msg.at.cloud.cloudtrain.core.entity.WatchedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WatchedItemHistory {

    @Autowired
    private UnexpectedBehaviour behaviour;

    public List<WatchedItem> getWatchedItems(String userId) {
        behaviour.applyUnexpectedBehaviour();
        List<WatchedItem> result = new ArrayList<>();
        result.add(new WatchedItem(UUID.randomUUID(), "StarTrek Discovery", LocalDateTime.now().minusDays(3)));
        result.add(new WatchedItem(UUID.randomUUID(), "StarTrek Picard", LocalDateTime.now().minusWeeks(3)));
        return result;
    }
}
