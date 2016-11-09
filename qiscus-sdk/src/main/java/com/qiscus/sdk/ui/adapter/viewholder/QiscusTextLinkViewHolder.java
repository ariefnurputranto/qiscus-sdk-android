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

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.qiscus.sdk.R;
import com.qiscus.sdk.ui.adapter.OnItemClickListener;
import com.qiscus.sdk.ui.adapter.OnLongItemClickListener;

/**
 * Created on : September 27, 2016
 * Author     : zetbaitsu
 * Name       : Zetra
 * Email      : zetra@mail.ugm.ac.id
 * GitHub     : https://github.com/zetbaitsu
 * LinkedIn   : https://id.linkedin.com/in/zetbaitsu
 */
public class QiscusTextLinkViewHolder extends QiscusBaseTextLinkMessageViewHolder {
    public QiscusTextLinkViewHolder(View itemView, OnItemClickListener itemClickListener, OnLongItemClickListener longItemClickListener) {
        super(itemView, itemClickListener, longItemClickListener);
    }

    @NonNull
    @Override
    protected TextView getMessageTextView(View itemView) {
        return (TextView) itemView.findViewById(R.id.contents);
    }

    @Nullable
    @Override
    protected TextView getTitleTextView(View itemView) {
        return (TextView) itemView.findViewById(R.id.title);
    }

    @Nullable
    @Override
    protected TextView getUrlTextView(View itemView) {
        return (TextView) itemView.findViewById(R.id.url);
    }

    @Nullable
    @Override
    protected TextView getDescriptionTextView(View itemView) {
        return (TextView) itemView.findViewById(R.id.description);
    }

    @Nullable
    @Override
    protected LinearLayout getInfoWrap(View itemView) {
        return (LinearLayout) itemView.findViewById(R.id.info_wrap);
    }

    @Nullable
    @Override
    protected LinearLayout getTitleWrap(View itemView) {
        return (LinearLayout) itemView.findViewById(R.id.title_wrap);
    }

    @Nullable
    @Override
    protected ImageView getImageSet(View itemView) {
        return (ImageView) itemView.findViewById(R.id.image_post_set);
    }

    @Nullable
    @Override
    protected ViewGroup getDropPreview(View itemView) {
        return (ViewGroup) itemView.findViewById(R.id.drop_preview);
    }

    @Nullable
    @Override
    protected ProgressBar getProgressBarLoading(View itemView) {
        return (ProgressBar) itemView.findViewById(R.id.progress_bar);
    }

    @Nullable
    @Override
    protected LinearLayout getLinLinkPreview(View itemView) {
        return (LinearLayout) itemView.findViewById(R.id.linLinkPreview);
    }

    @Nullable
    @Override
    protected ImageView getFirstMessageBubbleIndicatorView(View itemView) {
        return (ImageView) itemView.findViewById(R.id.bubble);
    }

    @NonNull
    @Override
    protected View getMessageBubbleView(View itemView) {
        return itemView.findViewById(R.id.message);
    }

    @Nullable
    @Override
    protected TextView getDateView(View itemView) {
        return (TextView) itemView.findViewById(R.id.date);
    }

    @Nullable
    @Override
    protected TextView getTimeView(View itemView) {
        return (TextView) itemView.findViewById(R.id.time);
    }

    @Nullable
    @Override
    protected ImageView getMessageStateIndicatorView(View itemView) {
        return (ImageView) itemView.findViewById(R.id.icon_read);
    }
}
