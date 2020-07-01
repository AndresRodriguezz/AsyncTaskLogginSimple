package co.and.asynctasksimple;

public interface Comunication {

    void progressBar(Boolean status);
    void launchActivity(Class<?> kindActivity);
    void showMessage(String message);
    void visibleButton(Boolean visible);
}
