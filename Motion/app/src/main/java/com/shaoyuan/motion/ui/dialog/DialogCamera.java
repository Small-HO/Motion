package com.shaoyuan.motion.ui.dialog;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.TextView;

import com.shaoyuan.core.utils.MyToast;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.utils.CheckSDCard;
import com.shaoyuan.motion.utils.MyProvider;
import com.shaoyuan.motion.utils.PhotoUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by small-ho on 2019/7/17 14:11
 * title：相册/相机弹框
 */
public class DialogCamera extends Dialog {
    private Context context;

    @BindView(R.id.tv_close)TextView mClose;
    @BindView(R.id.tv_camera)TextView mCamera;
    @BindView(R.id.tv_photos)TextView mPhotos;

    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CAMERA_PERMISSIONS_REQUEST_CODE = 0x03;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;

    private File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/photo.jpg");
    private Uri imageUri;

    public DialogCamera(Context context) {
        super(context, R.style.MyDialogSize);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_dialog_camera);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_close,R.id.tv_camera,R.id.tv_photos})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.tv_close:
                dismiss();
                break;
            case R.id.tv_camera:
                dismiss();
                autoObtainCameraPermission();   //  打开系统相机
                break;
            case R.id.tv_photos:
                autoObtainStoragePermission();  //  打开系统图库
                dismiss();
                break;
        }
    }

    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = AbsListView.LayoutParams.MATCH_PARENT;
        layoutParams.height = AbsListView.LayoutParams.WRAP_CONTENT;

        getWindow().setAttributes(layoutParams);
    }

    /** 自动获取相机权限 */
    private void autoObtainCameraPermission() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,Manifest.permission.CAMERA)){
                MyToast.showToast(context,"您已经拒绝过一次");
            }
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, CAMERA_PERMISSIONS_REQUEST_CODE);
        }else { //  有权限直接调用系统相机拍照
            if (CheckSDCard.hasSdcard())
            {
                imageUri = Uri.fromFile(fileUri);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    imageUri = FileProvider.getUriForFile(context, MyProvider.getFileProviderName(context), fileUri);  //  通过FileProvider创建一个content类型的Uri
                    PhotoUtils.takePicture((Activity) context, imageUri, CODE_CAMERA_REQUEST);
                }
            }else {
                MyToast.showToast(context,"设备没有SD卡！");
            }
        }
    }

    /** 自动获取相册权限 */
    private void autoObtainStoragePermission() {
        if (ContextCompat.checkSelfPermission(context,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
        }else {
            PhotoUtils.openPic((Activity) context,CODE_GALLERY_REQUEST);
        }
    }
}
