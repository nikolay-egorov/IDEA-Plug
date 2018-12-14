package editor.core;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

import javax.swing.*;

public class EditorInterfaceImpl implements EditorInterface {

    private VirtualFile file;
    private Project project;
    private  boolean isDisposed;

    public EditorInterfaceImpl(Project project, VirtualFile file) {
        this.file = file;
        this.project = project;

        //UI?
    }

    @Override
    public Project getProject() {
        return project;
    }

    @Override
    public JComponent getJComponent() {
        return null;
    }

    @Override
    public JComponent getContentComponent() {
        return null;
    }

    @Override
    public VirtualFile getFile() {
        return file;
    }

    @Override
    public void dispose() {
        isDisposed=true;
    }
}
