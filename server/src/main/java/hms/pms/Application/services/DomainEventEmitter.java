package hms.pms.Application.services;

import hms.pms.domain.common.DomainEvent;

public interface DomainEventEmitter {
    void emit(DomainEvent event);
}

