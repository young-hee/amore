package kr.ap.emt.display.vo;

import java.io.Serializable;
import java.util.List;

public class SupportersRequesterInfo implements Serializable {

    /**
	 * ��û�����ڵ�
	 */
    private String regularEventRequestStatus;

    /**
	 * ����
	 */
    private String genderCode;

    /**
	 * �������
	 */
    private String dob;

    /**
	 * SNSURL
	 */
    private String snsUrl;

    /**
	 * ����Ȩ������URL
	 */
    private String personalHomepageUrl;

    /**
	 * ��û����
	 */
    private String requestStatus;

    /**
	 * �̸����ּ�
	 */
    private String emailAddress;

    /**
	 * ÷���̹���
	 */
    private UploadedFile images;

    /**
	 * ��û�� ��ȭ��ȣ
	 */
    private EmbeddableTel requesterPhoneNo;

    /**
	 * ��û�� �ּ�
	 */
    private EmbeddableAddress requesterAddress;

    /**
	 * �б�
	 */
    private String school;

    /**
	 * �к�
	 */
    private String faculty;

    /**
	 * ������
	 */
    private String major;

    /**
	 * �г�
	 */
    private String grade;

    /**
	 * �̼��б�
	 */
    private String completeTerm;

    /**
	 * �����⵵
	 */
    private String graduationYear;

    /**
	 * �ڱ�Ұ�
	 */
    private String addQuestion1;

    /**
	 * ��������
	 */
    private String addQuestion2;

    /**
	 * ������ ����
	 */
    private String addQuestion3;

    /**
	 * youtube url
	 */
    private String addQuestion4;

    private List<RequesterHist> supportersRequesterHist;

    /**
	 * ��û�����ڵ�
	 */
    public String getRegularEventRequestStatus() {
        return regularEventRequestStatus;
    }

    /**
	 * ��û�����ڵ�
	 */
    public void setRegularEventRequestStatus(String regularEventRequestStatus) {
        this.regularEventRequestStatus = regularEventRequestStatus;
    }

    /**
	 * ����
	 */
    public String getGenderCode() {
        return genderCode;
    }

    /**
	 * ����
	 */
    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    /**
	 * �������
	 */
    public String getDob() {
        return dob;
    }

    /**
	 * �������
	 */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
	 * SNSURL
	 */
    public String getSnsUrl() {
        return snsUrl;
    }

    /**
	 * SNSURL
	 */
    public void setSnsUrl(String snsUrl) {
        this.snsUrl = snsUrl;
    }

    /**
	 * ����Ȩ������URL
	 */
    public String getPersonalHomepageUrl() {
        return personalHomepageUrl;
    }

    /**
	 * ����Ȩ������URL
	 */
    public void setPersonalHomepageUrl(String personalHomepageUrl) {
        this.personalHomepageUrl = personalHomepageUrl;
    }

    /**
	 * ��û����
	 */
    public String getRequestStatus() {
        return requestStatus;
    }

    /**
	 * ��û����
	 */
    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    /**
	 * �̸����ּ�
	 */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
	 * �̸����ּ�
	 */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
	 * ÷���̹���
	 */
    public UploadedFile getImages() {
        return images;
    }

    /**
	 * ÷���̹���
	 */
    public void setImages(UploadedFile images) {
        this.images = images;
    }

    /**
	 * ��û�� ��ȭ��ȣ
	 */
    public EmbeddableTel getRequesterPhoneNo() {
        return requesterPhoneNo;
    }

    /**
	 * ��û�� ��ȭ��ȣ
	 */
    public void setRequesterPhoneNo(EmbeddableTel requesterPhoneNo) {
        this.requesterPhoneNo = requesterPhoneNo;
    }

    /**
	 * ��û�� �ּ�
	 */
    public EmbeddableAddress getRequesterAddress() {
        return requesterAddress;
    }

    /**
	 * ��û�� �ּ�
	 */
    public void setRequesterAddress(EmbeddableAddress requesterAddress) {
        this.requesterAddress = requesterAddress;
    }

    /**
	 * �б�
	 */
    public String getSchool() {
        return school;
    }

    /**
	 * �б�
	 */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
	 * �к�
	 */
    public String getFaculty() {
        return faculty;
    }

    /**
	 * �к�
	 */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
	 * ������
	 */
    public String getMajor() {
        return major;
    }

    /**
	 * ������
	 */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
	 * �г�
	 */
    public String getGrade() {
        return grade;
    }

    /**
	 * �г�
	 */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
	 * �̼��б�
	 */
    public String getCompleteTerm() {
        return completeTerm;
    }

    /**
	 * �̼��б�
	 */
    public void setCompleteTerm(String completeTerm) {
        this.completeTerm = completeTerm;
    }

    /**
	 * �����⵵
	 */
    public String getGraduationYear() {
        return graduationYear;
    }

    /**
	 * �����⵵
	 */
    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    /**
	 * �ڱ�Ұ�
	 */
    public String getAddQuestion1() {
        return addQuestion1;
    }

    /**
	 * �ڱ�Ұ�
	 */
    public void setAddQuestion1(String addQuestion1) {
        this.addQuestion1 = addQuestion1;
    }

    /**
	 * ��������
	 */
    public String getAddQuestion2() {
        return addQuestion2;
    }

    /**
	 * ��������
	 */
    public void setAddQuestion2(String addQuestion2) {
        this.addQuestion2 = addQuestion2;
    }

    /**
	 * ������ ����
	 */
    public String getAddQuestion3() {
        return addQuestion3;
    }

    /**
	 * ������ ����
	 */
    public void setAddQuestion3(String addQuestion3) {
        this.addQuestion3 = addQuestion3;
    }

    /**
	 * youtube url
	 */
    public String getAddQuestion4() {
        return addQuestion4;
    }

    /**
	 * youtube url
	 */
    public void setAddQuestion4(String addQuestion4) {
        this.addQuestion4 = addQuestion4;
    }

    public List<RequesterHist> getSupportersRequesterHist() {
        return supportersRequesterHist;
    }

    public void setSupportersRequesterHist(List<RequesterHist> supportersRequesterHist) {
        this.supportersRequesterHist = supportersRequesterHist;
    }
}
