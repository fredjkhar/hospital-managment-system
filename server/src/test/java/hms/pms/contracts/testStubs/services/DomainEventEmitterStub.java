package hms.pms.contracts.testStubs.services;

import hms.pms.application.services.DomainEventEmitter;
import hms.pms.domain.common.DomainEvent;

public class DomainEventEmitterStub implements DomainEventEmitter {
    @Override
    public void emit(DomainEvent event) {

    }
}
