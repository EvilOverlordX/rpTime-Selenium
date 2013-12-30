package com.roosterpark.rptime.selenium.control.complex.list.unregistered;

/**
 * User: John
 * Date: 12/30/13
 * Time: 10:19 AM
 */
public class UnregisteredWorkerListRow {

    private String email;
    private UnregisteredUserLink unregisteredUserLink;

    public UnregisteredWorkerListRow(String email, UnregisteredUserLink unregisteredUserLink) {
        this.email = email;
        this.unregisteredUserLink = unregisteredUserLink;
    }

    public String getEmail() {
        return email;
    }

    public UnregisteredUserLink getUnregisteredUserLink() {
        return unregisteredUserLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnregisteredWorkerListRow that = (UnregisteredWorkerListRow) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (unregisteredUserLink != null ? !unregisteredUserLink.equals(that.unregisteredUserLink) : that.unregisteredUserLink != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (unregisteredUserLink != null ? unregisteredUserLink.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UnregisteredWorkerListRow{" +
                "email='" + email + '\'' +
                ", unregisteredUserLink=" + unregisteredUserLink +
                '}';
    }

}
