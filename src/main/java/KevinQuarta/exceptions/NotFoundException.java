package KevinQuarta.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("L'Evento " + id + "non è stato trovato");
    }
}