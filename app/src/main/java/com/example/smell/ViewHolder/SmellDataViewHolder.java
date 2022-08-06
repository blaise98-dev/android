package com.example.smell.ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smell.R;
import com.example.smell.model.SmellTypesModal;

public class SmellDataViewHolder extends RecyclerView.ViewHolder {
    TextView smellId;
    TextView smellTitle;
    TextView smellDesc;
//    ImageView productImageView;
    Context context;

    public SmellDataViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        smellId = itemView.findViewById(R.id.smell_id);
        smellTitle = itemView.findViewById(R.id.smellTitle);
        smellDesc = itemView.findViewById(R.id.smellDesc);
    }

    public void BindSmellData(final SmellTypesModal smellData) {
        smellId.setText(String.valueOf(smellData.getId()));
        smellTitle.setText(smellData.getSmellType());
        smellDesc.setText(smellData.getSmellDescriptions());

//        Glide.with(context).load(smellData.getPhotoURL()).into(productImageView);
    }

//    private void saveImage(String photoURL) throws IOException {
//        URL url = new URL(photoURL);
//        InputStream input = url.openStream();
//        try {
////The sdcard directory e.g. '/sdcard' can be used directly, or
////more safely abstracted with getExternalStorageDirectory()
//            File storagePath = Environment.getExternalStorageDirectory();
//            OutputStream output = new FileOutputStream(storagePath + "/myImage.png");
//            try {
//                byte[] buffer = new byte[1024];
//                int bytesRead;
//                while ((bytesRead = input.read(buffer, 0, buffer.length)) >= 0) {
//                    output.write(buffer, 0, bytesRead);
//                }
//            } finally {
//                output.close();
//            }
//        } finally {
//            input.close();
//        }
//    }

}
