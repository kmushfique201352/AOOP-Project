package com.library;

public class AvailableAdmin {
    private final String adminID;
    private final String adminPassword;
    private final String adminImage;

    public AvailableAdmin(String adminID, String adminPassword, String adminImage) {
        this.adminID = adminID;
        this.adminPassword = adminPassword;
        this.adminImage = adminImage;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getAdminImage() {
        return adminImage;
    }
}
