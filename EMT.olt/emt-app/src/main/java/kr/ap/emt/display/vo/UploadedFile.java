package kr.ap.emt.display.vo;


import java.io.Serializable;

public class UploadedFile implements Serializable {

    /**
	 * ���ϸ�
	 */
    private String fileName;

    /**
	 * ����URL
	 */
    private String fileUrl;

    /**
	 * �����URL
	 */
    private String thumbnailUrl;

    /**
	 * ���ϼ���
	 */
    private String fileDesc;

    /**
	 * ���ϸ�
	 */
    public String getFileName() {
        return fileName;
    }

    /**
	 * ���ϸ�
	 */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
	 * ����URL
	 */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
	 * ����URL
	 */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
	 * �����URL
	 */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    /**
	 * �����URL
	 */
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    /**
	 * ���ϼ���
	 */
    public String getFileDesc() {
        return fileDesc;
    }

    /**
	 * ���ϼ���
	 */
    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc;
    }
}
