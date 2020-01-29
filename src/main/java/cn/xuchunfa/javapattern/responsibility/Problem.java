package cn.xuchunfa.responsibility;

public enum Problem {
    STRUCTURE("structure"), ARCHITECTURE("architecture");

    private String discripition;
    Problem(String name) {
        this.discripition = name;
    }

    @Override
    public String toString() {
        return discripition;
    }

}
