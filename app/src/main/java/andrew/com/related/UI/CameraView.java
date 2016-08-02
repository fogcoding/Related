package andrew.com.related.UI;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import andrew.com.related.R;
import andrew.com.related.toolClass.CameraPreview;
import andrew.com.related.toolClass.FileDocuments;

public class CameraView extends Activity implements View.OnClickListener {

    private CameraPreview mPreview;
    private SurfaceView sf_Preview;
    private Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_view);

        sf_Preview = (SurfaceView) findViewById(R.id.sf_Preview);
        mPreview = new CameraPreview(this, sf_Preview.getHolder());

        findViewById(R.id.btn_Capture).setOnClickListener(this);
        findViewById(R.id.btn_Gallery).setOnClickListener(this);
        findViewById(R.id.btn_Back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Capture:
                CapturePhoto();
                break;
            case R.id.btn_Gallery:

                break;
            case R.id.btn_Back:

                break;
        }


    }

    private void CapturePhoto() {
        mPreview.takePicture(new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                mCamera = camera;
                //TODO design gallery view
                String time = new SimpleDateFormat("yyyymmdd_hhmmss").format(new Date());

                File Photo = new File(FileDocuments.GALLERY_DOCUMENT + File.separator + time + ".jpg");
                try {
                    FileOutputStream fos = new FileOutputStream(Photo);
                    fos.write(data);
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mCamera.startPreview();
            }
        });
    }
}
