package hu.pe.moony.songsformydaughter;

import java.util.UUID;

/**
 * Created by 이상문 on 2016-09-19.
 */
public class Song {
    private UUID mId;
    private String mTitle;
    private int mImgId;
    private int mRawId;

    public int getRawId() {
        return mRawId;
    }

    public void setRawId(int rawId) {
        this.mRawId = rawId;
    }

    public int getImgId() {
        return mImgId;
    }

    public void setImgId(int ImgId) {
        this.mImgId = ImgId;
    }

    public Song() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    @Override
    public String toString() {
        return mTitle;
    }
}
