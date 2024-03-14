package com.pingwit.part_30;

import java.util.Objects;

public final class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Employee) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, location);
    }

    @Override
    public String toString() {
        return "Employee[" +
                "id=" + id + ", " +
                "firstName=" + firstName + ", " +
                "lastName=" + lastName + ", " +
                "location=" + location + ']';
    }

}
