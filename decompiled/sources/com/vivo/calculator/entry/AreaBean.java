package com.vivo.calculator.entry;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class AreaBean {
    private int bottom;
    private int left;
    private View mView;
    private int right;
    private int top;

    public static class Builder {
        private int bottom;
        private int left;
        private View mView;
        private int right;
        private int top;

        public AreaBean build() {
            return new AreaBean(this);
        }

        public Builder setBottom(int i3) {
            this.bottom = i3;
            return this;
        }

        public Builder setLeft(int i3) {
            this.left = i3;
            return this;
        }

        public Builder setRight(int i3) {
            this.right = i3;
            return this;
        }

        public Builder setTop(int i3) {
            this.top = i3;
            return this;
        }

        public Builder setmView(View view) {
            this.mView = view;
            return this;
        }
    }

    public AreaBean(Builder builder) {
        this.left = builder.left;
        this.top = builder.top;
        this.right = builder.right;
        this.bottom = builder.bottom;
        this.mView = builder.mView;
    }

    public int getBottom() {
        return this.bottom;
    }

    public int getLeft() {
        return this.left;
    }

    public int getRight() {
        return this.right;
    }

    public int getTop() {
        return this.top;
    }

    public View getmView() {
        return this.mView;
    }
}
