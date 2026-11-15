package com.vivo.calculator.entry;

/* JADX INFO: loaded from: classes.dex */
public class ExchangeEntry {
    private DataBean data;
    private Object message;
    private Object redirect;
    private int retcode;
    private Object toast;
    private Object upgrade;
    private Object ver;

    public static class DataBean {
        private String cfrom;
        private String cfromEn;
        private Object rate;
        private long time;

        public String getCfrom() {
            return this.cfrom;
        }

        public String getCfromEn() {
            return this.cfromEn;
        }

        public Object getRate() {
            return this.rate;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public Object getMessage() {
        return this.message;
    }

    public int getRetcode() {
        return this.retcode;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }
}
