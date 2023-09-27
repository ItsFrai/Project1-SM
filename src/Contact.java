public class Contact {
    private final Department department;
    private final String email;

    public Contact(Department department, String email) {
        this.department = department;
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public String getEmail(){
        return email;
    }

    public boolean isValid() {
        return this.department != null && this.email.endsWith("@rutgers.edu");
    }
}
