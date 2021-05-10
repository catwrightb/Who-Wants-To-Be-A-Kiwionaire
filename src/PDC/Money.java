package PDC;

public enum Money {
    /**
     * enum type constants for assigning users score
     * used in the User class and GameApplication
     *
     */
    LEVEL1(500,1),
    LEVEL2(1000,2),
    LEVEL3(2000,3),
    LEVEL4(3000,4),
    LEVEL5(5000,5),
    LEVEL6(7500,6),
    LEVEL7(10000,7),
    LEVEL8(15000,8),
    LEVEL9(25000,9),
    LEVEL10(50000,10),
    LEVEL11(75000,11),
    LEVEL12(150000,12),
    LEVEL13(250000,13),
    LEVEL14(500000,14),
    LEVEL15(1000000,15),
    ;

    private int prizeMoney;
    private int prizeLevel;

    Money(int prizeMoney, int prizeLevel) {
        this.prizeMoney = prizeMoney;
        this.prizeLevel = prizeLevel;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public void setPrizeMoney(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeLevel() {
        return prizeLevel;
    }

    public void setPrizeLevel(int prizeLevel) {
        this.prizeLevel = prizeLevel;
    }
}
