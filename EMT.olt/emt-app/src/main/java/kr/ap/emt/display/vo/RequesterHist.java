package kr.ap.emt.display.vo;


import java.io.Serializable;
import java.util.Date;

public class RequesterHist implements Serializable {

   
    private String activityType;

   
    private String activityName;

   
    private Date activityStartDate;

   
    private Date activityEndDate;

   
    private String activityBodyText;

   
    public String getActivityType() {
        return activityType;
    }

   
    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

   
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    
    public Date getActivityStartDate() {
        return activityStartDate;
    }

    
    public void setActivityStartDate(Date activityStartDate) {
        this.activityStartDate = activityStartDate;
    }

   
    public Date getActivityEndDate() {
        return activityEndDate;
    }

    
    public void setActivityEndDate(Date activityEndDate) {
        this.activityEndDate = activityEndDate;
    }

   
    public String getActivityBodyText() {
        return activityBodyText;
    }

    public void setActivityBodyText(String activityBodyText) {
        this.activityBodyText = activityBodyText;
    }
}
