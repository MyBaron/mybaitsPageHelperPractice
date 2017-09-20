package Entity;

public class Person {
  private Long id;
  private String person_name;
  private String hobby;
  private Long age;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPerson_name() {
    return person_name;
  }

  public void setPerson_name(String person_name) {
    this.person_name = person_name;
  }

  public String getHobby() {
    return hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }

  public Long getAge() {
    return age;
  }

  public void setAge(Long age) {
    this.age = age;
  }

  public Person() {
    super();
  }

  public Person(String person_name, String hobby, Long age) {
    this.person_name = person_name;
    this.hobby = hobby;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
            "id=" + id +
            ", person_name='" + person_name + '\'' +
            ", hobby='" + hobby + '\'' +
            ", age=" + age +
            '}';
  }
}
