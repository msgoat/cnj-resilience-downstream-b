package group.msg.at.cloud.cloudtrain.core.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UnexpectedBehaviour {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private boolean noResponse;

    private boolean slowResponse;

    private boolean alwaysFail;

    public boolean isNoResponse() {
        return noResponse;
    }

    public boolean isAlwaysFail() {
        return alwaysFail;
    }

    public boolean isSlowResponse() {
        return slowResponse;
    }

    public void setUnexpectedBehaviour(boolean noResponse, boolean slowResponse, boolean alwaysFail) {
        this.noResponse = noResponse;
        this.slowResponse = slowResponse;
        this.alwaysFail = alwaysFail;
        logger.info("set unexpected behaviour to noResponse [{}] slowResponse [{}] alwaysFail [{}]", this.noResponse, this.slowResponse, this.alwaysFail);
    }

    public void applyUnexpectedBehaviour() {
        if (isNoResponse()) {
            logger.info("sending no response...");
            try {
                Thread.sleep(10 * 60 * 1000);
            } catch (InterruptedException e) {
                logger.error("got interrupted while sending no response", e);
            }
        }
        if (isSlowResponse()) {
            logger.info("sending slow response...");
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                logger.error("got interrupted while sending slow response", e);
            }
        }
        if (isAlwaysFail()) {
            logger.info("failing miserably...");
            throw new IllegalStateException("crash'n'burn baby!");
        }
    }
}
