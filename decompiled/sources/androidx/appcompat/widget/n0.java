package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ResourcesWrapper.java */
/* JADX INFO: loaded from: classes.dex */
class n0 extends Resources {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f702a;

    public n0(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f702a = resources;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i3) throws Resources.NotFoundException {
        return this.f702a.getAnimation(i3);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i3) throws Resources.NotFoundException {
        return this.f702a.getBoolean(i3);
    }

    @Override // android.content.res.Resources
    public int getColor(int i3) throws Resources.NotFoundException {
        return this.f702a.getColor(i3);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i3) throws Resources.NotFoundException {
        return this.f702a.getColorStateList(i3);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f702a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i3) throws Resources.NotFoundException {
        return this.f702a.getDimension(i3);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i3) throws Resources.NotFoundException {
        return this.f702a.getDimensionPixelOffset(i3);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i3) throws Resources.NotFoundException {
        return this.f702a.getDimensionPixelSize(i3);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f702a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i3) throws Resources.NotFoundException {
        return this.f702a.getDrawable(i3);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i3, int i4) throws Resources.NotFoundException {
        return this.f702a.getDrawableForDensity(i3, i4);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i3, int i4, int i5) {
        return this.f702a.getFraction(i3, i4, i5);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f702a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i3) throws Resources.NotFoundException {
        return this.f702a.getIntArray(i3);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i3) throws Resources.NotFoundException {
        return this.f702a.getInteger(i3);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i3) throws Resources.NotFoundException {
        return this.f702a.getLayout(i3);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i3) throws Resources.NotFoundException {
        return this.f702a.getMovie(i3);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i3, int i4, Object... objArr) throws Resources.NotFoundException {
        return this.f702a.getQuantityString(i3, i4, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i3, int i4) throws Resources.NotFoundException {
        return this.f702a.getQuantityText(i3, i4);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i3) throws Resources.NotFoundException {
        return this.f702a.getResourceEntryName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i3) throws Resources.NotFoundException {
        return this.f702a.getResourceName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i3) throws Resources.NotFoundException {
        return this.f702a.getResourcePackageName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i3) throws Resources.NotFoundException {
        return this.f702a.getResourceTypeName(i3);
    }

    @Override // android.content.res.Resources
    public String getString(int i3) throws Resources.NotFoundException {
        return this.f702a.getString(i3);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i3) throws Resources.NotFoundException {
        return this.f702a.getStringArray(i3);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3) throws Resources.NotFoundException {
        return this.f702a.getText(i3);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i3) throws Resources.NotFoundException {
        return this.f702a.getTextArray(i3);
    }

    @Override // android.content.res.Resources
    public void getValue(int i3, TypedValue typedValue, boolean z2) throws Resources.NotFoundException {
        this.f702a.getValue(i3, typedValue, z2);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i3, int i4, TypedValue typedValue, boolean z2) throws Resources.NotFoundException {
        this.f702a.getValueForDensity(i3, i4, typedValue, z2);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i3) throws Resources.NotFoundException {
        return this.f702a.getXml(i3);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f702a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i3) throws Resources.NotFoundException {
        return this.f702a.obtainTypedArray(i3);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i3) throws Resources.NotFoundException {
        return this.f702a.openRawResource(i3);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i3) throws Resources.NotFoundException {
        return this.f702a.openRawResourceFd(i3);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f702a.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f702a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f702a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i3, Resources.Theme theme) throws Resources.NotFoundException {
        return this.f702a.getDrawable(i3, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i3, int i4, Resources.Theme theme) {
        return this.f702a.getDrawableForDensity(i3, i4, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i3, int i4) throws Resources.NotFoundException {
        return this.f702a.getQuantityString(i3, i4);
    }

    @Override // android.content.res.Resources
    public String getString(int i3, Object... objArr) throws Resources.NotFoundException {
        return this.f702a.getString(i3, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3, CharSequence charSequence) {
        return this.f702a.getText(i3, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z2) throws Resources.NotFoundException {
        this.f702a.getValue(str, typedValue, z2);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i3, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f702a.openRawResource(i3, typedValue);
    }
}
