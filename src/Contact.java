public class Contact {
    private Department department;
    private String email;

    public Contact(Department department, String email) {
        this.department = department;
        this.email = email;
    }
    public boolean isValid() {
        return this.department != null && this.email.endsWith("@rutgers.edu");
    }
}
