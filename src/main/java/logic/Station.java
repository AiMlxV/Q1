package logic;

public class Station {

    private String name;
    private int number;

    public Station(String name, int number) {
        setName(name);
        setNumber(number);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = Math.max(number, 0);
    }

    public int getNumber() {
        return number;
    }

}
