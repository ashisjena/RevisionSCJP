package scjp.com.java;

class Emp implements Comparable<Emp> {

  Integer id;

  Emp(int id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public int compareTo(Emp o) {
    return this.id.compareTo(o.id);
  }
}