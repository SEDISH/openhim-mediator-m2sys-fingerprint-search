package com.soldevelo.mediator.m2sys.fingerprint.search;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.apache.http.HttpStatus;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.FinishRequest;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;

public class FingerprintBulkSearchOrchestrator extends UntypedActor {

    private LoggingAdapter log = Logging.getLogger(getContext().system(), this); //NOPMD

    private final MediatorConfig config; //NOPMD

    public FingerprintBulkSearchOrchestrator(MediatorConfig config) {
        this.config = config;
    }

    @Override
    public void onReceive(Object msg) throws Exception {
        if (msg instanceof MediatorHTTPRequest) {
            FinishRequest finishRequest = new FinishRequest("A message from my new mediator!",
                    "text/plain", HttpStatus.SC_OK);
            ((MediatorHTTPRequest) msg).getRequestHandler().tell(finishRequest, getSelf());
        } else {
            unhandled(msg);
        }
    }
}
