public class MyDate {
    private int year;
    private int month;
    private int day;

    public static final String[] MONTHS = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public static final String[] DAYS = {
            "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"
    };

    public static final int[] DAYS_IN_MONTHS = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999) return false;
        if (month < 1 || month > 12) return false;

        int maxDay = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            maxDay = 29;
        }

        return day >= 1 && day <= maxDay;
    }

    public static int getDayOfWeek(int year, int month, int day) {
        int[] centuryTable = {6, 4, 2, 0};
        int c = year / 100;
        int y = year % 100;
        int cCentury = centuryTable[(c - 17) % 4 < 0 ? ((c - 17) % 4) + 4 : (c - 17) % 4];

        int[] monthTableJan = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
        int[] monthTableLeap = {6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};

        int mVal = isLeapYear(year) ? monthTableLeap[month - 1] : monthTableJan[month - 1];

        return (cCentury + y + (y / 4) + mVal + day) % 7;
    }

    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }

    public void setDate(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Invalid year!");
        }
        this.year = year;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month!");
        }
        this.month = month;
    }

    public void setDay(int day) {
        int maxDay = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            maxDay = 29;
        }
        if (day < 1 || day > maxDay) {
            throw new IllegalArgumentException("Invalid day!");
        }
        this.day = day;
    }

    @Override
    public String toString() {
        String dayOfWeekStr = DAYS[getDayOfWeek(year, month, day)];
        return dayOfWeekStr + " " + day + " " + MONTHS[month - 1] + " " + year;
    }

    public MyDate nextDay() {
        int maxDay = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            maxDay = 29;
        }

        if (day < maxDay) {
            day++;
        } else {
            if (month < 12) {
                month++;
                day = 1;
            } else {
                if (year < 9999) {
                    year++;
                    month = 1;
                    day = 1;
                } else {
                    throw new IllegalStateException("Year out of range!");
                }
            }
        }
        return this;
    }

    public MyDate nextMonth() {
        if (month < 12) {
            month++;
        } else {
            if (year < 9999) {
                year++;
                month = 1;
            } else {
                throw new IllegalStateException("Year out of range!");
            }
        }
        int maxDay = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            maxDay = 29;
        }
        if (day > maxDay) {
            day = maxDay;
        }
        return this;
    }

    public MyDate nextYear() {
        if (year < 9999) {
            year++;
        } else {
            throw new IllegalStateException("Year out of range!");
        }
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }

    public MyDate previousDay() {
        if (day > 1) {
            day--;
        } else {
            if (month > 1) {
                month--;
                int maxDay = DAYS_IN_MONTHS[month - 1];
                if (month == 2 && isLeapYear(year)) {
                    maxDay = 29;
                }
                day = maxDay;
            } else {
                if (year > 1) {
                    year--;
                    month = 12;
                    day = 31;
                } else {
                    throw new IllegalStateException("Year out of range!");
                }
            }
        }
        return this;
    }

    public MyDate previousMonth() {
        if (month > 1) {
            month--;
        } else {
            if (year > 1) {
                year--;
                month = 12;
            } else {
                throw new IllegalStateException("Year out of range!");
            }
        }
        int maxDay = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            maxDay = 29;
        }
        if (day > maxDay) {
            day = maxDay;
        }
        return this;
    }

    public MyDate previousYear() {
        if (year > 1) {
            year--;
        } else {
            throw new IllegalStateException("Year out of range!");
        }
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }
}