package co.and.asynctasksimple.task;

import android.os.AsyncTask;

import co.and.asynctasksimple.Comunication;
import co.and.asynctasksimple.ui.ResultActivity;

public class AsyncTaskUSer extends AsyncTask<Object,Void,Boolean> {
    Comunication comunication;

    public AsyncTaskUSer(Comunication comunication) {
        this.comunication = comunication;
    }

    @Override
    protected void onPreExecute() {
        comunication.progressBar(true);
        comunication.visibleButton(false);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Boolean doInBackground(Object... objects) {
        try{
            Thread.sleep( (int)objects[2]);
            String user = (String) objects[0];
            String password = (String) objects[1];
            if(user.equals("ElNeneConFlow")  && password.equals("Dembow")){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if (aBoolean){
            comunication.progressBar(false);
            comunication.launchActivity(ResultActivity.class);
            comunication.showMessage("Correct");
            comunication.visibleButton(true);
        } else {
            comunication.progressBar(false);
            comunication.showMessage("Incorrect Data");
            comunication.visibleButton(true);
        }
    }
}
