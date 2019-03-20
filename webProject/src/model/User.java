package model;

public class User {
    private Integer id;
    private Integer age;
    private String name;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(Integer id, String name, Integer age, String password) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + ", password=" + password + "]";
    }
}
