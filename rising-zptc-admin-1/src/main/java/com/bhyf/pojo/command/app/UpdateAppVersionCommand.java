package com.bhyf.pojo.command.app;

import com.rising.common.component.BaseCommand;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by admin on 2016/4/19.
 */
public class UpdateAppVersionCommand extends BaseCommand{

    private String versionName;

    private Integer category;

    private Integer versionNo;

    private Integer isUpgrade;

    private String content;

    private Integer status;

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }

    public Integer getIsUpgrade() {
        return isUpgrade;
    }

    public void setIsUpgrade(Integer isUpgrade) {
        this.isUpgrade = isUpgrade;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
