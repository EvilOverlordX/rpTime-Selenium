package com.roosterpark.rptime.selenium.control.complex.list.timesheet;

import com.roosterpark.rptime.selenium.control.complex.list.timesheet.status.Approved;
import com.roosterpark.rptime.selenium.control.complex.list.timesheet.status.Submitted;
import com.roosterpark.rptime.selenium.control.complex.list.timesheet.status.Unsubmitted;
import com.roosterpark.rptime.selenium.page.UserTimeSheetPage;

/**
 * User: John
 * Date: 1/7/14
 * Time: 9:43 AM
 */
public class UserTimeSheetRow {

    private UserTimeSheetRowLink userTimeSheetRowLink;
    private Integer week;
    private String date;
    private Integer year;
    private Approved approved;
    private Submitted submitted;
    private Unsubmitted unsubmitted;

    public UserTimeSheetRow(UserTimeSheetRowLink link, Integer week, String date, Integer year,
                            Approved approved, Submitted submitted, Unsubmitted unsubmitted) {
        userTimeSheetRowLink = link;
        this.week = week;
        this.date = date;
        this.year = year;
        this.approved = approved;
        this.submitted = submitted;
        this.unsubmitted = unsubmitted;
    }

    public Integer getWeek() {
        return week;
    }

    public String getDate() {
        return date;
    }

    public Integer getYear() {
        return year;
    }

    public UserTimeSheetPage clickLink() {
        return userTimeSheetRowLink.click();
    }

    public boolean isApproved() {
        return approved.isVisible();
    }

    public boolean isSubmitted() {
        return submitted.isVisible();
    }

    public boolean isUnsubmitted() {
        return unsubmitted.isVisible();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTimeSheetRow that = (UserTimeSheetRow) o;

        if (approved != null ? !approved.equals(that.approved) : that.approved != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (submitted != null ? !submitted.equals(that.submitted) : that.submitted != null) return false;
        if (unsubmitted != null ? !unsubmitted.equals(that.unsubmitted) : that.unsubmitted != null) return false;
        if (userTimeSheetRowLink != null ? !userTimeSheetRowLink.equals(that.userTimeSheetRowLink) : that.userTimeSheetRowLink != null)
            return false;
        if (week != null ? !week.equals(that.week) : that.week != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userTimeSheetRowLink != null ? userTimeSheetRowLink.hashCode() : 0;
        result = 31 * result + (week != null ? week.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (approved != null ? approved.hashCode() : 0);
        result = 31 * result + (submitted != null ? submitted.hashCode() : 0);
        result = 31 * result + (unsubmitted != null ? unsubmitted.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserTimeSheetRow{" +
                "userTimeSheetRowLink=" + userTimeSheetRowLink +
                ", week=" + week +
                ", date='" + date + '\'' +
                ", year=" + year +
                ", approved=" + approved +
                ", submitted=" + submitted +
                ", unsubmitted=" + unsubmitted +
                '}';
    }

}
