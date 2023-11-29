package hms.pms.Application.services;

public interface DomainEventEmitter {
    void emit(Object obj);
}

