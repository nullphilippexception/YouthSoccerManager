package com.example.youthsoccermanager.layouthelper;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.youthsoccermanager.R;
import com.example.youthsoccermanager.dataclasses.admin.Mail;

public class MailPreviewCreator {
    public static void createMailPreview(View mail_preview, LinearLayout linearLayout, Mail mail, int idCount) {
        linearLayout.addView(mail_preview);
        ((TextView)mail_preview.findViewById(R.id.mail_preview_sender)).setText(mail.getSender());
        ((TextView)mail_preview.findViewById(R.id.mail_preview_date)).setText(mail.getDate());
        ((TextView)mail_preview.findViewById(R.id.mail_preview_text)).setText(mail.getTitle());
        ((View)mail_preview.findViewById(R.id.template_id_mail_preview)).setId(idCount);
    }
}
