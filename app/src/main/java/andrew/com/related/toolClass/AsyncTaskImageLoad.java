package andrew.com.related.toolClass;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Andrew on 2016/7/21.
 */
public class AsyncTaskImageLoad extends AsyncTask<String,Integer,Bitmap> {

    private ImageView image = null;

    public AsyncTaskImageLoad(ImageView imageView){
        this.image = imageView;
    }


    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            URL Url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) Url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(5000);
            if (connection.getResponseCode() == 200){
                InputStream inputStream = connection.getInputStream();
                Bitmap map = BitmapFactory.decodeStream(inputStream);
                return map;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (image!=null&&bitmap!=null){
            image.setImageBitmap(bitmap);
        }
    }
}
