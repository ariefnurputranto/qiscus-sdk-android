/*
 * Copyright (c) 2016 Qiscus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.qiscus.sdk.ui.adapter.viewholder;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewCallback;
import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import com.qiscus.sdk.R;
import com.qiscus.sdk.data.model.QiscusComment;
import com.qiscus.sdk.ui.adapter.OnItemClickListener;
import com.qiscus.sdk.ui.adapter.OnLongItemClickListener;
import com.qiscus.sdk.util.linkpreview.QiscusLinkPreviewCallback;
import com.qiscus.sdk.util.linkpreview.QiscusSourceContent;
import com.qiscus.sdk.util.linkpreview.QiscusTextCrawler;

import java.net.URL;

import retrofit2.http.Url;

/**
 * Created on : September 27, 2016
 * Author     : zetbaitsu
 * Name       : Zetra
 * Email      : zetra@mail.ugm.ac.id
 * GitHub     : https://github.com/zetbaitsu
 * LinkedIn   : https://id.linkedin.com/in/zetbaitsu
 */
public abstract class QiscusBaseTextLinkMessageViewHolder extends QiscusBaseMessageViewHolder<QiscusComment> {

    @NonNull protected TextView messageTextView;
    @Nullable protected TextView titleTextView;
    @Nullable protected TextView urlTextView;
    @Nullable protected TextView descriptionTextView;
    @Nullable protected LinearLayout infoWrap;
    @Nullable protected LinearLayout titleWrap;
    @Nullable protected ImageView imageSet;
    @Nullable protected ViewGroup dropPreview;
    @Nullable protected ProgressBar progressBarLoading;
    @Nullable protected LinearLayout linLinkPreview;


    private QiscusTextCrawler textCrawler;


    public QiscusBaseTextLinkMessageViewHolder(View itemView, OnItemClickListener itemClickListener, OnLongItemClickListener longItemClickListener) {
        super(itemView, itemClickListener, longItemClickListener);
        messageTextView = getMessageTextView(itemView);
        titleTextView= getTitleTextView(itemView);
        urlTextView= getUrlTextView(itemView);
        descriptionTextView= getDescriptionTextView(itemView);
        infoWrap= getInfoWrap(itemView);
        titleWrap= getTitleWrap(itemView);
        imageSet= getImageSet(itemView);
        dropPreview= getDropPreview(itemView);
        progressBarLoading= getProgressBarLoading(itemView);
        linLinkPreview= getLinLinkPreview(itemView);
    }

    @NonNull
    protected abstract TextView getMessageTextView(View itemView);

    @Nullable
    protected abstract TextView getTitleTextView(View itemView);

    @Nullable
    protected abstract TextView getUrlTextView(View itemView);

    @Nullable
    protected abstract TextView getDescriptionTextView(View itemView);

    @Nullable
    protected abstract LinearLayout getInfoWrap(View itemView);

    @Nullable
    protected abstract LinearLayout getTitleWrap(View itemView);

    @Nullable
    protected abstract ImageView getImageSet(View itemView);

    @Nullable
    protected abstract ViewGroup getDropPreview(View itemView);

    @Nullable
    protected abstract ProgressBar getProgressBarLoading(View itemView);

    @Nullable
    protected abstract LinearLayout getLinLinkPreview(View itemView);

    @Override
    protected void setUpColor() {
        messageTextView.setTextColor(messageFromMe ? rightBubbleTextColor : leftBubbleTextColor);
        super.setUpColor();
    }

    @Override
    protected void showMessage(QiscusComment qiscusComment) {
        messageTextView.setText(qiscusComment.getMessage());
        textCrawler = new QiscusTextCrawler();
        textCrawler
                .makePreview(callback, qiscusComment.getMessage());
    }

    private QiscusLinkPreviewCallback callback = new QiscusLinkPreviewCallback() {

        @Override
        public void onPre() {
           //if use loading can use this or custom before load link preview
        }

        @Override
        public void onPos(final QiscusSourceContent sourceContent, boolean isNull) {

            progressBarLoading.setVisibility(View.GONE);

            if(isNull){
                linLinkPreview.setVisibility(View.GONE);
            }else
                linLinkPreview.setVisibility(View.VISIBLE);

            if (sourceContent.getImages().size() > 0) {
                UrlImageViewHelper.setUrlDrawable(imageSet, sourceContent
                        .getImages().get(0), new UrlImageViewCallback() {

                    @Override
                    public void onLoaded(ImageView imageView,
                                         Bitmap loadedBitmap, String url,
                                         boolean loadedFromCache) {
                        if (loadedBitmap != null) {

                        }
                    }
                });

            }

            titleTextView.setText(sourceContent.getTitle());
            urlTextView.setText(sourceContent.getCannonicalUrl());
            descriptionTextView.setText(sourceContent.getDescription());

        }
    };

}
