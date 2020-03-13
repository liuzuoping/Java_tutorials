package domain;

public class Items {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                '}';
    }

    private Integer id;
    private String NAME;

    public void getId(int id) {
    }

    public void getNAME(String name) {
    }
}
