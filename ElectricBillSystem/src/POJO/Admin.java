package POJO;

public class Admin {
    private String adminUsername;
    private String adminEmail;
    private String adminpassword;

    public Admin() {
        super();
    }

    public Admin(String adminUsername, String adminEmail, String adminpassword) {
        this.adminUsername = adminUsername;
        this.adminEmail = adminEmail;
        this.adminpassword = adminpassword;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }

    @Override
    public String toString() {
        return "Admin Details are --->\nAdminUsername=" + adminUsername + "\nAdminEmail=" + adminEmail + "\nAdminpassword="
                + adminpassword + "";
    }

}
