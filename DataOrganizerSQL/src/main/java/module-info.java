module DataOrganizerSQL {
    exports de.superdupermarkt.util;
    exports de.superdupermarkt.services;
    requires lombok;
    requires java.persistence;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.beans;
    requires Products;
}