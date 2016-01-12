package entities;

public class Info {
    private int infoId;
    private Integer bankId;
    private String text1;
    private String text2;
    private String text3;

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Info info = (Info) o;

        if (infoId != info.infoId) return false;
        if (bankId != null ? !bankId.equals(info.bankId) : info.bankId != null) return false;
        if (text1 != null ? !text1.equals(info.text1) : info.text1 != null) return false;
        if (text2 != null ? !text2.equals(info.text2) : info.text2 != null) return false;
        if (text3 != null ? !text3.equals(info.text3) : info.text3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = infoId;
        result = 31 * result + (bankId != null ? bankId.hashCode() : 0);
        result = 31 * result + (text1 != null ? text1.hashCode() : 0);
        result = 31 * result + (text2 != null ? text2.hashCode() : 0);
        result = 31 * result + (text3 != null ? text3.hashCode() : 0);
        return result;
    }
}
