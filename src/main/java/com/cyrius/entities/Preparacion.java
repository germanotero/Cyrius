package com.cyrius.entities;

import com.framework.persistence.PersistibleObject;

import java.util.Objects;

public class Preparacion implements PersistibleObject {
    protected Long id;
    protected String nombre;
    protected String descripcion;

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return getNombre();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Preparacion)) {
            return false;
        }
        Preparacion that = (Preparacion) obj;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void validate() {
    }
}
