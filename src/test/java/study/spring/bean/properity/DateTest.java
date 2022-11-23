package study.spring.bean.properity;


import java.util.Date;

public class DateTest {
    private Date dateValue;

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    @Override
    public String toString() {
        return "DateTest{" +
                "dateValue=" + dateValue +
                '}';
    }
}
