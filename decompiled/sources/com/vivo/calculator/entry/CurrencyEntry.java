package com.vivo.calculator.entry;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CurrencyEntry {
    private List<DataBean> data;
    private Object message;
    private String redirect;
    private int retcode;
    private Object toast;
    private Object upgrade;
    private String ver;

    public static class DataBean {
        private String curr;
        private String cy;
        private String name;
        private int position;
        private String url;
        private String ver;

        public String getCurr() {
            return this.curr;
        }

        public String getCy() {
            return this.cy;
        }

        public String getName() {
            return this.name;
        }

        public int getPosition() {
            return this.position;
        }

        public String getUrl() {
            return this.url;
        }

        public String getVer() {
            return this.ver;
        }

        public void setCurr(String str) {
            this.curr = str;
        }

        public void setCy(String str) {
            this.cy = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPosition(int i3) {
            this.position = i3;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setVer(String str) {
            this.ver = str;
        }
    }

    private Object getMessage() {
        return this.message;
    }

    private String getRedirect() {
        return this.redirect;
    }

    private Object getToast() {
        return this.toast;
    }

    private Object getUpgrade() {
        return this.upgrade;
    }

    private void setData(List<DataBean> list) {
        this.data = list;
    }

    private void setMessage(Object obj) {
        this.message = obj;
    }

    private void setRedirect(String str) {
        this.redirect = str;
    }

    private void setRetcode(int i3) {
        this.retcode = i3;
    }

    private void setToast(Object obj) {
        this.toast = obj;
    }

    private void setUpgrade(Object obj) {
        this.upgrade = obj;
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public int getRetcode() {
        return this.retcode;
    }

    public String getVer() {
        return this.ver;
    }
}
